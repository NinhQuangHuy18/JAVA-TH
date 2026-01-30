package Bai24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai24 {
    public static class SanPham{
        private String maSP, tenSP;
        private double donGia;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma san pham: ");
            maSP = sc.nextLine();

            System.out.print("Nhap ten san pham: ");
            tenSP = sc.nextLine();

            System.out.print("Nhap don gia: ");
            donGia = sc.nextDouble();
        }

        void xuat(){
            System.out.print("Ma san pham: " + maSP
                    + "  |  Ten san pham: " + tenSP
                    + "  |  Don gia: " + donGia);
        }

        double thanhTien(){
            return donGia;
        }

        public double getDonGia() {
            return donGia;
        }
    }

    public static class SanPhamDienTu extends SanPham{
        int thoiGianBaoHanh;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap thoi gian bao hanh: ");
            thoiGianBaoHanh = sc.nextInt();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.println("  |  Thoi gian bao hanh: " + thoiGianBaoHanh
                    + "  |  Thanh tien: " + thanhTien());
        }

        @Override
        double thanhTien() {
            return getDonGia() + getDonGia() * 0.1;
        }
    }

    public static class SanPhamThucPham extends SanPham{
        String ngayHetHan;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            sc.nextLine();
            System.out.print("Nhap ngay het han: ");
            ngayHetHan = sc.nextLine();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.println("  |  Ngay het han: " + ngayHetHan
                    + "  |  Thanh tien: " + thanhTien());
        }

        @Override
        double thanhTien() {
            return getDonGia() + getDonGia() * 0.05;
        }
    }

    public static class QuanLySanPham{
        ArrayList<SanPham> ds = new ArrayList<>();

        void themSPDT(Scanner sc){
            SanPhamDienTu x = new SanPhamDienTu();
            x.nhap(sc);
            ds.add(x);
        }

        void themSPTP(Scanner sc){
            SanPhamThucPham x = new SanPhamThucPham();
            x.nhap(sc);
            ds.add(x);
        }

        void in(){
            for(SanPham x : ds){
                x.xuat();
            }
        }

        void sapXepGiamDanTheoThanhTien(){
            Collections.sort(ds, (a, b)-> Double.compare(b.thanhTien(), a.thanhTien()));
        }

        void timSPCoThanhTienMax(){
            double MaxThanhTien = ds.get(0).thanhTien();
            for(SanPham x : ds){
                if(Math.abs(x.thanhTien() - MaxThanhTien) < 1e-9){
                    MaxThanhTien = x.thanhTien();
                }
            }

            for(SanPham x : ds){
                if(x.thanhTien() == MaxThanhTien){
                    x.xuat();
                }
            }
        }

        boolean checkDS(){
            return ds.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySanPham ql = new QuanLySanPham();

        int luaChon;
        do{
            System.out.println("------------------------------");
            System.out.println("----------MENU----------");
            System.out.println("1. Them san pham dien tu");
            System.out.println("2. Them san pham thuc pham");
            System.out.println("3. In danh sach san pham");
            System.out.println("4. Sap xep giam dan theo thanh tien");
            System.out.println("5. Tim san pham co thanh tien lon nhat");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("-------------------------------");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    ql.themSPDT(sc);
                    break;
                case 2:
                    ql.themSPTP(sc);
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach san pham la:");
                    ql.in();
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Kong co du lieu");
                        break;
                    }

                    ql.sapXepGiamDanTheoThanhTien();
                    System.out.println("Danh sach sau khi sap xep la:");
                    ql.in();
                    break;
                case 5:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("San pham co thanh tien lon nhat la:");
                    ql.timSPCoThanhTienMax();
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }

        }while (luaChon != 0);

        sc.close();
    }
}
