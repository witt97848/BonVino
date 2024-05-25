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
    private JLabel labelImagenLogo, labelFechaDesde, labelFechaHasta, labelImagenTitulo;
    private JLabel labelTipoDeReseña;
    private JLabel labelFormatoVisualizacion;
    private JTextField inputFechaDesde, inputFechaHasta;
    private JComboBox comboBoxTipoDeReseña;
    private JComboBox comboBoxFormatoVisualizacion;
    private JButton btnTomarFechaDesdeFechaHasta, btnCancelarCU, btnTomarTipoDeReseña, btnTomarFormatoVisualizacion;
    private ImageIcon imagenLogo;
    
    public PantallaGenerarReporteDeRankingDeVinos(){
        this.gestor = new GestorDeGeneracionDeReporte(this);
    }

    // Creamos la pantalla para generar el reporte de ranking de vinos
    public void habilitarPantalla(){
        // Buttons _____________________________________________________________
        btnCancelarCU = new JButton("Cancelar");
        btnCancelarCU.setBounds(800, 500, 150, 45);
        btnCancelarCU.setBackground(new Color(200,200,200));
        btnCancelarCU.setForeground(new Color(102, 66, 138));
        btnCancelarCU.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnCancelarCU.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                gestor.finCU();
            }
        });

        // Frame _______________________________________________________________
        frame = new JFrame("Generar Ranking de Vinos");
        frame.setLayout(null);
        frame.setBounds(0,0,1000,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new java.awt.Color(30,15,35));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon(getClass().getResource("../images/LogoPPAI.png")).getImage());

        // Imagenes ____________________________________________________________
        ImageIcon imagenLogo = new ImageIcon(getClass().getResource("../images/LogoPPAI.png"));
		labelImagenLogo = new JLabel(imagenLogo);
		labelImagenLogo.setBounds(60,80,150,150);

        ImageIcon imagenTitulo = new ImageIcon(getClass().getResource("../images/TituloGrupo.png"));
		labelImagenTitulo = new JLabel(imagenTitulo);
		labelImagenTitulo.setBounds(50,250,170,170);


        // Agregar elementos al frame
        frame.add(btnCancelarCU);
        frame.add(labelImagenLogo);
        frame.add(labelImagenTitulo);

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

    // HECHO
    public void solicitarFechaDesdeYFechaHasta() {
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
        labelFechaDesde.setBounds(250, 70, 160, 15);
        labelFechaDesde.setForeground(Color.WHITE);
        labelFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        
        labelFechaHasta = new JLabel("Fecha hasta: [dd/mm/yyyy]");
        labelFechaHasta.setBounds(430, 70, 160, 15);
        labelFechaHasta.setForeground(Color.WHITE);
        labelFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 17));

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
                        labelFechaDesde.setVisible(false);
                        labelFechaHasta.setVisible(false);
                        inputFechaDesde.setVisible(false);
                        inputFechaHasta.setVisible(false);
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
        frame.add(labelFechaDesde);
        frame.add(inputFechaDesde);
        frame.add(labelFechaHasta);
        frame.add(inputFechaHasta);
        frame.add(btnTomarFechaDesdeFechaHasta);
    }

    // HECHO
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
        btnTomarTipoDeReseña = new JButton("Tomar tipo de reseña");
        btnTomarTipoDeReseña.setBounds(620, 180, 150, 45);
        btnTomarTipoDeReseña.setBackground(new Color(102, 66, 138));
        btnTomarTipoDeReseña.setForeground(Color.WHITE);
        btnTomarTipoDeReseña.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

        // Agregar elementos al frame
        frame.add(labelTipoDeReseña);
        frame.add(comboBoxTipoDeReseña);
        frame.add(btnTomarTipoDeReseña);

        labelTipoDeReseña.setVisible(true);
        comboBoxTipoDeReseña.setVisible(true);
        btnTomarTipoDeReseña.setVisible(true);

        // Evento para tomar la selección del tipo de reseña
        btnTomarTipoDeReseña.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String seleccionTipoReseña = tomarSeleccionTipoReseña();
                if (seleccionTipoReseña == "Sommelier"){
                    
                    // Bloqueamos los elementos de la pantalla
                    btnTomarTipoDeReseña.setVisible(false);
                    comboBoxTipoDeReseña.setVisible(false);
                    labelTipoDeReseña.setVisible(false);

                    // Flujo de control hacia el gestor
                    gestor.tomarTipoReseñaSeleccionada(seleccionTipoReseña);
                }
            }
        });
    }

    // HECHO
    public String tomarSeleccionTipoReseña(){
        return comboBoxTipoDeReseña.getSelectedItem().toString();
    }

    // HECHO
    public void solicitarFormatoVisualizacion(){
        // Labels ______________________________________________________________
        labelFormatoVisualizacion = new JLabel("Seleccione Formato de visualizacion:");
        labelFormatoVisualizacion.setBounds(250, 230, 160, 20);
        labelFormatoVisualizacion.setForeground(Color.WHITE);

        // ComboBox ____________________________________________________________
        comboBoxFormatoVisualizacion = new JComboBox();
        comboBoxFormatoVisualizacion.addItem("EXCEL (.xslx)");
        comboBoxFormatoVisualizacion.addItem("otro");
        comboBoxFormatoVisualizacion.setBounds(250, 260, 160, 45);
        comboBoxFormatoVisualizacion.setBackground(new Color(240,240,240));
        comboBoxFormatoVisualizacion.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        
        // Buttons _____________________________________________________________
        btnTomarFormatoVisualizacion = new JButton("Tomar tipo de reseña");
        btnTomarFormatoVisualizacion.setBounds(620, 260, 150, 45);
        btnTomarFormatoVisualizacion.setBackground(new Color(102, 66, 138));
        btnTomarFormatoVisualizacion.setForeground(Color.WHITE);
        btnTomarFormatoVisualizacion.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

        // Agregar elementos al frame
        frame.add(comboBoxFormatoVisualizacion);
        frame.add(btnTomarFormatoVisualizacion);
        frame.add(labelFormatoVisualizacion);

        comboBoxFormatoVisualizacion.setEnabled(true);
        btnTomarFormatoVisualizacion.setVisible(true);
        labelFormatoVisualizacion.setEnabled(true);
        

        // Evento para tomar la selección del tipo de reseña
        btnTomarFormatoVisualizacion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String seleccionFormato = tomarSeleccionFormato();
                if (seleccionFormato == "EXCEL (.xslx)"){
                    // Ocultamos los elementos de la pantalla___________
                    // btnTomarFormatoVisualizacion.setVisible(false);
                    // comboBoxFormatoVisualizacion.setVisible(false);
                    // labelFormatoVisualizacion.setVisible(false);

                    btnTomarFormatoVisualizacion.setEnabled(false);
                    comboBoxFormatoVisualizacion.setEnabled(false);

                    gestor.tomarSeleccionFormato(seleccionFormato);
                }
            }
        });
    }

    // HECHO
    public String tomarSeleccionFormato(){
        return comboBoxFormatoVisualizacion.getSelectedItem().toString();
    }

    // HECHO
    public void solicitarConfirmacion(){
        Object[] options = {"Aceptar", "Cancelar"};
        int choice = JOptionPane.showOptionDialog(null, 
                        "¿Deseas continuar?", 
                        "Confirmación", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        options, 
                        options[0]);
        // Verificar la opción seleccionada por el usuario
        if (choice == JOptionPane.YES_OPTION) {
            // El usuario seleccionó "Aceptar"
            System.out.println("Se seleccionó Aceptar");
            confirmarGeneracionReporte();
        } else if (choice == JOptionPane.NO_OPTION) {
            // El usuario seleccionó "Cancelar" o cerró el diálogo
            System.out.println("Se seleccionó Cancelar o se cerró el diálogo");
            gestor.tomarConfirmacion("NO");
        }
    }
    
    // HECHO
    public void confirmarGeneracionReporte(){
        gestor.tomarConfirmacion("SI");
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
    
    public void cerrar(){
        frame.dispose();
    }
}