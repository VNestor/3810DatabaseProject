/*
 * THIS FILE RUNS SQL QUERYS RETURNING THE QUERY SENT AND THE OUTPUT
 */
package database_project;
import java.sql.*;
import java.util.*;

/**
 *
 * @author VICTOR NESTOR
 */
public class SQLCommands {
    public static void main(String[] args){
        

      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";
      
      //creat scanner object 
      Scanner keyboard = new Scanner(System.in);
      
      try {
          Connection conn = DriverManager.getConnection(DB_URL);
          
          //Create a statement object
          Statement stmt = conn.createStatement();
          
          String sqlStatement = "SELECT NAME, GPA FROM STUDENTS ORDER BY GPA";
          System.out.println("QUERY: " + sqlStatement);
          System.out.println("-----------------------------");
          ResultSet result = stmt.executeQuery(sqlStatement);
          
          //Display the contents of result set
          while (result.next()) {
              System.out.printf("%25s %.2f\n",
                                result.getString("NAME"),
                                result.getDouble("GPA"));
          }
      }
      catch (Exception ex) {
          System.out.println("ERROR: " + ex.getMessage());
         
      }
      
      System.out.println("\n" + "------------------------------" + "\n");
      
      try {
          Connection conn = DriverManager.getConnection(DB_URL);
          
          //Create a statement object
          Statement stmt = conn.createStatement();
          
          String sqlStatement = "SELECT EMPLID, NAME, CREDITS, STATUS FROM STUDENTS "
                              + "ORDER BY NAME";
          System.out.println("QUERY: " + sqlStatement);
          System.out.println("-----------------------------");
          ResultSet result = stmt.executeQuery(sqlStatement);
          
          //Display the contents of result set
          while (result.next()) {
              System.out.printf("%15s %15s %15s %15s\n",
                                result.getInt("EMPLID"),                               
                                result.getString("NAME"),
                                result.getInt("CREDITS"),
                                result.getString("STATUS"));
          }
      }
      catch (Exception ex) {
          System.out.println("ERROR: " + ex.getMessage());
         
      }
      
      System.out.println("\n" + "------------------------------" + "\n");
      
      try {
          Connection conn = DriverManager.getConnection(DB_URL);
          
          //Create a statement object
          Statement stmt = conn.createStatement();
          
          String sqlStatement = "SELECT STUDENTS.EMPLID, STUDENTS.NAME, "
                  + "DEPARTMENT.MAJOR, DEPARTMENT.DEGREE "
                  + "FROM STUDENTS JOIN DEPARTMENT ON "
                  + "(STUDENTS.DEPTNO=DEPARTMENT.DEPTNO)"
                  + "ORDER BY EMPLID";
          System.out.println("QUERY: " + sqlStatement);
          System.out.println("-----------------------------");
          ResultSet result = stmt.executeQuery(sqlStatement);
          
          //Display the contents of result set
          while (result.next()) {
              System.out.printf("%25s %25s %25s %25s\n",
                                result.getInt("EMPLID"),
                                result.getString("NAME"),
                                result.getString("MAJOR"),
                                result.getString("DEGREE"));
          }
      }
      catch (Exception ex) {
          System.out.println("ERROR: " + ex.getMessage());
         
      }
      
      System.out.println("\n" + "------------------------------" + "\n");
      
      try {
          Connection conn = DriverManager.getConnection(DB_URL);
          
          //Create a statement object
          Statement stmt = conn.createStatement();
          
          String sqlStatement = "SELECT STUDENTS.EMPLID, STUDENTS.NAME, "
                  + "SCHOOLS.SCODE, SCHOOLS.SADDRESS "
                  + "FROM STUDENTS JOIN SCHOOLS ON "
                  + "(STUDENTS.TRANSFER=SCHOOLS.SCODE)"
                  + "ORDER BY EMPLID";
          System.out.println("QUERY: " + sqlStatement);
          System.out.println("-----------------------------");
          ResultSet result = stmt.executeQuery(sqlStatement);
          
          //Display the contents of result set
          while (result.next()) {
              System.out.printf("%25s %25s %25s %25s\n",
                                result.getInt("EMPLID"),
                                result.getString("NAME"),
                                result.getInt("SCODE"),
                                result.getString("SADDRESS"));
          }
      }
      catch (Exception ex) {
          System.out.println("ERROR: " + ex.getMessage());
         
      }
    }
}

