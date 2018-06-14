package appLayer;
import dataLayer.DB_user;
public class User {
    public boolean isValidCredentials(String sUsername, String sUserpassword){

        DB_user DB_user_object = new DB_user();

        return DB_user_object.isValidUserLogin(sUsername, sUserpassword);

    }
}
