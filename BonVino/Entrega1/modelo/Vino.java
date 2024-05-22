
package Entrega1.modelo;

import java.util.ArrayList; // Import ArrayList
import java.util.Date;

public class Vino {
    private int añada;
    private String nombre;
    private double notaDeCataBodeta;
    private double precioARS;
    private ArrayList<Reseña> reseñas;
    private Bodega bodega;

    // Add a constructor to initialize all attributes
    public Vino(int añada, String nombre, double notaDeCataBodeta, double precioARS, ArrayList<Reseña> reseñas, Bodega bodega){
        this.añada = añada;
        this.nombre = nombre;
        this.notaDeCataBodeta = notaDeCataBodeta;
        this.precioARS = precioARS;
        this.reseñas = reseñas;
        this.bodega = bodega;
    }
    
    public ArrayList<Reseña> tomarReseñasDeVinoEnPeriodo(Date fechaDesde, Date fechaHasta){
        ArrayList<Reseña> arrayTemporal = new ArrayList<>(); // Change array type to ArrayList<Reseña>
        for (Reseña cadaReseña : reseñas){
            if (cadaReseña.sosDelPeriodo(fechaDesde, fechaHasta)){
                
                arrayTemporal.add(cadaReseña); // Use add() method to add each Reseña object to the arrayTemporal list

            }
        }
        return arrayTemporal;
    }

    public int getAñada(){
        return añada;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getNotaDeCataBodeta(){
        return notaDeCataBodeta;
    }
    
    public double getPrecioARS(){
        return precioARS;
    }
    
    public ArrayList<Reseña> getReseñas(){
        return reseñas;
    }
    
    public Bodega getBodega(){
        return bodega;
    }

}