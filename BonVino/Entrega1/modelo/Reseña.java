package Entrega1.modelo;

import java.util.Date;

public class Reseña {
    private String comentario;
    private boolean esPremium;
    private Date fechaReseña;
    private int puntaje;
    private Vino vino;

    public Reseña(String comentario, boolean esPremium, Date fechaReseña, int puntaje, Vino vino) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.fechaReseña = fechaReseña;
        this.puntaje = puntaje;
        this.vino = vino;
    }

    public boolean sosDelPeriodo(Date fechaDesde, Date fechaHasta) {
        // Return true si la reseña fue realizada en el periodo indicado
        return fechaReseña.after(fechaDesde) && fechaReseña.before(fechaHasta);
    }

    public String getComentario() {
        return comentario;
    }
    
    public Date getFechaReseña() {
        return fechaReseña;
    }
    
    public int getPuntaje() {
        return puntaje;
    }
    
    public boolean sosPremium() {
        return esPremium;
    }
    
    public Vino getVino() {
        return vino;
    }

    public String toString() {
        return "Comentario: " + comentario + "\nPuntaje: " + puntaje + "\nFecha: " + fechaReseña.getDate() + "/" + fechaReseña.getMonth() + "/" + fechaReseña.getYear() + "\n" + (esPremium ? "Premium" : "No premium");
    }
}