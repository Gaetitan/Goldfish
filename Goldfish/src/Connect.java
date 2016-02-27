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
      
    } catch (Exception e) {
      e.printStackTrace();
    }  
    System.out.println("\n... Statement finish");
  }
}