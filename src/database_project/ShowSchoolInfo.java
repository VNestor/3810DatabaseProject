/*
 * THIS SHOWS THE SCHOOLS TABLE
 */
package database_project;
import java.sql.*;
/**
 *
 * @author VICTOR NESTOR
 */
public class ShowSchoolInfo {
       public static void main(String[] args) {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
        final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";
        System.out.printf("%25s %25s %25s\n", 
                    "SCHOOL CODE","SCHOOL NAME","SCHOOL ADDRESS");
        try {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         
         // Create a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create a string with a SELECT statement.
         String sqlStatement = "SELECT * FROM SCHOOLS";
         
         // Send the statement to the DBMS.
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         // Display the contents of the result set.
         // The result set will have three columns.
         
         while (result.next()) {
            
            System.out.printf("%25s %25s %25s\n",
                              result.getInt("SCODE"),
                              result.getString("SNAME"),
                              result.getString("SADDRESS"));
         }
         
         // Close the connection.
         conn.close();
        }
        catch(Exception ex) {
         System.out.println("ERROR: " + ex.getMessage());
        }
       }
}

   
