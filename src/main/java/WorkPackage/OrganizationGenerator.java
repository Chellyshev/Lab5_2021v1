package WorkPackage;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class OrganizationGenerator {
    public static Organization generate() {
        Organization organization = null;
        try {
            Scanner scanner = new Scanner(System.in);
            String name;
            do {
                System.out.println("������� ��� �����������:");
                name = scanner.nextLine();
            } while (name.isEmpty());

            Long x = null;
            do {
                System.out.println("������� ���������� x");
                try {
                    x = Long.valueOf(scanner.nextLine());
                    if (x <= -259) {
                        System.out.println("����� ������ ���� ������ -259");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("������ ����� �����");
                }
            } while (x == null || x <= -259);

            int y = 0;
            while (true) {
                System.out.println("������� ���������� Y:");
                try {
                    y = Integer.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("������ ����� �����");
                    continue;
                }
                break;
            }

            Float annualTurnover = null;
            do {
                System.out.println("������� ��������� ������");
                try {
                    annualTurnover = Float.valueOf(scanner.nextLine());
                    if (annualTurnover < 0) {
                        System.out.println("����� ������ ���� ������ 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("������ ����� �����");
                }
            } while (annualTurnover == null || annualTurnover < 0);

            String fullName = null;
            System.out.println("������� ������ ���");
            fullName = scanner.nextLine();

            Long employeesCount = null;
            while (true) {
                System.out.println("������� ���������� ���-�� �������:");
                try {
                    employeesCount = Long.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("������ ����� �����");
                    continue;
                }
                break;
            }


            OrganizationType organizationType = null;
            while (true) {
                System.out.println("������� ���� OrganizationType");
                System.out.println("��������� ��������:");
                for (OrganizationType organizationType1 : OrganizationType.values())
                    System.out.println(organizationType1.toString());
                try {
                    String string = scanner.nextLine();
                    organizationType = OrganizationType.valueOf(string);
                } catch (IllegalArgumentException e) {
                    System.out.println("������ �����");
                    continue;
                }
                break;
            }

            String street = null;
            do {
                System.out.println("������� ��� �����������:");
                street = scanner.nextLine();
                if (street.length() > 108)
                    System.out.println("�������� ����� �� ����� ���� ������ 108 ��������");
            } while (street.isEmpty() || street.length() > 108);

            int x1 = 0;
            while (true) {
                System.out.println("������� ���������� x ������:");
                try {
                    x1 = Integer.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("������ ����� �����");
                    continue;
                }
                break;
            }
            double y1 = 0;
            while (true) {
                System.out.println("������� ���������� y ������:");
                try {
                    y1 = Double.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("������ ����� �����");
                    continue;
                }
                break;
            }

            long z1 = 0;
            while (true) {
                System.out.println("������� ���������� z ������:");
                try {
                    z1 = Long.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("������ ����� �����");
                    continue;
                }
                break;
            }
            String townName = null;
            do {
                System.out.println("������� �����:");
                townName = scanner.nextLine();
                if (townName.length() > 637)
                    System.out.println("�������� ����� �� ����� ���� ������ 637 ��������");
            } while (townName.isEmpty() || townName.length() > 637);
            Location location = new Location(x1, y1, z1, townName);
            Address address = new Address(street, location);
            Coordinates coordinates = new Coordinates(x, y);
            Integer Id = (new Random()).nextInt();
            organization = new Organization(Id, name, coordinates, LocalDateTime.now(), annualTurnover, fullName, employeesCount, organizationType, address);
        } catch (NoSuchElementException e) {
            System.out.println("���� ��� ��������...");
        }
        return organization;
    }


}

