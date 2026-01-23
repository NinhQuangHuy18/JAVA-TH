import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai25 {
    public static abstract class SinhVien{
        private String maSV, hoTen;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma sinh vien: ");
            maSV = sc.nextLine();

            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();
        }

        void xuat(){
            System.out.printf("Ma sinh vien: %-10s  |  Ten sinh vien: %-20s  |  Diem trung binh: %-5.2f  |  Xep loai: %-10s",
                    maSV, hoTen, getDiem(), xepLoai());
        }

        public abstract float getDiem();

        String xepLoai(){
            if(getDiem() >= 8) return "Gioi";
            else if(getDiem() >= 6.5) return "Kha";
            else if(getDiem() >= 5) return "Trung binh";
            else return "Yeu";
        }
    }

    public static class SinhVienIT extends SinhVien{
        private float diemJava, diemWeb;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap diem java: ");
            diemJava = sc.nextFloat();

            System.out.print("Nhap diem Web: ");
            diemWeb = sc.nextFloat();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.printf("  |  Diem java: %-8.1f  |  Diem web: %.1f\n",
                    diemJava, diemWeb);
        }

        public float getDiemJava() {
            return diemJava;
        }

        public float getDiemWeb() {
            return diemWeb;
        }

        @Override
        public float getDiem() {
            return (getDiemJava() + getDiemWeb()) / 2;
        }
    }

    public static class SinhVienBiz extends SinhVien{
        float diemMarketing, diemSales;

        @Override
        void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap diem marketing: ");
            diemMarketing = sc.nextFloat();

            System.out.print("Nhap diem sales: ");
            diemSales = sc.nextFloat();
        }

        @Override
        void xuat() {
            super.xuat();
            System.out.printf("  |  Diem marketing: %.1f  |  Diem sales: %.1f\n",
                    diemMarketing, diemSales);
        }

        public float getDiemSales() {
            return diemSales;
        }

        public float getDiemMarketing() {
            return diemMarketing;
        }

        @Override
        public float getDiem() {
            return (getDiemMarketing() + getDiemSales()) / 2;
        }
    }

    public static class QuanLySinhVien{
        ArrayList<SinhVien> ds= new ArrayList<>();

        void themSVIT(Scanner sc){
            SinhVienIT x = new SinhVienIT();
            x.nhap(sc);
            ds.add(x);
        }

        void themSVBiz(Scanner sc){
            SinhVienBiz x = new SinhVienBiz();
            x.nhap(sc);
            ds.add(x);
        }

        void inDanhSach(){
            for(SinhVien x : ds){
                x.xuat();
            }
        }

        void timSVCoDiemCaoNhat(){
            float diemMax = ds.get(0).getDiem();
            for(SinhVien x : ds){
                if(x.getDiem() > diemMax){
                    diemMax = x.getDiem();
                }
            }

            for(SinhVien x : ds){
                if(Math.abs(x.getDiem() - diemMax) < 1e-9){
                    x.xuat();
                }
            }
        }

        void sapXepGiamDanTheoDiem(){
            Collections.sort(ds, (a, b) -> Float.compare(b.getDiem(), a.getDiem()));
        }

        boolean checkDS(){
            return ds.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySinhVien ql = new QuanLySinhVien();

        int luaChon;
        do{
            System.out.println("------------------------------");
            System.out.println("----------MENU----------");
            System.out.println("1. Them sinh vien IT");
            System.out.println("2. Them sinh vien Biz");
            System.out.println("3. In danh sach sinh vien");
            System.out.println("4. Tim sinh vien co diem cao nhat");
            System.out.println("5. Sap xep giam dan them diem");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("------------------------------");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    ql.themSVIT(sc);
                    break;
                case 2:
                    ql.themSVBiz(sc);
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Danh sach sinh vien la:");
                    ql.inDanhSach();
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    System.out.println("Sinh vien co diem cao nhat la:");
                    ql.timSVCoDiemCaoNhat();
                    break;
                case 5:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu");
                        break;
                    }

                    ql.sapXepGiamDanTheoDiem();
                    System.out.println("Danh sach sau khi sap xep la:");
                    ql.inDanhSach();
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
