/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Dao.FacultyDao;
import Exception.AuthenticationException;
import Exception.CoursePlanNotFoundException;
import Exception.FacultyException;
import Model.CoursePlan;
import Model.Faculty;
import Utility.Dao;
import java.sql.SQLException;

public class FacultyDaoImpl implements FacultyDao {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public  Connection getconnection1(){
        try {
            con = Dao.getConnectionFactory().getConnection() ;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return con;
    }
   private void closeResources() {
    try {
        if (pst != null) pst.close();
        if (rs != null) rs.close();
        if (con != null) con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    @Override
   public Faculty loginIntoFaculty(String username, String password) throws AuthenticationException {
    Faculty faculty = null;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    try {
 con=getconnection1();        String query = "SELECT * FROM Faculty WHERE username = ? AND password = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, password); // Ensure passwords are hashed if needed
        rs = pst.executeQuery();
        
        if (rs.next()) {
            faculty = new Faculty(
                rs.getInt("facultyId"),
                rs.getString("facultyName"),
                rs.getString("facultyAddress"),
                rs.getString("mobile"),
                rs.getString("email"),
                rs.getString("username"),
                rs.getString("password")
            );
        } else {
            throw new AuthenticationException("Invalid username or password.");
        }
    } catch (SQLException e) {
        throw new AuthenticationException("Error during authentication: " + e.getMessage());
    } finally {
        closeResources(); // Ensure all resources are closed properly
    }
    
    return faculty;
}

    @Override
    public CoursePlan viewCoursePlan(int BatchId) throws CoursePlanNotFoundException {
        try {
            String query="select * from CoursePlan where batchId =?";
            con=getconnection1();
            pst=con.prepareStatement(query);
            pst.setInt(1,BatchId);
            rs=pst.executeQuery();
            if(rs.next()){
                return new CoursePlan(rs.getInt("planId"),rs.getInt("batchId"),rs.getInt("dayNumber"),rs.getString("topic"),rs.getString("status"));
            }else{
                throw new CoursePlanNotFoundException("Course plan not found for batch ID: " + BatchId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();        }
        finally {
        closeResources();
    }
                throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
public String fillDayWisePlanner(int planId, String topic, String status) throws CoursePlanNotFoundException {
    String message = "Planner not updated";
    
    try {
        con = getconnection1();
        pst = con.prepareStatement("UPDATE CoursePlan SET topic = ?, status = ? WHERE planId = ?");
        pst.setString(1, topic);
        pst.setString(2, status);
        pst.setInt(3, planId);
        
        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            message = "Planner updated successfully";
        } else {
            throw new CoursePlanNotFoundException("Course plan with ID " + planId + " not found.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        throw new CoursePlanNotFoundException(ex.getMessage());
    } finally {
        closeResources();
    }
    
    return message;
}

    @Override
    public String updateFacultyPassword(int facultyId, String oldPassword, String newPassword) throws FacultyException, AuthenticationException {
        String msg="Password not updated";
        try {
            con=getconnection1();
            pst=con.prepareStatement("update Faculty set password=? where facultyId=? and password=?");
            pst.setString(1, newPassword);
            pst.setInt(2, facultyId);
            pst.setString(3,oldPassword);
            int ans=pst.executeUpdate();
            if(ans!=0){
                msg="Password updated successfully!";
            }else{
                throw new AuthenticationException("Incorrect old password.");
            }
        } catch (Exception e) {
             throw new FacultyException(e.getMessage());
        }finally {
        closeResources();
    }
        return msg;
    }

   
    
    
    
}
