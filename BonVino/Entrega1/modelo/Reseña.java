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
    
    public boolean esPremium() {
        return esPremium;
    }
    
    public Vino getVino() {
        return vino;
    }
    
    public boolean sosDeEnofilo() {
        // TODO: Implementar lógica para determinar si el autor de la reseña es un enófilo
        return false;
    }
    
    public boolean sosDeSommelier() {
        // TODO: Implementar lógica para determinar si el autor de la reseña es un sommelier
        return false;
    }
}