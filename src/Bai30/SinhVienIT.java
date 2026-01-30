package Bai30;

import java.util.Scanner;

public class SinhVienIT extends SinhVien{
    private float diemJava, diemHTML, diemCSS;

    @Override
    void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap diem java: ");
        diemJava = sc.nextFloat();

        System.out.print("Nhap diem HTML: ");
        diemHTML = sc.nextFloat();

        System.out.print("Nhap diem CSS: ");
        diemCSS = sc.nextFloat();
    }

    @Override
    void xuat() {
        super.xuat();
        System.out.printf("  |  Diem java: %-5.2f  |  Diem HTML: %-5.2f  |  Diem CSS: %-5.2f\n", diemJava, diemHTML, diemCSS);
    }

    @Override
    float tinhDiemTB() {
        return (diemJava * 2 + diemHTML + diemCSS) / 4;
    }
}
