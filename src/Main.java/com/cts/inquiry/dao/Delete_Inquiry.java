package com.cts.inquiry.dao;

import com.cts.util.DBConnection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_Inquiry {
    public static void deleteInquiry() {
        try {
            //Establishing Database Connection
            Connection conn = DBConnection.getConnection();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Inquiry ID: ");
            int inquiryId = scanner.nextInt();

            // SQL query to delete the details into the database
            String sql = "DELETE FROM inquiry WHERE inquiryId = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Prepare the statement and set the parameters
                pstmt.setInt(1, inquiryId);
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Inquiry deleted successfully.");
                } else {
                    System.out.println("Inquiry not found.");
                }
            }
            // Execute the update
            catch (SQLException e) {
                System.out.println("Error deleting inquiry: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error deleting inquiry: " + e.getMessage());
        }
    }
}
