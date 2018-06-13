package appLayer;

public class User {
    public boolean isValidCredentials(String sUsername, String sUserpassword){
        if(sUsername.equals("ab@d.com")&sUserpassword.equals("12")){
            return true;
        }
        return false;

    }
}
