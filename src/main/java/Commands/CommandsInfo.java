package Commands;
/**
 * ENUM storing all commands. It is needed to output help on commands.
 *
 */
public enum CommandsInfo {
    HELP("help : ������� ������� �� ��������� ��������"),
    INFO("info : ������� ���������� � ���������"),
    SHOW("show : ������� � ����������� ����� ������ ��� �������� ��������� � ��������� �������������"),
    ADD("add {element} : �������� ����� ������� � ���������"),
    UPDATE_ID("update id {element} : �������� �������� �������� ���������, id �������� ����� ���������"),
    REMOVE_BY_ID("remove_by_id id : ������� ������� �� ��������� �� ��� �����"),
    CLEAR("clear : �������� ���������"),
    SAVE("save : ��������� ��������� � ����"),
    EXECUTE_SCRIPT("execute_script file_name : ������� � ��������� ������ �� ���������� �����. � ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������."),
    EXIT("exit : ��������� ��������� (��� ���������� � ����)"),
    ADD_IF_MIN("add_if_min:{element} : �������� ����� ������� � ���������, ���� ��� �������� ������, ��� � ����������� �������� ���� ���������"),
    REMOVE_LOWER("remove_lower {element} : ������� �� ��������� ��� ��������, �������, ��� ��������"),
    HISTORY("history : ������� ��������� 7 ������ (��� �� ����������)"),
    REMOVE_ALL_BY_ANNUAL_TURNOVER("remove_all_by_annual_turnover annualTurnover : ������� �� ��������� ��� ��������, �������� ���� annualTurnover �������� ������������ ���������\n"),
    FILTER_STARTS_WITH_NAME("filter_starts_with_name name : ������� ��������, �������� ���� name ������� ���������� � �������� ���������"),
    FILTER_LESS_THAN_ANNUAL_TURNOVER("filter_less_than_annual_turnover annualTurnover : ������� ��������, �������� ���� annualTurnover ������� ������ ���������");

    String s;
    CommandsInfo(String s) {
        this.s = s;
    }


    public String getHelp() {
        return s;
    }
}

