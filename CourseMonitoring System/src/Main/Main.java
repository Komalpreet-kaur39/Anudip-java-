
package Main;

import DaoImplementation.AdminDaoImpl;
import Exception.AuthenticationException;
import Exception.BatchNotFoundException;
import Exception.FacultyException;
import Exception.courseNotFoundException;
import Model.Admin;
import Operations.AdminOperations;
import Operations.FacultyOperations;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
           while (true) {
                    try {
                        System.out.println("========================================");
                        System.out.println("Welcome to the Course Monitoring System");
                        System.out.println("=========================================");
                        System.out.println("         1. Admin Menu");
                        System.out.println("         2. Faculty Menu");
                        System.out.println("         3. Exit");
                        System.out.println("==========================================");
                        System.out.print("Choose an option: ");
                        
                        int choice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        
                        switch (choice) {
                            case 1:
                                showAdminMenu(scanner);
                                break;
                            case 2:
                                showFacultyMenu(scanner);
                                break;
                            case 3:
                                System.out.println("Exiting...");
                                scanner.close();
                                return;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }       
                    } catch (courseNotFoundException ex) {
                            ex.printStackTrace();                    
                    } catch (BatchNotFoundException ex) {
                            ex.printStackTrace();
                    } catch (FacultyException ex) {
                            ex.printStackTrace();                     }
        }
    }

    private static void showAdminMenu(Scanner scanner) throws courseNotFoundException, BatchNotFoundException, FacultyException {
       AdminOperations adminOps = new AdminOperations();

 
// Call the login function from AdminOperations
        System.out.println("Please login to access the Admin menu:");
        Admin loggedInAdmin = adminOps.loginAdmin(scanner);

        if (loggedInAdmin == null) {
            // If login failed, deny access
            System.out.println("Invalid login. Access denied.");
            return;
        }

        // If login succeeds, show the admin menu
        System.out.println("Welcome, " + loggedInAdmin.getUsername() + "! Accessing Admin Menu...");

        while (true) {
               System.out.println("\n==============================");
               System.out.println("         Admin Menu            ");
               System.out.println("================================");
               System.out.println("     1. Manage Courses");
               System.out.println("     2. Manage Batches");
               System.out.println("     3. Manage Faculty");
               System.out.println("     4. Manage Course Plans");
               System.out.println("     5. Logout");
               System.out.println("=================================");
               System.out.print("Choose an option (1-5): ");


               
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    adminOps.manageCourses();
                    break;
                case 2:
                    adminOps.manageBatches();
                    break;
                case 3:
                    adminOps.manageFaculty();
                    break;
                case 4:
                    adminOps.manageCoursePlans();
                    break;
                case 5:
                    return; // Exit Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showFacultyMenu(Scanner scanner) {
        FacultyOperations facultyOps = new FacultyOperations();
   if (!facultyOps.facultyLogin()) {
        System.out.println("Invalid login. Access denied.");
        return;
    }
        while (true) {
            System.out.println("\n==============================");
            System.out.println("         Faculty Menu          ");
            System.out.println("==============================");
            System.out.println("   1. View Course Plan");
            System.out.println("   2. Update Course Plan");
            System.out.println("   3. Change Password");
            System.out.println("   4. Logout");
            System.out.println("==============================");
            System.out.print("Choose an option (1-4): ");


            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    facultyOps.viewCoursePlan();
                    break;
                case 2:
                    facultyOps.updateCoursePlan();
                    break;
                case 3:
                    facultyOps.changePassword();
                    break;
                case 4:
                    return; // Exit Faculty Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}

