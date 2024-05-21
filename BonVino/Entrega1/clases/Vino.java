package Entrega1.clases;


public class Vino {
    private int añada;
    private String nombre;
    private double notaDeCataBodeta;
    private double precioARS;
    private Reseña[] reseñas;
    private Bodega bodega;

    public Vino(int añada, String nombre, double notaDeCataBodeta, double precioARS, Reseña[] reseñas, Bodega bodega){
        this.añada = añada;
        this.nombre = nombre;
        this.notaDeCataBodeta = notaDeCataBodeta;
        this.precioARS = precioARS;
        this.reseñas = reseñas;
        this.bodega = bodega;
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
    public Reseña[] getReseñas(){
        return reseñas;
    }
    public Bodega getBodega(){
        return bodega;
    }
}