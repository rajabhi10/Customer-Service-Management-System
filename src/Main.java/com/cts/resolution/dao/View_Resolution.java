package com.cts.resolution.dao;

import com.cts.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class View_Resolution {
    public static void viewResolutionDetails() {
        try {
            //Establishing Database Connection
            Connection conn = DBConnection.getConnection();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Resolution ID: ");
            int resolutionId = scanner.nextInt();

            // SQL query to view the details into the database
            String sql = "SELECT * FROM resolution WHERE resolutionId = ?";
            try {
                // Prepare the statement and set the parameters
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, resolutionId);
                try {
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Resolution ID: " + rs.getInt("resolutionId"));
                        System.out.println("Inquiry ID: " + rs.getInt("inquiryId"));
                        System.out.println("Complaint ID: " + rs.getInt("complaintId"));
                        System.out.println("Resolution Date: " + rs.getDate("resolution_date"));
                        System.out.println("Details: " + rs.getString("details"));
                    } else {
                        System.out.println("Resolution not found.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error viewing resolution: " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error viewing resolution: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error viewing resolution: " + e.getMessage());
        }
    }
}
