package com.cts.complaint.dao;

import com.cts.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_Complaint {
    public static void updateComplaintStatus() {
        try {
            //Establishing Database Connection
            Connection conn = DBConnection.getConnection();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Complaint ID: ");
            int complaintId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter New Status: ");
            String status = scanner.nextLine();

            // SQL query to update the details into the database
            String sql = "UPDATE complaint SET status = ? WHERE complaintId = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

            // Prepare the statement and set the parameters
                pstmt.setString(1, status);
                pstmt.setInt(2, complaintId);
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Complaint status updated successfully.");
                } else {
                    System.out.println("Complaint not found.");
                }
            }
            //Execute the update
            catch (SQLException e) {
                System.out.println("Error updating complaint status: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error updating complaint status: " + e.getMessage());
        }
    }
}
