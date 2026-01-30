package Bai31;

import java.util.Scanner;

public class SanPhamThuong extends SanPham{
    private float giaGoc;

    @Override
    void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap gia goc: ");
        giaGoc = sc.nextFloat();
    }

    @Override
    void xuat() {
        super.xuat();
        System.out.printf("  |  Gia goc: %-10.2f\n", giaGoc);
    }

    @Override
    double tinhGiaBan() {
        return giaGoc;
    }
}
