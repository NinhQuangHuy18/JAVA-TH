import java.util.Scanner;

public class Bai2 {
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        byte tuoi = sc.nextByte();

        System.out.println("Xin chao toi la: "+ ten + " va toi: " + tuoi + " tuoi");
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap 2 so nguyen a va b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int tong = a + b;
        int hieu = a - b;
        int tich = a * b;

        System.out.println("Tong la: " + tong);
        System.out.println("Hieu la: " + hieu);
        System.out.println("Tich la: " + tich);

        if(b != 0) {
            float thuong =(float) a / b;
            System.out.println("Thuong la: " + thuong);
        }else{
            System.out.println("Khong the chia vi b = 0");
        }
        sc.close();
    }
}
