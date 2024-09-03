package com.cts.inquiry.dao;

import com.cts.util.DBConnection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inquiry_Management {
    // Method to record a new inquiry
    public static void recordInquiry() {
        try {
            // Establish database connection
            Connection conn = DBConnection.getConnection();
            System.out.println("Connection Successful");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Inquiry ID: ");
            int inquiryId = scanner.nextInt();

            System.out.print("Enter Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            System.out.print("Enter Inquiry Date (YYYY-MM-DD): ");
            String inquiryDate = scanner.nextLine();

            System.out.print("Enter Description: ");
            String description = scanner.nextLine();

            System.out.print("Enter Status: ");
            String status = scanner.nextLine();

            // SQL query to insert the inquiry details into the database
            String sql = "INSERT INTO inquiry ( inquiryId , customerId , inquiry_date, description, status) VALUES (?,?,?,?,?)";

            // Prepare the statement and set the parameters
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, inquiryId);
            pstmt.setInt(2, customerId);
            pstmt.setString(3, inquiryDate); // Convert string to SQL date
            pstmt.setString(4, description);
            pstmt.setString(5, status);

            // Execute the update
            pstmt.executeUpdate();
            System.out.println("Inquiry recorded successfully.");
        } catch (SQLException e) {
            System.out.println("Error recording inquiry: " + e.getMessage());
        }
    }
}
