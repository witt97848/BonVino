package Entrega1.controlador;

import Entrega1.interfaz.InterfazExcel;
import Entrega1.interfaz.PantallaGenerarReporteDeRankingDeVinos;

public class GestorDeGeneracionDeReporte {
    public PantallaGenerarReporteDeRankingDeVinos pantalla;
    public InterfazExcel interfazExcel;
    private String fechaDesde, fechaHasta;

    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla, InterfazExcel interfazExcel){
        this.pantalla = pantalla;
        this.interfazExcel = interfazExcel;
    }

    public void generarRankingDeVino(){

        pantalla.solicitarFechaDesdeYFechaHasta(); // Mensaje 4 del DS
        // TODO pantalla.solicitarTipoDeReseña();
        // TODO solicitarFormatoVisualizacion();
        // TODO solicitarConfirmacion();
        // TODO 
        // this.pantalla.habilitarPantalla();
        // Code to generate the ranking
        interfazExcel.exportarExcel();
    }

    public void fechaDesdeFechaHasta(String fechaDesde, String fechaHasta){
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }
}
