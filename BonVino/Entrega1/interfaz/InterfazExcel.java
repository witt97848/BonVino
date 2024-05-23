package Entrega1.interfaz;

public class InterfazExcel {

    public InterfazExcel() {
        
    }
    public void exportarExcel(){
        try {
            Thread.sleep(2000);
            System.out.println("Excel file exported successfully!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}