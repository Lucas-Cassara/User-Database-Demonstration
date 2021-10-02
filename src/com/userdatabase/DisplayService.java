// Displays the main menu.

package com.userdatabase;

public class DisplayService {

    public String displayMainMenu() {
        return """
                1. Create user account.
                2. View existing accounts.
                3. Exit application.
                Enter a selection:\s""";
    }

}
