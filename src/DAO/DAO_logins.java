/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.usuarios;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ulises_rod
 */
public class DAO_logins {

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isIserror() {
        return iserror;
    }

    public void setIserror(boolean iserror) {
        this.iserror = iserror;
    }

    private String error;
    private boolean iserror;

    //metodoLimpiar//
    public void clean() {
        this.error = "";
        this.iserror = false;
    }

    public int login(String id, String password) {
        int resultado = 0;
        clean();
        try {
            Connection con = bdConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as login FROM login where id='" + id + "'and password='" + password + "';");
            rs.next();
            resultado = rs.getInt("login");
        } catch (Exception ex) {
            this.error = ex.getMessage();
            this.iserror = true;
        }
        return resultado;
    }

    public void tabla(JTable tabla_users) {
        clean();
        DefaultTableModel model = (DefaultTableModel) tabla_users.getModel();

        try {
            Connection con = bdConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM datos");

            Object row[] = new Object[6];

            while (rs.next()) {
                row[0] = rs.getString("id");
                row[1] = rs.getString("nombres");
                row[2] = rs.getString("apellido_parterno");
                row[3] = rs.getString("apellido_materno");
                row[4] = rs.getString("fecha_nacimiento");
                row[5] = rs.getString("email");

                model.addRow(row);
            }

            tabla_users.setModel(model);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "No se pudo mostrar");
            this.error = ex.getMessage();
            this.iserror = true;
        }
    }

    public int guardar(usuarios U) {
        int resultado = 0;
        clean();
        try {
            Connection con = bdConnection.getConexion();
            Statement st = con.createStatement();
            resultado = st.executeUpdate("INSERT INTO datos VALUE('" + U.getId() + "','"
                    + U.getNombre() + "','"
                    + U.getApellido_paterno() + "','"
                    + U.getApellido_materno() + "','"
                    + U.getFecha_nacimiento() + "','"
                    + U.getEmail() + "')");
        } catch (Exception ex) {
            this.error = ex.getMessage();
            this.iserror = true;

        }
        return resultado;
    }

    public int actualizar(usuarios U) {
        int resultado = 0;
        clean();
        try {
            Connection con = bdConnection.getConexion();
            Statement st = con.createStatement();
            resultado = st.executeUpdate("UPDATE datos SET id='" + U.getId()
                    + "', nombres='" + U.getNombre()
                    + "', apellido_parterno='" + U.getApellido_paterno()
                    + "', apellido_materno='" + U.getApellido_materno()
                    + "', fecha_nacimiento='" + U.getFecha_nacimiento()
                    + "', email='" + U.getEmail()
                    + "' WHERE id='" + U.getId() + "'");

        } catch (Exception ex) {
            this.error = ex.getMessage();
            this.iserror = true;

        }
        return resultado;
    }

    public int eliminar (String id){
        int resultado = 0;
        clean();
        try{ Connection con = bdConnection.getConexion();
            Statement st = con.createStatement();
             resultado = st.executeUpdate("DELETE FROM datos WHERE id='" + id + "';");
            
        }catch(Exception ex){
           
            this.error = ex.getMessage();
            this.iserror = true;

        }return resultado;
    }
    
    public void buscar (JTable busqueda, String desde, String hasta){
          clean();
        DefaultTableModel model = (DefaultTableModel) busqueda.getModel();
         try {
            Connection con = bdConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM datos WHERE fecha_nacimiento between '"+ desde +"' AND '"+ hasta +"'");

            Object row[] = new Object[6];

            while (rs.next()) {
                row[0] = rs.getString("id");
                row[1] = rs.getString("nombres");
                row[2] = rs.getString("apellido_parterno");
                row[3] = rs.getString("apellido_materno");
                row[4] = rs.getString("fecha_nacimiento");
                row[5] = rs.getString("email");

                model.addRow(row);
            }

            busqueda.setModel(model);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "No se pudo mostrar");
            this.error = ex.getMessage();
            this.iserror = true;
        }
    }
}
