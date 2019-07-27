/*
 * THIS FILE REMOVES A STUDENT FROM THE DATABASE
 */
package database_project;
import java.sql.*;
import java.util.*;


/**
 *
 * @author VICTOR NESTOR
 */
public class RemoveStudent {
     public static void main(String[] args) {
      int emplid;   // To hold the EMPLID number
      String sure;      // To make sure the user wants to delete

      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);

      try {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);

         // Create a Statement object.
         Statement stmt = conn.createStatement();

         // Get the product number for the desired student.
         System.out.print("Enter the student's EMPLID: ");
         emplid = keyboard.nextInt();

         // Display the student's current data.
         if (findAndDisplayStudent(stmt, emplid)) {
            // Make sure the user wants to remove this student.
            System.out.print("Are you sure you want to remove " +
                             "this student? (Y/N): ");
            keyboard.nextLine();
            sure = keyboard.nextLine();

            if (Character.toUpperCase(sure.charAt(0)) == 'Y') {
               // remove student.
               removeStudent(stmt, emplid);
            }
            else {
               System.out.println("The student was not removed.");
            }
         }
         else {
            // The specified product number was not found.
            System.out.println("That student was not found.");
         }

         // Close the connection.
         conn.close();
      }
      catch(Exception ex) {
         System.out.println("ERROR: " + ex.getMessage());
      }
      keyboard.close();
   }

   /**
     The findAndDisplayProduct method finds a specified student's
     data and displays it.
     @param stmt A Statement object for the database.
     @param emplid The product number for the desired student.
     @return true or false to indicate whether the product was found.
   */

   public static boolean findAndDisplayStudent(Statement stmt, int emplid) throws SQLException {
      
	  boolean studentFound; // Flag

      // Create a SELECT statement to get the specified
      // row from the Students table.
      String sqlStatement =
         "SELECT * FROM STUDENTS WHERE EMPLID = " + emplid + "";

      // Send the SELECT statement to the DBMS.
      ResultSet result = stmt.executeQuery(sqlStatement);

      // Display the contents of the result set.
      if (result.next()) {
            // Display the product.
            System.out.printf("%25s %25s %25s %25s %25s %25s %5s\n", 
                    "EMPLID","NAME","DEPARMENT","TRANSFER","STATUS","CREDITS","GPA");
            System.out.printf("%25s %25s %25s %25s %25s %25s %5.2f\n",
                              result.getInt("EMPLID"),
                              result.getString("NAME"),
                              result.getInt("DEPTNO"),
                              result.getInt("TRANSFER"),
                              result.getString("STATUS"),
                              result.getInt("CREDITS"),
                              result.getDouble("GPA"));

            // Set the flag to indicate the product was found.
            studentFound = true;
      }
      else {
         // Indicate the product was not found.
         studentFound = false;
      }

      return studentFound;
   }

   /**
     The delete emplid method deletes a specified emplid.
     @param stmt A Statement object for the database.
     @param emplid The emplid number for the desired student.
   */

   public static void removeStudent(Statement stmt, int emplid) throws SQLException {
      // Create a DELETE statement to delete the
      // specified product number.
      String sqlStatement = "DELETE FROM STUDENTS WHERE EMPLID = " + emplid + "";

      // Send the DELETE statement to the DBMS.
      int rows = stmt.executeUpdate(sqlStatement);

      // Display the results.
      System.out.println(rows + " row(s) deleted.");
   }
    
}
