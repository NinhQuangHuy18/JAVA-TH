package Bai30;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySinhVien ql = new QuanLySinhVien();

        int luaChon;
        do{
            System.out.println("------------------------------");
            System.out.println("----------MENU----------");
            System.out.println("1. Them sinh vien IT");
            System.out.println("2. Them sinh vien Biz");
            System.out.println("3. In danh sach");
            System.out.println("4. Tim sinh vien co diem trung binh cao nhat");
            System.out.println("5. Sap xep giam dan theo diem");
            System.out.println("6. Tim sinh vien theo ma");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("------------------------------");

            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    ql.themSVIT(sc);
                    break;
                case 2:
                    ql.themSVBiz(sc);
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach sinh vien la:");
                    ql.inDanhSach();
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach sinh vien co diem trung binh cao nhat la:");
                    ql.timSVCoDiemTBMax();
                    break;
                case 5:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    ql.sapXepGiamDanTheoDiemTB();
                    System.out.println("Danh sach sau khi sap xep la:");
                    ql.inDanhSach();
                    break;
                case 6:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Nhap ma sinh vien: ");
                    String maCanTim = sc.nextLine();
                    System.out.println("Sinh vien co ma " + maCanTim + " la:");
                    ql.timSVTheoMa(maCanTim);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }while(luaChon != 0);

        sc.close();
    }
}
