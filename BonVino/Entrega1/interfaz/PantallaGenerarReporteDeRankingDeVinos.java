package Entrega1.interfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
    private JTextField inputDiaFechaDesde, inputMesFechaDesde, inputAñoFechaDesde;
    private JTextField inputDiaFechaHasta, inputMesFechaHasta, inputAñoFechaHasta;
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
    
    // HECHO
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
        inputDiaFechaDesde = new JTextField();
        inputMesFechaDesde = new JTextField();
        inputAñoFechaDesde = new JTextField();
        inputDiaFechaDesde.setBounds(250, 100, 45, 35);
        inputMesFechaDesde.setBounds(310, 100, 45, 35);
        inputAñoFechaDesde.setBounds(370, 100, 60, 35);
        inputDiaFechaDesde.setBackground(new Color(240,240,240));
        inputMesFechaDesde.setBackground(new Color(240,240,240));
        inputAñoFechaDesde.setBackground(new Color(240,240,240));
        inputDiaFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        inputMesFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        inputAñoFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 20));


        inputDiaFechaHasta = new JTextField();
        inputMesFechaHasta = new JTextField();
        inputAñoFechaHasta = new JTextField();
        inputDiaFechaHasta.setBounds(460, 100, 45, 35);
        inputMesFechaHasta.setBounds(520, 100, 45, 35);
        inputAñoFechaHasta.setBounds(580, 100, 60, 35);
        inputDiaFechaHasta.setBackground(new Color(240,240,240));
        inputMesFechaHasta.setBackground(new Color(240,240,240));
        inputAñoFechaHasta.setBackground(new Color(240,240,240));
        inputDiaFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        inputMesFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        inputAñoFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));


        // Labels ______________________________________________________________

        labelFechaDesde = new JLabel("Fecha desde: [dd/mm/yyyy]");
        labelFechaDesde.setBounds(250, 70, 200, 20);
        labelFechaDesde.setForeground(Color.WHITE);
        labelFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        
        labelFechaHasta = new JLabel("Fecha hasta: [dd/mm/yyyy]");
        labelFechaHasta.setBounds(460, 70, 200, 20);
        labelFechaHasta.setForeground(Color.WHITE);
        labelFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

        // Buttons _____________________________________________________________
        btnTomarFechaDesdeFechaHasta = new JButton("Tomar fechas");
        btnTomarFechaDesdeFechaHasta.setBounds(660, 100, 150, 45);
        btnTomarFechaDesdeFechaHasta.setBackground(new Color(102, 66, 138));
        btnTomarFechaDesdeFechaHasta.setForeground(Color.WHITE);
        btnTomarFechaDesdeFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        
        // Evento del botón para tomar las fechas
        btnTomarFechaDesdeFechaHasta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // __________________________________________ Mensaje 5 del DS
                try{
                    Date[] fechas = tomarFechaDesdeFechaHasta();
                    // ______________________________________ Mensaje 6 del DS
                    if (validarFechas(fechas[0], fechas[1])){
                        System.out.println("Fechas válidas");
                        // _______________________________________________ Mensaje 7 del DS
                        
                        inputDiaFechaDesde.setEnabled(false);
                        inputMesFechaDesde.setEnabled(false);
                        inputAñoFechaDesde.setEnabled(false);
                        inputDiaFechaHasta.setEnabled(false);
                        inputMesFechaHasta.setEnabled(false);
                        inputAñoFechaHasta.setEnabled(false);
                        btnTomarFechaDesdeFechaHasta.setVisible(false);

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

        frame.add(inputDiaFechaDesde);
        frame.add(inputMesFechaDesde);
        frame.add(inputAñoFechaDesde);

        frame.add(inputDiaFechaHasta);
        frame.add(inputMesFechaHasta);
        frame.add(inputAñoFechaHasta);

        frame.add(labelFechaDesde);
        frame.add(labelFechaHasta);
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
                    comboBoxTipoDeReseña.setEnabled(false);
                    btnTomarTipoDeReseña.setVisible(false);

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

                    btnTomarFormatoVisualizacion.setVisible(false);
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

    // HECHO
    public void mostrarGeneracionDeArchivo(){
        ocultarElementos();

        JOptionPane.showMessageDialog(null, "Archivo generado exitosamente.");
        
        gestor.finCU();
    }

    // HECHO
    public Date[] tomarFechaDesdeFechaHasta(){
        Date[] fechas = new Date[2];

        int diaDesde = Integer.parseInt(inputDiaFechaDesde.getText());
        int mesDesde = Integer.parseInt(inputMesFechaDesde.getText());
        int añoDesde = Integer.parseInt(inputAñoFechaDesde.getText());

        int diaHasta = Integer.parseInt(inputDiaFechaHasta.getText());
        int mesHasta = Integer.parseInt(inputMesFechaHasta.getText());
        int añoHasta = Integer.parseInt(inputAñoFechaHasta.getText());

        fechas[0] = new Date(añoDesde, mesDesde, diaDesde); // Fecha desde
        fechas[1] = new Date(añoHasta, mesHasta, diaHasta); // Fecha hasta
        return fechas;
    }

    // HECHO
    private boolean validarFechas(Date fechaDesde, Date fechaHasta){
        // Validar que fechaDesde no sea mayor que fechaHasta
        if (fechaDesde.after(fechaHasta)) {
            return false;
        } else {
            return true;
        }
    }
    
    // HECHO
    private void ocultarElementos(){
        labelFechaDesde.setVisible(false);
        labelFechaHasta.setVisible(false);
        labelTipoDeReseña.setVisible(false);
        labelFormatoVisualizacion.setVisible(false);
        inputDiaFechaDesde.setVisible(false);
        inputMesFechaDesde.setVisible(false);
        inputAñoFechaDesde.setVisible(false);
        inputDiaFechaHasta.setVisible(false);
        inputMesFechaHasta.setVisible(false);
        inputAñoFechaHasta.setVisible(false);
        comboBoxTipoDeReseña.setVisible(false);
        comboBoxFormatoVisualizacion.setVisible(false);
        btnTomarFechaDesdeFechaHasta.setVisible(false);
        btnCancelarCU.setVisible(false);
        btnTomarTipoDeReseña.setVisible(false);
        btnTomarFormatoVisualizacion.setVisible(false);
        
    }

    // HECHO
    public void cerrar(){
        frame.dispose();
    }
}

