package com.example.androidnetworking.Model;

public class ScheduleModel {
    private String titile1, titile2, titile3, titile4, titile5;

    public ScheduleModel( String titile1, String titile2, String titile3, String titile4, String titile5) {
        this.titile1 = titile1;
        this.titile2 = titile2;
        this.titile3 = titile3;
        this.titile4 = titile4;
        this.titile5 = titile5;
    }

    public ScheduleModel() {
    }

    public String getTitile5() {
        return titile5;
    }

    public void setTitile5(String titile5) {
        this.titile5 = titile5;
    }

    public String getTitile1() {
        return titile1;
    }

    public void setTitile1(String titile1) {
        this.titile1 = titile1;
    }

    public String getTitile2() {
        return titile2;
    }

    public void setTitile2(String titile2) {
        this.titile2 = titile2;
    }

    public String getTitile3() {
        return titile3;
    }

    public void setTitile3(String titile3) {
        this.titile3 = titile3;
    }

    public String getTitile4() {
        return titile4;
    }

    public void setTitile4(String titile4) {
        this.titile4 = titile4;
    }
}
