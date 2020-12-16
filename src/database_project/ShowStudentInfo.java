/*
 * THIS SHOWS THE STUDENTS TABLE
 */
package database_project;
import java.sql.*;

/**
 *
 * @author VICTOR NESTOR
 */
public class ShowStudentInfo {
    public static void main(String[] args) {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";
      
      try {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         
        // Create a Statement object.
         Statement upperNames = conn.createStatement();
         
         // Create a string with a SELECT statement.
         String upperNameStatement = "UPDATE STUDENTS SET NAME = UPPER(NAME)";
         
         // Send the update statement to the DBMS.
         int upperResult = upperNames.executeUpdate(upperNameStatement);
         
         // Create a Statement object.
         Statement upperStatus = conn.createStatement();
         
         // Create a string with a SELECT statement.
         String upperStatusStatement = "UPDATE STUDENTS SET STATUS = UPPER(STATUS)";
         
         // Send the update statement to the DBMS.
         int statusResult = upperStatus.executeUpdate(upperStatusStatement);
         
         // Create a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create a string with a SELECT statement.
         String sqlStatement = "SELECT * FROM STUDENTS";
         
         // Send the statement to the DBMS.
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         // Display the contents of the result set.
         // The result set will have three columns.
         
         System.out.printf("%25s %25s %25s %25s %25s %25s %5s\n", 
                    "EMPLID","NAME","DEPARMENT","TRANSFER","STATUS","CREDITS","GPA");
         
         while (result.next()) {
            
            System.out.printf("%25s %25s %25s %25s %25s %25s %5.2f\n",
                              result.getInt("EMPLID"),
                              result.getString("NAME"),
                              result.getInt("DEPTNO"),
                              result.getInt("TRANSFER"),
                              result.getString("STATUS"),
                              result.getInt("CREDITS"),
                              result.getDouble("GPA"));
         }
         
         // Close the connection.
         conn.close();
      }
      catch(Exception ex) {
         System.out.println("ERROR: " + ex.getMessage());
      }
    }
}
