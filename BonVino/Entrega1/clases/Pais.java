package Entrega1.clases;

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
}