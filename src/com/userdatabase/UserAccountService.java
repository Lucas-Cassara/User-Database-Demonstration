// Class that handles the creation and management of new user accounts.

package com.userdatabase;

public class UserAccountService {

    UserAccountRepository userAccountRepository = new UserAccountRepository();

    public UserAccountModel CreateUserAccount(String firstName, String lastName, String department) {
        UserAccountModel newUserAccount = new UserAccountModel(firstName, lastName, department);
        newUserAccount.setEmailAddress(generateEmailAddress(newUserAccount));
        newUserAccount.setEmailPassword(generatePassword());
        newUserAccount.setUserId(String.valueOf(userAccountRepository.numberOfAccounts() + 1));
        userAccountRepository.saveUserAccount(newUserAccount.getUserId(), newUserAccount);
        return newUserAccount;
    }

    public UserAccountModel GetUserAccountById(String userId) {
        return userAccountRepository.loadUserAccountById(userId);
    }

    public void DeleteUserAccount(String userId) {
        userAccountRepository.RemoveUserAccountModel(userId);
    }

    private String generateEmailAddress(UserAccountModel userAccountModel) {
        String defaultDomain = "corporate.com";
        return userAccountModel.getFirstName() + "." + userAccountModel.getLastName() + "@" + defaultDomain;
    }

    private String generatePassword() {
        int passwordLength = 12;
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*/";
        char[] password = new char[passwordLength];
        for (int i = 0; i < passwordLength; i++) {
            int randomValue = (int) (Math.random() * validCharacters.length());
            password[i] = validCharacters.charAt(randomValue);
        }
        return new String(password);
    }

}
