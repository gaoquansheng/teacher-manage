package com.entity;

import java.util.Date;

public class Projectmember {
    private int projectId;
    private String teacherId;
    private float score;
    private String creator;
    private String jobDescription;
    private int orderId;
    private String tName;
    private Date createTime;
    private String explain;
    private float Proportion;
    private float weight;
    private  String  sumscore;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public float getProportion() {
        return Proportion;
    }

    public void setProportion(float proportion) {
        Proportion = proportion;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    public String toString(){
        return "项目id:"+this.projectId+"老师id"+this.teacherId+"权重："+this.weight;
    }

    public String getSumscore() {
        return sumscore;
    }

    public void setSumscore(String sumscore) {
        this.sumscore = sumscore;
    }
}
