package com.example.doanmonhoc;

import java.io.Serializable;

public class SanBong implements Serializable {
    private int idsanbong;
    private String TenSan;
    private String LoaiSan;
    private String DonGiaSanBanh;
    private String HinhSanBanh;

    public SanBong(int idsanbong, String tenSan, String loaiSan, String donGiaSanBanh, String hinhSanBanh) {
        this.idsanbong = idsanbong;
        TenSan = tenSan;
        LoaiSan = loaiSan;
        DonGiaSanBanh = donGiaSanBanh;
        HinhSanBanh = hinhSanBanh;
    }

    public int getIdsanbong() {
        return idsanbong;
    }

    public void setIdsanbong(int idsanbong) {
        this.idsanbong = idsanbong;
    }

    public String getTenSan() {
        return TenSan;
    }

    public void setTenSan(String tenSan) {
        TenSan = tenSan;
    }

    public String getLoaiSan() {
        return LoaiSan;
    }

    public void setLoaiSan(String loaiSan) {
        LoaiSan = loaiSan;
    }

    public String getDonGiaSanBanh() {
        return DonGiaSanBanh;
    }

    public void setDonGiaSanBanh(String donGiaSanBanh) {
        DonGiaSanBanh = donGiaSanBanh;
    }

    public String getHinhSanBanh() {
        return HinhSanBanh;
    }

    public void setHinhSanBanh(String hinhSanBanh) {
        HinhSanBanh = hinhSanBanh;
    }
}
