package Bai27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Bai27 {
    interface tinhLuong{
        double tinhLuong();
    }

    public abstract class NhanVien implements tinhLuong{
        private String maNV, hoTen;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma nhan vien: ");
            maNV = sc.nextLine();

            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();
        }

        void xuat(){
            System.out.printf("Ma nhan vien: %-10s  |  Ho ten: %-20s  |  Luong: %-10.2f  |  Xep loai: %-10s", maNV, hoTen,tinhLuong(), xepLoai());
        }

        String xepLoai(){
            if(tinhLuong() >= 15000000) return "Xuất sắc";
            else if(tinhLuong() >= 8000000 && tinhLuong() < 15000000) return "Tốt";
            else return "Bình thường";
        }

        public String getMaNV() {
            return maNV;
        }
    }

    public class NhanVienHanhChinh extends NhanVien{
        private double luongCoBan;
        private float heSoLuong;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap luong co ban: ");
            luongCoBan = sc.nextDouble();

            System.out.print("Nhap he so luong: ");
            heSoLuong = sc.nextFloat();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.printf("  |  Luong co ban: %-10.2f  |  He so luong: %-5.2f", luongCoBan, heSoLuong);
            System.out.println();
        }

        @Override
        public double tinhLuong(){
            return luongCoBan * heSoLuong;
        }
    }

    public class NhanVienSanXuat extends NhanVien{
        private double luongCoBan;
        private double soSanPham;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap luong co ban: ");
            luongCoBan = sc.nextDouble();

            System.out.print("Nhap so san pham: ");
            soSanPham = sc.nextDouble();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.printf("  |  Luong co ban: %-10.2f  |  So san pham: %-5s", luongCoBan, soSanPham);
            System.out.println();
        }

        @Override
        public double tinhLuong(){
            return luongCoBan + soSanPham * 50000;
        }
    }

    public class NhanVienQuanLy extends NhanVien{
        private double luongCoBan;
        private double phuCap;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap luong co ban: ");
            luongCoBan = sc.nextDouble();

            System.out.print("Nhap phu cap: ");
            phuCap = sc.nextDouble();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.printf("  |  Luong co ban: %-10.2f  |  Phu cap: %-10.2f", luongCoBan, phuCap);
            System.out.println();
        }

        @Override
        public double tinhLuong(){
            return luongCoBan + phuCap;
        }
    }

    public class QuanLyNhanVien{
        ArrayList<NhanVien> ds = new ArrayList<>();

        void themNVHC(Scanner sc){
            NhanVienHanhChinh x = new NhanVienHanhChinh();
            x.nhap(sc);
            ds.add(x);
        }

        void themNVXS(Scanner sc){
            NhanVienSanXuat x = new NhanVienSanXuat();
            x.nhap(sc);
            ds.add(x);
        }

        void themNVQL(Scanner sc){
            NhanVienQuanLy x = new NhanVienQuanLy();
            x.nhap(sc);
            ds.add(x);
        }

        void inDanhSach(){
            for(NhanVien x : ds){
                x.xuat();
            }
        }

        void timNhanVienLuongMax(){
            double luongMax = ds.get(0).tinhLuong();
            for(NhanVien x : ds){
                if(x.tinhLuong() > luongMax){
                    luongMax = x.tinhLuong();
                }
            }
            for(NhanVien x : ds){
                if(Math.abs(x.tinhLuong() - luongMax) < 1e-9){
                    x.xuat();
                }
            }
        }

        void sapXepGiamDanTheoLuong(){
            Collections.sort(ds, (a, b) -> Double.compare(b.tinhLuong(), a.tinhLuong()));
        }

        void timNhanVienTheoMa(String maCanTim){
            boolean found = false;
            for(NhanVien x : ds){
                if(x.getMaNV().equals(maCanTim)){
                    found = true;
                    x.xuat();
                }
            }

            if(!found) System.out.println("Khong co nhan vien nao co ma: " + maCanTim);
        }

        boolean checkDS(){
            return ds.isEmpty();
        }
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyNhanVien ql = new QuanLyNhanVien();

        int luaChon;
        do{
            System.out.println("------------------------------");
            System.out.println("----------MENU----------");
            System.out.println("1. Them nhan vien");
            System.out.println("2. In danh sach");
            System.out.println("3. Tim nhan vien luong cao nhat");
            System.out.println("4. Sap xep giam dan theo luong");
            System.out.println("5. Tim nhan vien theo ma");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("------------------------------");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    int chon;
                    do{
                        System.out.println("1.Nhan vien hanh chinh");
                        System.out.println("2. Nhan vien san xuat");
                        System.out.println("3. Nhan vien quan ly");
                        System.out.println("0. Thoat them nhan vien");
                        System.out.print("Nhap lua chon de them: ");
                        chon = sc.nextInt();

                        switch (chon){
                            case 1:
                                ql.themNVHC(sc);
                                break;
                            case 2:
                                ql.themNVXS(sc);
                                break;
                            case 3:
                                ql.themNVQL(sc);
                                break;
                            case 0:
                                System.out.println("Da thoat them nhan vien");
                                break;
                            default:
                                System.out.println("Lua chon khong hop le. Vui long chon lai");
                        }
                    }while(chon != 0);
                    break;
                case 2:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach nhan vien la:");
                    ql.inDanhSach();
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Nhan vien co luong cao nhat la:");
                    ql.timNhanVienLuongMax();
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach sap xep giam dan theo luong la:");
                    ql.sapXepGiamDanTheoLuong();
                    ql.inDanhSach();
                    break;
                case 5:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    sc.nextLine();
                    String maCanTim;
                    System.out.print("Nhap ma can tim: ");
                    maCanTim = sc.nextLine();
                    System.out.println("Thong tin nhan vien co ma " + maCanTim + " la:");
                    ql.timNhanVienTheoMa(maCanTim);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai");
            }
        }while(luaChon != 0);

        sc.close();
    }
}
