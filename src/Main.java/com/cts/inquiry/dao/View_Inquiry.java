package com.cts.inquiry.dao;

import com.cts.util.DBConnection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View_Inquiry {
    // Method to view inquiry details
    public static void viewInquiryDetails() {
        try{
            //Establishing Database Connection
        Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Inquiry ID: ");
            int inquiryId = scanner.nextInt();

            // SQL query to view the details into the database
            String sql = "SELECT * FROM inquiry WHERE inquiryId = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Prepare the statement and set the parameters
                pstmt.setInt(1, inquiryId);
                try {
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Inquiry ID: " + rs.getInt("inquiryId"));
                        System.out.println("Customer ID: " + rs.getInt("customerId"));
                        System.out.println("Inquiry Date: " + rs.getDate("inquiry_date"));
                        System.out.println("Description: " + rs.getString("description"));
                        System.out.println("Status: " + rs.getString("status"));
                    } else {
                        System.out.println("Inquiry not found.");
                    }
                }
                // Execute the update
                catch (SQLException e) {
                    System.out.println("Error viewing inquiry: " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error viewing inquiry: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error viewing inquiry: " + e.getMessage());
        }
    }
}