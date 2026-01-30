package Bai31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLySanPham {
    ArrayList<SanPham> ds = new ArrayList<>();

    void themSPT(Scanner sc){
        SanPhamThuong x = new SanPhamThuong();
        x.nhap(sc);
        ds.add(x);
    }

    void themSPGP(Scanner sc){
        SanPhamGiamGia x = new SanPhamGiamGia();
        x.nhap(sc);
        ds.add(x);
    }

    void inDanhSach(){
        for(SanPham x : ds){
            x.xuat();
        }
    }

    void sapXepSPGiamDanTheoGia(){
        Collections.sort(ds, (a, b) -> Double.compare(b.tinhGiaBan(), a.tinhGiaBan()));
    }

    boolean checkDS(){
        return ds.isEmpty();
    }
}
