/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class CoursePlan {

    private int planId;
    private int batchId;
    private int dayNumber;
    private String topic;
    private String status;

    // Default constructor
    public CoursePlan() {
    }

    // Parameterized constructor
    public CoursePlan(int planId, int batchId, int dayNumber, String topic, String status) {
        this.planId = planId;
        this.batchId = batchId;
        this.dayNumber = dayNumber;
        this.topic = topic;
        this.status = status;
    }

    // Getters and Setters
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
public String toString() {
    return "Course Plan Details:\n" +
           "---------------------------------\n" +
           "Plan ID            : " + planId + "\n" +
           "Batch ID           : " + batchId + "\n" +
           "Day Number         : " + dayNumber + "\n" +
           "Topic              : " + topic + "\n" +
           "Status             : " + status + "\n" +
           "---------------------------------";
}

}

