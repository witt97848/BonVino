package Entrega1.clases;

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
}