package com.example.androidnetworking.Model;

public class ScheduleModel {
    private String idLH;
    private String idMon;
    private int ca;
    private String diaDiem;
    private String ngayHoc;

    public ScheduleModel(String idLH, String idMon, int ca, String diaDiem, String ngayHoc) {
        this.idLH = idLH;
        this.idMon = idMon;
        this.ca = ca;
        this.diaDiem = diaDiem;
        this.ngayHoc = ngayHoc;
    }

    public String getIdLH() {
        return idLH;
    }

    public void setIdLH(String idLH) {
        this.idLH = idLH;
    }

    public String getIdMon() {
        return idMon;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String date) {
        this.ngayHoc = date;
    }
}
