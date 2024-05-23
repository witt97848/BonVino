package Entrega1.modelo;


public class Varietal{
    private String nombre;
    private String descripcion;
    
    public Varietal(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public boolean esTuNombre(String nombre){
        return this.nombre.equals(nombre);
    }
    
    public boolean esTuDescripcion(String descripcion){
        return this.descripcion.equals(descripcion);
    }
}