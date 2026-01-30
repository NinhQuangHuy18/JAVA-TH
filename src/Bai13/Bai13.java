package Bai13;

import java.util.Scanner;

public class Bai13 {
    public static class MangSo{
        int n;
        int[] a;

        MangSo(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap gia tri cua mang: ");
            n = sc.nextInt();
            a = new int[n];

            for(int i = 0; i < n; i++) {
                System.out.print("a[" + (i + 1) + "]: ");
                a[i] = sc.nextInt();
            }
        }

        void xuat(){
            for(int x : a){
                System.out.print(x + " ");
            }
            System.out.println();
        }

        int tongChan(){
            int tong = 0;
            for(int x : a){
                if(x % 2 == 0) tong += x;
            }
            return tong;
        }

        boolean laSoNguyenTo(int x){
            if(x < 2) return false;
            for(int i = 2; i <= Math.sqrt(x); i++){
                if(x % i == 0) return false;
            }
            return true;
        }

        int demSoNguyenTo(){
            int dem = 0;
            for(int x : a){
                if(laSoNguyenTo(x)) dem ++;
            }
            return dem;
        }

        boolean coSoAmKhong(){
            for(int x : a){
                if(x < 0) return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        MangSo ms = new MangSo();

        System.out.print("Mang vua nhap la: ");
        ms.xuat();

        int tongSoChan = ms.tongChan();
        System.out.println("Tong cac so chan cua mang la: " + tongSoChan);

        int demSNT = ms.demSoNguyenTo();
        System.out.println("Mang co " + demSNT + " so nguyen to");

        boolean checkSoAm = ms.coSoAmKhong();
        if(checkSoAm) System.out.println("Mang co so am");
        else System.out.println("Mang khong co so am");
    }
}
