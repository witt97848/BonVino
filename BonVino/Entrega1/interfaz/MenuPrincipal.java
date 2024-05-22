
package Entrega1.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Entrega1.clases.GestorDeGeneracionDeReporte;

public class MenuPrincipal implements ActionListener{
    private JFrame frame;
    private JButton botonGenerarReporte;

    public MenuPrincipal(){
        frame = new JFrame("Menu Principal");
        frame.setLayout(null);

        botonGenerarReporte = new JButton("Generar Reporte");
        botonGenerarReporte.setBounds(400, 300, 200, 50);
        botonGenerarReporte.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                GestorDeGeneracionDeReporte gestor = new GestorDeGeneracionDeReporte();
                gestor.generarReporte();
            }
        });

        frame.add(botonGenerarReporte);
    }

    public void habilitarPantalla(){
        frame.setBounds(0,0,1000,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public static void main(String[] args){
        GestorDeGeneracionDeReporte gestor = new GestorDeGeneracionDeReporte()
        MenuPrincipal menu = new MenuPrincipal(gestor);
        menu.habilitarPantalla();
    }
}