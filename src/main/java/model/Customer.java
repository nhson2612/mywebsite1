package model;
import java.sql.*;
public class Customer {
    private int id;
    private String name;
    private long numberPhone;
    private Date dateOfBirth;
    private boolean sex;
    private String address;
    private String email;
    private String passWord;

    public Customer(String name,long numberPhone,Date dateOfBirth,boolean sex,String address,String email,String passWord){
        this.name = name;
        this.numberPhone = numberPhone;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.passWord = passWord;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumberPhone(long numberPhone){
        this.numberPhone = numberPhone;
    }

    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(boolean sex){
        this.sex = sex;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public String getName(String name){
        return this.name;
    }

    public long getNumberPhone(long numberPhone){
        return this.numberPhone;
    }

    public Date getDateOfBirth(Date dateOfBirth){
        return this.dateOfBirth;
    }

    public boolean getSex(boolean sex){
        return this.sex;
    }

    public String getAddress(String address){
        return this.address;
    }

    public String getEmail(String email){
        return this.email;
    }

    public String getPassWord(String passWord){
        return this.passWord;
    }

    public int getId() {
        return id;
    }
}