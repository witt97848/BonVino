package Entrega1.modelo;

import java.util.ArrayList;

public class Provincia{
    private String nombre;
    private ArrayList<RegionVitivinicola> regiones;
    
    public Provincia(String nombre, ArrayList<RegionVitivinicola> regiones){
        this.nombre = nombre;
        this.regiones = regiones;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<RegionVitivinicola> getRegiones(){
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

    public Pais conocerPais(ArrayList<Pais> paises){
        for (Pais cadaPais : paises) {
            if(cadaPais.esTuProvincia(this)){
                return cadaPais;
            }
        }
        return null;
    }

    public String toString(){
        return "Nombre: " + nombre;
    }
}