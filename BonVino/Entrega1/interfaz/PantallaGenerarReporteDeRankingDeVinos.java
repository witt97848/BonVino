package Entrega1.interfaz;
import javax.swing.JFrame;

import Entrega1.controlador.GestorDeGeneracionDeReporte;

public class PantallaGenerarReporteDeRankingDeVinos {
    private GestorDeGeneracionDeReporte gestor;
    private InterfazExcel interfazExcel;
    private JFrame frame;
    
    public PantallaGenerarReporteDeRankingDeVinos(){
        this.interfazExcel = new InterfazExcel();
        this.gestor = new GestorDeGeneracionDeReporte(this, interfazExcel);
    }

    public void habilitarPantalla(){
        frame = new JFrame("Generar Ranking de Vinos");
        frame.setBounds(0,0,1000,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        System.out.println("Pantalla habilitada");
    }
    
    public void opcionGenerarRankingDeVino(){
        habilitarPantalla();
        System.out.println("Generando ranking de vinos...");
        gestor.generarRankingDeVino();
    }

    public void solicitarFechaDesdeYFechaHasta(){
        System.out.println("Solicitando fechas...");
        
    }
}