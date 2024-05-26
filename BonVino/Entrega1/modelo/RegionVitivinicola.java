package Entrega1.modelo;

import java.util.ArrayList;

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

    public Pais conocerPais(ArrayList<Pais> paises, ArrayList<Provincia> provincias){
        Provincia provincia = conocerProvincia(provincias);
        return provincia.conocerPais(paises);

    }

    public Provincia conocerProvincia(ArrayList<Provincia> provincias){
        for (Provincia cadaProvincia : provincias) {
            if(cadaProvincia.esTuRegion(this)){
                return cadaProvincia;
            }
        }
        return null;
    }

    public String toString(){
        return "Nombre: " + nombre + " Descripcion: " + descripcion;
    }
}