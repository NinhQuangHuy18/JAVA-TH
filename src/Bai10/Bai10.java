package Bai10;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap gia tri cua mang: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Nhap gia tri thu " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }

        System.out.println("Mang vua nhap la: ");
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }

        // 10.1
        int min = a[0];
        for(int x : a){
            if(x < min){
                min = x;
            }
        }
        System.out.println("\nMin cua mang vua nhap la: " + min);

        // 10.2
        int am = 0, duong = 0, khong = 0;
        for(int x : a){
            if(x < 0) am++;
            else if(x > 0) duong++;
            else khong ++;
        }
        System.out.println("Co " + am + " so am");
        System.out.println("Co " + duong + " so duong");
        System.out.println("Co " + khong + " so 0");

        // 10.3
        int tong = 0;
        for(int x : a){
            tong += x;
        }

        float tbc = (float) tong / n;
        System.out.println("Trung binh cong la: " + tbc);

        System.out.println("Cac so lon hon trung binh cong la:");
        for(int x : a){
            if(x > tbc){
                System.out.print(x + " ");
            }
        }

        //10.4
        System.out.println("\nMang sau khi dao nguoc la:");
        for(int i = n - 1; i >= 0; i--){
            System.out.print(a[i] + " ");
        }

        // 10.5
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("\nMang sau khi sap xep tang dan la:");
        for(int x : a){
            System.out.print(x + " ");
        }

        sc.close();
    }
}
