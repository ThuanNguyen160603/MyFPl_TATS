package com.example.androidnetworking.Model;

import java.util.List;

public class CategorySchedule {
    private String nameCategory;

    private List<ScheduleModel> schedules;

    public CategorySchedule(String nameCategory, List<ScheduleModel> schedules) {
        this.nameCategory = nameCategory;
        this.schedules = schedules;

    }

    public List<ScheduleModel> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleModel> schedules) {
        this.schedules = schedules;
    }


    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }


}
