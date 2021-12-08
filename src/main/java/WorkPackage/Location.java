package WorkPackage;

public class Location {
    private int x;
    private double y;
    private long z;
    private String name; //Длина строки не должна быть больше 637, Поле не может быть null

    public Location(int x, double y, long z, String name)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    public Location(){

    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public long getZ() {
        return z;
    }

    public void setZ(long z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }
}