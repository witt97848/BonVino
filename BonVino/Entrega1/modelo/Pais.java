package Entrega1.modelo;

import java.util.ArrayList;

public class Pais {
    private String nombre;
    private ArrayList<Provincia> provincias = new ArrayList<Provincia>();

    public Pais(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<Provincia> getProvincias(){
        return provincias;
    }

    public void agregarProvincia(Provincia provincia){
        provincias.add(provincia);
    }
    
    public boolean esTuProvincia(Provincia provincia){
        for (Provincia cadaProvincia : provincias) {
            if(cadaProvincia == provincia){
                return true;
            }
        }
        return false;
    }
}