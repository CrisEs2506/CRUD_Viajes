package Modelo;

public class Planeta 
{
    //Atributos
    private int cod_planeta;
    private String nombre;
    private int poblacion;
    private double nivel_oxigeno;
    private int habitable;
    
    //Setters and Getters
    public int getCod_planeta() 
    {
        return cod_planeta;
    }

    public void setCod_planeta(int cod_planeta) 
    {
        this.cod_planeta = cod_planeta;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public int getPoblacion() 
    {
        return poblacion;
    }

    public void setPoblacion(int poblacion) 
    {
        this.poblacion = poblacion;
    }

    public double getNivel_oxigeno() 
    {
        return nivel_oxigeno;
    }

    public void setNivel_oxigeno(double nivel_oxigeno) 
    {
        this.nivel_oxigeno = nivel_oxigeno;
    }

    public int getHabitable() 
    {
        return habitable;
    }

    public void setHabitable(int habitable) 
    {
        this.habitable = habitable;
    }
}
