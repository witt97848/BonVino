package Entrega1.clases;
import javax.swing.JFrame;

public class PantallaGenerarReporteDeRankingDeVinos {
    private GestorDeGeneracionDeReporte gestor;
    private JFrame frame;

    public PantallaGenerarReporteDeRankingDeVinos(GestorDeGeneracionDeReporte gestor){
        this.gestor = gestor;
    }

    public void habilitarPantalla(){
        frame.setBounds(0,0,1000,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public void opcionGenerarRankingDeVino(){
        gestor.generarRankingDeVino();
    }
}