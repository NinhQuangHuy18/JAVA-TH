package Bai29;

public class NhanVienFullTime extends NhanVien{
    private double luongCoBan, thuong;

    public NhanVienFullTime(String maNV, String tenNV, double luongCoBan, double thuong){
        super(maNV, tenNV);
        this.luongCoBan = luongCoBan;
        this.thuong = thuong;
    }

    @Override
    public double tinhThuNhap() {
        return luongCoBan + thuong;
    }

    @Override
    public void xuat() {
        System.out.println("Ma nhan vien: " + maNV + "  |  Ten nhan vien: " + tenNV + "  |  Thu nhap: " + tinhThuNhap());
    }
}
