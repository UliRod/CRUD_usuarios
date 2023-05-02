/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAO.bdConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ulises_rod
 */
public class prueba_conex {

    public static void main(String[] args){
        try{
Connection con = bdConnection.getConexion();
        System.out.println("La conexion a la base de datos fue correcta.");
    }
    catch (SQLException ex) {
System.out.println("No se conecto por" + ex.getMessage());
    }

}
}

