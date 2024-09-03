package com.cts.complaint.dao;

import com.cts.util.DBConnection;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Complaint_Management {
    public static void recordComplaint() {
        try {
            // Establish database connection
            Connection conn = DBConnection.getConnection();
            System.out.println("Connection Successful");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Complaint ID: ");
            int complaintId = scanner.nextInt();

            System.out.print("Enter Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            System.out.print("Enter Complaint Date (YYYY-MM-DD): ");
            String complaintDate = scanner.nextLine();

            System.out.print("Enter Complaint: ");
            String complaint = scanner.nextLine();

            System.out.print("Enter Status: ");
            String status = scanner.nextLine();

            // SQL query to insert the complaint details into the database
            String sql = "INSERT INTO complaint ( complaintId , customerId , complaint_date, complaint, status) VALUES (?,?,?,?,?)";

            // Prepare the statement and set the parameters
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, complaintId);
            pstmt.setInt(2, customerId);
            pstmt.setString(3,complaintDate); // Convert string to SQL date
            pstmt.setString(4, complaint);
            pstmt.setString(5, status);

            // Execute the update
            pstmt.executeUpdate();
            System.out.println("Complaint recorded successfully.");
        } catch (SQLException e) {
            System.out.println("Error recording complaint: " + e.getMessage());
        }
    }
}
