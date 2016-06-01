/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author agomezcastro
 */
public class Metodos {
    private Connection conexion;
    private Statement st;
    
    /** Metodo para conectar
     * la base de datos
     * @return
     * @throws ClassNotFoundException 
     */
    public Connection conectar() throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conexion=(Connection) DriverManager.getConnection("jdbc:mysql://10.0.0.254/agomezcastro/agomezcastro", "agomezcastro", "agomezcastro");
            JOptionPane.showMessageDialog(null, "Conectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return conexion;
    }
    
    /** Metodo para insertar valores en una tabla creada
     * en la base de datos
     * @param tabla
     * @param valores
     * @return
     * @throws SQLException 
     */
    public int insertar(String tabla, String[] valores) throws SQLException {

        String consulta = "insert into " + tabla + " values(";
        for (int i = 0; i < valores.length; i++) {
            if (i < valores.length-1) {
                consulta = "'" + valores[i] + "',";
            } else {
                consulta = "'" + valores[i] + "'";
            }
        }
        consulta += ");";

        st = conexion.createStatement();
        return st.executeUpdate(consulta);
    }
     
     /** Metodo para consultar la base de datos
      * 
      * @param tabla
      * @param campos
      * @return
      * @throws SQLException 
      */
     public ResultSet consultarDatos(String tabla, String[] campos) throws SQLException {
        ResultSet rs;
        String consulta = "select ";
        st = conexion.createStatement();
        for (int i = 0; i < campos.length; i++) {
            if (i == campos.length - 1) {
                consulta += campos[i] + " from " + tabla + " ;";
            } else {
                consulta += campos[i] + ",";
            }
        }
        rs = st.executeQuery(consulta);
        return rs;
    }
     
     /** Metodo para eliminar valores
      * en la base de datos
      * @param tabla
      * @param primaryKeyCol
      * @param primaryKeyVal
      * @return
      * @throws SQLException 
      */
     public int eliminar(String tabla, String primaryKeyCol, String primaryKeyVal) throws SQLException {
        st = conexion.createStatement();
        int n= st.executeUpdate("delete from " + tabla + " where " + primaryKeyCol + "=" + "'" + primaryKeyVal + "';");
        return n;
     }
     
     /** Metodo para cerra la conexion
     * de la base de datos
     * @throws SQLException 
     */
     public void cerrarConexion() throws SQLException {
        st.close();
        conexion.close();
        JOptionPane.showMessageDialog(null, "Conexion cerrada");
     }
}
