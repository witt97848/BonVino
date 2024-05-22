package Entrega1.controlador;

import Entrega1.interfaz.InterfazExcel;
import Entrega1.interfaz.PantallaGenerarReporteDeRankingDeVinos;

public class GestorDeGeneracionDeReporte {
    public PantallaGenerarReporteDeRankingDeVinos pantalla;
    public InterfazExcel interfazExcel;

    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla, InterfazExcel interfazExcel){
        this.pantalla = pantalla;
        this.interfazExcel = interfazExcel;
    }

    public void generarRankingDeVino(){
        pantalla.solicitarFechaDesdeYFechaHasta();
        // Code to generate the ranking
        this.interfazExcel.exportarExcel();
    }
}
