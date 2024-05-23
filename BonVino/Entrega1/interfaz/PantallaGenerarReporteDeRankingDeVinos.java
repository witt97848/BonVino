package Entrega1.interfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Entrega1.controlador.GestorDeGeneracionDeReporte;

public class PantallaGenerarReporteDeRankingDeVinos {
    private GestorDeGeneracionDeReporte gestor;
    private InterfazExcel interfazExcel;
    private JFrame frame;
    private JLabel labelFechaDesde, labelFechaHasta, labelImagenLogo;
    private JTextField inputFechaDesde, inputFechaHasta;
    private JButton btnTomarFechaDesdeFechaHasta;
    private ImageIcon imagenLogo;
    
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon(getClass().getResource("../images/LogoPPAI.png")).getImage());

        // Imagenes ____________________________________________________________
        ImageIcon imagenLogo = new ImageIcon(getClass().getResource("../images/LogoPPAI.png"));
		labelImagenLogo = new JLabel(imagenLogo);
		labelImagenLogo.setBounds(50,50,150,150);

        // TextFields___________________________________________________________
        inputFechaDesde = new JTextField();
        inputFechaDesde.setBounds(250, 100, 160, 45);
        inputFechaDesde.setBackground(new Color(240,240,240));
        inputFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        
        inputFechaHasta = new JTextField(10);
        inputFechaHasta.setBounds(430, 100, 160, 45);
        inputFechaHasta.setBackground(new Color(240,240,240));
        inputFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

        // Labels ______________________________________________________________
        labelFechaDesde = new JLabel("Fecha desde: [dd/mm/yyyy]");
        labelFechaDesde.setBounds(250, 70, 160, 20);
        labelFechaDesde.setForeground(Color.WHITE);
        
        labelFechaHasta = new JLabel("Fecha hasta: [dd/mm/yyyy]");
        labelFechaHasta.setBounds(430, 70, 160, 20);
        labelFechaHasta.setForeground(Color.WHITE);


        // Buttons _____________________________________________________________
        btnTomarFechaDesdeFechaHasta = new JButton("Tomar fechas");
        btnTomarFechaDesdeFechaHasta.setBounds(620, 100, 150, 45);
        btnTomarFechaDesdeFechaHasta.setBackground(new Color(102, 66, 138));
        btnTomarFechaDesdeFechaHasta.setForeground(Color.WHITE);
        btnTomarFechaDesdeFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        
        // Evento del botón para tomar las fechas
        btnTomarFechaDesdeFechaHasta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // __________________________________________ Mensaje 5 del DS
                String[] fechas = tomarFechaDesdeFechaHasta();
                try{
                    // ______________________________________ Mensaje 6 del DS 
                    if (validarFechas(fechas[0], fechas[1])){
                        System.out.println("Fechas válidas");

                        // _______________________________________________ Mensaje 7 del DS 
                        gestor.fechaDesdeFechaHasta(fechas[0], fechas[1]); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Fechas invalidas.");
                        System.out.println("Fechas inválidas");
                    }
                } catch (Exception error){
                    JOptionPane.showMessageDialog(null, "Formato de fecha invalida. [dd/mm/yyyy]");
                    System.out.println("Formato de fecha invalida. [dd/mm/yyyy]");
                }
            }
        });

        System.out.println("Pantalla habilitada");
        frame.setVisible(true);
    }
    
    public void opcionGenerarRankingDeVino(){
        // _________________ Mensaje 2 del DS 
        habilitarPantalla();
        System.out.println("Generando ranking de vinos...");
        // ___________________________ Mensaje 3 del DS
        gestor.generarRankingDeVino();
    }

    public void solicitarFechaDesdeYFechaHasta(){
        frame.add(inputFechaDesde);
        frame.add(inputFechaHasta);
        frame.add(btnTomarFechaDesdeFechaHasta);
        frame.add(labelFechaDesde);
        frame.add(labelFechaHasta);
        frame.add(labelImagenLogo);

        System.out.println("Solicitando fechas...");
    }

    public String[] tomarFechaDesdeFechaHasta(){
        String[] fechas = new String[2];
        fechas[0] = inputFechaDesde.getText();
        fechas[1] = inputFechaHasta.getText();
        return fechas;
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