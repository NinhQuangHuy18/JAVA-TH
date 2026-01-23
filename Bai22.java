import java.util.*;

public class Bai22 {
    public static class NhanVien{
        String maNV, hoTen;
        double luong;

        void nhap(Scanner sc){
            sc.nextLine();
            System.out.print("Nhap ma nhan vien: ");
            maNV = sc.nextLine();

            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();

            System.out.print("Nhap luong: ");
            luong = sc.nextDouble();
        }

        void xuat(){
            System.out.println("Ma nhan vien: " + maNV
                    + "  |  Ho ten: " + hoTen
                    + "  |  Luong: " + luong);
        }

        String getHoTen(){
            return hoTen;
        }

        public double getLuong() {
            return luong;
        }

        String getMaNV(){
            return maNV;
        }
    }

    public static class QuanLyNhanVien{
        ArrayList<NhanVien> ds = new ArrayList<>();

        void them(Scanner sc){
            NhanVien x = new NhanVien();
            x.nhap(sc);
            ds.add(x);
        }

        void in(){
            for(NhanVien x : ds){
                x.xuat();
            }
        }

        void timNVTheoTen(String tenCanTim){
            boolean found = false;
            for(NhanVien x : ds){
                if(x.getHoTen().toLowerCase().contains(tenCanTim.toLowerCase())){
                    x.xuat();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co nhan vien ten: " + tenCanTim);
        }

        void sapXepGiamDanTheoLuong(){
            Collections.sort(ds, (a, b) -> Double.compare(b.getLuong(), a.getLuong()));
        }

        double luongTB(){
            if(ds.isEmpty()) return 0;
            double tong = 0;
            for(NhanVien x : ds){
                tong += x.getLuong();
            }
            return tong / ds.size();
        }

        void xoaNVTheoMa(String maCanXoa){
            Iterator<NhanVien> xoa = ds.iterator();
            boolean found = false;
            while (xoa.hasNext()){
                NhanVien x = xoa.next();
                if(x.getMaNV().equalsIgnoreCase(maCanXoa)){
                    xoa.remove();
                    found = true;
                }
            }

            if(!found) System.out.println("Khong co nhan vien co ma: " + maCanXoa);
        }

        boolean checkDS(){
            return ds.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyNhanVien ql = new QuanLyNhanVien();

        int luaChon;
        do{
            System.out.println("------------------------------");
            System.out.println("----------MENU----------");
            System.out.println("1. Nhap nhan vien");
            System.out.println("2. In danh sach nhan vien");
            System.out.println("3. Tim nhan vien theo ten");
            System.out.println("4. Sap xep giam dan theo luong");
            System.out.println("5. Tinh luong trung binh");
            System.out.println("6. Xoa nhan vien theo ma");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();

            switch (luaChon){
                case 1:
                    ql.them(sc);
                    break;
                case 2:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }
                    System.out.println("Danh sach da nhap la:");
                    ql.in();
                    break;
                case 3:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Nhap ten nhan vien can tim: ");
                    String tenCanTim = sc.nextLine();
                    System.out.println("Thong tin nhan vien co ten " + tenCanTim + " la:");
                    ql.timNVTheoTen(tenCanTim);
                    break;
                case 4:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }
                    ql.sapXepGiamDanTheoLuong();
                    System.out.println("Danh sach sau khi sap xep giam dan theo luong la:");
                    ql.in();
                    break;
                case 5:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }
                    double luongTB = ql.luongTB();
                    System.out.println("Luong trung binh cua nhan vien la: " + luongTB);
                    break;
                case 6:
                    if(ql.checkDS()){
                        System.out.println("Khong co du lieu.");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maCanXoa = sc.nextLine();
                    ql.xoaNVTheoMa(maCanXoa);
                    System.out.println("Danh sach nhan vien sau khi xoa ma " + maCanXoa + " la:");
                    ql.in();
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
