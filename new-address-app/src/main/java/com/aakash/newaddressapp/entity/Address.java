package com.aakash.newaddressapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="address")
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "lane1")
    private String lane1;
    @Column(name = "lane2")
    private String lane2;
    @Column(name = "state")
    private String state;
    @Column(name = "zip")
    private String zip;



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
