package Entrega1.modelo;

public class Pais {
    private String nombre;
    private Provincia[] provincias;
    public Pais(String nombre, Provincia[] provincias){
        this.nombre = nombre;
        this.provincias = provincias;
    }

    public String getNombre(){
        return nombre;
    }
    
    public Provincia[] getProvincias(){
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