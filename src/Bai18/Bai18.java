package Bai18;

import java.util.Scanner;

public class Bai18 {
    public static class Sach{
        private String maSach, tenSach, tacGia;
        private double gia;
        private int soLuong;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma sach: ");
            maSach = sc.nextLine();

            System.out.print("Nhap ten sach: ");
            tenSach = sc.nextLine();

            System.out.print("Nhap tac gia: ");
            tacGia = sc.nextLine();

            System.out.print("Nhap gia: ");
            gia = sc.nextDouble();

            System.out.print("Nhap so luong: ");
            soLuong = sc.nextInt();
        }

        void xuat(){
            System.out.println("Ma sach: " + maSach
                    + "  |  Ten sach: " + tenSach
                    + "  |  Tac gia: " + tacGia
                    + "  |  Gia: " + gia
                    + "  |  So luong: " + soLuong
                    + "  |  Thanh tien: " + thanhTien());
        }

        public double getGia() {
            return gia;
        }

        public int getSoLuong() {
            return soLuong;
        }

        double thanhTien(){
            return getGia() * getSoLuong();
        }

        String getTenSach(){
            return tenSach;
        }
    }

    public static class DanhSachSach{
        int n;
        Sach[] ds;

        void nhapDanhSach(Scanner sc){
            System.out.print("Nhap so luong sach: ");
            n = sc.nextInt();
            ds = new Sach[n];
            if(n <= 0){
                System.out.println("Danh sach rong");
                return;
            }

            for(int i = 0; i < n; i++){
                System.out.println("Nhap sach thu " + (i + 1) + ": ");
                ds[i] = new Sach();
                ds[i].nhap(sc);
            }
        }

        void xuatDanhSach(){
            for(Sach x : ds){
                x.xuat();
            }
        }

        void sachGiaMax(){
            double giaMax = ds[0].getGia();
            for(Sach x : ds){
                if(x.getGia() > giaMax) giaMax = x.getGia();
            }

            for(Sach x : ds){
                if(x.getGia() == giaMax){
                    x.xuat();
                }
            }
        }

        double tongGiaTriKhoSach(){
            double tong = 0;
            for(Sach x : ds){
                tong += x.thanhTien();
            }
            return tong;
        }

        void timSachTheoTen(String tenCanTim){
            boolean found = false;
            for(Sach x : ds){
                if(x.getTenSach().toLowerCase().contains(tenCanTim.toLowerCase())){
                    x.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co sach nao ten: " + tenCanTim);
        }

        void sapXepGiamDanTheoThanhTien(){
            for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    if(ds[i].thanhTien() < ds[j].thanhTien()){
                        Sach temp = ds[i];
                        ds[i] = ds[j];
                        ds[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSach ds = new DanhSachSach();
        ds.nhapDanhSach(sc);

        System.out.println("-----Danh sach sach-----");
        ds.xuatDanhSach();

        System.out.println("Sach co gia cao nhat la: ");
        ds.sachGiaMax();

        double tongKho = ds.tongGiaTriKhoSach();
        System.out.println("Tong gia tri kho sach la: " + tongKho);

        String tenCanTim;
        sc.nextLine();
        System.out.print("Nhap ten can tim: ");
        tenCanTim = sc.nextLine();
        System.out.println("Thong tin sach co ten " + tenCanTim + " la: ");
        ds.timSachTheoTen(tenCanTim);

        ds.sapXepGiamDanTheoThanhTien();
        System.out.println("Danh sach sau khi sap xep giam dan theo thanh tien la: ");
        ds.xuatDanhSach();

        sc.close();
    }
}
