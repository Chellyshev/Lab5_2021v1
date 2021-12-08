import CollectionControl.XMLController;
import java.util.Scanner;
public class main {
    /**
     * The starting point of the program. Reads the path to the file from the environment variable, and starts the command handler.
     *
     * @param args Command line arguments (not used)
     * @autor Kirill Chelyshev
     * @version 1.0
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = null;
        System.out.println("�������� ���� �����");
        String filePath = System.getenv("Lab5");
        System.out.println("����, �������� � ���������� ��������� LabFilePath: " + filePath);
        if (filePath == null) {
            System.out.println("���������� ��������� �� ������");
            return;
        }
        int id;
        XMLController.setAbsolutePath("Organizations.xml",filePath);
        String[] words = null;
        String[] commands = null;
        XMLController.ReadFile();
        while (true) {
            System.out.print("������� ������� >>");
            command = scanner.nextLine();
            try {
                CommandsControl.setCommand(command);
            }
            catch (NumberFormatException e)
            {
                System.out.println("");
            }

        }
    }}