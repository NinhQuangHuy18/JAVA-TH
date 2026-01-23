import java.util.Scanner;

public class Bai15 {
    public static class SanPham{
        private String maSP, tenSP;
        private double gia;
        private int soLuong;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma san pham: ");
            maSP = sc.nextLine();

            System.out.print("Nhap ten san pham: ");
            tenSP = sc.nextLine();

            System.out.print("Nhap gia san pham: ");
            gia = sc.nextDouble();

            System.out.print("Nhap so luong san pham: ");
            soLuong = sc.nextInt();
        }

        void xuat(){
            System.out.println("Ma san pham: " + maSP
                    + "  |  Ten san pham: " + tenSP
                    + "  | Gia san pham: " + gia
                    + "  |  So luong san pham: " + soLuong);
        }

        double getGia(){
            return gia;
        }

        int getSoLuong(){
            return soLuong;
        }

        String getTenSP(){
            return tenSP;
        }

    }

    public static class DanhSachSanPham{
        int n;
        SanPham[] ds;

        void nhapDanhSach(Scanner sc){
            System.out.print("Nhap so loai san pham: " );
            n = sc.nextInt();
            ds = new SanPham[n];

            for(int i = 0; i < n; i++){
                System.out.println("San pham thu " + (i + 1) + " la: ");
                ds[i] = new SanPham();
                ds[i].nhap(sc);
            }
        }

        void xuatDanhSach(){
            for(SanPham x : ds){
                x.xuat();
            }
        }

        void timSPCoGiaCaoNhat(){
            double giaMax = ds[0].getGia();
            for(SanPham x : ds){
                if(x.getGia() > giaMax){
                    giaMax = x.getGia();
                }
            }

            for(SanPham x : ds){
                if(x.getGia() == giaMax){
                    x.xuat();
                }
            }
        }

        double tongGiaTriKho(){
            double tong = 0;
            for(SanPham x : ds){
                tong += x.getGia() * x.getSoLuong();
            }
            return tong;
        }

        void timSPTheoTen(String ten){
            boolean found = false;
            for(SanPham x : ds){
                if(x.getTenSP().toLowerCase().contains(ten.toLowerCase())){
                    x.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co san pham ten: " + ten);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSanPham ds = new DanhSachSanPham();
        ds.nhapDanhSach(sc);

        System.out.println("-----Danh sach san pham la-----");
        ds.xuatDanhSach();

        System.out.println("San pham co gia cao nhat la: ");
        ds.timSPCoGiaCaoNhat();

        double tongKho = ds.tongGiaTriKho();
        System.out.println("Tong gia tri cua kho la: " + tongKho);

        String tenCanTim;
        sc.nextLine();
        System.out.print("Nhap ten san pham can tim: ");
        tenCanTim = sc.nextLine();
        System.out.println("Danh sach san pham co ten " + tenCanTim + " la:" );
        ds.timSPTheoTen(tenCanTim);

        sc.close();
    }
}
