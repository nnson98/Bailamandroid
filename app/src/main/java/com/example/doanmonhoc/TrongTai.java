package com.example.doanmonhoc;

public class TrongTai {
    private int idtt;
    private String hotentt;
    private String tuoitt;
    private String kntt;
    private String hinhtt;
    private String dongia;

    public TrongTai(int idtt, String hotentt, String tuoitt, String kntt, String hinhtt, String dongia) {
        this.idtt = idtt;
        this.hotentt = hotentt;
        this.tuoitt = tuoitt;
        this.kntt = kntt;
        this.hinhtt = hinhtt;
        this.dongia = dongia;
    }

    public int getIdtt() {
        return idtt;
    }

    public void setIdtt(int idtt) {
        this.idtt = idtt;
    }

    public String getHotentt() {
        return hotentt;
    }

    public void setHotentt(String hotentt) {
        this.hotentt = hotentt;
    }

    public String getTuoitt() {
        return tuoitt;
    }

    public void setTuoitt(String tuoitt) {
        this.tuoitt = tuoitt;
    }

    public String getKntt() {
        return kntt;
    }

    public void setKntt(String kntt) {
        this.kntt = kntt;
    }

    public String getHinhtt() {
        return hinhtt;
    }

    public void setHinhtt(String hinhtt) {
        this.hinhtt = hinhtt;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }
}
