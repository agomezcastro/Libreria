/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebalibreria;

import Libreria.Metodos;
import java.sql.SQLException;

/**
 *
 * @author agomezcastro
 */
public class PruebaLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Metodos con = new Metodos();
        
        con.conectar();
        con.consultarDatos(null, args);
        con.insertar(null, args);
        con.eliminar(null, null, null);
        con.cerrarConexion();
    }
    
}
