package com.cts.complaint.dao;


import com.cts.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class View_Complaint {
    public static void viewComplaintDetails() {
        try {
            // Establishing Database Connection
            Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Complaint ID: ");
            int complaintId = scanner.nextInt();

            // SQL query to view the details into the database
            String sql = "SELECT * FROM complaint WHERE complaintId = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Prepare the statement and set the parameters
                pstmt.setInt(1, complaintId);
                try {
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Complaint ID: " + rs.getInt("complaintId"));
                        System.out.println("Customer ID: " + rs.getInt("customerId"));
                        System.out.println("Complaint Date: " + rs.getDate("complaint_date"));
                        System.out.println("Complaint: " + rs.getString("complaint"));
                        System.out.println("Status: " + rs.getString("status"));
                    } else {
                        System.out.println("Complaint not found.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error viewing Complaint: " + e.getMessage());
                }
            }
            // Execute the update
             catch (SQLException e) {
                System.out.println("Error viewing Complaint: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error viewing Complaint: " + e.getMessage());
        }
    }
}
