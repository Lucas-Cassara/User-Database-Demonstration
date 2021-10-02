// Class for creating User Account objects.

package com.userdatabase;

public class UserAccountModel {

    // Variables to store desired information about each user.

    private String firstName;
    private String lastName;
    private String department;
    private String emailAddress;
    private String emailPassword;
    private String userId;

    public UserAccountModel(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.emailAddress = "";
        this.emailPassword = "";
        this.userId = "";
    }

    // Getters and setters for each variable within the User Account object.

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getUserId() {
        return String.valueOf(userId);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserId: " + userId + "\n"
                + "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "Department " + department + "\n"
                + "Email Address: " + emailAddress + "\n"
                + "Password: " + emailPassword + "\n";
    }
}
