package Entrega1.modelo;

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
    
    public boolean esTuRegion(RegionVitivinicola region){
        for (RegionVitivinicola cadaRegion : regiones) {
            if(cadaRegion == region){
                return true;
            }
        }
        return false;
    }
    
}