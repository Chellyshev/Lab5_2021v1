package WorkPackage;

public class Address {
    private String street; //Длина строки не должна быть больше 108, Поле не может быть null
    private Location town; //Поле не может быть null

    public Address(String street, Location town)
    {
        this.street = street;
        this.town = town;
    }
    public Address()
    {

    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Location getTown() {
        return town;
    }

    public void setTown(Location town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", town=" + town +
                '}';
    }
}