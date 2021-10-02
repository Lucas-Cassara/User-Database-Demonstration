// Lucas Casssara
// User Account Service
// This application does in-memory creation and storage of user email accounts.

package com.userdatabase;

public class DatabaseMain {

    static ConsoleApplication consoleApplication = new ConsoleApplication();

    public static void main(String[] args) {
        consoleApplication.createDefaultAccounts();
        consoleApplication.mainMenu();
    }

}
