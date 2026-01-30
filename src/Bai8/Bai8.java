package Bai8;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        do{
            System.out.println("Nhap so (0 de dung): ");
            n = sc.nextInt();
        }while(n != 0);

        System.out.println("Da dung chuong trinh");
        sc.close();
    }
}
