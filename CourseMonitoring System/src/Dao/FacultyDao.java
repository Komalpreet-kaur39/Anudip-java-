/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Exception.*;
import Model.*;

public interface FacultyDao {
    public Faculty loginIntoFaculty(String username ,String password ) throws AuthenticationException;
    public CoursePlan viewCoursePlan(int BatchId) throws CoursePlanNotFoundException;
    public String fillDayWisePlanner(int coursePlan, String topic, String status) throws CoursePlanNotFoundException;
    public String updateFacultyPassword(int facultyId, String oldPassword, String newPassword) throws FacultyException, AuthenticationException;   
}
