import Bai29.NhanVienFullTime;
import Bai29.QuanLyNhanVien;

void main() {
        QuanLyNhanVien ql = new QuanLyNhanVien();

        ql.them(new NhanVienFullTime("NV01", "An", 8000000, 2000000));
        ql.xuatDanhSach();
}