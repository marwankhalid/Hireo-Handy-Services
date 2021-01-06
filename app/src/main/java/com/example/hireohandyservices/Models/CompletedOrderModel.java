package com.example.hireohandyservices.Models;

public class CompletedOrderModel {
    private int img;
    private String jobName;
    private String jobPhone;
    private String jobLocation;
    private String jobPrice;
    private String status;

    public CompletedOrderModel(int img, String jobName, String jobPhone, String jobLocation, String jobPrice, String status) {
        this.img = img;
        this.jobName = jobName;
        this.jobPhone = jobPhone;
        this.jobLocation = jobLocation;
        this.jobPrice = jobPrice;
        this.status = status;
    }

    public CompletedOrderModel() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setJobPhone(String jobPhone) {
        this.jobPhone = jobPhone;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public void setJobPrice(String jobPrice) {
        this.jobPrice = jobPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobPhone() {
        return jobPhone;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public String getJobPrice() {
        return jobPrice;
    }

    public String getStatus() {
        return status;
    }
}
