package Commands;
import java.util.ArrayList;
/**
 * A class for the output of commands entered earlier in the amount of 7 pieces.
 *
 */
public class History {
    private static ArrayList<String> history = new ArrayList<>();
    /**
     * A method for adding a command to the history.
     * @param command the entered command.
     *
     */
    public static void addInHistory(String command)
    {
        history.add(command);
        if(history.size() == 8) history.remove(0);
    }
    /**
     * A method for displaying the history.
     */
    public static void ShowHistory(){
        for (int i = 0; i< history.size(); i++)
        {
            System.out.println(history.get(i));
        }

    }
}
