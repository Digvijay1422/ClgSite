package com.clg.Helper;

import org.springframework.security.core.Authentication;

public class Helper {

    @SuppressWarnings("null")
    public static String getEmailOfLoggedInUser(Authentication authentication)

    {

        return authentication.getName();

    }

}
