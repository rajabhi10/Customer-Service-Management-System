package com.cts.resolution.dao;

import com.cts.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_Resolution {
    public static void deleteResolution() {
        try {
            //Establishing Database Connection
            Connection conn = DBConnection.getConnection();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Resolution ID: ");
            int resolutionId = scanner.nextInt();

            // SQL query to delete the details into the database
            String sql = "DELETE FROM resolution WHERE resolutionId = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

            // Prepare the statement and set the parameters
                pstmt.setInt(1, resolutionId);
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Resolution deleted successfully.");
                } else {
                    System.out.println("Resolution not found.");
                }
            }
            // Execute the update
            catch (SQLException e) {
                System.out.println("Error deleting Resolution: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error deleting Resolution: " + e.getMessage());
        }
    }
}
