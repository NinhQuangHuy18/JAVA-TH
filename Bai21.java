import java.util.*;

public class Bai21 {
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

        String getMaSV(){
            return maSV;
        }
    }

    public static class DanhSachSinhVien{
        ArrayList<SinhVien> ds = new ArrayList<>();

        void nhap(Scanner sc){
            SinhVien sv = new SinhVien();
            sv.nhap(sc);
            ds.add(sv);
        }

        void xuat(){
            for(SinhVien x : ds){
                x.xuat();
            }
        }

        void timSinhVienTheoTen(String tenCanTim){
            boolean found = false;
            for(SinhVien x : ds){
                if(x.getHoTen().toLowerCase().contains(tenCanTim.toLowerCase())){
                    x.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co sinh vien ten: " + tenCanTim);
        }

        double tinhDiemTBLop(){
            if(ds.isEmpty()){
                return 0;
            }

            double tong = 0;
            for(SinhVien x : ds){
                tong +=x.getDiemTB();
            }
            return tong / ds.size();
        }

        void sapXepGiamTheoDiemTB(){
            Collections.sort(ds, (a, b) -> Double.compare(b.getDiemTB(), a.getDiemTB()));
        }

        void xoaSVTheoMa(String maCanXoa){
           Iterator<SinhVien> xoa = ds.iterator();
           boolean found = false;
           while(xoa.hasNext()){
               SinhVien sv = xoa.next();
               if(sv.getMaSV().equalsIgnoreCase(maCanXoa)){
                   xoa.remove();
                   found = true;
               }
           }

           if(!found) System.out.println("Khong co sinh vien ma: " + maCanXoa);
        }

        boolean checkDS(){
            return ds.isEmpty();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien ql = new DanhSachSinhVien();

        int luaChon;
        do{
            System.out.println("------------------------------");
            System.out.println("----------Menu----------");
            System.out.println("1. Them sinh vien");
            System.out.println("2. In danh sach");
            System.out.println("3. Tim sinh vien theo ten");
            System.out.println("4. Tinh diem trung binh ca lop");
            System.out.println("5. Sap xep giam dan theo diem trung binh");
            System.out.println("6. Xoa sinh vien theo ma");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("------------------------------");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    ql.nhap(sc);
                    break;
                case 2:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }

                    System.out.println("Danh sach sinh vien la:");
                    ql.xuat();
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }

                    String tenCanTim;
                    sc.nextLine();
                    System.out.print("Nhap ten can tim: ");
                    tenCanTim = sc.nextLine();
                    System.out.println("Thong tin sinh vien co ten " + tenCanTim + " la:");
                    ql.timSinhVienTheoTen(tenCanTim);
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }

                    double diemTBLop = ql.tinhDiemTBLop();
                    System.out.println("Diem trung binh cua ca lop la: " + diemTBLop);
                    break;
                case 5:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }

                    ql.sapXepGiamTheoDiemTB();
                    System.out.println("Danh sach sau khi sap xep la:");
                    ql.xuat();
                    break;
                case 6:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }

                    String maCanXoa;
                    sc.nextLine();
                    System.out.print("Nhap ma can xoa: ");
                    maCanXoa = sc.nextLine();
                    ql.xoaSVTheoMa(maCanXoa);
                    System.out.println("Danh sach sau khi da xoa sinh vien ma " + maCanXoa + " la:");
                    ql.xuat();
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }while(luaChon != 0);

        sc.close();
    }
}
