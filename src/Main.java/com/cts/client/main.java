package com.cts.client;

import com.cts.complaint.dao.Complaint_Management;
import com.cts.complaint.dao.Delete_Complaint;
import com.cts.complaint.dao.Update_Complaint;
import com.cts.complaint.dao.View_Complaint;
import com.cts.inquiry.dao.Delete_Inquiry;
import com.cts.inquiry.dao.Inquiry_Management;
import com.cts.inquiry.dao.Update_Inquiry;
import com.cts.inquiry.dao.View_Inquiry;
import com.cts.resolution.dao.Delete_Resolution;
import com.cts.resolution.dao.Resolution_Management;
import com.cts.resolution.dao.Update_Resolution;
import com.cts.resolution.dao.View_Resolution;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (true) {
            System.out.println("\nCustomer Service Management System");
            System.out.println("1. Manage Inquiries");
            System.out.println("2. Manage Complaints");
            System.out.println("3. Manage Resolutions");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            System.out.println(choice);

            switch (choice) {
                case 1:
                    manageInquiries();
                case 2:
                    manageComplaints();
                case 3:
                manageResolution();
                case 4: {
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);

                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

                //-------------------INQUIRY MANAGEMENT---------------------------

    private static void manageInquiries() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n--- Inquiry Management ---");
            System.out.println("1. Record a New Inquiry");
            System.out.println("2. View Inquiry Details");
            System.out.println("3. Update Inquiry Status");
            System.out.println("4. Delete an Inquiry");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // Check if the next input is an integer before processing
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
//                scanner.nextLine(); // Clear the buffer after reading the integer

                switch (choice) {
                    case 1:
                        Inquiry_Management.recordInquiry();
                        break;
                    case 2:
                        View_Inquiry.viewInquiryDetails();
                        break;
                    case 3:
                        Update_Inquiry.updateInquiryStatus();
                        break;
                    case 4:
                        Delete_Inquiry.deleteInquiry();
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice, please enter a number between 1 and 5.");
                        break;
                }
            } else {
                // If input is not an integer, clear the input and prompt again
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input to avoid infinite loop
            }
        } while (choice != 5);
    }


                //-------------------- COMPLAINT MANAGEMENT-------------------------

    private static void manageComplaints() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n--- Complaint Management ---");
            System.out.println("1. Record a New Complaint");
            System.out.println("2. View Complaint Details");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. Delete an Complaint");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // Check if the next input is an integer before processing
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Complaint_Management.recordComplaint();
                        break;
                    case 2:
                        View_Complaint.viewComplaintDetails();
                        break;
                    case 3:
                        Update_Complaint.updateComplaintStatus();
                        break;
                    case 4:
                        Delete_Complaint.deleteComplaint();
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice, please enter a number between 1 and 5.");
                        break;
                }
            } else {
                // If input is not an integer, clear the input and prompt again
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input to avoid infinite loop
            }
        } while (choice != 5);
    }


            //---------------------------RESOLUTION MANAGEMENT------------------------

    private static void manageResolution() {
                Scanner scanner = new Scanner(System.in);
                int choice = 0;

                do {
                    System.out.println("\n--- Resolution Management ---");
                    System.out.println("1. Provide a Resolution");
                    System.out.println("2. View resolution details");
                    System.out.println("3. Update Resolution Information");
                    System.out.println("4. Delete a Resolution Record");
                    System.out.println("5. Return to Main Menu");
                    System.out.print("Enter your choice: ");

                    // Check if the next input is an integer before processing
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
//                scanner.nextLine(); // Clear the buffer after reading the integer

                        switch (choice) {
                            case 1:
                                Resolution_Management.provideResolution();
                                break;
                            case 2:
                                View_Resolution.viewResolutionDetails();
                                break;
                            case 3:
                                Update_Resolution.updateResolutionDetails();
                                break;
                            case 4:
                                Delete_Resolution.deleteResolution();
                                break;
                            case 5:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice, please enter a number between 1 and 5.");
                                break;
                        }
                    } else {
                        // If input is not an integer, clear the input and prompt again
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Consume the invalid input to avoid infinite loop
                    }
                } while (choice != 5);
            }

}
