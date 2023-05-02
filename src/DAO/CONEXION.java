/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
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
public class CONEXION {
    
    Connection conectar = null;
    
    String usuario = "root";
    String contraseña = "Barricade98";
    String bd = "bdcrud_users";
    String ip = "localhost";
    String puerto = "3306";

    String cadena ="jdbc:mysql://localhost:3306/bdcrud_users";
    
    public Connection estableceConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contraseña);
            JOptionPane.showMessageDialog(null, "Conexion realizada con exito");
        
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,"Error al conectarse a la BD"+ e.toString());
        }
        return conectar;
    }
    
}
