package com.cts.resolution.dao;

import com.cts.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_Resolution {
    public static void updateResolutionDetails() {
        try {
            //Establishing Database Connection
            Connection conn = DBConnection.getConnection();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Resolution ID to update: ");
            int resolutionId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new Resolution Date (YYYY-MM-DD): ");
            String resolutionDate = scanner.nextLine();

            System.out.print("Enter new Resolution Details: ");
            String details = scanner.nextLine();

            // SQL query to update resolution details
            String sql = "UPDATE resolution SET resolution_date = ?, details = ? WHERE resolutionId = ?";
            try {

                // Prepare the statement and set the parameters
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDate(1, java.sql.Date.valueOf(resolutionDate)); // Convert string to SQL Date
                pstmt.setString(2, details);
                pstmt.setInt(3, resolutionId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Resolution updated successfully.");
                } else {
                    System.out.println("Resolution not found.");
                }
            } catch (SQLException e) {
                System.out.println("Error updating resolution: " + e.getMessage());
            }
        } catch (IllegalArgumentException | SQLException e) {
            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format." + e.getMessage());
        }
    }
}


