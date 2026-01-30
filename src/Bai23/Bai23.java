package Bai23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Bai23 {
    public static class SanPham{
        private String maSP, tenSP;
        private double donGia;
        private int soLuong;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma san pham: ");
            maSP = sc.nextLine();

            System.out.print("Nhap ten san pham: ");
            tenSP = sc.nextLine();

            System.out.print("Nhap don gia: ");
            donGia = sc.nextDouble();

            System.out.print("Nhap so luong: ");
            soLuong = sc.nextInt();
        }

        void xuat(){
            System.out.println("Ma san pham: " + maSP
                    + "  |  Ten san pham: " + tenSP
                    + "  |  Don gia: " + donGia
                    + "  |  So luong: " + soLuong
                    + "  |  Thanh tien: " + thanhTien());
        }

        public String getTenSP() {
            return tenSP;
        }

        public double getDonGia() {
            return donGia;
        }

        public int getSoLuong() {
            return soLuong;
        }

        double thanhTien(){
            return getDonGia() * getSoLuong();
        }

        public String getMaSP() {
            return maSP;
        }
    }

    public static class QuanLySanPham{
        ArrayList<SanPham> ds = new ArrayList<>();

        void them(Scanner sc){
            SanPham x = new SanPham();
            x.nhap(sc);
            ds.add(x);
        }

        void in(){
            for(SanPham x : ds){
                x.xuat();
            }
        }

        void timSPTheoTen(String tenCanTim){
            boolean found = false;
            for(SanPham x : ds){
                if(x.getTenSP().toLowerCase().contains(tenCanTim.toLowerCase())){
                    x.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co san pham nao ten: " + tenCanTim);
        }

        void sapXepGiamDanTheoThanhTien(){
            Collections.sort(ds, (a, b) -> Double.compare(b.thanhTien(), a.thanhTien()));
        }

        void timSPCoThanhTienLonNhat(){
            double maxThanhTien = ds.get(0).thanhTien();
            for(SanPham x : ds){
                if(x.thanhTien() > maxThanhTien){
                    maxThanhTien = x.thanhTien();
                }
            }

            for(SanPham x : ds){
                if(x.thanhTien() == maxThanhTien){
                    x.xuat();
                }
            }
        }

        void xoaSPTheoMa(String maCanXoa){
            Iterator<SanPham> xoa = ds.iterator();
            boolean found = false;
            while (xoa.hasNext()){
                SanPham x = xoa.next();
                if(x.getMaSP().equalsIgnoreCase(maCanXoa)) {
                    xoa.remove();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co san pham nao co ma: " + maCanXoa);
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
            System.out.println("1. Them san pham");
            System.out.println("2. In danh sach pham");
            System.out.println("3. Tim san pham theo ten");
            System.out.println("4. Sap xep san pham giam dan theo thanh tien");
            System.out.println("5. Tim san pham co thanh tien lon nhat");
            System.out.println("6. Xoa san pham theo ma");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("------------------------------");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    ql.them(sc);
                    break;
                case 2:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach san pham da nhap la:");
                    ql.in();
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Nhap ten san pham can tim: ");
                    String tenCanTim = sc.nextLine();
                    System.out.println("Thong tin san pham co ten: " + tenCanTim + " la:");
                    ql.timSPTheoTen(tenCanTim);
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
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
                    ql.timSPCoThanhTienLonNhat();
                    break;
                case 6:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Nhap ma san pham can xoa: ");
                    String maCanXoa = sc.nextLine();
                    ql.xoaSPTheoMa(maCanXoa);
                    System.out.println("Danh sach san pham sau khi xoa ma: " + maCanXoa + " la:");
                    ql.in();
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
