package com.example.doanmonhoc;

public class GioSanClass {
    private int Id;
    private String ngaydat;
    private String tensan;
    private String thoigianbatdau;
    private String thoigianketthuc;
    private String tentt;
    private String tennuoc;
    private String tongtien;
    private String phone;

    public GioSanClass(int id, String ngaydat, String tensan, String thoigianbatdau, String thoigianketthuc, String tentt, String tennuoc, String tongtien, String phone) {
        Id = id;
        this.ngaydat = ngaydat;
        this.tensan = tensan;
        this.thoigianbatdau = thoigianbatdau;
        this.thoigianketthuc = thoigianketthuc;
        this.tentt = tentt;
        this.tennuoc = tennuoc;
        this.tongtien = tongtien;
        this.phone = phone;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getTensan() {
        return tensan;
    }

    public void setTensan(String tensan) {
        this.tensan = tensan;
    }

    public String getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(String thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public String getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(String thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public String getTentt() {
        return tentt;
    }

    public void setTentt(String tentt) {
        this.tentt = tentt;
    }

    public String getTennuoc() {
        return tennuoc;
    }

    public void setTennuoc(String tennuoc) {
        this.tennuoc = tennuoc;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
