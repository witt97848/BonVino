package Entrega1.modelo;

public class RegionVitivinicola{
    private String nombre;
    private String descripcion;
    
    public RegionVitivinicola(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public Pais conocerPais(){
        return null;
    }
}