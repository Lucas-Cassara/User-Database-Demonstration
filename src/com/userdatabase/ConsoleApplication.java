// This class displays the menus that the administrator can interact with.
// It also processes their inputs to perform database tasks.

package com.userdatabase;

import java.util.Scanner;

public class ConsoleApplication {

    // Initial Variables

    boolean exitApplication = false;
    UserAccountService userAccountService = new UserAccountService();
    DisplayService displayService = new DisplayService();
    Scanner in = new Scanner(System.in);

    public void mainMenu() {
        int userSelection;

        System.out.print(displayService.displayMainMenu());

        do {
            userSelection = in.nextInt();
            switch (userSelection) {
                case 1 -> accountCreationMenu();
                case 2 -> accountSearchMenu();
                case 3 -> {
                    System.out.println("Closing the application...");
                    exitApplication = true;
                }
                default -> System.out.print("Enter a valid selection:\s");
            }
            System.out.println(displayService.displayMainMenu());
        } while(exitApplication != true);
    }

    public void accountCreationMenu() {
        String firstName;
        String lastName;
        String department;

        System.out.print("Enter employee first name: ");
        firstName = in.next();

        System.out.print("Last name: ");
        lastName = in.next();

        System.out.print("Department: ");
        department = in.next();

        UserAccountModel newUserAccount =
                userAccountService.CreateUserAccount(firstName, lastName, department);

        System.out.println("\n" + newUserAccount.toString());
    }

    public void accountSearchMenu() {
        System.out.print("""
                                          
                1. View all user accounts.
                2. Search by UserID.
                Enter a selection:\s""");
        int userSelection = in.nextInt();
        switch (userSelection) {
            case 1 -> System.out.println(userAccountService.userAccountRepository.userAccountModels);
            case 2 -> {
                String userId;
                System.out.print("Enter UserId: ");
                userId = in.next();
                System.out.println(userAccountService.GetUserAccountById(userId));
                System.out.print("""
                        1. Modify.
                        2. Delete.
                        3. Exit.
                        Enter a selection:\s""");

                userSelection = in.nextInt();
                switch (userSelection) {
                    // Case for modifying user account data.
                    case 1:
                        UserAccountModel selectedAccount = userAccountService.GetUserAccountById(userId);
                        String firstName;
                        String lastName;
                        String department;
                        String password;

                        System.out.println("Current first name: " + selectedAccount.getFirstName());
                        System.out.print("Enter new first name: ");
                        firstName = in.next();
                        selectedAccount.setFirstName(firstName);

                        System.out.println("Current last name: " + selectedAccount.getLastName());
                        System.out.print("Enter new last name: ");
                        lastName = in.next();
                        selectedAccount.setLastName(lastName);

                        System.out.println("Current department: " + selectedAccount.getDepartment());
                        System.out.print("Enter new department: ");
                        department = in.next();
                        selectedAccount.setDepartment(department);

                        System.out.println("Current password: " + selectedAccount.getEmailPassword());
                        System.out.print("Enter new password: ");
                        password = in.next();
                        selectedAccount.setEmailPassword(password);
                        break;
                    case 2:
                        userAccountService.DeleteUserAccount(userId);
                        break;
                    case 3:
                        break;
                }
            }
        }

    }

    public void createDefaultAccounts() {

        String[][] initialAccounts = {
                {"Marcus", "Aurelius", "Management"},
                {"Issac", "Newton", "Engineering"},
                {"Irina", "Sebrova", "Flight_Operations"},
                {"John", "Bardeen", "Technology"}
        };

        for (String[] initialAccount : initialAccounts) {
            String firstName = initialAccount[0];
            String lastName = initialAccount[1];
            String department = initialAccount[2];
            userAccountService.CreateUserAccount(firstName, lastName, department);
        }
    }

}