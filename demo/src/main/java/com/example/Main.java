package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "ketan123";

        

        try {

            Connection con = DriverManager.getConnection(url, username, password);

           String sql = "SELECT * FROM employees";

           PreparedStatement ps = con.prepareStatement(sql);

           ResultSet rs = ps.executeQuery();

           while (rs.next()) {

          System.out.println(
          rs.getInt("id") + " | " +
          rs.getString("name") + " | " +
          rs.getDouble("salary") + " | " +
          rs.getString("department")
    );
}

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}