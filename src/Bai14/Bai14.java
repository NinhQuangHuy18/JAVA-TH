package Bai14;

import java.util.Scanner;

public class Bai14 {
    public static class SinhVien{
        private String hoTen;
        private byte tuoi;
        private float diemTB;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();

            System.out.print("Nhap tuoi: ");
            tuoi = sc.nextByte();

            System.out.print("Nhap diem trung binh: ");
            diemTB = sc.nextFloat();
        }

        void xuat(){
            System.out.println("Ho ten: " + hoTen + "  | Tuoi: " + tuoi + "  | DiemTB: " + diemTB);
        }

        byte getTuoi(){
            return  tuoi;
        }

        float getDiemTB(){
            return diemTB;
        }

        String getHoTen(){
            return hoTen;
        }
    }

    public static class DanhSachSinhVien{
        int n;
        SinhVien[] ds;

        void nhapDanhSach(Scanner sc){
            System.out.print("Nhap so luong sinh vien: ");
            n = sc.nextInt();

            ds = new SinhVien[n];
            for(int i = 0; i < n; i++){
                System.out.println("Nhap sinh vien thu: " + (i + 1));
                ds[i] = new SinhVien();
                ds[i].nhap(sc);
            }
        }

        void xuatDanhSach(){
            for(SinhVien sv : ds){
                sv.xuat();
            }
        }

        void timTuoiLonNhat(){
            byte maxTuoi = ds[0].getTuoi();
            for(SinhVien sv : ds){
                if(sv.getTuoi() > maxTuoi) maxTuoi = sv.getTuoi();
            }

            for (SinhVien sv : ds){
                if(sv.getTuoi() == maxTuoi) sv.xuat();
            }
        }

        void sapXepDiemTangDan(){
            for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    if(ds[i].getDiemTB() > ds[j].getDiemTB()){
                        SinhVien temp = ds[i];
                        ds[i] = ds[j];
                        ds[j] = temp;
                    }
                }
            }
        }

        void timTheoTen(String ten){
            boolean found = false;
            for(SinhVien sv : ds){
                if(sv.getHoTen().toLowerCase().contains(ten.toLowerCase())){
                    sv.xuat();
                    found = true;
                }
            }
            if(!found) System.out.println("Khong tim thay sinh vien ten: " + ten);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DanhSachSinhVien ds = new DanhSachSinhVien();
        ds.nhapDanhSach(sc);

        System.out.println("---Danh Sach Sinh Vien---");
        ds.xuatDanhSach();

        System.out.println("Sinh vien co tuoi lon nhat la: ");
        ds.timTuoiLonNhat();

        ds.sapXepDiemTangDan();
        System.out.println("Danh sach sau khi sap xep diem tang dan la: ");
        ds.xuatDanhSach();

        sc.nextLine();
        System.out.println("Nhap ten can tim: ");
        String ten = sc.nextLine();

        System.out.println("Thong tin sinh vien co ten " + ten + " la: ");
        ds.timTheoTen(ten);

        sc.close();
    }
}
