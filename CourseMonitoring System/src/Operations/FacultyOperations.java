/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operations;

import DaoImplementation.AdminDaoImpl;
import DaoImplementation.FacultyDaoImpl;
import Exception.AuthenticationException;
import Exception.CoursePlanNotFoundException;
import Exception.FacultyException;
import Model.CoursePlan;
import Model.Faculty;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FacultyOperations {
    private Scanner scanner = new Scanner(System.in);
    private FacultyDaoImpl facultyDao = new FacultyDaoImpl();
    private AdminDaoImpl adminDao = new AdminDaoImpl();
 // Method to handle Faculty login
    public boolean facultyLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            Faculty faculty = facultyDao.loginIntoFaculty(username, password);
            if (faculty != null) {
                System.out.println("Login successful! Welcome, " + faculty.getUsername());
                return true;
            } else {
                System.out.println("Invalid username or password.");
                return false;
            }
        } catch (AuthenticationException e) {
            System.out.println("Login failed: " + e.getMessage());
            return false;
        }}
    public void viewCoursePlan() {
        try {
            System.out.print("Enter Batch ID: ");
            int batchId = scanner.nextInt();
            
            CoursePlan coursePlan = facultyDao.viewCoursePlan(batchId);
            System.out.println("Course Plan: " + coursePlan);
        } catch (CoursePlanNotFoundException ex) {
        System.out.println("Error: " + ex.getMessage());
        }
    }

    public void updateCoursePlan() {
    try {
        System.out.print("Enter batch ID to update course plan: ");
        int batchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Check if the course plan exists
        CoursePlan existingCoursePlan = adminDao.getCoursePlanByBatchId(batchId);
        
        if (existingCoursePlan != null) {
            // Course plan exists, prompt for other details
            System.out.println("Course Plan found: " + existingCoursePlan);
            
            System.out.print("Enter new plan ID (or leave blank to keep current): ");
            String planIdInput = scanner.nextLine();
            int planId = planIdInput.isEmpty() ? existingCoursePlan.getPlanId() : Integer.parseInt(planIdInput);
            
            System.out.print("Enter new day number (or leave blank to keep current): ");
            String dayNumberInput = scanner.nextLine();
            int dayNumber = dayNumberInput.isEmpty() ? existingCoursePlan.getDayNumber() : Integer.parseInt(dayNumberInput);
            
            System.out.print("Enter new topic (or leave blank to keep current): ");
            String topic = scanner.nextLine();
            if (topic.isEmpty()) {
                topic = existingCoursePlan.getTopic(); // Keep current topic if blank
            }
            
            System.out.print("Enter new status (or leave blank to keep current): ");
            String status = scanner.nextLine();
            if (status.isEmpty()) {
                status = existingCoursePlan.getStatus(); // Keep current status if blank
            }
            
            // Create a new course plan object with updated details
            CoursePlan updatedCoursePlan = new CoursePlan(planId, batchId, dayNumber, topic, status);
            String message = facultyDao.fillDayWisePlanner(updatedCoursePlan.getPlanId(), updatedCoursePlan.getTopic(), updatedCoursePlan.getStatus());
            System.out.println(message);
        } else {
            System.out.println("Course Plan with batch ID " + batchId + " does not exist.");
        }
    } catch (CoursePlanNotFoundException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}



    public void changePassword() {
        System.out.print("Enter Faculty ID: ");
        int facultyId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        try {
            String message = facultyDao.updateFacultyPassword(facultyId, oldPassword, newPassword);
            System.out.println(message);
        } catch (FacultyException | AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
