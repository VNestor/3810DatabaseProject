/*
 * THIS FILE SHOWS THE DEPARTMENT TABLE
 */
package database_project;
import java.sql.*;

/**
 *
 * @author VICTOR NESTOR
 */
public class ShowDepartmentInfo {
    public static void main(String[] args) {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
        final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";
        System.out.printf("%25s %25s %25s\n", 
                    "DEPT NUMBER","MAJOR","DEGREE TYPE");
        try {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         
         // Create a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create a string with a SELECT statement.
         String sqlStatement = "SELECT * FROM DEPARTMENT";
         
         // Send the statement to the DBMS.
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         // Display the contents of the result set.
         // The result set will have three columns.
         
         while (result.next()) {
            
            System.out.printf("%25s %25s %25s\n",
                              result.getInt("DEPTNO"),
                              result.getString("MAJOR"),
                              result.getString("DEGREE"));
         }
         
         // Close the connection.
         conn.close();
        }
        catch(Exception ex) {
         System.out.println("ERROR: " + ex.getMessage());
        }
       }
}
