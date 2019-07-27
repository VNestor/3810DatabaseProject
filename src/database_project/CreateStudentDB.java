/*
 * THIS FILE CREATE THE DATABASES; STUDENTS, DEPARTMENT, SCHOOLS
 */
package database_project;
import java.sql.*;
/**
 *
 * @author VICTOR NESTOR
 */
public class CreateStudentDB {
     public static void main(String[] args) {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";
      
      try {
         // Create a connection to the database.
         Connection conn =
                DriverManager.getConnection(DB_URL);
                
         // If the DB already exists, drop the tables.
         dropTables(conn);
         
         // Build the Student table.
         buildStudentTable(conn);
         
         // Build the Schools table.
         buildSchoolsTable(conn);
         
         // Build the Majors table.
         buildDepartmentTable(conn);

         // Close the connection.
         conn.close();
      }
      catch (Exception ex) {
         System.out.println("ERROR: " + ex.getMessage());
      }
  }
   
   /**
    * The dropTables method drops any existing
    * in case the database already exists.
    */
   public static void dropTables(Connection conn) {
      System.out.println("Checking for existing tables.");
      
     try {
         // Get a Statement object.
         Statement stmt  = conn.createStatement();;

         try {
            // Drop the Students table.
            stmt.execute("DROP TABLE Students");
            System.out.println("Students table dropped.");
         }
         catch(SQLException ex) {
            // No need to report an error.
            // The table simply did not exist.
         }

         try {
           // Drop the Schools table.
            stmt.execute("DROP TABLE Schools");
            System.out.println("Schools table dropped.");           
         }
         catch(SQLException ex) {
            // No need to report an error.
            // The table simply did not exist.
         }

         try {
            // Drop the Department table.
            stmt.execute("DROP TABLE Department");
            System.out.println("Department table dropped.");
         }
         catch(SQLException ex) {
            // No need to report an error.
            // The table simply did not exist.
         }
      }
      catch(SQLException ex) {
         System.out.println("ERROR: " + ex.getMessage());
         ex.printStackTrace();
      }
   }
   
   /**
    * The buildCoffeeTable method creates the
    * Coffee table and adds some rows to it.
    */
   public static void buildStudentTable(Connection conn) {
      try {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create the table.
         stmt.execute("CREATE TABLE STUDENTS(" +
                      "EMPLID INT NOT NULL PRIMARY KEY, " +
                      "NAME VARCHAR(50), " +
                      "DEPTNO INT, " +
                      "TRANSFER INT, " +
                      "STATUS VARCHAR(30), " +
                      "CREDITS INT, " +
                      "GPA DOUBLE)");
                      
         // Insert row #1.
         stmt.execute("INSERT INTO STUDENTS VALUES ( " +
                      "975262, " +
                      "'JENN SMITH', " +
                      "101, " +
                      "NULL, " +
                      "'JUNIOR', " +
                      "80, " +
                      "2.9)");

         // Insert row #2.
         stmt.execute("INSERT INTO STUDENTS VALUES ( " +
                      "836198, " +
                      "'ALEX WALKER', " +
                      "104, " +
                      "1400, " +
                      "'JUNIOR', " +
                      "76, " +
                      "3.7)");

         // Insert row #3.
         stmt.execute("INSERT INTO STUDENTS VALUES ( " +
                      "524771, " +
                      "'JAMES DOE', " +
                      "104, " +
                      "1417, " +
                      "'SOPHOMORE', " +
                      "45, " +
                      "3.2)");

         // Insert row #4.
         stmt.execute("INSERT INTO STUDENTS VALUES ( " +
                      "317182, " +
                      "'MICHAEL BLUE', " +
                      "102, " +
                      "1411, " +
                      "'SENIOR', " +
                      "110, " +
                      "3.2)");

         // Insert row #5.
         stmt.execute("INSERT INTO STUDENTS VALUES ( " +
                      "216521, " +
                      "'EMILY WRIGHT', " +
                      "105, " +
                      "NULL, " +
                      "'FRESHMAN', " +
                      "18, " +
                      "3.9)");
            
         System.out.println("STUDENT table created.");
      }
      catch (SQLException ex) {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /**
    * The buildCustomerTable method creates the
    * Customer table and adds some rows to it.
    */
   public static void buildDepartmentTable(Connection conn) {
      try {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create the table.
         stmt.execute("CREATE TABLE DEPARTMENT(" +
            "  DEPTNO INT NOT NULL PRIMARY KEY, " +
            "  MAJOR VARCHAR(50),"    +
            "  DEGREE VARCHAR(50))");

         // Add some rows to the new table.
         stmt.executeUpdate("INSERT INTO DEPARTMENT VALUES(" +
               "101, " + 
               "'UNDECIDED', " +
               "'UNDECIDED' )");
         
         stmt.executeUpdate("INSERT INTO DEPARTMENT VALUES(" +
               "102, " + 
               "'COMPUTER SCIENCE', " +
               "'BACHELOR OF SCIENCE' )");

         stmt.executeUpdate("INSERT INTO DEPARTMENT VALUES(" +
               "103, " + 
               "'BIOLOGY', " +
               "'BACHELOR OF SCIENCE' )");
         
         stmt.executeUpdate("INSERT INTO DEPARTMENT VALUES(" +
               "104, " + 
               "'MATHEMATICS', " +
               "'BACHELOR OF ARTS' )");
         
         stmt.executeUpdate("INSERT INTO DEPARTMENT VALUES(" +
               "105, " + 
               "'MATHEMATICS', " +
               "'BACHELOR OF SCIENCE' )");
               
         System.out.println("DEPARTMENT table created.");
      }
     catch (SQLException ex) {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /**
   * The buildUnpaidOrderTable method creates
    * the UnpaidOrder table.
    */

   public static void buildSchoolsTable(Connection conn) {
      try {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create the table.
         stmt.execute("CREATE TABLE SCHOOLS( " +
            "  SCODE INT NOT NULL PRIMARY KEY, "+
            "  SNAME VARCHAR(50),"+
            "  SADDRESS VARCHAR(75))");
        
         //ADD SCHOOLS 
         stmt.executeUpdate("INSERT INTO SCHOOLS VALUES(" +
               "1400, " + 
               "'BRONX COMMUNITY COLLEGE', " +
               "'2155 University Ave')");
         
         stmt.executeUpdate("INSERT INTO SCHOOLS VALUES(" +
               "1410, " + 
               "'BROOKLYN COLLEGE', " +
               "'2900 Bedford Avenue')");
         
         stmt.executeUpdate("INSERT INTO SCHOOLS VALUES(" +
               "1411, " + 
               "'CITY COLLEGE', " +
               "'160 Convent Ave')");
         
         stmt.executeUpdate("INSERT INTO SCHOOLS VALUES(" +
               "1417, " + 
               "'COLLEGE OF STATEN ISLAND', " +
               "'2800 Victory Blvd')");
            
         System.out.println("SCHOOLS table created.");
      }
      catch (SQLException ex) {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
    
}
