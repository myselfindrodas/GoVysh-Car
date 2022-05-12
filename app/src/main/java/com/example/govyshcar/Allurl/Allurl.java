package com.example.govyshcar.Allurl;

public class Allurl {


    public static final String IS_USER_LOGIN = "IsUserLoggedIn";
    public static String KEY_PASSWORD = null;
    public static String USER_NAME = "USER_NAME";
    public static String baseUrl;
    public static String RegistrationUrl;
    public static String ForgotPassword;
    public static String loginUrl;
    public static String verifyOTP;






    static {

        baseUrl = "http://ec2-107-20-51-89.compute-1.amazonaws.com:9081/user-ws";
        RegistrationUrl = baseUrl + "/users/registration";
        loginUrl = baseUrl + "/users/userLogin";
        ForgotPassword = baseUrl+"/users/OTPForgotPassword";
        verifyOTP = baseUrl+"/users/OTP";

        USER_NAME = "user_name";
        KEY_PASSWORD = "password";
    }
}
