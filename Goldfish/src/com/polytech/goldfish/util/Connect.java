package com.polytech.goldfish.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//CTRL + SHIFT + O pour générer les imports
public class Connect {
  public static void main(String[] args) {      
    try {
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver O.K.");
      String url = "jdbc:postgresql://ec2-107-20-153-141.compute-1.amazonaws.com:5432/deo26s6g50b66u?sslmode=require";
      String user = "neuakxuifmnrfv";
      String passwd = "tlK7w4GuufFaIzOyvaoTmu8KkK";
      
      System.out.println("Connexion sur: ");
      System.out.println("**USER = " +user);
      System.out.println("**PassWord = " +passwd);
      System.out.println("**URL = " +url);
      Connection conn = DriverManager.getConnection(url, user, passwd);
      System.out.println("\nConnexion effective !");
      
    //STEP 4: Execute a query
      java.sql.Statement stmt = null;
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql = "SELECT * FROM ticks";
      ResultSet rs = stmt.executeQuery(sql);
      ResultSetMetaData resultMeta = rs.getMetaData();
      
    //STEP 5: Extract data from result set
      System.out.println("\n************************************************************************************************************************************************************************************");
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
          System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
      System.out.println("\n************************************************************************************************************************************************************************************");
      
      
      while(rs.next()){
         //Retrieve by column name
         /*String id_user  = rs.getString("iduser");
         String email_user  = rs.getString("email");
         String passWord_user  = rs.getString("password");
         //Display values
         System.out.print("ID: " + id_user +"\n");
         System.out.print("EMAIL: " + email_user +"\n");
         System.out.print("PASSWORD: " + passWord_user +"\n");*/
    	  
    	  for(int i = 1; i <= resultMeta.getColumnCount(); i++)
              System.out.print("\t" + rs.getObject(i).toString() + "\t |");
                
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      }
      rs.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }  
    System.out.println("\n... Statement finish");
  }
}