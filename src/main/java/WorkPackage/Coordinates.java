package WorkPackage;

public class Coordinates {
    private Long x; //�������� ���� ������ ���� ������ -259, ���� �� ����� ���� null
    private int y;

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Coordinates(Long x, int y)
    {
        this.x = x;
        this.y = y;

    }
    public Coordinates()
    {

    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}