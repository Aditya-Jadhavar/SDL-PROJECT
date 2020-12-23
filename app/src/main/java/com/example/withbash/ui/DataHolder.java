package com.example.withbash.ui;

public class DataHolder {

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   // public String getPhoneNumber() {
  //      return phoneNumber;
  //  }

  //  public void setPhoneNumber(String phoneNumber) {
    //    this.phoneNumber = phoneNumber;
   // }

    public DataHolder(){}

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    String date;

    public DataHolder(String date, String eventName, String packages,String cost) {
        this.date = date;
     //   this.phoneNumber = phoneNumber;
        this.packages = packages;
        this.eventName = eventName;
        this.cost = cost;

    }

    //String phoneNumber;
    String packages;
    String eventName;
    String cost;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
