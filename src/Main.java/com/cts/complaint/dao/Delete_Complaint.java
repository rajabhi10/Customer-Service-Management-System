package com.cts.complaint.dao;

import com.cts.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_Complaint {
    public static void deleteComplaint() {
        try {
            //Establishing Database Connection
            Connection conn = DBConnection.getConnection();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Complaint ID: ");
            int complaintId = scanner.nextInt();

            // SQL query to delete the details into the database
            String sql = "DELETE FROM complaint WHERE complaintId = ?";
            try {
                // Prepare the statement and set the parameters
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, complaintId);
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Complaint deleted successfully.");
                } else {
                    System.out.println("Complaint not found.");
                }
            }
            // Execute the deletion
            catch (SQLException e) {
                System.out.println("Error deleting Complaint: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error deleting Complaint: " + e.getMessage());
        }
    }
}
