package Commands;
/**
 * ENUM storing all commands. It is needed to output help on commands.
 *
 */
public enum CommandsInfo {
    HELP("help : вывести справку по доступным командам"),
    INFO("info : вывести информацию о коллекции"),
    SHOW("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
    ADD("add {element} : добавить новый элемент в коллекцию"),
    UPDATE_ID("update id {element} : обновить значение элемента коллекции, id которого равен заданному"),
    REMOVE_BY_ID("remove_by_id id : удалить элемент из коллекции по его ключу"),
    CLEAR("clear : очистить коллекцию"),
    SAVE("save : сохранить коллекцию в файл"),
    EXECUTE_SCRIPT("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
    EXIT("exit : завершить программу (без сохранения в файл)"),
    ADD_IF_MIN("add_if_min:{element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции"),
    REMOVE_LOWER("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный"),
    HISTORY("history : вывести последние 7 команд (без их аргументов)"),
    REMOVE_ALL_BY_ANNUAL_TURNOVER("remove_all_by_annual_turnover annualTurnover : удалить из коллекции все элементы, значение поля annualTurnover которого эквивалентно заданному\n"),
    FILTER_STARTS_WITH_NAME("filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки"),
    FILTER_LESS_THAN_ANNUAL_TURNOVER("filter_less_than_annual_turnover annualTurnover : вывести элементы, значение поля annualTurnover которых меньше заданного");

    String s;
    CommandsInfo(String s) {
        this.s = s;
    }


    public String getHelp() {
        return s;
    }
}

