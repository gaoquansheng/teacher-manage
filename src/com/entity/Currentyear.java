package com.entity;

import java.util.Date;

public class Currentyear {
    private String projectYear;
    private Date startTime;
    private Date endTime;
    private int isUsed;

    public String getProjectYear() {
        return projectYear;
    }

    public void setProjectYear(String projectYear) {
        this.projectYear = projectYear;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }
}
