package Entrega1.interfaz;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Entrega1.controlador.GestorDeGeneracionDeReporte;

public class PantallaGenerarReporteDeRankingDeVinos {
    private GestorDeGeneracionDeReporte gestor;
    private InterfazExcel interfazExcel;
    private JFrame frame;
    private JTextField inputFechaDesde;
    private JTextField inputFechaHasta;
    private JButton btnTomarFechaDesdeFechaHasta;
    
    public PantallaGenerarReporteDeRankingDeVinos(){
        this.interfazExcel = new InterfazExcel();
        this.gestor = new GestorDeGeneracionDeReporte(this, interfazExcel);
    }

    public void habilitarPantalla(){
        frame = new JFrame("Generar Ranking de Vinos");
        frame.setLayout(null);
        frame.setBounds(0,0,1000,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new java.awt.Color(20,20,20));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        inputFechaDesde = new JTextField();
        inputFechaDesde.setBounds(100, 50, 100, 20);
        inputFechaDesde.setBackground(new Color(240,240,240));

        inputFechaHasta = new JTextField(10);
        inputFechaHasta.setBounds(100, 150, 100, 20);
        inputFechaHasta.setBackground(new Color(240,240,240));

        btnTomarFechaDesdeFechaHasta = new JButton("Tomar fechas");
        btnTomarFechaDesdeFechaHasta.setBounds(100, 250, 100, 20);
        btnTomarFechaDesdeFechaHasta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tomarFechaDesdeFechaHasta();
            }
        });
        

        System.out.println("Pantalla habilitada");
        frame.setVisible(true);
    }
    
    public void opcionGenerarRankingDeVino(){
        habilitarPantalla();
        System.out.println("Generando ranking de vinos...");
        gestor.generarRankingDeVino();
    }

    public void solicitarFechaDesdeYFechaHasta(){
        frame.add(inputFechaDesde);
        frame.add(inputFechaHasta);
        frame.add(btnTomarFechaDesdeFechaHasta);
        System.out.println("Solicitando fechas...");

    }

    public void tomarFechaDesdeFechaHasta(){
        String fechaDesde = inputFechaDesde.getText();
        String fechaHasta = inputFechaHasta.getText();

        if (validarFechas(fechaDesde, fechaHasta)){
            System.out.println("Fechas válidas");
        } else {
            System.out.println("Fechas inválidas");
        }
    }

    private boolean validarFechas(String fechaDesdeStr, String fechaHastaStr){
        // Definir el formato de la fecha

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Convertir las cadenas de fecha en LocalDate
        LocalDate fechaDesde = LocalDate.parse(fechaDesdeStr, formatter);
        LocalDate fechaHasta = LocalDate.parse(fechaHastaStr, formatter);

        // Validar que fechaDesde no sea mayor que fechaHasta
        if (fechaDesde.isAfter(fechaHasta)) {
            return false;
        } else {
            return true;
        }
    }
}