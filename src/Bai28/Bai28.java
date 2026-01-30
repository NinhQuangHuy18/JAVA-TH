package Bai28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Bai28 {
    interface TinhThuNhap{
        double tinhThuNhap();
    }

    public static abstract class NhanVien implements TinhThuNhap{
        private String maNV, hoTen;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma nhan vien: ");
            maNV = sc.nextLine();

            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();
        }

        void xuat(){
            System.out.printf("Ma nhan vien: %-5s  |  Ho ten: %-10s  |  Thu nhap: %-10.2f  |  Xep loai: %-10s", maNV, hoTen,tinhThuNhap(), xepLoai());
        }

        String xepLoai(){
            if(tinhThuNhap() >= 20000000) return "Xuất sắc";
            else if(tinhThuNhap() >= 10000000) return "Tốt";
            else return "Bình thường";
        }

        public String getMaNV() {
            return maNV;
        }
    }

    public static class NhanVienHanhChinh extends NhanVien{
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
            System.out.printf("  |  Luong co ban: %-10.2f  |  He so luong: %-10.2f\n", luongCoBan, heSoLuong);
        }

        @Override
        public double tinhThuNhap() {
            return luongCoBan * heSoLuong;
        }
    }

    public static class NhanVienSanXuat extends NhanVien{
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
            System.out.printf("  |  Luong co ban: %-10.2f  |  So san pham: %-5f\n",luongCoBan, soSanPham);
        }

        @Override
        public double tinhThuNhap() {
            return luongCoBan + soSanPham * 60000;
        }
    }

    public static class NhanVienQuanLy extends NhanVien{
        private double luongCoBan, phuCap, thuong;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap luong co ban: ");
            luongCoBan = sc.nextDouble();

            System.out.print("Nhap phu cap: ");
            phuCap = sc.nextDouble();

            System.out.print("Nhap thuong: ");
            thuong = sc.nextDouble();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.printf("  |  Luong co ban: %-10.2f  |  Phu cap: %-10.2f  |  Thuong: %-10.2f\n", luongCoBan, phuCap, thuong);
        }

        @Override
        public double tinhThuNhap() {
            return luongCoBan + phuCap + thuong;
        }
    }

    public static class QuanLyNhanVien{
        ArrayList<NhanVien> ds = new ArrayList<>();

        void themNVHC(Scanner sc){
            NhanVienHanhChinh x = new NhanVienHanhChinh();
            x.nhap(sc);
            ds.add(x);
        }

        void themNVSX(Scanner sc){
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
            for (NhanVien x : ds){
                x.xuat();
            }
        }

        void timNVCoThuNhapMax(){
            double thuNhapMax = ds.get(0).tinhThuNhap();
            for(NhanVien x : ds){
                if(x.tinhThuNhap() > thuNhapMax){
                    thuNhapMax = x.tinhThuNhap();
                }
            }

            for(NhanVien x : ds){
                if(Math.abs(x.tinhThuNhap() - thuNhapMax) < 1e-9){
                    x.xuat();
                }
            }
        }

        void sapXepGiamDanTheoThuNhap(){
            Collections.sort(ds, (a, b) -> Double.compare(b.tinhThuNhap(), a.tinhThuNhap()));
        }

        void timNVTheoMa(String maCanTim){
            boolean found = false;
            for(NhanVien x : ds){
                if(x.getMaNV().equals(maCanTim)){
                    x.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co nhan vien nao co ma: " + maCanTim);
        }

        void locDSTheoLoaiNV(){
            System.out.println("Nhan vien hanh chinh:");
            for(NhanVien x : ds){
                if(x instanceof NhanVienHanhChinh){
                    x.xuat();
                }
            }

            System.out.println("Nhan vien san xuat:");
            for(NhanVien x : ds){
                if(x instanceof NhanVienSanXuat){
                    x.xuat();
                }
            }

            System.out.println("Nhan vien quan ly:");
            for(NhanVien x : ds){
                if(x instanceof NhanVienQuanLy){
                    x.xuat();
                }
            }
        }

        void xoaNVTheoMa(String maCanXoa){
            boolean found = false;
            Iterator<NhanVien> it = ds.iterator();

            while (it.hasNext()){
                NhanVien x = it.next();
                if(x.getMaNV().equals(maCanXoa)){
                    it.remove();
                    found = true;
                    break;
                }
            }

            if(!found) System.out.println("Khong co nhan vien nao co ma: " + maCanXoa);
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
            System.out.println("1. Them nhan vien");
            System.out.println("2. In danh sach nhan vien");
            System.out.println("3. Tim nhan vien co thu nhap cao nhat");
            System.out.println("4. Sap xep giam dan theo thu nhap");
            System.out.println("5. Tim nhan vien theo ma");
            System.out.println("6. Loc danh sach theo xep loai nhan vien");
            System.out.println("7. Xoa nhan vien theo ma");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("------------------------------");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    int chon;
                    do{
                        System.out.println("1. Them nhan vien hanh chinh");
                        System.out.println("2. Them nhan vien san xuat");
                        System.out.println("3. Them nhan vien quan ly");

                        System.out.print("Nhap lua chon: ");
                        chon = sc.nextInt();

                        switch (chon){
                            case 1:
                                ql.themNVHC(sc);
                                break;
                            case 2:
                                ql.themNVSX(sc);
                                break;
                            case 3:
                                ql.themNVQL(sc);
                                break;
                            default:
                                System.out.println("Lua chon khong hop le. Vui long chon lai.");
                        }
                    }while (chon != 1 && chon != 2 && chon != 3);
                    break;
                case 2:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach nhan vien");
                    ql.inDanhSach();
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Nhan vien co thu nhap cao nhat la:");
                    ql.timNVCoThuNhapMax();
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    ql.sapXepGiamDanTheoThuNhap();
                    System.out.println("Danh sach sau khi sap xep la:");
                    ql.inDanhSach();
                    break;
                case 5:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Nhap ma can tim: ");
                    String maCanTim = sc.nextLine();
                    System.out.println("Nhan vien co ma " + maCanTim + " la:");
                    ql.timNVTheoMa(maCanTim);
                    break;
                case 6:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach sau khi loc la:");
                    ql.locDSTheoLoaiNV();
                    break;
                case 7:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    ql.xoaNVTheoMa(maCanXoa);
                    System.out.println("Danh sach sau khi xoa ma " + maCanXoa + " la:");
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
