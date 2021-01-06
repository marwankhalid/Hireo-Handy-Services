package com.example.hireohandyservices.Models;

public class ActiveOrderModel {
    private int img;
    private String status;
    private String jobName;
    private String jobLocation;
    private String jobPhone;
    private String jobPrice;


    public ActiveOrderModel(int img,String status, String jobName, String jobLocation, String jobPhone, String jobPrice) {
        this.img = img;
        this.status = status;
        this.jobName = jobName;
        this.jobLocation = jobLocation;
        this.jobPhone = jobPhone;
        this.jobPrice = jobPrice;
    }

    public ActiveOrderModel() {
    }

    public String getStatus() {
        return status;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public void setJobPhone(String jobPhone) {
        this.jobPhone = jobPhone;
    }

    public void setJobPrice(String jobPrice) {
        this.jobPrice = jobPrice;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public String getJobPhone() {
        return jobPhone;
    }

    public String getJobPrice() {
        return jobPrice;
    }
}
