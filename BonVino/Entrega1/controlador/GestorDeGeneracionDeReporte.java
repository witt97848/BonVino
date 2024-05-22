package Entrega1.clases;

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
