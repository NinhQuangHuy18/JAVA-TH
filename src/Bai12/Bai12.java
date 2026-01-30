package Bai12;

import java.util.Scanner;

public class Bai12 {
    /*
    static class SinhVien{
        String hoTen;
        int tuoi;

        void nhap(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();
            System.out.print("Nhap tuoi: ");
            tuoi = sc.nextInt();
        }

        void xuat(){
            System.out.println("Ho ten: " + hoTen);
            System.out.println("Tuoi: " + tuoi);
        }
    }

    public static void main() {
        SinhVien sv = new SinhVien();
        sv.nhap();
        sv.xuat();
    }
     */

    public static class MangSo{
        int[] a;
        int n;

        MangSo(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap gia tri mang: ");
            n = sc.nextInt();

            a = new int[n];
            for(int i = 0; i < n; i++){
                System.out.print("a[" + (i + 1) + "]: ");
                a[i] = sc.nextInt();
            }
        }

        void xuat(){
            for(int i = 0; i < n; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        int timMin(){
            int min = a[0];
            for(int x : a){
                if(x < min) min = x;
            }
            return min;
        }

        void kiemTraSo(){
            int am = 0, duong = 0, khong = 0;
            for(int x : a){
                if(x > 0) duong ++;
                else if(x < 0) am ++;
                else khong ++;
            }
            System.out.println("Co: " + am + " so am");
            System.out.println("Co: " + duong + " so duong");
            System.out.println("Co: " + khong + " so 0");
        }

        float TBC(){
            int tong = 0;
            for(int x : a){
                tong += x;
            }
            return (float) tong / n;
        }

         void soLonHonTBC(float tbc){
            for(int x : a){
                if(x > tbc){
                    System.out.print(x + " ");
                }
            }
            System.out.println();
        }

        void daoNguocMang(){
            for(int i = n - 1; i >= 0; i--){
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        void sapXepMang(){
            for(int i = 0; i < a.length - 1; i++){
                for(int j = i + 1; j < a.length; j++){
                    if(a[i] > a[j]){
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        MangSo ms = new MangSo();

        System.out.print("Mang vua nhap la: ");
        ms.xuat();

        int min = ms.timMin();
        System.out.println("Min cua mang la: " + min);

        ms.kiemTraSo();

        float tbc = ms.TBC();
        System.out.println("Trung binh cong cua mang la: " + tbc);

        System.out.print("Cac so lon hon trung binh cong la: ");
        ms.soLonHonTBC(tbc);

        System.out.print("Mang sau khi dao nguoc la: ");
        ms.daoNguocMang();

        ms.sapXepMang();
        System.out.print("Mang sau khi sap xep la: ");
        for(int x : ms.a){
            System.out.print(x + " ");
        }
    }
}
