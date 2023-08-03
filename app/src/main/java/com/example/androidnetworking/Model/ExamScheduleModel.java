package com.example.androidnetworking.Model;

public class ExamScheduleModel {
    String idLT;
    String ngayThi;
    String maMon;
    String diaDiem;
    int ca;

    public ExamScheduleModel(String idLT, String ngayThi, String maMon, String diaDiem, int ca) {
        this.idLT = idLT;
        this.ngayThi = ngayThi;
        this.maMon = maMon;
        this.diaDiem = diaDiem;
        this.ca = ca;
    }

    public String getIdLT() {
        return idLT;
    }

    public void setIdLT(String idLT) {
        this.idLT = idLT;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }
}
