package Bai31;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySanPham ql = new QuanLySanPham();

        int luaChon;
        do{
            System.out.println("------------------------------");
            System.out.println("----------MENU----------");
            System.out.println("1. Them san pham thuong");
            System.out.println("2. Them san pham giam gia");
            System.out.println("3. Xuat danh sach san pham");
            System.out.println("4. Sap xep san pham giam dan theo gia");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("------------------------------");

            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    ql.themSPT(sc);
                    break;
                case 2:
                    ql.themSPGP(sc);
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach da nhap la:");
                    ql.inDanhSach();
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    ql.sapXepSPGiamDanTheoGia();
                    System.out.println("Danh sach sau khi sap xep la:");
                    ql.inDanhSach();
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai");
            }
        }while(luaChon != 0);

        sc.close();
    }
}
