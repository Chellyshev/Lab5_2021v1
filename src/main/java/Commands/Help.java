package Commands;
/**
 * A class for displaying available commands.
 *
 */
public class Help {
    /**
     *A method for adding items to a collection if the input item is the largest.
     *
     */
    public static void getHelp()
    {
        for(CommandsInfo type: CommandsInfo.values()) System.out.println(type.getHelp());
    }
}
