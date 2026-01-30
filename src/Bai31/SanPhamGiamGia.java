package Bai31;

import java.util.Scanner;

public class SanPhamGiamGia extends SanPham{
    private double phanTranGiam;
    private double giaGoc;

    @Override
    void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap gia goc: ");
        giaGoc = sc.nextDouble();

        System.out.print("Nhap phan tram giam: ");
        phanTranGiam = sc.nextDouble();
    }

    @Override
    void xuat() {
        super.xuat();
        System.out.printf("  |  GiaGoc: %-10.2f  |  Phan tram giam: %-5.2f\n",giaGoc, phanTranGiam);
    }

    @Override
    double tinhGiaBan() {
        return giaGoc * (1 - phanTranGiam / 100);
    }
}
