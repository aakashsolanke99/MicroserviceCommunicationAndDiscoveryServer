package com.aakash.newmployeeapp.response;


public class AddressResponse {

    private int id;

    private String lane1;

    private String lane2;

    private String state;
    private String zip;

    public AddressResponse() {
    }

    public AddressResponse(int id, String lane1, String lane2, String state, String zip) {
        this.id = id;
        this.lane1 = lane1;
        this.lane2 = lane2;
        this.state = state;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public String getLane1() {
        return lane1;
    }

    public String getLane2() {
        return lane2;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLane1(String lane1) {
        this.lane1 = lane1;
    }

    public void setLane2(String lane2) {
        this.lane2 = lane2;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
