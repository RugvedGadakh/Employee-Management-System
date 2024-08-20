package EmployeeManagement;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn(){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeeManagement","root","Rugved@12");
            s = c.createStatement();

        }
        catch (Exception e){
            e.printStackTrace();;
        }
    }
}
