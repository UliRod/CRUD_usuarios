/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
/**
 *
 * @author ulises_rod
 */
public class CONEXION_vid {
    
    
    
    public static final String URL = "jdbc:mysql://localhost:3306/nombreclientes";
     public static final String USERNAME = "root";
     public static final String PASSWORD = "Barricade98";
    private    Connection con = null;
    
     public Connection getConection(){
         
         Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            
            System.out.println(e);
        }
        return con;
     }
}
