package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
    String user = "root";
    String password = "cris10013321462506";
    String url = "jdbc:mysql://localhost:3306/bitacora_viajes";
    Connection con;
    
    public Connection getConexion()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conecte con la Base de Datos");
        } 
        catch(Exception e)
        {
            System.err.println(e);
        } 

        return con;
    }
}
