package Entrega1.interfaz;

import java.util.ArrayList;

import Entrega1.controlador.GestorDeGeneracionDeReporte;

public class InterfazExcel {

    public InterfazExcel() {
        
    }
    public void exportarExcel(GestorDeGeneracionDeReporte gestor, ArrayList<String> filas){
        try {
            Thread.sleep(3000);
            System.out.println("Excel file exported successfully!");
            gestor.tomarArchivoGenerado();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}