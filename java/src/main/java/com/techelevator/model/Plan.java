package com.techelevator.model;

public class Plan {
    private int planId;
    private int userId;
    private String planName;
    private String houseType;
    private String state;
    private String city;
    private int squareFootage;
    private double priceRangeLower;
    private double priceRangeUpper;

    public double getPriceRangeLower() {
        return priceRangeLower;
    }

    public void setPriceRangeLower(double priceRangeLower) {
        this.priceRangeLower = priceRangeLower;
    }

    public double getPriceRangeUpper() {
        return priceRangeUpper;
    }

    public void setPriceRangeUpper(double priceRangeUpper) {
        this.priceRangeUpper = priceRangeUpper;
    }

    public Plan() {
    }

    public Plan(int planId, int userId, String planName, String houseType, String city, String state, int squareFootage) {
        this.planId = planId;
        this.userId = userId;
        this.planName = planName;
        this.houseType = houseType;
        this.state = state;
        this.city = city;
        this.squareFootage = squareFootage;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "planId=" + planId +
                ", userId=" + userId +
                ", planName='" + planName + '\'' +
                ", houseType='" + houseType + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", size=" + squareFootage +
                '}';
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }
}
