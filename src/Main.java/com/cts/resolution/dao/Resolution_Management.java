package com.cts.resolution.dao;

import com.cts.util.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class Resolution_Management {
    // Method to provide a resolution for an existing inquiry or complaint
    public static void provideResolution() {
        try {
            //Establishing Database Connection
            Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in);
            System.out.println("Connection Successful");

            System.out.print("Enter Resolution ID: ");
            int resolutionId = scanner.nextInt();

            System.out.print("Enter Inquiry ID (Enter 0 if not applicable): ");
            int inquiryId = scanner.nextInt();

            System.out.print("Enter Complaint ID (Enter 0 if not applicable): ");
            int complaintId = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()

            // Check if the inquiry or complaint exists
            boolean inquiryExists = (inquiryId != 0) && checkRecordExists(conn, "inquiry", "inquiryId", inquiryId);
            boolean complaintExists = (complaintId != 0) && checkRecordExists(conn, "complaint", "complaintId", complaintId);

            // Validation to ensure at least one exists
            if (!inquiryExists && !complaintExists) {
                System.out.println("Neither a valid Inquiry ID nor a valid Complaint ID was found.");
                return;
            }

            System.out.print("Enter Resolution Date (YYYY-MM-DD): ");
            String resolutionDate = scanner.nextLine();

            System.out.print("Enter Resolution Details: ");
            String details = scanner.nextLine();

            // SQL query to insert the resolution details into the database
            String sql = "INSERT INTO resolution (resolutionId, inquiryId, complaintId, resolution_date, details) VALUES (?, ?, ?, ?, ?)";

            // Prepare the statement and set the parameters
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, resolutionId);
                pstmt.setObject(2, inquiryExists ? inquiryId : null, Types.INTEGER); // Set null if not applicable
                pstmt.setObject(3, complaintExists ? complaintId : null, Types.INTEGER); // Set null if not applicable
                pstmt.setString(4, resolutionDate);
                pstmt.setString(5, details);

                // Execute the update
                pstmt.executeUpdate();
                System.out.println("Resolution provided successfully.");
            }
            catch (SQLException e) {
                System.out.println("Error providing resolution: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error providing resolution: " + e.getMessage());
        }
    }

    // Method to check if a record exists in the specified table
    private static boolean checkRecordExists(Connection conn, String tableName, String columnName, int id) throws SQLException {
        String query = "SELECT 1 FROM " + tableName + " WHERE " + columnName + " = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            try {
                ResultSet rs = pstmt.executeQuery();
                return rs.next(); // Returns true if the record exists
            } catch (SQLException e) {
                System.out.println("Error providing resolution: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error providing resolution: " + e.getMessage());
        }
        return false;
    }
}
