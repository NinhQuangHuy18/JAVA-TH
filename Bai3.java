import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap 1 so nguyen bat ky: ");
        int n = sc.nextInt();

        if(n > 0) System.out.println( n + " la so duong");
        else if(n < 0) System.out.println(n + " la so am");
        else System.out.println(n + " la so 0");

        sc.close();
    }
}
