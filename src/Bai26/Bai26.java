package Bai26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai26 {
    public static abstract class NhanVien{
        private String maNV, hoTen;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma nhan vien: ");
            maNV = sc.nextLine();

            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();
        }

        void xuat(){
            System.out.printf("Ma: %-10s  |  Ho ten: %-20s  |  Thu nhap: %-10.2f  | Xep loai: %-10s",
                    maNV, hoTen, getThuNhap(), xepLoai());
        }

        abstract double getThuNhap();

        String xepLoai(){
            if(getThuNhap() >= 10000000) return "Cao";
            else if(getThuNhap() >= 5000000) return "Trung Binh";
            else return "Thap";
        }
    }

    public static class NhanVienIT extends NhanVien{
        private float luongCoBan, luongOT;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap luong co ban: ");
            luongCoBan = sc.nextFloat();

            System.out.print("Nhap luong ot: ");
            luongOT = sc.nextFloat();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.printf("  |  Luong co ban: %-10s  |  Luong OT: %-10s\n",
                    luongCoBan, luongOT);
        }

        @Override
        double getThuNhap() {
            return luongCoBan + luongOT;
        }
    }

    public static  class NhanVienSale extends NhanVien{
        private float luongCoBan, hoaHong;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap luong co ban: ");
            luongCoBan = sc.nextFloat();

            System.out.print("Nhap hoa hong: ");
            hoaHong = sc.nextFloat();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.printf("  |  Luong co ban: %-10s  |  Hoa hong: %-10s\n",
                    luongCoBan, hoaHong);
        }

        @Override
        double getThuNhap() {
            return luongCoBan +hoaHong;
        }
    }

    public static class QuanLyNhanVien{
        ArrayList<NhanVien> ds = new ArrayList<>();

        void themNVIT(Scanner sc){
            NhanVienIT x = new NhanVienIT();
            x.nhap(sc);
            ds.add(x);
        }

        void themNVSale(Scanner sc){
            NhanVienSale x = new NhanVienSale();
            x.nhap(sc);
            ds.add(x);
        }

        void inDanhSach(){
            for(NhanVien x : ds){
                x.xuat();
            }
        }

        void timNVCoThuNhapMax(){
            if(ds.isEmpty()) return;
            double thuNhapMax = ds.get(0).getThuNhap();
            for(NhanVien x : ds){
                if(x.getThuNhap() > thuNhapMax){
                    thuNhapMax = x.getThuNhap();
                }
            }

            for(NhanVien x : ds){
                if(Math.abs(x.getThuNhap() - thuNhapMax) < 1e-9){
                    x.xuat();
                }
            }
        }

        void sapXepGiamDanTheoThuNhap(){
            Collections.sort(ds, (a, b) -> Double.compare(b.getThuNhap(), a.getThuNhap()));
        }

        boolean checkDS(){
            return ds.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyNhanVien ql = new QuanLyNhanVien();

        int luaChon;
        do{
            System.out.println("------------------------------");
            System.out.println("----------MENU----------");
            System.out.println("1. Them nhan vien IT");
            System.out.println("2. Them nhan vien Sale");
            System.out.println("3. In danh sach nhan vien");
            System.out.println("4. Tim nhan vien co thu nhap cao nhat");
            System.out.println("5. Sap xep giam dan theo thu nhap");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("------------------------------");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    ql.themNVIT(sc);
                    break;
                case 2:
                    ql.themNVSale(sc);
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach nhan vien:");
                    ql.inDanhSach();
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Nhan vien co thu nhap cao nhat la:");
                    ql.timNVCoThuNhapMax();
                    break;
                case 5:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    ql.sapXepGiamDanTheoThuNhap();
                    System.out.println("Danh sach sau khi sap xep la:");
                    ql.inDanhSach();
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
