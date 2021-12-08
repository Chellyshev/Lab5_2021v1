import CollectionControl.CollectionControl;
import Commands.*;
import CollectionControl.XMLController;
import java.io.IOException;
/**
 * A class for processing commands and executing them.
 */
public class CommandsControl {
    /**
     * A method for processing commands and executing them.
     * @param task the command that the user entered.
     */
    public static void setCommand(String task) {
        History.addInHistory(task);
        String command = task.trim().split(" ", 2)[0];
        Integer id;
        Float turnover;
        try {
            switch (command) {
                case ("add"):
                    Add.AddElement();
                    break;
                case ("clear"):
                    if (CollectionControl.getCollectionSize() == 0) System.out.println("Коллекция пуста");
                    else {
                        CollectionControl.getCollection().clear();
                        System.out.println("Коллекция очищена");
                    }
                    break;
                case ("update"):
                    try {
                        id = Integer.parseInt(task.trim().split(" ",2)[1]);
                        UpdateID.update(id);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Введите аргумент");
                    }

                    break;
                case ("remove_by_id"):
                    try {
                        id = Integer.parseInt(task.trim().split(" ",2)[1]);
                        RemoveById.remove(id);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Введите аргумент");
                    }
                    break;

                case ("help"):
                    Help.getHelp();
                    break;
                case ("show"):
                    Show.showCollection();
                    break;
                case ("info"):
                    System.out.println("Информация о коллекции:\n" +
                            "Файл коллекции" + XMLController.AbsolutePath + "\n" +
                            "Тип коллекции" + CollectionControl.getCollection().getClass());
                    break;
                case ("exit"):
                    System.exit(0);
                    break;
                case ("save"):
                    Save.SaveCollection();

                    break;
                case ("history"):
                    History.ShowHistory();
                    break;
                case ("add_if_max"):
                    AddIfMax.AddGreater();
                    break;
                case ("execute_script"):
                    try {
                        ScriptReader scriptReader = new ScriptReader();
                        String filePath = task.trim().split(" ",2)[1];
                        scriptReader.read(filePath);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Введите аргумент");
                    }
                    break;
                case ("remove_lower"):
                    RemoveLower.RemoveLower();
                    break;
                case ("remove_all_by_annual_turnover"):
                    try {
                        turnover = Float.parseFloat(task.trim().split(" ",2)[1]);
                        RemoveAllByAnnualTurnover.Remove(turnover);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Введите аргумент");
                    }
                    break;
                case ("filter_starts_with_name"):
                    try {
                        String name = task.trim().split(" ",2)[1];
                        FilterName.FilterName(name);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Введите аргумент");}
                    break;
                case ("filter_less_than_annual_turnover"):
                    try {
                        turnover = Float.parseFloat(task.trim().split(" ",2)[1]);
                        FilterAnnualTurnover.Filter(turnover);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Введите аргумент");}
                    break;
                default:
                    System.out.println("Неправильно введена команда");
                    break;

            }
        } catch (NullPointerException e) {
            System.out.println("Введите команду");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

