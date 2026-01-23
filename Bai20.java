import java.util.Scanner;

public class Bai20 {
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
            if(n == 0) return 0;
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

        boolean checkDS(){
            return ds == null || n == 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien ds = new DanhSachSinhVien();

        int luaChon;
        do{
            System.out.println("----------Menu----------");
            System.out.println("1. Nhap danh sach");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Tim sinh vien theo ten");
            System.out.println("4. Tim sinh vien co diem trung binh cao nhat");
            System.out.println("5. Tinh diem trung binh ca lop");
            System.out.println("6. Sap xep sinh vien giam dan theo diem trung binh");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch(luaChon) {
                case 1:
                    ds.nhapDanhSach(sc);
                    break;
                case 2:
                    if(ds.checkDS()){
                        System.out.println("Danh sach chua co du lieu.");
                        break;
                    }

                    System.out.println("Danh sach da nhap la:");
                    ds.xuatDanhSach();
                    break;
                case 3:
                    if(ds.checkDS()){
                        System.out.println("Danh sach chua co du lieu.");
                        break;
                    }

                    String tenCanTim;
                    sc.nextLine();
                    System.out.print("Nhap ten sinh vien can tim: ");
                    tenCanTim = sc.nextLine();
                    System.out.println("Sinh vien co ten " + tenCanTim + " la:");
                    ds.timSVTheoTen(tenCanTim);
                    break;
                case 4:
                    if(ds.checkDS()){
                        System.out.println("Danh sach chua co du lieu.");
                        break;
                    }

                    System.out.println("Sinh vien co diem trung binh cao nhat la:");
                    ds.timSVCoDiemTBMax();
                    break;
                case 5:
                    if(ds.checkDS()){
                        System.out.println("Danh sach chua co du lieu.");
                        break;
                    }

                    double diemTBLop = ds.diemTBCuaCaLop();
                    System.out.print("Diem trung binh cua ca lop la: " + diemTBLop);
                    break;
                case 6:
                    if(ds.checkDS()){
                        System.out.println("Danh sach chua co du lieu.");
                        break;
                    }

                    ds.sapXepGiamDanDiemTB();
                    System.out.println("Danh sach sau khi sap xep la:");
                    ds.xuatDanhSach();
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