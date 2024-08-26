/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Exception.*;
import Model.*;
import java.util.List;


public interface AdminDao {
    
    //Admin  login
    public Admin  loginIntoAdmin(String username,String password) throws AuthenticationException;
    
    //course management
    public String createCourse(Course course) throws DuplicateEntryException;
    public String updateCourse(Course course) throws courseNotFoundException;
    public Course getCourseById(int courseId) throws courseNotFoundException;
    public List<Course> getAllCourse()throws courseNotFoundException;
   
    //Batch management
    public String createBatch(Batch batch) throws DuplicateEntryException;
    public String updateBatch(Batch batch) throws BatchNotFoundException;
    public Batch getBatchById(int batchId) throws BatchNotFoundException;
    public List<Batch> getAllBatch()throws BatchNotFoundException;

    //faculty management
    public String registerFaculty(Faculty faculty)throws DuplicateEntryException;
    public String updateFaculty(Faculty Faculty) throws FacultyException;
    public Faculty getFacultyById(int facultyId) throws FacultyException;
    public List<Faculty> getAllFaculty() throws FacultyException;
    
    //course plan management
    public String createCoursePlan(CoursePlan coursePlan) throws DuplicateEntryException;
    public String updateCoursePlan(CoursePlan coursePlan) throws CoursePlanNotFoundException;
    public CoursePlan getCoursePlanByBatchId(int batchId) throws CoursePlanNotFoundException;
    public List<CoursePlan> getAllCoursePlan() throws CoursePlanNotFoundException;
    
    //View day-wise updates for a batch
    public List<CoursePlan> getDayWiseUpdatesForBatch(int batchId) throws BatchNotFoundException;
    
    //Generate report for a batch
    public String generateReportForBatch(int batchId) throws BatchNotFoundException;
}