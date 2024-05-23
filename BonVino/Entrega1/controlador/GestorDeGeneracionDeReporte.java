package Entrega1.controlador;

import Entrega1.interfaz.InterfazExcel;
import Entrega1.interfaz.PantallaGenerarReporteDeRankingDeVinos;
import Entrega1.modelo.Vino;

public class GestorDeGeneracionDeReporte {
    public PantallaGenerarReporteDeRankingDeVinos pantalla;
    public InterfazExcel interfazExcel;
    private String fechaDesde, fechaHasta, seleccionTipoReseñas, seleccionFormatoVisualizacion, formatoVisualizacion;

    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla){
        this.pantalla = pantalla;
        this.interfazExcel = new InterfazExcel();
    }
    
    public void generarRankingDeVino(){
        pantalla.solicitarFechaDesdeYFechaHasta(); // Mensaje 4 del DS
    };
        
    public void fechaDesdeFechaHasta(String fechaDesde, String fechaHasta){
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        pantalla.solicitarTipoDeReseña();
    }

    // TODO cambiar en el diagrama el nombre de tomarSeleccionSommelier por tomarTipoReseñaSeleccionada()
    public void tomarTipoReseñaSeleccionada(String seleccion){
        this.seleccionTipoReseñas = seleccion;
        pantalla.solicitarFormatoVisualizacion();
    }

    public void tomarSeleccionFormato(String seleccion){
        this.formatoVisualizacion = seleccion;
        pantalla.solicitarConfirmacion();
    }

    public void tomarConfirmacion(){
        // TODO
    }

    public Vino[] buscarVinosConReseñaSolicitada(){
        // TODO
        return null;
    }

    public void generarArchivo(){
        // TODO
    }

    public Vino[] ordenarVinosSegunCalificacion(){
        // TODO
        return null;
    }

    public void finCU(){
        // TODO
    }
}
