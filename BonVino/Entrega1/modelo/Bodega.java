package Entrega1.modelo;


public class Bodega {
    private String descripcion;
    private String nombre;
    private RegionVitivinicola region;
    
    public Bodega(String descripcion, String nombre, RegionVitivinicola region){
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.region = region;
    }
    
    public String getDescripcion(){
        return descripcion;
    }

    public String getNombre(){
        return nombre;
    }

    public RegionVitivinicola getRegion(){
        return region;
    }
    public String toString(){
        return "Nombre: " + nombre + " Descripcion: " + descripcion;
    }
}