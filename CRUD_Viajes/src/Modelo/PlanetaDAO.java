package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanetaDAO
{
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List mostrar()
    {
        List<Planeta>datos = new ArrayList<>();
        String sql= "SELECT * FROM planeta";
        try
        {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs =  ps.executeQuery();
            
            while(rs.next())
            {
                Planeta planeta = new Planeta();
                planeta.setCod_planeta(rs.getInt(1));
                planeta.setNombre(rs.getString(2));
                planeta.setPoblacion(rs.getInt(3));
                planeta.setNivel_oxigeno(rs.getDouble(4));
                planeta.setHabitable(rs.getInt(5));
                datos.add(planeta);
            }
        }
        catch(Exception e)
        {
                    
        }
        
        return datos;
    }
    
    public int crear(Planeta planeta)
    {   
        int r = 0;
        
        String sql = "INSERT INTO planeta(nombre, poblacion, nivel_oxigeno, habitable) VALUES (?,?,?,?)";
        
        try
        {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, planeta.getNombre());
            ps.setInt(2, planeta.getPoblacion());
            ps.setDouble(3, planeta.getNivel_oxigeno());
            ps.setInt(4, planeta.getHabitable());
            r = ps.executeUpdate();
            
            if(r == 1)
            {
                r = 1;
            }
            else
            {
                r = 0;
            }
        }
        catch(Exception e)
        {
            
        }
        System.out.println("crearDAO: "+r);
        return r;
    }
    
    public int actualizar(Planeta planeta)
    {
        int r = 0;
        
        String sql = "UPDATE planeta SET nombre = ?, poblacion = ?, nivel_oxigeno = ?, habitable = ? WHERE nombre = ?";
        
        try
        {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, planeta.getNombre());
            ps.setInt(2, planeta.getPoblacion());
            ps.setDouble(3, planeta.getNivel_oxigeno());
            ps.setInt(4, planeta.getHabitable());
            ps.setString(5, planeta.getNombre());
            r = ps.executeUpdate();
            
            if(r == 1)
            {
                r = 1;
            }
            else
            {
                r = 0;
            }
        }
        catch(Exception e)
        {
            
        }
        System.out.println("actualizarDAO: "+r);
        return r;
    }
    
    public int eliminar(int cod_planeta)
    {
        int r = 0;
        
        String sql = "DELETE FROM planeta WHERE cod_planeta = ?";
        
        try
        {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod_planeta);
            r = ps.executeUpdate();
            
            if(r == 1)
            {
                r = 1;
            }
            else
            {
                r = 0;
            }
        }
        catch(Exception e)
        {
            
        }
        System.out.println("borrarDAO: "+r);
        return r;
    }
}