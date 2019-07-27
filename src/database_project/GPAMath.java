/*
 * THIS FINDS THE LOWEST, HIGHEST, AVERAGE GPA
 */
package database_project;
import java.sql.*;

/**
 * 
 * @author VICTOR NESTOR
 */
public class GPAMath {
    public static void main(String[] args){
        double lowest = 0.0,
               highest = 0.0,
               average = 0.0;
        
        final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";
        
        try {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
     
        // Create a Statement object
        Statement stmt = conn.createStatement();
        
        
       // Create select statements 
       String minStatement = "SELECT MIN(GPA) FROM STUDENTS";
       String maxStatement = "SELECT MAX(GPA) FROM STUDENTS";
       String avgStatement = "SELECT AVG(GPA) FROM STUDENTS";
       
        // Get lowest GPA 
        ResultSet minResult = stmt.executeQuery(minStatement);
        if (minResult.next())
            lowest = minResult.getDouble(1);
        
        // Get highest GPA
        ResultSet maxResult = stmt.executeQuery(maxStatement);
        if (maxResult.next())
            highest = maxResult.getDouble(1);
        
        // Get average GPA
        ResultSet avgResult = stmt.executeQuery(avgStatement);
        if (avgResult.next())
            average = avgResult.getDouble(1);
        
        //Display results
        System.out.printf("Lowest GPA: %.2f\n", lowest);
        System.out.printf("Highest GPA: %.2f\n", highest);
        System.out.printf("Average GPA: %.2f\n", average);
        
        // Close the connection
        conn.close();
        }
        catch(Exception ex) {
         System.out.println("ERROR: " + ex.getMessage());
        }
    }
        
}
