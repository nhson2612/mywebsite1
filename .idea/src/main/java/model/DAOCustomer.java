package model;

import java.sql.*;
import java.util.ArrayList;

public class DAOCustomer implements  DAOInterface<Customer>{

    private static Connection connection = null;
    private static DAOCustomer dAOCustomer = null;

    private DAOCustomer(){}
    public static DAOCustomer getInstance(){
        if(dAOCustomer==null){
            dAOCustomer = new DAOCustomer();
            String url = "jdbc:mySQL://localhost:3306/mywebsite";
            String username = "root";
            String password = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,username,password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dAOCustomer;
    }

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            Statement statement = connection.createStatement();
            String statementString = "SELECT * FROM mywebsite.customer";
            ResultSet rs = statement.executeQuery(statementString);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                long numberPhone = rs.getLong("numberphone");
                boolean sex = rs.getBoolean("sex");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String passWord = rs.getString("password");
                Date dateOfBirth = rs.getDate("dateofbirth");

                customers.add(new Customer(name,numberPhone,dateOfBirth,sex,address,email,passWord));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customers;
    }

    @Override
    public Customer selectById(Customer t) {
        Customer customer  = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String statementString = "SELECT * FROM mywebsite WHERE id = " + t.getId();
        try {
            ResultSet rs = statement.executeQuery(statementString);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            long numberPhone = rs.getLong("numberphone");
            boolean sex = rs.getBoolean("sex");
            String address = rs.getString("address");
            String email = rs.getString("email");
            String passWord = rs.getString("password");
            Date dateOfBirth = rs.getDate("dateofbirth");
            customer = new Customer(name,numberPhone,dateOfBirth,sex,address,email,passWord);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public int insert(Customer t) {
        return 0;
    }

    @Override
    public int insertAll(ArrayList<Customer> arr) {
        return 0;
    }

    @Override
    public int delete(Customer t) {
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<Customer> arr) {
        return 0;
    }

    @Override
    public int update(Customer t) {
        return 0;
    }

    public boolean seachUser(String name){
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String statementString = "SELECT * FROM mywebsite.customer WHERE name = \"" + name +" \" ";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(statementString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int count = 0;
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean searchEmail(String email){
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String statementString = "SELECT * FROM mywebsite.customer WHERE email = \" " + email + " \"";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(statementString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int count = 0;
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    public Customer selectByUser(String name){
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String statementString = "SELECT * FROM mywebsite.customer WHERE name = \"" + name + " \"";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(statementString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Customer customer = null;
        int count = 0;
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            count++;
             customer = (Customer) rs;
        }
        if(count==0){
            return null;
        }else{
            return customer;
        }
    }
}