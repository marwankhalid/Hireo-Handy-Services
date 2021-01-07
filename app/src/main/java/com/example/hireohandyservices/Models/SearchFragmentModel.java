package com.example.hireohandyservices.Models;

public class SearchFragmentModel {
    private int img;
    private String jobTitle;
    private String jobLocation;
    private String jobPrice;
    private String jobPhone;


    public SearchFragmentModel(int img, String jobTitle, String jobLocation, String jobPrice, String jobPhone) {
        this.img = img;
        this.jobTitle = jobTitle;
        this.jobLocation = jobLocation;
        this.jobPrice = jobPrice;
        this.jobPhone = jobPhone;
    }

    public SearchFragmentModel() {
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

    public void setJobPrice(String jobPrice) {
        this.jobPrice = jobPrice;
    }

    public void setJobPhone(String jobPhone) {
        this.jobPhone = jobPhone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public String getJobPrice() {
        return jobPrice;
    }

    public String getJobPhone() {
        return jobPhone;
    }
}
