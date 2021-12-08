package WorkPackage;

import java.time.LocalDateTime;


public class Organization {
    private Integer id; //���� �� ����� ���� null, �������� ���� ������ ���� ������ 0, �������� ����� ���� ������ ���� ����������, �������� ����� ���� ������ �������������� �������������
    private String name; //���� �� ����� ���� null, ������ �� ����� ���� ������
    private Coordinates coordinates; //���� �� ����� ���� null
    private java.time.LocalDateTime creationDate; //���� �� ����� ���� null, �������� ����� ���� ������ �������������� �������������
    private Float annualTurnover; //���� �� ����� ���� null, �������� ���� ������ ���� ������ 0
    private String fullName; //���� ����� ���� null
    private Long employeesCount; //���� ����� ���� null, �������� ���� ������ ���� ������ 0
    private OrganizationType type; //���� �� ����� ���� null
    private Address officialAddress; //���� �� ����� ���� null

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Float getAnnualTurnover() {
        return annualTurnover;
    }
    public String getFullName() {
        return fullName;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }
    public OrganizationType getType() {
        return type;
    }
    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAnnualTurnover(Float annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmployeesCount(Long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }
    public Organization(Integer id, String name,Coordinates coordinates, LocalDateTime creationDate, Float annualTurnover,String fullName,
                        Long employeesCount, OrganizationType type, Address officialAddress)
    {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officialAddress = officialAddress;

    }
    public Organization()
    {

    }
    public int compareTo(Object o) {
        int thisValue = -1;
        if (this.getAnnualTurnover() != null) thisValue = this.getAnnualTurnover().intValue();
        int oValue = -1;
        if (((Organization) o).getAnnualTurnover() != null) oValue = ((Organization) o).getAnnualTurnover().intValue();

        return thisValue - oValue;
    }
    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", annualTurnover=" + annualTurnover +
                ", fullName='" + fullName + '\'' +
                ", employeesCount=" + employeesCount +
                ", type=" + type +
                ", officialAddress=" + officialAddress +
                '}';
    }
}
