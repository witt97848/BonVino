
package Entrega1.modelo;

import java.util.ArrayList; // Import ArrayList
import java.util.Date;
import java.util.Random; // Import Random

public class Vino {
    private String nombre;
    private ArrayList<Reseña> reseñas;
    private ArrayList<Varietal> varietales;
    private Bodega bodega;
    private Random random = new Random(); // Create a Random object
    private Float precioSugerido;


    // Add a constructor to initialize all attributes
    public Vino(String nombre, Bodega bodega, Float precioSugerido){
    //public Vino(String nombre, Bodega bodega){
        this.nombre = nombre;
        this.reseñas = new ArrayList<>();
        this.bodega = bodega;
        this.varietales = new ArrayList<>();
        this.precioSugerido = precioSugerido;
    }
    

    public ArrayList<Reseña> tomarReseñasDeVinoEnPeriodo(Date fechaDesde, Date fechaHasta){
        ArrayList<Reseña> arrayTemporal = new ArrayList<>(); // Change array type to ArrayList<Reseña>
        for (Reseña cadaReseña : reseñas){
            if (cadaReseña.sosDelPeriodo(fechaDesde, fechaHasta) && cadaReseña.sosPremium()){
                // System.out.println(getNombre() + "=======>" + cadaReseña.toString());
                arrayTemporal.add(cadaReseña); // Use add() method to add each Reseña object to the arrayTemporal list
            }
        }
        
        return arrayTemporal;
    }

    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<Reseña> getReseñas(){
        return reseñas;
    }
    
    public Bodega getBodega(){
        return bodega;
    }    

    // TODO cambiar nombre de calcularPromedioDeLasReseñas() en el diagrama
    public Float getPromedioPuntajeSommelier(){
        Float promedio = 0.0f;
        int sumatoria = 0;
        if (reseñas.size() > 0){
            for (Reseña cadaReseña : reseñas){
                if (cadaReseña.sosPremium()){
                    sumatoria += cadaReseña.getPuntaje();
                }
            }
            promedio = (float) (sumatoria / reseñas.size());
        }
        return promedio;
    }

    public Float getPromedioPuntaje(){
        Float promedio = 0.0f;
        int sumatoria = 0;
        if (reseñas.size() > 0){
            for (Reseña cadaReseña : reseñas){
                sumatoria += cadaReseña.getPuntaje();
            }
            promedio = (float) (sumatoria / reseñas.size());
        }
        return promedio;
    }

    public Float getPrecioSugerido(){
        return precioSugerido;
    }

    public Pais conocerPais(ArrayList<Pais> paises, ArrayList<Provincia> provincias){
        RegionVitivinicola regionDelVino = getBodega().getRegion();
        Pais suPais = regionDelVino.conocerPais(paises, provincias);
        return suPais;
    }

    public void testCrearReseñasAleatorias(){
        String[] com1 = {"Muy", "Demasiado", "Bastante", "Poco", "Nada"};
        String[] com2 = {"rico", "amargo", "dulce", "suave", "fuerte", "sabroso", "asqueroso", "delicioso", "horrible", "bueno", "malo", "regular", "excelente", "pésimo", "espectacular", "normal", "extraño", "raro", "común", "incomún", "único", "especial", "particular", "distinto", "diferente", "único", "original", "nuevo", "viejo", "antiguo", "moderno", "actual", "pasado", "futuro", "presente", "eterno", "temporal"};
        
        int cantidadReseñas = random.nextInt(30);
        for (int i = 0; i <= cantidadReseñas; i++){
            String comRandom = com1[random.nextInt(com1.length - 1)] + " " + com2[random.nextInt(com2.length - 1)];
            long fechaDesde = new Date(2015, 1, 1).getTime();
            long fechaHasta = new Date(2024, 4, 25).getTime();
            Date fechaRandom = new Date(random.nextLong(fechaDesde,fechaHasta)); // Use nextLong() method to generate a random long value
            Reseña reseña = new Reseña(comRandom, random.nextBoolean(), fechaRandom, random.nextInt(100), this);
            reseñas.add(reseña);
        }
    }

    public ArrayList<Varietal> getVarietales(){
        return varietales;
    }

    public void testCrearVarietal(){
        int cantidadVarietales = random.nextInt(1,5);
        String[] descripcionesVarietales = {"Malbec", "Cabernet Sauvignon", "Merlot", "Syrah", "Bonarda", "Petit Verdot", "Tannat", "Pinot Noir", "Chardonnay", "Sauvignon Blanc", "Semillón", "Torrontés", "Viognier", "Riesling", "Gewürztraminer", "Malbec Rosé", "Cabernet Franc", "Malbec Blend", "Cabernet Sauvignon Blend", "Merlot Blend", "Syrah Blend", "Bonarda Blend", "Petit Verdot Blend", "Tannat Blend", "Pinot Noir Blend", "Chardonnay Blend", "Sauvignon Blanc Blend", "Semillón Blend", "Torrontés Blend", "Viognier Blend", "Riesling Blend", "Gewürztraminer Blend", "Malbec Rosé Blend", "Cabernet Franc Blend"};

        for (int i = 0; i <= cantidadVarietales; i++){
            varietales.add(new Varietal(descripcionesVarietales[random.nextInt(descripcionesVarietales.length - 1)]));
        }
    }

    public String toStringVarietales(){
        String cad = "";
        for (Varietal cadaVarietal : varietales){
            cad += "\n- " + cadaVarietal.getDescripcion();
        }
        return cad;
    }

    public String toStringReseñas(){
        String cad = "";
        for (Reseña cadaReseña : reseñas){
            cad += "-------------------------\n" + cadaReseña.toString() + "\n";
        }
        return cad;
    }

    public String toString(){
        String cad = "==========================================================\n" + 
        "Vino: " + nombre + 
        "\n...................................................\n" + 
        "Bodega\n" + bodega.toString() + 
        "\n...................................................\n" + 
        "Region:\n" + bodega.getRegion().toString() + 
        "\n...................................................\n" + 
        "Varietales: " + toStringVarietales() + 
        "\n...................................................\n" + 
        "Precio sugerido: " + precioSugerido +
        "\n...................................................\n" +
        "Reseñas\n" + toStringReseñas() + 
        "==========================================================\n";
        return cad;
    }
}