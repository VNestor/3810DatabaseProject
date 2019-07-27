/*
 * THIS TEST THE DATABASE CONNECTION
 */
package database_project;
import java.sql.*;
/**
 *
 * @author VICTOR NESTOR
 */
public class Database_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";
      
      try {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to StudentDB created.");
         
         // Close the connection.
         conn.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex) {
         System.out.println("ERROR: " + ex.getMessage());
      } 
    }
    
}
