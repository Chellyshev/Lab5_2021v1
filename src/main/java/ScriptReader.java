import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * A class for working with scripts from files.
 */
public class ScriptReader {
    private final Stack<String> scripStack = new Stack();
    private File currentFile;
    /**
     * Method for checking the file.
     * @param filePath file path
     */
    private File checkFile(String filePath) {
        File script = new File(filePath);

        if (!script.exists() || !script.isFile()) {
            System.out.println(("Файл по  пути " + script.getAbsolutePath() + " не существует."));
            return null;
        }
        if (!script.canRead()) {
            System.out.println("Файл защищён от чтения.");
            return null;
        }
        if (script.length() == 0) {
            System.out.println("Скрипт не содержит команд.");
            return null;
        }
        return script;
    }

    /**
     * Reads commands from a file.
     *
     * @param filePath file path
     * @return A collection of commands.
     */
    public ArrayList<String> read(String filePath) {
        ArrayList<String> taskList = new ArrayList<>();
        File script = checkFile(filePath);
        try (InputStreamReader scriptReader1 = new InputStreamReader(new FileInputStream(filePath), "UTF-8")) {
            BufferedReader scriptReader = new BufferedReader(scriptReader1);
            System.out.println("Анализ файла " + script.getAbsolutePath());
            String scriptCommand = scriptReader.readLine();
            while (scriptCommand != null) {
                currentFile = script;
                if (commandCheck(scriptCommand)) {
                    if (scripStack.search(script.getAbsolutePath()) != -1) {
                        System.out.println("Обнаружена рекурсия вызова скриптов:");
                        for (String file : scripStack) System.out.println("---> " + file);
                        System.out.println("---> " + script.getAbsolutePath());
                        scripStack.clear();
                        return null;
                    }
                    scripStack.add(script.getAbsolutePath());
                    ArrayList add = read(getAddressScript(relativeToAbsolutePath(scriptCommand)));
                    if (add != null) taskList.addAll(add);
                    else return null;
                    scripStack.remove(script);
                } else {
                    CommandsControl.setCommand(scriptCommand);
                    if (scriptCommand != null) taskList.add(scriptCommand);
                }
                scriptCommand = scriptReader.readLine();
            }
        } catch (IOException e) {
            return null;
        }
        return taskList;
    }

    /**
     * Allocates the path to the script from the command in case the script is called from the script.
     *
     * @param command command.
     * @return the path to the script.
     */
    private String getAddressScript(String command) {
        String[] trimScriptCommand;
        trimScriptCommand = command.trim().split(" ", 2);
        return trimScriptCommand[1];
    }

    /**
     * Checks the command from the script to call a new script.
     *
     * @param command command.
     * @return The result of the check.
     */
    private boolean commandCheck(String command) {
        if (command != null) {
            String[] trimScriptCommand;
            trimScriptCommand = command.trim().split(" ", 2);
            return trimScriptCommand[0].equals("execute_script");
        }
        return false;
    }

    /**
     * defines the absolute path to the script from the command in case the script is called from the script.
     * @param nextExecute The address of the new script.
     * @return The absolute path.
     */
    private String relativeToAbsolutePath(String nextExecute) {
        String nextFilePath = nextExecute.trim().split(" ", 2)[1];
        if (nextFilePath != null) {
            File nextFile = new File(nextFilePath);
            if (!nextFile.isAbsolute()) {
                String newExecute = "execute_script " + currentFile.getAbsolutePath().replace(currentFile.getName(), nextFile.getPath());
                return newExecute;
            }
        }
        return nextExecute;
    }
}
