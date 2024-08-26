package Operations;

import DaoImplementation.AdminDaoImpl;
import DaoImplementation.FacultyDaoImpl;
import Exception.AuthenticationException;
import Exception.BatchNotFoundException;
import Exception.CoursePlanNotFoundException;
import Exception.DuplicateEntryException;
import Exception.FacultyException;
import Exception.courseNotFoundException;
import Model.Admin;
import Model.Batch;
import Model.Course;
import Model.CoursePlan;
import Model.Faculty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminOperations {

    private Scanner scanner = new Scanner(System.in);
    private AdminDaoImpl adminDao = new AdminDaoImpl();
    private FacultyDaoImpl facultyDao = new FacultyDaoImpl();

  
 // Method to perform the login process for an admin, accepting a Scanner as a parameter
    public Admin loginAdmin(Scanner scanner) {
        // Collect username and password from the admin
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        try {
            // Attempt to login the admin using the AdminDao
            Admin admin = adminDao.loginIntoAdmin(username, password);

            // Login successful, return the logged-in admin
            System.out.println("Login successful! Welcome " + admin.getUsername());
            return admin;

        } catch (AuthenticationException e) {
            // Login failed, print error message and return null
            System.out.println("Login failed: " + e.getMessage());
            return null;
        }
    }
    // Course Management
    public void manageCourses() throws courseNotFoundException {
        while(true){
        System.out.println("\n==============================");
        System.out.println("        Manage Courses         ");
        System.out.println("==============================");
        System.out.println("1. Add Course");
        System.out.println("2. Update Course");
        System.out.println("3. View Courses");
        System.out.println("4. View Courses By Id");
        System.out.println("5.exit");
        System.out.println("==============================");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addCourse();
                break;
            case 2:
                updateCourse();
                break;
            case 3:
                viewCourses();
                break;
            case 4:
                getCourseById();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice.");
        }
        }
    }

    private void addCourse() {
        try {
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();
            System.out.print("Enter fee: ");
            double fee = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter course description: ");
            String courseDescription = scanner.nextLine();
            
            Course course = new Course(0, courseName, fee, courseDescription);
            adminDao.createCourse(course);
            System.out.println("Course added: " + course);
        } catch (DuplicateEntryException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private void updateCourse() {
    try {
        System.out.print("Enter course ID to update: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check if the course exists
        Course existingCourse = adminDao.getCourseById(courseId);
        
        if (existingCourse != null) {
            // Course exists, prompt for other details
            System.out.println("Course found: " + existingCourse);

            System.out.print("Enter new course name (or leave blank to keep current): ");
            String courseName = scanner.nextLine();
            if (courseName.isEmpty()) {
                courseName = existingCourse.getCourseName(); // Keep current name if blank
            }

            System.out.print("Enter new fee (or leave blank to keep current): ");
            String feeInput = scanner.nextLine();
            double fee = feeInput.isEmpty() ? existingCourse.getFee() : Double.parseDouble(feeInput);

            System.out.print("Enter new course description (or leave blank to keep current): ");
            String courseDescription = scanner.nextLine();
            if (courseDescription.isEmpty()) {
                courseDescription = existingCourse.getCourseDescription(); // Keep current description if blank
            }

            // Create a new course object with updated details
            Course updatedCourse = new Course(courseId, courseName, fee, courseDescription);
            adminDao.updateCourse(updatedCourse);
            System.out.println("Course updated: " + updatedCourse);
        } else {
            // If course is not found, provide a clear message
            System.out.println("Course with ID " + courseId + " not found.");
        }
    } catch (NumberFormatException e) {
        // Handle cases where the fee input is not a valid number
        System.out.println("Invalid input format for fee. Please enter a valid number.");
    } catch (Exception e) {
        // Catch any other unexpected exceptions
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
}



    private void viewCourses() {
        try {
            List<Course> courses = adminDao.getAllCourse();
            courses.forEach(System.out::println);
        } catch (courseNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    private void getCourseById() throws courseNotFoundException {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            Course course = adminDao.getCourseById(courseId);
            System.out.println("Course details: " + course);
        } catch (courseNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Batch Management
    public void manageBatches() throws BatchNotFoundException {
        while(true){
        System.out.println("\n==============================");
        System.out.println("        Manage Batches         ");
        System.out.println("==============================");        System.out.println("1. Add Batch");
        System.out.println("2. Update Batch");
        System.out.println("3. View Batches");
        System.out.println("4. View Batches by Id");
        System.out.println("5.exit");
        System.out.println("==============================");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addBatch();
                break;
            case 2:
                updateBatch();
                break;
            case 3:
                viewBatches();
                break;
            case 4:
                getBatchById();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice.");
        }
        }
    }

    private void addBatch() {
        try {
            System.out.print("Enter course ID: ");
            int courseId = scanner.nextInt();
            System.out.print("Enter faculty ID: ");
            int facultyId = scanner.nextInt();
            System.out.print("Enter number of students: ");
            int numberOfStudents = scanner.nextInt();
            System.out.print("Enter batch start date (YYYY-MM-DD): ");
            String batchStartDateStr = scanner.next();
            System.out.print("Enter duration (in days): ");
            int duration = scanner.nextInt();
            
            Date batchStartDate = parseDate(batchStartDateStr);
            Batch batch = new Batch(0, courseId, facultyId, numberOfStudents, batchStartDate, duration);
            adminDao.createBatch(batch);
            System.out.println("Batch added: " + batch);
        } catch (DuplicateEntryException ex) {
        System.out.println("Error: " + ex.getMessage());
        }
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
        System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

  private void updateBatch() {
    try {
        System.out.print("Enter batch ID to update: ");
        int batchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Check if the batch exists
        Batch existingBatch = adminDao.getBatchById(batchId);
        
        if (existingBatch != null) {
            // Batch exists, prompt for other details
            System.out.println("Batch found: " + existingBatch);
            
            System.out.print("Enter new course ID (or leave blank to keep current): ");
            String courseIdInp = scanner.nextLine();
            int courseId = courseIdInp.isEmpty() ? existingBatch.getCourseId() : Integer.parseInt(courseIdInp);

            System.out.print("Enter new faculty ID (or leave blank to keep current): ");
            String facultyIdInp = scanner.nextLine();
            int facultyId = facultyIdInp.isEmpty() ? existingBatch.getFacultyId() : Integer.parseInt(facultyIdInp);

            System.out.print("Enter new number of students (or leave blank to keep current): ");
            String numberOfStudentsIn = scanner.nextLine();
            int numberOfStudents = numberOfStudentsIn.isEmpty() ? existingBatch.getNumberOfStudents() : Integer.parseInt(numberOfStudentsIn);

            System.out.print("Enter new batch start date (YYYY-MM-DD, or leave blank to keep current): ");
            String batchStartDateStr = scanner.nextLine();
            Date batchStartDate = batchStartDateStr.isEmpty() ? existingBatch.getBatchStartDate() : parseDate(batchStartDateStr);

            System.out.print("Enter new duration (in days, or leave blank to keep current): ");
            String durationInput = scanner.nextLine();
            int duration = durationInput.isEmpty() ? existingBatch.getDuration() : Integer.parseInt(durationInput);
            
            // Create a new batch object with updated details
            Batch updatedBatch = new Batch(batchId, courseId, facultyId, numberOfStudents, batchStartDate, duration);
            adminDao.updateBatch(updatedBatch);
            System.out.println("Batch updated: " + updatedBatch);
        } else {
            // If batch is not found, provide a clear message
            System.out.println("Batch with ID " + batchId + " not found.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid input format. Please enter the correct value.");
    } catch (Exception e) {
        // Catch any other unexpected exceptions
        System.out.println( e.getMessage());
    }
}



    private void viewBatches() {
        try {
            List<Batch> batches = adminDao.getAllBatch();
            batches.forEach(System.out::println);
        } catch (BatchNotFoundException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getBatchById() throws BatchNotFoundException {
        System.out.print("Enter batch ID: ");
        int batchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            Batch batch = adminDao.getBatchById(batchId);
            System.out.println("Batch details: " + batch);
        } catch (BatchNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Faculty Management
    public void manageFaculty() throws FacultyException {
       while(true){
        System.out.println("\n==============================");
        System.out.println("        Manage Faculty         ");
        System.out.println("==============================");
        System.out.println("1. Add Faculty");
        System.out.println("2. Update Faculty");
        System.out.println("3. View Faculty");
        System.out.println("4. View Faculty By ID");
        System.out.println("5.exit");
        System.out.println("==============================");

        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addFaculty();
                break;
            case 2:
                updateFaculty();
                break;
            case 3:
                viewFaculty();
                break;
            case 4:
                getFacultyById();
            case 5:
                return;
            default:
                System.out.println("Invalid choice.");
        }
       }
    }

    private void addFaculty() {
        try {
            System.out.print("Enter faculty name: ");
            String facultyName = scanner.nextLine();
            System.out.print("Enter faculty address: ");
            String facultyAddress = scanner.nextLine();
            System.out.print("Enter mobile number: ");
            String mobile = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            
            Faculty faculty = new Faculty(0, facultyName, facultyAddress, mobile, email, username, password);
            adminDao.registerFaculty(faculty);
            System.out.println("Faculty added: " + faculty);
        } catch (DuplicateEntryException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateFaculty() {
    try {
        System.out.print("Enter faculty ID to update: ");
        int facultyId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Check if the faculty exists
        Faculty existingFaculty = adminDao.getFacultyById(facultyId);
        
        if (existingFaculty != null) {
            // Faculty exists, prompt for other details
            System.out.println("Faculty found: " + existingFaculty);
            
            System.out.print("Enter new faculty name (or leave blank to keep current): ");
            String facultyName = scanner.nextLine();
            if (facultyName.isEmpty()) {
                facultyName = existingFaculty.getFacultyName(); // Keep current name if blank
            }

            System.out.print("Enter new address (or leave blank to keep current): ");
            String facultyAddress = scanner.nextLine();
            if (facultyAddress.isEmpty()) {
                facultyAddress = existingFaculty.getFacultyAddress(); // Keep current address if blank
            }

            System.out.print("Enter new mobile number (or leave blank to keep current): ");
            String mobile = scanner.nextLine();
            if (mobile.isEmpty()) {
                mobile = existingFaculty.getMobile(); // Keep current mobile number if blank
            }

            System.out.print("Enter new email (or leave blank to keep current): ");
            String email = scanner.nextLine();
            if (email.isEmpty()) {
                email = existingFaculty.getEmail(); // Keep current email if blank
            }
            
            // Create a new faculty object with updated details
            Faculty updatedFaculty = new Faculty(facultyId, facultyName, facultyAddress, mobile, email, existingFaculty.getUsername(), existingFaculty.getPassword());
            adminDao.updateFaculty(updatedFaculty);
            System.out.println("Faculty updated: " + updatedFaculty);
        } else {
            System.out.println("Faculty ID does not exist.");
        }
    } catch (FacultyException ex) {
        Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
}



    private void viewFaculty() {
        try {
            List<Faculty> faculties = adminDao.getAllFaculty();
            faculties.forEach(System.out::println);
        } catch (FacultyException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getFacultyById() throws FacultyException {
        System.out.print("Enter faculty ID: ");
        int facultyId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            Faculty faculty = adminDao.getFacultyById(facultyId);
            System.out.println("Faculty details: " + faculty);
        } catch (FacultyException e) {
            System.out.println(e.getMessage());
        }
    }

    // Course n Management
    public void manageCoursePlans() {
        while(true){
        System.out.println("\n==============================");
        System.out.println("        Manage CoursePlan         ");
        System.out.println("==============================");
        System.out.println("1. Create Course Plan");
        System.out.println("2. Update Course Plan");
        System.out.println("3. View Course Plan by Batch ID");
        System.out.println("4. View All Course Plans");
        System.out.println("5. View Day-wise Updates for Batch");
        System.out.println("6. Generate Report for Batch");
        System.out.println("==============================");

                System.out.println("7.exit" );

        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                createCoursePlan();
                break;
            case 2:
                updateCoursePlan();
                break;
            case 3:
                viewCoursePlanByBatchId();
                break;
            case 4:
                viewAllCoursePlans();
                break;
            case 5:
                viewDayWiseUpdatesForBatch();
                break;
            case 6:
                generateReportForBatch();
                break;
            case 7:
                return;
            default:
                System.out.println("Invalid choice.");
        }
        }
    }

    private void createCoursePlan() {
        System.out.print("Enter plan ID: ");
        int planId = scanner.nextInt();
        System.out.print("Enter batch ID: ");
        int batchId = scanner.nextInt();
        System.out.print("Enter day number: ");
        int dayNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter topic: ");
        String topic = scanner.nextLine();
        System.out.print("Enter status: ");
        String status = scanner.nextLine();

        CoursePlan coursePlan = new CoursePlan(planId, batchId, dayNumber, topic, status);
        try {
            String result = adminDao.createCoursePlan(coursePlan);
            System.out.println(result);
        } catch (DuplicateEntryException e) {
        System.out.println("Error: " + e.getMessage());
        }catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
    }

   private void updateCoursePlan() {
    try {
        System.out.print("Enter course plan ID to update: ");
        int planId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Check if the course plan exists
        CoursePlan existingCoursePlan = adminDao.getCoursePlanByBatchId(planId);
        
        if (existingCoursePlan != null) {
            // Course plan exists, prompt for other details
            System.out.println("Course Plan found: " + existingCoursePlan);
            
            System.out.print("Enter new batch ID (or leave blank to keep current): ");
            String batchIdInput = scanner.nextLine();
            int batchId = batchIdInput.isEmpty() ? existingCoursePlan.getBatchId() : Integer.parseInt(batchIdInput);

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
             String resultMessage =adminDao.updateCoursePlan(updatedCoursePlan);
//            System.out.println("Course Plan updated: " + updatedCoursePlan);
            System.out.println(resultMessage);

        } else {
            System.out.println("Course Plan ID does not exist.");
        }
    } catch (CoursePlanNotFoundException e) {
           System.out.println("An unexpected error occurred: " + e.getMessage());

    }
}


    private void viewCoursePlanByBatchId() {
        System.out.print("Enter batch ID to view course plan: ");
        int batchId = scanner.nextInt();
        try {
            CoursePlan coursePlan = adminDao.getCoursePlanByBatchId(batchId);
            System.out.println(coursePlan);
        } catch (CoursePlanNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void viewAllCoursePlans() {
        try {
            List<CoursePlan> coursePlans = adminDao.getAllCoursePlan();
            coursePlans.forEach(System.out::println);
        } catch (CoursePlanNotFoundException e) {
            e.printStackTrace();
        }
    }



   private void viewDayWiseUpdatesForBatch() {
    System.out.print("Enter batch ID to view day-wise updates: ");
    int batchId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    try {
        // Check if the batch exists first
        if (adminDao.getBatchById(batchId) == null) {
            // Batch ID does not exist
            System.out.println("Batch with ID " + batchId + " not found.");
            return;
        }

        // Proceed to get and display day-wise updates if batch exists
        List<CoursePlan> coursePlans = adminDao.getDayWiseUpdatesForBatch(batchId);
        if (coursePlans.isEmpty()) {
            System.out.println("No day-wise updates found for batch with ID " + batchId);
        } else {
            coursePlans.forEach(System.out::println);
        }
    } catch (Exception e) {
        // Handle other exceptions
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
}


   private void generateReportForBatch() {
    System.out.print("Enter batch ID to generate report: ");
    int batchId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    try {
        // Check if the batch exists first
        if (adminDao.getBatchById(batchId) == null) {
            // Batch ID does not exist
            System.out.println("Batch with ID " + batchId + " not found.");
            return;
        }

        // Generate and display the report if the batch exists
        String report = adminDao.generateReportForBatch(batchId);
        if (report != null && !report.isEmpty()) {
            System.out.println(report);
        } else {
            System.out.println("No report available for batch with ID " + batchId);
        }
    } catch (BatchNotFoundException e) {
        // Handle the exception if thrown
        System.out.println("Error generating report: " + e.getMessage());
    } catch (Exception e) {
        // Handle other unexpected exceptions
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
}

}