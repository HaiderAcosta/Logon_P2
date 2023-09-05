/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Cconexion {
  
   Connection conectar;
    
    String usuario ="root";
    String Contraseña="Jh0n.M4r.12";
    String bd = "login";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
                
                try {
                    
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conectar = DriverManager.getConnection(cadena,usuario,Contraseña);
                    JOptionPane.showMessageDialog(null, "Se conecto a la base de datos ");
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Problemas en la conexion "+e.toString());
                           }
            return conectar;    
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
    