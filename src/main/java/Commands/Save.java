package Commands;
import CollectionControl.XMLController;
import java.io.IOException;

/**
 * A class for saving a collection to an XML file.
 *
 */
public class Save {
    /**
     * A method for saving the collection to an XML file.
     *
     */
    public static void SaveCollection() throws IOException {
        XMLController.writeToXMLusingJDOM();
        System.out.println("Файл успешно сохранен");

    }
}

