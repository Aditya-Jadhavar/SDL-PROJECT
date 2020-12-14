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

    public String getPakage() {
        return pakage;
    }

    public void setPakage(String pakage) {
        this.pakage = pakage;
    }

    String date;

    public DataHolder(String date, String phoneNumber, String pakage) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.pakage = pakage;
    }

    String phoneNumber;
    String pakage;


}
