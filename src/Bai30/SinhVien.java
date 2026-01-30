package Bai30;

import java.util.Scanner;

public abstract class SinhVien implements XepLoai{
    private String maSV, hoTen;

    void nhap(Scanner sc){
        sc.nextLine();
        System.out.print("Nhap ma sinh vien: ");
        maSV = sc.nextLine();

        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
    }

    void xuat(){
        System.out.printf("Ma sin vien: %-10s  |  Ho ten: %-20s  |  Diem trung binh: %5.2f |  Xep loai: %-10s", maSV, hoTen, tinhDiemTB(), xepLoai());
    }

    abstract float tinhDiemTB();

    @Override
    public String xepLoai() {
        if(tinhDiemTB() >= 8) return "Giỏi";
        else if(tinhDiemTB() >= 6.5) return "Khá";
        else if(tinhDiemTB() >= 5) return "Trung bình";
        else return "Yếu";
    }

    public String getMaSV() {
        return maSV;
    }
}
