package model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DAOCustomer implements  DAOInterface<Customer>{


    private Connection connection = null;

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            String url = "jdbc:mySQL://localhost:3306/mywebsite";
            String username = "root";
            String password = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,username,password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Statement statement =  connection.createStatement();
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
        String url = "jdbc:mySQL://localhost:3306/mywebsite";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        String url = "jdbc:mySQL://localhost:3306/mywebsite";
        String username = "root";
        String passworddb = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,passworddb);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(seachUser(t.getName())){
            return 0;
        } else if (searchEmail(t.getEmail())) {
            return 0;
        }else {
            try {
                Statement statement = connection.createStatement();
                String name = t.getName();
                long numberPhone = t.getNumberPhone();
                int date = t.getDateOfBirth().getDate();
                int month = t.getDateOfBirth().getMonth() + 1;
                int year = t.getDateOfBirth().getYear() + 1900;
                String address = t.getAddress();
                String email = t.getEmail();
                String password = t.getPassWord();
                int sex = t.getSex() ? 0 : 1;
                String statementString = "INSERT  INTO mywebsite.customer(name,numberPhone,sex,address,email,password,dateOfBirth) " +
                        "  VALUES( \"" + name + "\" , " +
                        numberPhone + " , " + sex + " , \"" + address + "\" , \"" +
                        email + "\" , \"" + password + "\" , \"" + year + "/" + date + "/" + month +" \")";
                statement.executeUpdate(statementString);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return 2;
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
        String url = "jdbc:mySQL://localhost:3306/mywebsite";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        String url = "jdbc:mySQL://localhost:3306/mywebsite";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        String url = "jdbc:mySQL://localhost:3306/mywebsite";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

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