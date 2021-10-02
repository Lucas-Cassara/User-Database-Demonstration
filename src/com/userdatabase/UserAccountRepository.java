// Creates a Hash Map to store user accounts as a key / value pair.
// Methods for saving, loading, and deleting accounts.

package com.userdatabase;

import java.util.HashMap;

public class UserAccountRepository {

    HashMap<String, UserAccountModel> userAccountModels = new HashMap<>();

    public void saveUserAccount(String userId, UserAccountModel userAccount) {
        userAccountModels.put(userId, userAccount);
    }

    public UserAccountModel loadUserAccountById(String userId) {
        return userAccountModels.get(userId);
    }

    public void RemoveUserAccountModel(String userId) {
        userAccountModels.remove(userId);
    }

    public int numberOfAccounts() {
        return userAccountModels.size();
    }

}
