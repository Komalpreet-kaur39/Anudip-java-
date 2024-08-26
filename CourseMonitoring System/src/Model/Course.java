/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Course {
    
    private int courseId;
    private String courseName;
    private double fee;
    private String courseDescription;

    // Default constructor
    public Course() {
    }

    // Parameterized constructor
    public Course(int courseId, String courseName, double fee, String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
        this.courseDescription = courseDescription;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    // toString method
   @Override
public String toString() {
    return "Course Details:\n" +
           "---------------------------------\n" +
           "Course ID           : " + courseId + "\n" +
           "Course Name         : " + courseName + "\n" +
           "Course Fee          : " + fee + "\n" +
           "Course Description  : " + courseDescription + "\n" +
           "---------------------------------";
}

}

    

