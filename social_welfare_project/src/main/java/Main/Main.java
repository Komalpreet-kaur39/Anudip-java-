
package Main;

import operations.AdminOperations;
//import operations.UserOperations;
import exception.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("========================================");
                System.out.println("Welcome to the Social Welfare Application");
                System.out.println("========================================");
                System.out.println("1. Admin Menu");
                System.out.println("2. User Menu");
                System.out.println("3. Exit");
                System.out.println("========================================");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                
                switch (choice) {
                    case 1:
                        showAdminMenu(scanner);
                        break;
                    case 2:
//                        showUserMenu(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void showAdminMenu(Scanner scanner) {
        AdminOperations adminOps = new AdminOperations();

        while (true) {
            System.out.println("\n==============================");
            System.out.println("         Admin Menu            ");
            System.out.println("==============================");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Donations");
            System.out.println("3. Manage NGOs");
            System.out.println("4. Manage Volunteer Activities");
            System.out.println("5. Manage CleanUp Activities");
            System.out.println("6. Manage Certifications");
            System.out.println("7. Logout");
            System.out.println("==============================");
            System.out.print("Choose an option (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    adminOps.manageUsers();
                    break;
                case 2:
                    adminOps.manageDonations();
                    break;
                case 3:
                    adminOps.manageNGOs();
                    break;
                case 4:
                    adminOps.manageVolunteerActivities();
                    break;
                case 5:
                    adminOps.manageCleanUpActivities();
                    break;
                case 6:
                    adminOps.manageCertifications();
                    break;
                case 7:
                    return; // Exit Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

//    private static void showUserMenu(Scanner scanner) {
//        UserOperations userOps = new UserOperations();
//
//        while (true) {
//            System.out.println("\n==============================");
//            System.out.println("         User Menu             ");
//            System.out.println("==============================");
//            System.out.println("1. Donate Money");
//            System.out.println("2. Donate Trees");
//            System.out.println("3. View Donations");
//            System.out.println("4. Logout");
//            System.out.println("==============================");
//            System.out.print("Choose an option (1-4): ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();  // Consume newline
//
//            switch (choice) {
//                case 1:
//                    userOps.donateMoney(scanner);
//                    break;
//                case 2:
//                    userOps.donateTrees(scanner);
//                    break;
//                case 3:
//                    userOps.viewDonations();
//                    break;
//                case 4:
//                    return; // Exit User Menu
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
}

