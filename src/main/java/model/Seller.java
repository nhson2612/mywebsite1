package model;

import java.sql.*;
public class Seller{
    private String name;
    private String address;
    private Date joinDate;
    private int rate;
    private String email;
    private long numberPhone;

    public Seller(String name,String address,Date joinDate,int rate){
        this.name = name;
        this.address = address;
        this.joinDate = joinDate;
        this.rate = rate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setJoinDate(Date joinDate){
        this.joinDate = joinDate;
    }

    public void setRate(int rate){
        this.rate = rate;
    }

    public int getRate(){
        return this.rate;
    }

    public Date getJointDate(){
        return this.joinDate;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }
}
