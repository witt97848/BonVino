package Entrega1.clases;

public class Provincia{
    private String nombre;
    private RegionVitivinicola[] regiones;
    
    public Provincia(String nombre, Pais pais, RegionVitivinicola[] regiones){
        this.nombre = nombre;
        this.regiones = regiones;
    }
    public String getNombre(){
        return nombre;
    }

    public RegionVitivinicola[] getRegiones(){
        return regiones;
    }
    
}