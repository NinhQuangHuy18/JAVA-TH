package Bai30;

import java.util.Scanner;

public class SinhVienBiz extends SinhVien{
    private float diemMarketing, diemSales;

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
        System.out.printf("  |  Diem Marketing: %-5.2f  |  Diem Sales: %-5.2f\n", diemMarketing, diemSales);
    }

    @Override
    float tinhDiemTB() {
        return (diemMarketing * 2 + diemSales) / 3;
    }
}
