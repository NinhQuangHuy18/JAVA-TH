package Bai7;

import java.util.Scanner;

public class Bai7 {
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen: ");
        int n = sc.nextInt();
        int tong = 0;

//        int i = 1;
//        while(i <= n){
//            tong += i;
//            i++;
//        }

        int i = 1;
        do{
            tong += i;
            i++;
        }while(i <= n);

        System.out.println("Tong day tu 1->" + n + " la: " + tong);

        sc.close();
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap vao 1 so bat ky: ");
        int n = sc.nextInt();

        int i = 1;
        boolean found = false;
        while(i <= n){
            if(i % 3 == 0){
                System.out.print(i + " ");
                found = true;
            }
            i++;
        }
        if(!found){
            System.out.println("Day tu 1 -> " + n + " khong co so nao chia het cho 3");
        }
        sc.close();
    }
}
