import java.util.Scanner;

public class Bai19 {
    public static class SinhVien{
        private String maSV, hoTen;
        private double diemTB;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma sinh vien: ");
            maSV = sc.nextLine();

            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();

            System.out.print("Nhap diem trung binh: ");
            diemTB = sc.nextDouble();
        }

        void xuat(){
            System.out.println("Ma sinh vien: " + maSV
                    + "  |  Ho ten: " + hoTen
                    + "  |  Diem trung binh: " + diemTB
                    + "  |  Xep loai: " + xepLoai());
        }

        public double getDiemTB() {
            return diemTB;
        }

        String getHoTen(){
            return hoTen;
        }

        String xepLoai(){
            if(diemTB >= 8) return "Gioi";
            else if(diemTB >= 6.5) return "Kha";
            else if(diemTB >= 5) return  "Trung binh";
            else return "Yeu";
        }
    }

    public static class DanhSachSinhVien{
        int n;
        SinhVien[] ds;

        void nhapDanhSach(Scanner sc){
            System.out.print("Nhap so sinh vien: ");
            n = sc.nextInt();
            ds = new SinhVien[n];

            if(n <= 0){
                System.out.println("Danh sach rong");
                return;
            }

            for(int i = 0; i < n; i++){
                System.out.println("Nhap sinh vien thu: " + (i + 1));
                ds[i] = new SinhVien();
                ds[i].nhap(sc);
            }
        }

        void xuatDanhSach(){
            for(SinhVien x : ds){
                x.xuat();
            }
        }

        void timSVCoDiemTBMax(){
            double diemMax = ds[0].getDiemTB();
            for(SinhVien x : ds){
                if(x.getDiemTB() > diemMax){
                    diemMax = x.getDiemTB();
                }
            }

            for(SinhVien x : ds){
                if(x.getDiemTB() == diemMax){
                    x.xuat();
                }
            }
        }

        double diemTBCuaCaLop(){
            double diemTBLop = 0;
            for(SinhVien x : ds){
                diemTBLop += x.getDiemTB();
            }
            return  diemTBLop / n ;
        }

        void timSVTheoTen(String tenCanTim){
            boolean found = false;
            for(SinhVien x : ds){
                if(x.getHoTen().toLowerCase().contains(tenCanTim.toLowerCase())){
                    x.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong tim thay sinh vien ten: " + tenCanTim);
        }

        void sapXepGiamDanDiemTB(){
            for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    if(ds[i].getDiemTB() < ds[j].getDiemTB()){
                        SinhVien temp = ds[i];
                        ds[i] = ds[j];
                        ds[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien ds = new DanhSachSinhVien();

        ds.nhapDanhSach(sc);

        System.out.println("-----Danh sach sinh vien-----");
        ds.xuatDanhSach();

        System.out.println("Sinh vien co diem trung binh cao nhat la:");
        ds.timSVCoDiemTBMax();

        double diemTBLop = ds.diemTBCuaCaLop();
        System.out.println("Diem trung binh cua ca lop la: " + diemTBLop);

        String tenCanTim;
        sc.nextLine();
        System.out.print("Nhap ten can tim: ");
        tenCanTim = sc.nextLine();
        System.out.println("Thong tin sinh vien co ten " + tenCanTim + " la:");
        ds.timSVTheoTen(tenCanTim);

        ds.sapXepGiamDanDiemTB();
        System.out.println("Danh sach sau khi sap xep diem trung binh giam dan la");
        ds.xuatDanhSach();

        sc.close();
    }
}
