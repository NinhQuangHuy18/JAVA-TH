package Bai29;

import java.util.ArrayList;

public class QuanLyNhanVien {
    private ArrayList<NhanVien> ds = new ArrayList<>();

    public void them(NhanVien x){
        ds.add(x);
    }

    public void xuatDanhSach(){
        for(NhanVien x : ds){
            x.xuat();
        }
    }
}
