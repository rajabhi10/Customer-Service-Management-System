package com.cts.inquiry.dao;

import com.cts.util.DBConnection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_Inquiry {
    public static void updateInquiryStatus() {
        try {
            //Establishing Database Connection
            Connection conn = DBConnection.getConnection();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Inquiry ID: ");
            int inquiryId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter New Status: ");
            String status = scanner.nextLine();

            // SQL query to update the details into the database
            String sql = "UPDATE inquiry SET status = ? WHERE inquiryId = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Prepare the statement and set the parameters
                pstmt.setString(1, status);
                pstmt.setInt(2, inquiryId);
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Inquiry status updated successfully.");
                } else {
                    System.out.println("Inquiry not found.");
                }
            }
            // Execute the update
            catch (SQLException e) {
                System.out.println("Error updating inquiry status: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error updating inquiry status: " + e.getMessage());
        }

    }
}
