package ru.magazin.weblogin.utils;

import java.util.HashMap;
import java.util.Map;

import ru.magazin.weblogin.bean.UserAccount;
import ru.magazin.weblogin.config.SecurityConfig;

public class DataDAO {

    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

    static {
        initUsers();
    }

    private static void initUsers() {


        UserAccount emp = new UserAccount("employee", "123", UserAccount.GENDER_MALE, //
                SecurityConfig.ROLE_EMPLOYEE);


        UserAccount mng = new UserAccount("manager", "123", UserAccount.GENDER_MALE, //
                SecurityConfig.ROLE_EMPLOYEE, SecurityConfig.ROLE_MANAGER);

        mapUsers.put(emp.getUserName(), emp);
        mapUsers.put(mng.getUserName(), mng);
    }

    // Find a User by userName and password.
    public static UserAccount findUser(String userName, String password) {
        UserAccount u = mapUsers.get(userName);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

}