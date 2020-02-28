package com.example.doanmonhoc;

public class Nuoc {
    private int idnuoc;
    private String TenNuoc;
    private String DonGia;
    private String HinhNuoc;

    public Nuoc(int idnuoc, String tenNuoc, String donGia, String hinhNuoc) {
        this.idnuoc = idnuoc;
        TenNuoc = tenNuoc;
        DonGia = donGia;
        HinhNuoc = hinhNuoc;
    }

    public int getIdnuoc() {
        return idnuoc;
    }

    public void setIdnuoc(int idnuoc) {
        this.idnuoc = idnuoc;
    }

    public String getTenNuoc() {
        return TenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        TenNuoc = tenNuoc;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String donGia) {
        DonGia = donGia;
    }

    public String getHinhNuoc() {
        return HinhNuoc;
    }

    public void setHinhNuoc(String hinhNuoc) {
        HinhNuoc = hinhNuoc;
    }
}
