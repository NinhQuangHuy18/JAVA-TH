package Bai17;

import java.util.Scanner;

public class Bai17 {
    public static class HoaDon{
        private String maHD, tenKhachHang;
        private double donGia;
        private int soLuong;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma hoa don: ");
            maHD = sc.nextLine();

            System.out.print("Nhap ten khach hang: ");
            tenKhachHang = sc.nextLine();

            System.out.print("Nhap don gia: ");
            donGia = sc.nextDouble();

            System.out.print("Nhap so luong: ");
            soLuong  = sc.nextInt();

        }

        void xuat(){
            System.out.println("Ma hao don: " + maHD
                    + "  |  Ten khach hang: " + tenKhachHang
                    + "  |  Don gia: " + donGia
                    + "  |  So luong: " + soLuong
                    + "  |  Thanh tien: " + thanhTien());
        }

        double getDonGia() {
            return donGia;
        }

        int getSoLuong() {
            return soLuong;
        }

        double thanhTien(){
            return getSoLuong() * getDonGia();
        }
    }

    public static class DanhSachHoaDon{
        int n;
        HoaDon[] ds;

        void nhapDanhSach(Scanner sc){
            System.out.print("Nhap so hoa don: ");
            n = sc.nextInt();
            ds = new HoaDon[n];

            if(n == 0){
                System.out.println("Danh sach trong");
                return;
            }

            for(int i = 0; i < n; i++){
                System.out.println("Nhap hoa don thu " + (i + 1) + ": ");
                ds[i] = new HoaDon();
                ds[i].nhap(sc);
            }
        }

        void xuatDanhSach(){
            for(HoaDon x : ds){
                x.xuat();
            }
        }

        double tongDoanhThu(){
            double tong = 0;
            for(HoaDon x : ds){
                tong += x.thanhTien();
            }
            return tong;
        }

        void hoaDonGiaTriLonHon(double x){
            boolean found = false;
            for(HoaDon hd : ds){
                if(hd.thanhTien() > x){
                    hd.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co hoa don nao lon hon: " + x);
        }

        void sapXepGiamDanTheoThanhTien(){
            for(int i = 0; i < ds.length - 1; i++){
                for(int j = i + 1; j < ds.length; j++){
                    if(ds[i].thanhTien() < ds[j].thanhTien()){
                        HoaDon temp = ds[i];
                        ds[i] = ds[j];
                        ds[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachHoaDon ds = new DanhSachHoaDon();
        ds.nhapDanhSach(sc);

        System.out.println("-----Danh sach hoa don-----");
        ds.xuatDanhSach();

        double tongDT = ds.tongDoanhThu();
        System.out.println("Tong doanh thu la: " + tongDT);

        System.out.print("Nhap gia tri hoa don: ");
        double x= sc.nextDouble();
        System.out.println("Hoa don co gia tri lon hon " + x + " la:");
        ds.hoaDonGiaTriLonHon(x);

        ds.sapXepGiamDanTheoThanhTien();
        System.out.println("Danh sach sau khi sap xep la:");
        ds.xuatDanhSach();

        sc.close();
    }
}
