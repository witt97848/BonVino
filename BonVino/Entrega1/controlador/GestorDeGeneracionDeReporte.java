package Entrega1.clases;

import Entrega1.Interfaz.InterfazExcel;
import Entrega1.Interfaz.PantallaGenerarReporteDeRankingDeVinos;

public class GestorDeGeneracionDeReporte {
    public PantallaGenerarReporteDeRankingDeVinos pantalla;
    public InterfazExcel interfazExcel;

    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla, InterfazExcel interfazExcel){
        this.pantalla = pantalla;
        this.interfazExcel = interfazExcel;
    }

    public void generarRankingDeVino(){
        
        
        // Code to generate the ranking
        this.interfazExcel.exportarExcel();
    }
}
