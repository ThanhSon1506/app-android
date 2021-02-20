package com.example.food_2.Model;

public class NguoiDungModel {
    private String ten;
    private String gmail;
    private String matkhau;
    private int phanquyen;
    private int action;

    public NguoiDungModel(String gmail, String matkhau, int phanquyen) {
        this.gmail = gmail;
        this.matkhau = matkhau;
        this.phanquyen = phanquyen;
    }

    public  NguoiDungModel(){

    }
    public NguoiDungModel(String ten, String gmail, String matkhau, int phanquyen, int action) {
        this.ten = ten;
        this.gmail = gmail;
        this.matkhau = matkhau;
        this.phanquyen = phanquyen;
        this.action = action;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(int phanquyen) {
        this.phanquyen = phanquyen;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
