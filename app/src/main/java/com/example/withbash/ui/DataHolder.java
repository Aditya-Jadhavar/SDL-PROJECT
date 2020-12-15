package com.example.withbash.ui;

public class DataHolder {

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    String date;

    public DataHolder(String date, String phoneNumber, String packages) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.packages = packages;

    }

    String phoneNumber;
    String packages;

}
