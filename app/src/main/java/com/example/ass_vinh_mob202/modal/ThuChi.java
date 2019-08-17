package com.example.ass_vinh_mob202.modal;

public class ThuChi {


    public static final String CHI = "CHI";
    public static final String THU = "THU";


    public String id;

    public String ten;

    public float tien;

    public String thoiGian;

    public String khoanThuChi;

    public String loaiThuChi;

    public ThuChi(String ten,String khoanThuChi) {
        this.ten = ten;
        this.tien= 0;
        this.thoiGian="";
        this.loaiThuChi="";
        this.khoanThuChi=khoanThuChi;
    }

    public ThuChi() {
    }
}
