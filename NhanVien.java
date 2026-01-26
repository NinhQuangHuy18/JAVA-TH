public abstract class NhanVien implements TinhThuNhap{
    protected String maNV, tenNV;

    public NhanVien(String maNV, String tenNV){
        this.maNV = maNV;
        this.tenNV = tenNV;
    }

    public abstract void xuat();
}
