package Bai30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLySinhVien {
    private ArrayList<SinhVien> ds = new ArrayList<>();

    void themSVIT(Scanner sc){
        SinhVienIT x = new SinhVienIT();
        x.nhap(sc);
        ds.add(x);
    }

    void themSVBiz(Scanner sc){
        SinhVienBiz x = new SinhVienBiz();
        x.nhap(sc);
        ds.add(x);
    }

    void inDanhSach(){
        for(SinhVien x : ds){
            x.xuat();
        }
    }

    void timSVCoDiemTBMax(){
        float diemTBMax = ds.get(0).tinhDiemTB();
        for(SinhVien x : ds){
            if(x.tinhDiemTB() > diemTBMax){
                diemTBMax = x.tinhDiemTB();
            }
        }

        for(SinhVien x : ds){
            if(Math.abs(x.tinhDiemTB() - diemTBMax) < 1e-9){
                x.xuat();
            }
        }
    }

    void sapXepGiamDanTheoDiemTB(){
        Collections.sort(ds, (a, b) -> Float.compare(b.tinhDiemTB(), a.tinhDiemTB()));
    }

    void timSVTheoMa(String maCanTim){
        boolean found = false;
        for(SinhVien x : ds){
            if(x.getMaSV().equals(maCanTim)){
                x.xuat();
                found = true;
            }
        }

        if(!found) System.out.println("Khong co sinh vien nao co ma: " + maCanTim);
    }

    boolean checkDS(){
        return ds.isEmpty();
    }
}
