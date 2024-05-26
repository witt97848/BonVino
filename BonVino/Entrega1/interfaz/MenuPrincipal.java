package Entrega1.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPrincipal{
    private JFrame frame;
    private JButton botonGenerarReporte;
    private JButton botonOtraFuncionalidad1;
    private JButton botonOtraFuncionalidad2;
    private PantallaGenerarReporteDeRankingDeVinos pantallaRankingDeVinos;

    public MenuPrincipal(){
        frame = new JFrame("Menu Principal");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon(getClass().getResource("../images/LogoPPAI.png")).getImage());

        botonGenerarReporte = new JButton("Generar Reporte de Ranking de vinos");
        botonGenerarReporte.setBounds(100, 50, 500, 50);
        botonGenerarReporte.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Mensaje de opcionGenerarRankingDeVino();
                // (Primer mensaje que se ve en el diagrama de secuencia del CU24)
                pantallaRankingDeVinos = new PantallaGenerarReporteDeRankingDeVinos();
                pantallaRankingDeVinos.opcionGenerarRankingDeVino();
            }
        });
        frame.add(botonGenerarReporte);

        botonOtraFuncionalidad1 = new JButton("Otra funcionalidad 1");
        botonOtraFuncionalidad1.setBounds(100, 150, 500, 50);
        frame.add(botonOtraFuncionalidad1);
        botonOtraFuncionalidad2 = new JButton("Otra funcionalidad 2");
        botonOtraFuncionalidad2.setBounds(100, 250, 500, 50);
        frame.add(botonOtraFuncionalidad2);

    }

    public void habilitarPantalla(){
        frame.setBounds(0,0,1000,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public static void main(String[] args){
        MenuPrincipal menu = new MenuPrincipal();
        
        // Mensaje 1 del DS ____________________________________________________
        menu.habilitarPantalla();
    }
}