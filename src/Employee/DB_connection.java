/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Meth
 */
public class DB_connection {
    String sourceURL;
    Connection dbConn = null;
    public DB_connection()
    {         
        try {             // Load JDBC driver             
            Class.forName("com.mysql.jdbc.Driver");  
            // Connection URL.
            String sourceURL = "jdbc:mysql://localhost:3306/lodhi";  
        } 
        catch (ClassNotFoundException classNotFoundException) 
        {             System.out.println(classNotFoundException + "-----------Unable to load database driver classes");     
        } 
    } 
    
    public Connection connect()
    {       
        Connection dbConn = null;  
        try 
        {             dbConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lodhi", "root", "1234");        
        } 
        catch (SQLException sQLException) 
       {   JOptionPane.showMessageDialog(null, "dartabase not connected");          
           System.out.println(sQLException + "-----------DB connection failure");        
       }        
       return dbConn;  
   } 
    
  public void con_close(Connection dbConn) 
  {         
      try 
      {             
          dbConn.close();
      }        
   
     catch (SQLException sQLException)
     
    { 
        System.out.println(sQLException + "-----------DB connection closing failure"); 
    } 
    
  }  
}
