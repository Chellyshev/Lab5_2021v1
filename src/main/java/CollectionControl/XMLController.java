package CollectionControl;
import WorkPackage.*;
import WorkPackage.Location;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
/**
 * A class for working with an XML file

 */
public class XMLController {
    public static String AbsolutePath;
    public static void setAbsolutePath(String fileName, String path)
    {
        AbsolutePath = path+"\\"+fileName;
    }
    /**
     * Writes the collection to the file specified in the argument.
     * @throws java.io.IOException
     *
     *
     */
    public static void writeToXMLusingJDOM() throws IOException {
        Document doc = new Document();
        // создаем корневой элемент с пространством имен
        doc.setRootElement(new Element("Organizations"));
        // формируем JDOM документ из объектов Organization
        for (Organization organization : CollectionControl.getCollection()) {
            Element  organizationElement = new Element("list");
            organizationElement.setAttribute("id", String.valueOf(organization.getId()));
            organizationElement.addContent(new Element("name").setText("" + organization.getName()));
            organizationElement.addContent(new Element("coordinates_x").setText(organization.getCoordinates().getX().toString()));
            organizationElement.addContent(new Element("coordinates_y").setText(String.valueOf(organization.getCoordinates().getY())));
            organizationElement.addContent(new Element("creation_date").setText(organization.getCreationDate().toString()));
            organizationElement.addContent(new Element("annual_turnover").setText(organization.getAnnualTurnover().toString()));
            organizationElement.addContent(new Element("full_name").setText(organization.getFullName()));
            organizationElement.addContent(new Element("employees_count").setText(organization.getEmployeesCount().toString()));
            organizationElement.addContent(new Element("organization_type").setText(organization.getType().toString()));
            organizationElement.addContent(new Element("address_x").setText(String.valueOf(organization.getOfficialAddress().getTown().getX())));
            organizationElement.addContent(new Element("address_y").setText(String.valueOf(organization.getOfficialAddress().getTown().getY())));
            organizationElement.addContent(new Element("address_z").setText(String.valueOf(organization.getOfficialAddress().getTown().getZ())));
            organizationElement.addContent(new Element("address_name").setText(String.valueOf(organization.getOfficialAddress().getTown().getName())));
            organizationElement.addContent(new Element("street_name").setText(String.valueOf(organization.getOfficialAddress().getStreet())));

            doc.getRootElement().addContent(organizationElement);
        }
        // Документ JDOM сформирован и готов к записи в файл
        XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());

        File outFile = new File(AbsolutePath);
        outFile.getParentFile().mkdirs(); // Create parent folder.

        OutputStream os = new FileOutputStream(outFile);

        BufferedOutputStream br = new BufferedOutputStream(os, 16384);
        // сохраняем в файл
        xmlWriter.output(doc, br);
    }
    /**
     * Loads the collection from the file specified in the argument.
     *
     * @return Collection.
     */
    public static void ReadFile() {

        String fileName = AbsolutePath;
        try {
            // Создаем экземпляр JDOM Document
            SAXBuilder sax = new SAXBuilder();
            // XML is a local file
            Document doc = sax.build(new File(fileName));
            Element root = doc.getRootElement();
            // получаем список всех элементов Organization
            List<Element> organizationElements = root.getChildren("list");
            Coordinates coordinates = new Coordinates();
            Location location = new Location();
            Address address = new Address();
            // список объектов Organization, в которых будем хранить
            // считанные данные по каждому элементу
            LinkedList<Organization> organizationsList = new LinkedList<>();
            for (Element organizationEl : organizationElements) {
                Organization organization = new Organization();
                organization.setId(Integer.parseInt(organizationEl.getAttributeValue("id")));
                organization.setName(organizationEl.getChildText("name"));
                coordinates.setX(Long.parseLong(organizationEl.getChildText("coordinates_x")));
                coordinates.setY(Integer.parseInt(organizationEl.getChildText("coordinates_y")));

                organization.setCreationDate(LocalDateTime.parse(organizationEl.getChildText("creation_date")));
                organization.setAnnualTurnover(Float.parseFloat(organizationEl.getChildText("annual_turnover")));
                organization.setFullName(organizationEl.getChildText("full_name"));
                organization.setEmployeesCount(Long.parseLong(organizationEl.getChildText("employees_count")));
                organization.setType(OrganizationType.valueOf(organizationEl.getChildText("organization_type")));

                location.setX(Integer.parseInt(organizationEl.getChildText("address_x")));
                location.setY(Double.parseDouble(organizationEl.getChildText("address_y")));
                location.setZ(Long.parseLong(organizationEl.getChildText("address_z")));
                location.setName(organizationEl.getChildText("address_name"));

                organization.setCoordinates(coordinates);

                address.setTown(location);
                address.setStreet(organizationEl.getChildText("street_name"));
                organization.setOfficialAddress(address);
                organizationsList.add(organization);
            }
            CollectionControl.setCollection(organizationsList);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        } catch (JDOMException e) {
            System.out.println("Ошибка чтения файла");
        }

    }



}






