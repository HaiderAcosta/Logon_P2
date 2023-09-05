package Clases;

import com.mycompany.logon_p2.FormMenuPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 * @author PC
 */
public class CLogin {
    private int intentos; // Declarar la variable intentos como una variable de instancia
    int w =0;
    public int validarUsuario(JTextField usuario, JPasswordField Contraseña) {

        try {
            ResultSet rs = null;
            PreparedStatement ps = null;

            Clases.Cconexion objetoConexion = new Clases.Cconexion();
            String consulta = " select * from Usuarios where Usuarios.ingresoUsuario =(?) and Usuarios.ingresoContraseña= (?);";
            ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            String contra = String.valueOf(Contraseña.getPassword());

            ps.setString(1, usuario.getText());
            ps.setString(2, contra);

            rs = ps.executeQuery();
            //do {
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El usuario es Correcto");
                FormMenuPrincipal objetoMenu = new FormMenuPrincipal();
                objetoMenu.setVisible(true);
            } else if (intentos == 3) {
                JOptionPane.showMessageDialog(null, "Haz Exedido el numero de intentos");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Error, el Usuario y contrasela es INCORRECTO, Intente nuevamente \n quedan "
                                + (3 - intentos) + " intentos ");
                intentos++; // Incrementar la variable intentos en 1
            }
            //} while (intentos <2);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error :" + e.toString());
        }
        return 0;

    }
}
