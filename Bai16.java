import java.util.Scanner;

public class Bai16 {
    public static class NhanVien{
        private String maNV, hoTen;
        private double luong;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma nhan vien: ");
            maNV = sc.nextLine();

            System.out.print("Nhap ho ten nhan vien: ");
            hoTen = sc.nextLine();

            System.out.print("Nhap luong nhan vien: ");
            luong = sc.nextDouble();
        }

        void xuat(){
            System.out.println("Ma nhan vien: " + maNV
                    + "  |  Ho ten nhan vien: " + hoTen
                    + "  |  Luong nhan vien: " + luong);
        }

        double getLuong() {
            return luong;
        }

        String getHoTen(){
            return hoTen;
        }
    }

    public static class DanhSachNhanVien{
        int n;
        NhanVien[] ds;

        void nhapDanhSach(Scanner sc){
            System.out.print("Nhap so nhan vien: ");
            n = sc.nextInt();
            ds = new NhanVien[n];

            if(n == 0){
                System.out.println("Danh sach rong");
                return;
            }

            for(int i = 0; i < n; i++){
                System.out.println("Nhap nhan vien thu: " + (i + 1));
                ds[i] = new NhanVien();
                ds[i].nhap(sc);
            }
        }

        void xuatDanhSach(){
            for(NhanVien x : ds){
                x.xuat();
            }
        }

        void timNVCoLuongMax(){
            double luongMax = ds[0].getLuong();
            for(NhanVien x : ds){
                if(x.getLuong() > luongMax) luongMax = x.getLuong();
            }

            for(NhanVien x : ds){
                if(x.getLuong() == luongMax){
                    x.xuat();
                }
            }
        }

        double tongLuong(){
            double tong = 0;
            for(NhanVien x : ds) tong += x.getLuong();
            return tong;
        }

        void timTheoTen(String tenCanTim){
            boolean found = false;
            for(NhanVien x : ds){
                if(x.getHoTen().toLowerCase().contains(tenCanTim.toLowerCase())){
                    x.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co nhan vien ten: " + tenCanTim);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachNhanVien ds = new DanhSachNhanVien();
        ds.nhapDanhSach(sc);

        System.out.println("-----Danh sach nhan vien-----");
        ds.xuatDanhSach();

        System.out.println("Nhan vien co luong cao nhat la:");
        ds.timNVCoLuongMax();

        double tongLuongNV = ds.tongLuong();
        System.out.println("Tong luong cong ty la: " + tongLuongNV);

        String tenCanTim;
        sc.nextLine();
        System.out.print("Nhap ten can tim: ");
        tenCanTim = sc.nextLine();
        System.out.println("Nhan vien co ten " + tenCanTim + " la:");
        ds.timTheoTen(tenCanTim);

        sc.close();
    }
}
