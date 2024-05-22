package Entrega1.modelo;
import java.util.ArrayList;

public class Pais {
    private String nombre;
    private ArrayList<Provincia> provincias;
    public Pais(String nombre, ArrayList<Provincia> provincias){
        this.nombre = nombre;
        this.provincias = provincias;
    }

    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<Provincia> getProvincias(){
        return provincias;
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