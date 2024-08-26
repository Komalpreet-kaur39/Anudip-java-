/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import Dao.AdminDao;
import java.sql.Connection;
import java.sql.ResultSet;  
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
import Utility.Dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminDaoImpl implements AdminDao {

    Connection con=null;
    PreparedStatement ppst=null;
    ResultSet rs=null;
    
    public  Connection getconnection1(){
        try {
            con = Dao.getConnectionFactory().getConnection() ;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return con;
    }
    private void closeResources(Connection con,PreparedStatement ppst,   ResultSet rs) {
    try {
        if (ppst != null) ppst.close();
        if (rs != null) rs.close();
        if (con != null) con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
    public Admin loginIntoAdmin(String username, String password) throws AuthenticationException {
        try {
            con=getconnection1();
            ppst=con.prepareStatement("select *from Admin where username=? and password=?");
            ppst.setString(1, username);
            ppst.setString(2,password);
            rs=ppst.executeQuery();
            if(rs.next()){
//            return new Admin(rs.getString("username"),rs.getString("password"));
             String adminUsername = rs.getString("username");
            // Optionally, populate additional admin fields if needed
            return new Admin(adminUsername);
            }
            else{
                throw new AuthenticationException("Invalid username or password.");
            }
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
       finally {
        closeResources(con,ppst,rs);
    }
    }

    @Override
    public String createCourse(Course course) throws DuplicateEntryException {
    String msg = "Course not added";

    try {
        con = getconnection1();
        
        // Insert the course into the database without using RETURN_GENERATED_KEYS
        ppst = con.prepareStatement("Insert Into Course(courseName, fee, courseDescription) values(?,?,?)");
        ppst.setString(1, course.getCourseName());
        ppst.setDouble(2, course.getFee());
        ppst.setString(3, course.getCourseDescription());

        int ans = ppst.executeUpdate();

        if (ans != 0) {
            // Query for the last inserted ID
            ppst = con.prepareStatement("SELECT LAST_INSERT_ID()");
            rs = ppst.executeQuery();
            
            if (rs.next()) {
                int generatedId = rs.getInt(1);  // Get the last inserted ID
                course.setCourseId(generatedId);  // Set the ID in the course object
                msg = "Course added successfully with ID: " + generatedId;
            } else {
                msg = "Course added, but ID retrieval failed.";
            }
        }

    } catch (Exception e) {
        throw new DuplicateEntryException("SQL Error: " + e.getMessage());
    } finally {
        closeResources(con, ppst, rs);
    }

    return msg;
}


    @Override
    public String updateCourse(Course course) throws courseNotFoundException {
         String msg="Course not Updated";
        try {
            con=getconnection1();
            ppst=con.prepareStatement("Update Course set courseName = ?, fee = ?, courseDescription = ? WHERE courseId = ?");
            ppst.setString(1,course.getCourseName());
            ppst.setDouble(2,course.getFee());
            ppst.setString(3,course.getCourseDescription());
            ppst.setInt(4,course.getCourseId());

            int ans=ppst.executeUpdate();
            if(ans!=0){
                msg="Course updated successfully!";
            }else{
                throw new courseNotFoundException("Course with ID " + course.getCourseId() + " not found.");

            }
        } catch (Exception e) {
                throw new courseNotFoundException(e.getMessage());     
        }finally {
        closeResources(con,ppst,rs);
    }
        return msg;
   
    }

    @Override
    public Course getCourseById(int courseId) throws courseNotFoundException {
         
        try {
            con=getconnection1();
            ppst=con.prepareStatement("select *from Course where courseId=?");
            ppst.setInt(1, courseId);
            rs=ppst.executeQuery();
            if(rs.next()){
            return new Course(rs.getInt("courseid"),rs.getString("courseName"),rs.getDouble("fee"),rs.getString("courseDescription"));
            }
            else{
                throw new courseNotFoundException("Course with ID " + courseId + " not found.");
            }
        } catch (Exception e) {
            throw new courseNotFoundException(e.getMessage());
        } finally {
        closeResources(con,ppst,rs);
    } 
    }

    @Override
    public List<Course> getAllCourse() throws courseNotFoundException {
        List<Course> courses=new ArrayList<>();

        try {
            con=getconnection1();
            ppst=con.prepareStatement("select * from Course");
            rs=ppst.executeQuery();
            while(rs.next()){
                Course course = new Course(rs.getInt("courseId"), rs.getString("courseName"), rs.getDouble("fee"), rs.getString("courseDescription"));
                courses.add(course);
                
            }
            if(courses.isEmpty()){
                throw new courseNotFoundException("No courses found.");
            }
        } catch (Exception e) {
            throw new courseNotFoundException(e.getMessage());
        }finally {
        closeResources(con,ppst,rs);
    }
    return courses;
    }

   @Override
public String createBatch(Batch batch) throws DuplicateEntryException {
    String msg = "Batch not added";

    try {
        con = getconnection1();
        ppst = con.prepareStatement("INSERT INTO Batch (courseId, facultyId, numberOfStudents, batchStartDate, duration) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        ppst.setInt(1, batch.getCourseId());
        ppst.setInt(2, batch.getFacultyId());
        ppst.setInt(3, batch.getNumberOfStudents());
        ppst.setDate(4, new java.sql.Date(batch.getBatchStartDate().getTime()));
        ppst.setInt(5, batch.getDuration());

        int ans = ppst.executeUpdate();
        if (ans != 0) {
            rs = ppst.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                batch.setBatchId(generatedId);
                msg = "Batch added successfully with ID: " + generatedId;
            } else {
                msg = "Batch added, but ID retrieval failed.";
            }
        }
    } catch (SQLException e) {
        throw new DuplicateEntryException("SQL Error: " + e.getMessage());
    } finally {
        closeResources(con, ppst, rs);
    }

    return msg;
}

    @Override
    public String updateBatch(Batch batch) throws BatchNotFoundException {
        String msg="Batch not Updated";
        try {
            con=getconnection1();
            ppst=con.prepareStatement("Update Batch set courseId = ?, facultyId = ?, numberOfStudents = ? ,batchStartDate=?,duration=? WHERE batchId = ?");
            ppst.setInt(1,batch.getCourseId());
            ppst.setInt(2,batch.getFacultyId());
            ppst.setInt(3,batch.getNumberOfStudents());
            ppst.setDate(4,(Date) batch.getBatchStartDate());
            ppst.setInt(5,batch.getDuration());
            ppst.setInt(6,batch.getBatchId());



            int ans=ppst.executeUpdate();
            if(ans!=0){
                msg="Batch updated successfully!";
            }else{
                throw new courseNotFoundException("Batch with ID " + batch.getBatchId() + " not found.");

            }
        } catch (Exception e) {
                throw new BatchNotFoundException(e.getMessage());     
        }finally {
        closeResources(con,ppst,rs);
    }
        return msg;  
    }

    @Override
    public Batch getBatchById(int batchId) throws BatchNotFoundException {
        try {
            con=getconnection1();
            ppst=con.prepareStatement("select *from Batch where batchId=?");
            ppst.setInt(1, batchId);
            rs=ppst.executeQuery();
            if(rs.next()){
            return new Batch(rs.getInt("batchId"),rs.getInt("batchId"),rs.getInt("facultyId"),rs.getInt("numberOfStudents"),rs.getDate("batchStartDate"),rs.getInt("duration"));
            }
            else{
                throw new courseNotFoundException("Batch with ID " + batchId + " not found.");
            }
        } catch (Exception e) {
            throw new BatchNotFoundException(e.getMessage());
        }  finally {
        closeResources(con,ppst,rs);
    }
    }

    @Override
    public List<Batch> getAllBatch() throws BatchNotFoundException {
      List<Batch> batches=new ArrayList<>();
        try {
            con=getconnection1();
            ppst=con.prepareStatement("select * from Batch");
            rs=ppst.executeQuery();
            while(rs.next()){
                Batch batch = new Batch(rs.getInt("batchId"),rs.getInt("courseId"),rs.getInt("facultyId"), rs.getInt("numberOfStudents"), rs.getDate("batchStartDate"), rs.getInt("duration"));
                batches.add(batch);
                
            }
            if(batches.isEmpty()){
                throw new BatchNotFoundException("No batches found.");
            }
        } catch (Exception e) {
            throw new BatchNotFoundException(e.getMessage());
        }finally {
        closeResources(con,ppst,rs);
    }
    return batches;    }

    @Override
  

public String registerFaculty(Faculty f) throws DuplicateEntryException {
    String msg = "Faculty not added";

    try {
        con = getconnection1();
        
        // Check if a faculty member with the same username already exists
        ppst = con.prepareStatement("SELECT COUNT(*) FROM Faculty WHERE username = ?");
        ppst.setString(1, f.getUsername());
        rs = ppst.executeQuery();
        
        if (rs.next() && rs.getInt(1) > 0) {
            throw new DuplicateEntryException("Username already exists: " + f.getUsername());
        }

        // Proceed with insertion if the username is unique
        ppst = con.prepareStatement("INSERT INTO Faculty (facultyName, facultyAddress, email, mobile, username, password) VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        ppst.setString(1, f.getFacultyName());
        ppst.setString(2, f.getFacultyAddress());
        ppst.setString(3, f.getEmail());
        ppst.setString(4, f.getMobile());
        ppst.setString(5, f.getUsername());
        ppst.setString(6, f.getPassword());

        int ans = ppst.executeUpdate();
        if (ans != 0) {
            rs = ppst.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                f.setFacultyId(generatedId);
                msg = "Faculty added successfully with ID: " + generatedId;
            } else {
                msg = "Faculty added, but ID retrieval failed.";
            }
        }
    } catch (SQLException e) {
        throw new DuplicateEntryException("SQL Error: " + e.getMessage());
    } finally {
        closeResources(con, ppst, rs);
    }

    return msg;
}


    @Override
    public String updateFaculty(Faculty f) throws FacultyException {
        String msg="Faculty not Updated";
        try {
            con=getconnection1();
            ppst=con.prepareStatement("Update Faculty set facultyName=?,facultyAddress=?,  mobile=?,  email=?, username=?, password=? WHERE facultyId = ?");
            ppst.setString(1, f.getFacultyName());
            ppst.setString(2,  f.getFacultyAddress());
             ppst.setString(3,  f.getMobile());
            ppst.setString(4,f.getEmail());
            ppst.setString(5,f.getUsername());
            ppst.setString(6,f.getPassword()); 
            ppst.setInt(7, f.getFacultyId());


            int ans=ppst.executeUpdate();
            if(ans!=0){
                msg="Faculty updated successfully!";
            }else{
                throw new courseNotFoundException("Course with ID " + f.getFacultyId() + " not found.");

            }
        } catch (Exception e) {
                throw new FacultyException(e.getMessage());     
        }finally {
        closeResources(con,ppst,rs);
    }
        return msg;       }

    @Override
    public Faculty getFacultyById(int facultyId) throws FacultyException {
        try {
            con=getconnection1();
            ppst=con.prepareStatement("select *from Faculty where facultyId=?");
            ppst.setInt(1, facultyId);
            rs=ppst.executeQuery();
            if(rs.next()){
            return new Faculty(rs.getInt("facultyId"),rs.getString("facultyName"),rs.getString("facultyAddress"),rs.getString("mobile"),rs.getString("email"),rs.getString("username"),rs.getString("password"));
            }
            else{
                throw new courseNotFoundException("Faculty with ID " + facultyId + " not found.");
            }
        } catch (Exception e) {
            throw new FacultyException(e.getMessage());
        } finally {
        closeResources(con,ppst,rs);
    }     
    }

    @Override
    public List<Faculty> getAllFaculty() throws FacultyException {
        List<Faculty> f=new ArrayList<>();
        try {
            con=getconnection1();
            ppst=con.prepareStatement("select * from Faculty");
            rs=ppst.executeQuery();
            while(rs.next()){
                Faculty f1 = new Faculty(rs.getInt("facultyId"),rs.getString("facultyName"),rs.getString("facultyAddress"), rs.getString("mobile"), rs.getString("email"), rs.getString("username"),rs.getString("password"));
                f.add(f1);
                
            }
            if(f.isEmpty()){
                throw new FacultyException("No faculty found.");
            }
        } catch (Exception e) {
            throw new FacultyException(e.getMessage());
        }finally {
        closeResources(con,ppst,rs);
    }
    return f;  
    }

    @Override
    public String createCoursePlan(CoursePlan coursePlan) throws DuplicateEntryException {
     String msg = "Course Plan not added";
    try {
        con = getconnection1();
        

//if (!batchExists(coursePlan.getBatchId())) {
//            throw new DuplicateEntryException("Batch with ID " + coursePlan.getBatchId() + " does not exist.");
//        }
        ppst = con.prepareStatement("INSERT INTO CoursePlan (planId, batchId, dayNumber,topic, status) VALUES (?, ?, ?, ?, ?)");
        ppst.setInt(1, coursePlan.getPlanId());
        ppst.setInt(2, coursePlan.getBatchId());
        ppst.setInt(3, coursePlan.getDayNumber());
        ppst.setString(4, coursePlan.getTopic());
        ppst.setString(5, coursePlan.getStatus());

        int ans = ppst.executeUpdate();
        if (ans != 0) {
            msg = "Course Plan added successfully!";
        }
    } catch (Exception e) {
        throw new DuplicateEntryException("SQL error:"+e.getMessage());
    } finally {
        closeResources(con,ppst,rs);
    }
    return msg;
    }
    
//    public boolean batchExists(int batchId) {
//     
//    try {
//            con=getconnection1();
//        ppst = con.prepareStatement("SELECT 1 FROM Batch WHERE batchId = ?");
//        ppst.setInt(1, batchId);
//        rs = ppst.executeQuery();
//        return rs.next(); // If a result exists, batchId is valid
//    } catch (SQLException e) {
//        throw new RuntimeException("SQL Error: " + e.getMessage(), e);
//    } finally {
//        closeResources(con, ppst, rs);
//    }
//}

// Method to validate status
private boolean isValidStatus(String status) {
    return "done".equalsIgnoreCase(status) || "pending".equalsIgnoreCase(status);
}
    @Override
    public String updateCoursePlan(CoursePlan coursePlan) throws CoursePlanNotFoundException {
        String msg="CoursePlan not Updated";
        try {
            con=getconnection1();
            ppst=con.prepareStatement("Update CoursePlan set batchId=?,dayNumber=?,  topic=?,  status=?,  WHERE planId = ?");
            ppst.setInt(1, coursePlan.getBatchId());
            ppst.setInt(2,  coursePlan.getDayNumber());
             ppst.setString(3,  coursePlan.getTopic());
            ppst.setString(4,coursePlan.getStatus());
            ppst.setInt(5,coursePlan.getPlanId());
      
            int ans=ppst.executeUpdate();
            if(ans!=0){
                msg="CoursePlan updated successfully!";
            }else{
                throw new CoursePlanNotFoundException("CoursePlan with ID " + coursePlan.getPlanId() + " not found.");

            }
        } catch (Exception e) {
                throw new CoursePlanNotFoundException(e.getMessage());     
        }finally {
        closeResources(con,ppst,rs);
    }
        return msg;    
    }

    @Override
    public CoursePlan getCoursePlanByBatchId(int batchId) throws CoursePlanNotFoundException {
        try {
            con=getconnection1();
            ppst=con.prepareStatement("select *from CoursePlan where batchId=?");
            ppst.setInt(1, batchId);
            rs=ppst.executeQuery();
            if(rs.next()){
            return new CoursePlan(rs.getInt("planId"),rs.getInt("batchId"),rs.getInt("dayNumber"),rs.getString("topic"),rs.getString("status"));
            }
            else{
                throw new CoursePlanNotFoundException("Faculty with ID " + batchId + " not found.");
            }
        } catch (Exception e) {
            throw new CoursePlanNotFoundException(e.getMessage());
        } finally {
        closeResources(con,ppst,rs);
    }    
    }

    @Override
    public List<CoursePlan> getAllCoursePlan() throws CoursePlanNotFoundException {
         List<CoursePlan>  c =new ArrayList<>();
        try {
            con=getconnection1();
            ppst=con.prepareStatement("select * from CoursePlan");
            rs=ppst.executeQuery();
            while(rs.next()){
                CoursePlan c1 = new CoursePlan(rs.getInt("planId"),rs.getInt("batchId"),rs.getInt("dayNumber"),rs.getString("topic"),rs.getString("status"));
                c.add(c1);
                
            }
            if(c.isEmpty()){
                throw new CoursePlanNotFoundException("No faculty found.");
            }
        } catch (Exception e) {
            throw new CoursePlanNotFoundException(e.getMessage());
        }finally {
        closeResources(con,ppst,rs);
    }
    return c;  
    }

    @Override
    public List<CoursePlan> getDayWiseUpdatesForBatch(int batchId) throws BatchNotFoundException {
         List<CoursePlan> coursePlans = new ArrayList<>();
    try {
        con = getconnection1();
        ppst = con.prepareStatement("SELECT * FROM CoursePlan WHERE batchId = ? ORDER BY dayNumber");
        ppst.setInt(1, batchId);
        rs = ppst.executeQuery();
        while (rs.next()) {
                CoursePlan c1 = new CoursePlan(rs.getInt("planId"),rs.getInt("batchId"),rs.getInt("dayNumber"),rs.getString("topic"),rs.getString("status"));
            coursePlans.add(c1);
        }
        if (coursePlans.isEmpty()) {
            throw new BatchNotFoundException("No day-wise updates found for batch with ID " + batchId);
        }
    } catch (Exception e) {
        throw new BatchNotFoundException(e.getMessage());
    } finally {
        closeResources(con,ppst,rs);
    }
    return coursePlans;
    }

   @Override
public String generateReportForBatch(int batchId) throws BatchNotFoundException {
    StringBuilder report = new StringBuilder();

    try {
        // Get a connection
        con = getconnection1();
        
        // Prepare the SQL query
        String query = "SELECT dayNumber, topic, status FROM CoursePlan WHERE batchId = ?";
        ppst = con.prepareStatement(query);
        ppst.setInt(1, batchId);
        
        // Execute the query
        rs = ppst.executeQuery();
        
        // Header for the report
        report.append("Course Plan Report for Batch ID: ").append(batchId).append("\n")
              .append("--------------------------------------------------\n")
              .append(String.format("%-10s %-30s %-10s\n", "Day", "Topic", "Status"))
              .append("--------------------------------------------------\n");
        
        // Process the result set
        boolean reportFound = false;
        while (rs.next()) {
            reportFound = true;
            
            // Fetch the data and format it in columns
            report.append(String.format("%-10d %-30s %-10s\n", 
                                        rs.getInt("dayNumber"), 
                                        rs.getString("topic"), 
                                        rs.getString("status")));
        }
        
        // If no report is found, throw exception
        if (!reportFound) {
            throw new BatchNotFoundException("No report found for batch with ID " + batchId);
        }
        
    } catch (SQLException e) {
        // Log the exception message and throw as BatchNotFoundException
        throw new BatchNotFoundException("SQL Error: " + e.getMessage());
    } catch (Exception e) {
        // Catch any other exceptions
        throw new BatchNotFoundException("Error: " + e.getMessage());
    } finally {
        // Close resources to prevent memory leaks
        closeResources(con, ppst, rs);
    }
    
    return report.toString();
}

    
}
