package Bai31;

import java.util.Scanner;

public abstract class SanPham implements XepLoai {
    private String maSP, tenSP;

    void nhap(Scanner sc){
        sc.nextLine();
        System.out.print("Nhap ma san pham: ");
        maSP = sc.nextLine();

        System.out.print("Nhap ten san pham: ");
        tenSP = sc.nextLine();
    }

    void xuat(){
        System.out.printf("Ma san pham: %-10s  |  Ten san pham: %-10s  | Gia ban: %-10.2f  |  Xep loai: %-10s", maSP, tenSP, tinhGiaBan(), xepLoai());
    }

    abstract double tinhGiaBan();

    public String xepLoai() {
        if(tinhGiaBan() >= 10000000) return "Cao";
        else if(tinhGiaBan() >= 5000000) return "Trung binh";
        else return "Thap";
    }
}
