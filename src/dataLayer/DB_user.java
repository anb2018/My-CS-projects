package dataLayer;
import java.sql.*;

public class DB_user {

        //JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/webapp";

        // Database credentials
        static final String USER= "webappuser";
        static final String PASS= "test1234";

    public boolean isValidUserLogin(String sUsername, String sUserPassword){
        boolean isValidUser= false;

        Connection conn= null;
        Statement stmt= null;
        String sql= "";

        try{
            //Step2: Register JBDC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Step3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Step4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            sql= "SELECT * FROM users WHERE user_name= \""+ sUsername + "\"AND user_password = \""+ sUserPassword + "\"";
            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);

            //step 5:Extract data from result set

            if(rs.next()){
                isValidUser = true;
            }

            //step 6: Clean up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch(SQLException se){
            //handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //handle errors for Class.forName
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }//nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Closing DB Connection - Goodbye!");

        return isValidUser;
    }
}
