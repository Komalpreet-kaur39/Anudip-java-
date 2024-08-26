/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class Batch {

    private int batchId;
    private int courseId;
    private int facultyId;
    private int numberOfStudents;
    private Date batchStartDate;
    private int duration;

    // Default constructor
    public Batch() {
    }

    // Parameterized constructor
    public Batch(int batchId, int courseId, int facultyId, int numberOfStudents, Date batchStartDate, int duration) {
        this.batchId = batchId;
        this.courseId = courseId;
        this.facultyId = facultyId;
        this.numberOfStudents = numberOfStudents;
        this.batchStartDate = batchStartDate;
        this.duration = duration;
    }

    // Getters and Setters
    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Date getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(Date batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // toString method
    @Override
public String toString() {
    return "Batch Details:\n" +
           "---------------------------------\n" +
           "Batch ID         : " + batchId + "\n" +
           "Course ID        : " + courseId + "\n" +
           "Faculty ID       : " + facultyId + "\n" +
           "Number of Students: " + numberOfStudents + "\n" +
           "Batch Start Date : " + batchStartDate + "\n" +
           "Duration (Days)  : " + duration + "\n" +
           "---------------------------------";
}

}


