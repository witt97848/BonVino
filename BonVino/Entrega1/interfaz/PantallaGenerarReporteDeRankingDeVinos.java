package Entrega1.interfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Entrega1.controlador.GestorDeGeneracionDeReporte;

public class PantallaGenerarReporteDeRankingDeVinos {
    private GestorDeGeneracionDeReporte gestor;
    private InterfazExcel interfazExcel;
    private JFrame frame;
    private JLabel labelImagenLogo, labelFechaDesde, labelFechaHasta;
    private JLabel labelTipoDeReseña;
    private JLabel labelFormatoVisualizacion;
    private JTextField inputFechaDesde, inputFechaHasta;
    private JComboBox comboBoxTipoDeReseña;
    private JComboBox comboBoxFormatoVisualizacion;
    private JButton btnTomarFechaDesdeFechaHasta;
    private ImageIcon imagenLogo;
    
    public PantallaGenerarReporteDeRankingDeVinos(){
        this.gestor = new GestorDeGeneracionDeReporte(this);
    }

    // Creamos la pantalla para generar el reporte de ranking de vinos
    public void habilitarPantalla(){
        
        // Frame _______________________________________________________________
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
        frame.add(labelImagenLogo);

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

    // Paso 2, 3, 4
    public void solicitarFechaDesdeYFechaHasta() {
        System.out.println("Comienza solicitarFechaDesdeYFechaHasta");
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
                        btnTomarFechaDesdeFechaHasta.setVisible(false);
                        inputFechaDesde.setVisible(false);
                        inputFechaHasta.setVisible(false);
                        labelFechaDesde.setVisible(false);
                        labelFechaHasta.setVisible(false);
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

        // Agregar elementos al frame
        frame.add(inputFechaDesde);
        frame.add(inputFechaHasta);
        frame.add(btnTomarFechaDesdeFechaHasta);
        frame.add(labelFechaDesde);
        frame.add(labelFechaHasta);
    }

    // 
    public void solicitarTipoDeReseña(){
        // Labels ______________________________________________________________
        labelTipoDeReseña = new JLabel("Seleccione tipo de reseña:");
        labelTipoDeReseña.setBounds(250, 150, 160, 20);
        labelTipoDeReseña.setForeground(Color.WHITE);

        // ComboBox ____________________________________________________________
        comboBoxTipoDeReseña = new JComboBox();
        comboBoxTipoDeReseña.addItem("Sommelier");
        comboBoxTipoDeReseña.addItem("Regular");
        comboBoxTipoDeReseña.setBounds(250, 180, 160, 45);
        comboBoxTipoDeReseña.setBackground(new Color(240,240,240));
        comboBoxTipoDeReseña.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        
        // Buttons _____________________________________________________________
        JButton btnTomarTipoDeReseña = new JButton("Tomar tipo de reseña");
        btnTomarTipoDeReseña.setBounds(620, 180, 150, 45);
        btnTomarTipoDeReseña.setBackground(new Color(102, 66, 138));
        btnTomarTipoDeReseña.setForeground(Color.WHITE);
        btnTomarTipoDeReseña.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

        // Evento para tomar la selección del tipo de reseña
        btnTomarTipoDeReseña.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if (comboBoxTipoDeReseña.getSelectedItem().equals("Sommelier")){
                    gestor.tomarTipoReseñaSeleccionada(comboBoxTipoDeReseña.getSelectedItem().toString());
                    btnTomarTipoDeReseña.setVisible(false);
                    comboBoxTipoDeReseña.setVisible(false);
                    labelTipoDeReseña.setVisible(false);
                }
            }
        });

        // Agregar elementos al frame
        frame.add(labelTipoDeReseña);
        frame.add(comboBoxTipoDeReseña);
        frame.add(btnTomarTipoDeReseña);
    }

    //
    public String tomarSeleccionTipoReseña(){
        return comboBoxTipoDeReseña.getSelectedItem().toString();
    }

    //
    public void solicitarFormatoVisualizacion(){
        // Labels ______________________________________________________________
        labelFormatoVisualizacion = new JLabel("Seleccione Formato de visualizacion:");
        labelFormatoVisualizacion.setBounds(250, 150, 160, 20);
        labelFormatoVisualizacion.setForeground(Color.WHITE);

        // ComboBox ____________________________________________________________
        comboBoxFormatoVisualizacion = new JComboBox();
        comboBoxFormatoVisualizacion.addItem("EXCEL (.xslx)");
        comboBoxFormatoVisualizacion.addItem("otro");
        comboBoxFormatoVisualizacion.setBounds(250, 180, 160, 45);
        comboBoxFormatoVisualizacion.setBackground(new Color(240,240,240));
        comboBoxFormatoVisualizacion.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        
        // Buttons _____________________________________________________________
        JButton btnTomarFormatoVisualizacion = new JButton("Tomar tipo de reseña");
        btnTomarFormatoVisualizacion.setBounds(620, 180, 150, 45);
        btnTomarFormatoVisualizacion.setBackground(new Color(102, 66, 138));
        btnTomarFormatoVisualizacion.setForeground(Color.WHITE);
        btnTomarFormatoVisualizacion.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

        // Evento para tomar la selección del tipo de reseña
        btnTomarFormatoVisualizacion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if (comboBoxTipoDeReseña.getSelectedItem().equals("Sommelier")){
                    String seleccionFormato = tomarSeleccionFormato();
                    gestor.tomarSeleccionFormato(seleccionFormato);

                    // Ocultamos los elementos de la pantalla___________
                    btnTomarFormatoVisualizacion.setVisible(false);
                    comboBoxFormatoVisualizacion.setVisible(false);
                    labelFormatoVisualizacion.setVisible(false);
                }
            }
        });

        // Agregar elementos al frame
        frame.add(comboBoxFormatoVisualizacion);
        frame.add(btnTomarFormatoVisualizacion);
        frame.add(labelFormatoVisualizacion);
    }

    //
    public String tomarSeleccionFormato(){
        return comboBoxFormatoVisualizacion.getSelectedItem().toString();
    }

    // 
    public void solicitarConfirmacion(){
        // TODO
    }
    
    //
    public void confirmarGeneracionReporte(){
        // TODO
    }

    //
    public void mostrarGeneracionDeArchivo(){
        // TODO
    }

    //
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