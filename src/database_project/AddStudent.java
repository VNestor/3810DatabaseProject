/*
 * THIS FILE ADDS A STUDENT TO THE DATABASE
 */
package database_project;
import java.sql.*;
import java.util.*;

/**
 *
 * @author VICTOR NESTOR
 */
public class AddStudent {
    public static void main(String[] args){
        
        int emplid;
        String name;
        int department;
        int transfer = 0;
        String status;
        int credits;
        double gpa;
       
        // Create a named constant for the URL.
        // NOTE: This value is specific for Java DB.
        final String DB_URL = "jdbc:derby://localhost:1527/StudentDB";
      
        //creat scanner object 
        Scanner keyboard = new Scanner(System.in);
        
        while(true){
          try {
              
              Connection conn = DriverManager.getConnection(DB_URL);
          
              //get data for new student
              System.out.println("ENTER STUDENT'S EMPLID: ");
              emplid = keyboard.nextInt();
              System.out.println("ENTER STUDENT'S FIRST NAME AND LAST NAME: ");
              keyboard.nextLine();
              name = keyboard.nextLine();
              System.out.println("ENTER STUDENT'S DEPARTMENT: ");
              department = keyboard.nextInt();
              System.out.println("IS " + name + " A TRANSFER STUDENT?(Y/N):");
              String checkTransfer = keyboard.next();
          
              if(checkTransfer.equals("Y") || checkTransfer.equals("Yes")){
                  System.out.println("ENTER STUDENT'S SCHOOL CODE: ");
                  transfer = keyboard.nextInt();
              
              } else if (checkTransfer.equals("N") ||checkTransfer.equals("No")){
                  transfer = 0;
              
              } else {
                  System.out.println("INVALID INPUT");
              
              }
              
              System.out.println("ENTER STUDENT'S STATUS: ");
              keyboard.nextLine();
              status = keyboard.nextLine();
              System.out.println("ENTER STUDENT'S CREDITS: ");
              credits = keyboard.nextInt();
              System.out.println("ENTER STUDENT'S GPA (X.XX): ");
              gpa = keyboard.nextDouble();

              // Create a Statement object.
              Statement stmt = conn.createStatement();
         
              // Create a string with an INSERT statement.
              String sqlStatement = "INSERT INTO STUDENTS " +
                      "(EMPLID, NAME, DEPTNO, TRANSFER, STATUS, CREDITS, GPA) " +
                      "VALUES (" + emplid + ", '" + name + "', " + department + "," + transfer + ",'" + status + "'," + credits + "," + gpa + ")";
         
              // Send the statement to the DBMS.
              int rows = stmt.executeUpdate(sqlStatement);
         
              // Display the results.
              System.out.println(rows + " row(s) added to the table.");
         
              // Close the connection.
              conn.close();
              break;
          }
          
          catch (Exception ex) {
              System.out.println("ERROR: PLEASE CHECK THAT YOU ARE ENTERING A NAME OR NUMBER IN THE CORRECT FIELD.");
              //Reset scanner
              keyboard.reset();
              //Reads any invalid input
              keyboard.nextLine();
          }
        }
        //End
        keyboard.close();
        System.out.println("Database succesfully updated!");
    }
}
    

