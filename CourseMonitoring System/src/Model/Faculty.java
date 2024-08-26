/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.regex.Pattern;

public class Faculty {

    private int facultyId;
    private String facultyName;
    private String facultyAddress;
    private String mobile;
    private String email;
    private String username;
    private String password;

    // Default constructor
    public Faculty() {
    }

    // Parameterized constructor
    public Faculty(int facultyId, String facultyName, String facultyAddress, String mobile, String email, String username, String password) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyAddress = facultyAddress;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyAddress() {
        return facultyAddress;
    }

    public void setFacultyAddress(String facultyAddress) {
        this.facultyAddress = facultyAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        // Basic validation for a 10-digit phone number
        if (!Pattern.matches("\\d{10}", mobile)) {
            throw new IllegalArgumentException("Mobile number must be 10 digits");
        }
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Basic validation for email format
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method
@Override
public String toString() {
    return "Faculty Details:\n" +
           "---------------------------------\n" +
           "Faculty ID       : " + facultyId + "\n" +
           "Name             : " + facultyName + "\n" +
           "Address          : " + facultyAddress + "\n" +
           "Mobile           : " + mobile + "\n" +
           "Email            : " + email + "\n" +
           "Username         : " + username + "\n" +
           "Password         : " + password + "\n" + // You might want to omit showing the password in a real application
           "---------------------------------";
}

}


