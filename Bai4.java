import java.util.Scanner;

public class Bai4 {
    /*
    public static void main(String[] args) {
        int thu = 3;
        switch (thu){
            case 2:
                System.out.println("Thu 2");
                break;
            case 3:
                System.out.println("Thu 3");
                break;
            case 4:
                System.out.println("Thu 4");
                break;
            default:
                System.out.println("Khong hop le");
        }
    }
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap 1 so bat ky tu 1 -> 7: ");
        byte luaChon = sc.nextByte();

        switch (luaChon){
            case 1 -> System.out.println("Chu nhat");
            case 2 -> System.out.println("Thu 2");
            case 3 -> System.out.println("Thu 3");
            case 4 -> System.out.println("Thu 4");
            case 5 -> System.out.println("Thu 5");
            case 6 -> System.out.println("Thu 6");
            case 7 -> System.out.println("Thu 7");
            default -> System.out.println("Phai nhap so tu 1 -> 7");
        }
        sc.close();
    }
}
