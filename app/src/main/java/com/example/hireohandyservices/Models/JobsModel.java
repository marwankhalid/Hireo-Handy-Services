package com.example.hireohandyservices.Models;

public class JobsModel {
    private int img;
    private String jobTitle;
    private String jobLocation;
    private String jobPhone;
    private String jobPrice;

    public JobsModel(int img, String jobTitle, String jobLocation, String jobPhone, String jobPrice) {
        this.img = img;
        this.jobTitle = jobTitle;
        this.jobLocation = jobLocation;
        this.jobPhone = jobPhone;
        this.jobPrice = jobPrice;
    }

    public JobsModel() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public String getJobTitle() {
        return jobTitle;
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
