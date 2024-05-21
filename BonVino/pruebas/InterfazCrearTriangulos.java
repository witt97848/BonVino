import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfazCrearTriangulos extends JFrame implements ActionListener {
    private JLabel label1;
    private JButton botonEnviar;
    private JButton boton2;
    private int width;
    private int heigth;

    public InterfazCrearTriangulos(){
        setLayout(null);
        label1 = new JLabel("Texto en Label");
        label1.setBounds(10,10,200,10);
        add(label1);
        
        botonEnviar = new JButton("Enviar");
        botonEnviar.setBounds(500,500,100,20);
        add(botonEnviar);
        botonEnviar.addActionListener(this);

        boton2 = new JButton("Enviar");
        boton2.setBounds(500,500,100,20);
        add(botonEnviar);
        boton2.addActionListener(this);
        

    }
    
    public static void main(String[] args) {
        InterfazCrearTriangulos interfaz = new InterfazCrearTriangulos();
        interfaz.setBounds(0,0,1000,600);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}