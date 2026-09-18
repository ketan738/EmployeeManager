package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EmployeeManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Employee");
        System.out.println("Employee Manager - Version 2");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Salary");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");

        System.out.print("Enter choice: ");

        String choice = sc.nextLine();

        if (choice.equals("1")) {

            try {

                System.out.print("Enter employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter department: ");
        String department = sc.nextLine();

        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "ketan123";

        Connection con = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO employees (id, name, salary, department) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, salary);
        ps.setString(4, department);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee added successfully.");
        }

        con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (choice.equals("5")) {

            try {

                System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "ketan123";

        Connection con = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM employees WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        con.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (choice.equals("1")) {
            System.out.println("Add Employee selected");
        }

        else if (choice.equals("4")) {
            System.out.println("Update Salary selected");
        }

        else if (choice.equals("5")) {
            System.out.println("Delete Employee selected");
        }

        else if (choice.equals("6")) {
            System.out.println("Exiting...");
        }

        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}