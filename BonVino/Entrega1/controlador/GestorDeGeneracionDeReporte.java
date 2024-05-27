package Entrega1.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Entrega1.interfaz.InterfazExcel;
import Entrega1.interfaz.PantallaGenerarReporteDeRankingDeVinos;
import Entrega1.modelo.Bodega;
import Entrega1.modelo.Pais;
import Entrega1.modelo.Provincia;
import Entrega1.modelo.RegionVitivinicola;
import Entrega1.modelo.Reseña;
import Entrega1.modelo.Vino;

public class GestorDeGeneracionDeReporte {
    private PantallaGenerarReporteDeRankingDeVinos pantalla;
    private InterfazExcel interfazExcel;
    private Date fechaDesde, fechaHasta;
    private String seleccionTipoReseñas, formatoVisualizacion;
    private ArrayList<Vino> todosLosVinos = new ArrayList<Vino>();

    // Clases necesarias para generar datos aleatorios
    private ArrayList<Pais> paises = new ArrayList<Pais>();
    private ArrayList<Provincia> provincias = new ArrayList<Provincia>();
    private ArrayList<RegionVitivinicola> regiones = new ArrayList<RegionVitivinicola>();
    private ArrayList<Bodega> bodegas = new ArrayList<Bodega>();
    private Random random = new Random();

    private Map<Vino, Float> promediosCadaVinoSommelier = new HashMap<>();
    private Map<Vino, ArrayList<Reseña>> reseñasCadaVino = new HashMap<>();

    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla){
        this.pantalla = pantalla;
        this.interfazExcel = new InterfazExcel();
    }
    
    // IMPORTANTE ----------------------------------------------------------------------------------
    public void generarRankingDeVino(){

        // 1. Se generaran Datos aleatorios para el ranking de vinos
        System.out.println("Se generaran Datos aleatorios para el ranking de vinos: ");
        testCrearPaisesProvinciasYRegiones(); // Creamos paises, provincias y regiones
        generarVinosRandom(); // Agregamos a vinos los vinos creados
        
        // 2. Se muestran los paises, provincias y regiones creados
        for (Pais pais : paises){
            System.out.println(pais.toString());
            for (Provincia provincia : pais.getProvincias()){
                System.out.println("├─ " + provincia.toString());
                for (RegionVitivinicola region : provincia.getRegiones()){
                    System.out.println("│  ├─ " + region.getNombre());
                }
            }
        }

        // Mensaje 4 del DS
        pantalla.solicitarFechaDesdeYFechaHasta(); 
    };
        
    // HECHO
    public void fechaDesdeFechaHasta(Date fechaDesde, Date fechaHasta){
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        pantalla.solicitarTipoDeReseña();
    }

    // HECHO
    public void tomarTipoReseñaSeleccionada(String seleccion){
        this.seleccionTipoReseñas = seleccion;
        pantalla.solicitarFormatoVisualizacion();
    }

    // HECHO
    public void tomarSeleccionFormato(String seleccion){
        this.formatoVisualizacion = seleccion;
        pantalla.solicitarConfirmacion();
    }

    // HECHO
    public void tomarConfirmacion(String confirmacion){
        if(confirmacion.equals("SI")){
            buscarVinosConReseñaSolicitada();
        } else {
            finCU();
        }
    }

    // HECHO
    public void buscarVinosConReseñaSolicitada(){
        System.out.println("Buscando vinos con reseñas solicitadas...");

        for (Vino vino : todosLosVinos){
            if (vino.tomarReseñasDeVinoEnPeriodo(fechaDesde, fechaHasta).size()>0){
                reseñasCadaVino.put(vino, vino.tomarReseñasDeVinoEnPeriodo(fechaDesde, fechaHasta));
                promediosCadaVinoSommelier.put(vino, vino.getPromedioPuntajeSommelier());
            }
        }
        
        generarArchivo();

    }

    // HECHO
    public ArrayList<Vino> ordenarVinosSegunCalificacion(){
        ArrayList<Vino> vinosOrdenados = new ArrayList<Vino>();

        for (Vino vino : reseñasCadaVino.keySet()){
            Float promedioSommelier = vino.getPromedioPuntajeSommelier();
            if (vinosOrdenados.size() == 0){
                vinosOrdenados.add(vino);
            } else {
                if (promedioSommelier > promediosCadaVinoSommelier.get(vinosOrdenados.get(0))){
                    vinosOrdenados.add(0, vino);
                } else {
                    for (int i = 0; i < vinosOrdenados.size(); i++){
                        if (promedioSommelier > promediosCadaVinoSommelier.get(vinosOrdenados.get(i))){
                            vinosOrdenados.add(i, vino);
                            break;
                        }
                    
                    }
                }
            }
        }
        return vinosOrdenados;
    }

    // HECHO
    public void generarArchivo(){
        // TODO
        
        // Escogemos los primeros 10 vinos ordenados segun la calificacion del sommelier.
        ArrayList<Vino> vinosOrdenados = ordenarVinosSegunCalificacion();
        ArrayList<Vino> vinosTop10 = new ArrayList<>();
        if (vinosOrdenados.size() < 10){
            vinosTop10 = new ArrayList<>(vinosOrdenados.subList(0, vinosOrdenados.size()));
        }
        else{
            vinosTop10 = new ArrayList<>(vinosOrdenados.subList(0, 10));
        }
        
        // Creamos el archivo Excel
             
        ArrayList<String> filas = new ArrayList<>();
        
        for (Vino vino : vinosTop10){

            String regionDelVinoStr = vino.getRegion();
            String paisDelVinoStr = vino.conocerPais(paises, provincias).getNombre();
            Float calificacionGeneral = vino.getCalificacionGeneral();
            Float precioSugerido = vino.getPrecioSugerido();
            String bodegaStr = vino.getBodega().getNombre();
            int top = vinosTop10.indexOf(vino) + 1;
        
            String varietales = "[";    
            for (int i = 0; i < vino.getVarietales().size(); i++){
                if (i < vino.getVarietales().size() - 1){
                    varietales += "'" + vino.getVarietales().get(i).getDescripcion() + "', ";
                } else {
                    varietales += "'" + vino.getVarietales().get(i).getDescripcion() + "'";
                }
            }
            varietales += "]";
            

            String fila = 
            "{" + top + "," +
            "'nombre':'" + vino.getNombre() + "," +
            "'calificacionSommelier':" + promediosCadaVinoSommelier.get(vino) + "," +
            "'calificacionGeneral':" + calificacionGeneral + "," +
            "'precioSugerido': " + vino.getPrecioSugerido() + "," + 
            "'bodega': " + bodegaStr + "," + 
            "'Varietal': " + varietales + "," + 
            "'Region': " + regionDelVinoStr + "," +
            "'Pais': " + paisDelVinoStr +
            "},";

            filas.add(fila);
        }
        
        System.out.println("########################");
        System.out.println("Top 10 de Vinos");
        for (String fila : filas){
            System.out.println(fila);
        }
        System.out.println("########################");

        interfazExcel.exportarExcel(this, filas);
    }

    // HECHO
    public void tomarArchivoGenerado(){
        pantalla.mostrarGeneracionDeArchivo();
    }

    // HECHO
    private void testCrearPaisesProvinciasYRegiones(){
        regiones.add(new RegionVitivinicola("Maipu", "Región vitivinícola de Argentina, Mendoza"));
        regiones.add(new RegionVitivinicola("Valle de Uco", "Región vitivinícola de Argentina, Mendoza"));
        regiones.add(new RegionVitivinicola("Lujan de Cuyo", "Región vitivinícola de Argentina, Mendoza"));
        regiones.add(new RegionVitivinicola("Region San Juan", "Región vitivinícola de Argentina, San Juan"));
        regiones.add(new RegionVitivinicola("Region del Sur", "Región vitivinícola de Argentina, Neuquén"));

        Provincia mendoza = new Provincia("Mendoza", new ArrayList<>(regiones.subList(0, 3)));
        Provincia sanJuan = new Provincia("San Juan", new ArrayList<>(regiones.subList(3, 4)));
        Provincia neuquen = new Provincia("Neuquén", new ArrayList<>(regiones.subList(4, 5)));
        
        provincias.add(mendoza);
        provincias.add(sanJuan);
        provincias.add(neuquen);

        paises.add(new Pais("Argentina"));

        for (Pais pais : paises){
            for (Provincia provincia : provincias){
                pais.agregarProvincia(provincia);
            }
        }
        System.out.println("Paises, provincias y regiones creados");
    }

    // HECHO
    private void generarVinosRandom(){
        System.out.println("Generando vinos");
        for (int i = 0; i < 5; i++){
            Bodega bodega = bodegaRandom();
            bodegas.add(bodega);
        }
        for (int i = 0; i < 50; i++){
            String[] nombres1 = {"Vega", "Peinfold", "Chateau", "CVNE", "Familia"};
            String[] nombres2 = {"Torres", "Sanchez", "Catena", "Toro"};
            String nombreRandom = nombres1[random.nextInt(nombres1.length)] + " " + nombres2[random.nextInt(nombres2.length)];
            Float precioRandom = random.nextFloat() * 1000;
            Vino vino = new Vino(nombreRandom, bodegas.get(random.nextInt(bodegas.size()-1)), precioRandom);
            vino.testCrearReseñasAleatorias();
            vino.testCrearVarietal();
            todosLosVinos.add(vino);
        }

        for (Vino vino : todosLosVinos){
            System.out.println(vino.toString());
        }
    }

    // HECHO
    private Bodega bodegaRandom(){
        String[] nombresBodegas = {"Bodega Catena Zapata", "Bodegas Torres", "Bodegas Muga", "Bodega Viña Real", "Bodega Marqués de Riscal", "Bodegas Emilio Moro", "Bodegas Roda", "Bodega Vega Sicilia", "Bodega López de Heredia", "Bodega La Rioja Alta", "Bodega Pago de Carraovejas", "Bodega Pingus", "Bodegas Valduero", "Bodegas Protos", "Bodega Abadía Retuerta", "Bodega Ramón Bilbao", "Bodega Juan Gil", "Bodegas Cune (CVNE)", "Bodegas Faustino", "Bodegas Marqués de Cáceres"};
        String[] descripcionesBodegas = {"Bodega de vinos", "Bodega de vinos de calidad", "Bodega de vinos de excelencia", "Bodega de vinos de lujo", "Bodega de vinos de alta gama", "Bodega de vinos de baja gama"};
        
        RegionVitivinicola regionRandom = regiones.get(random.nextInt(regiones.size()));
        
        String nombreRandom = nombresBodegas[random.nextInt(nombresBodegas.length)];
        String descripcionRandom = descripcionesBodegas[random.nextInt(descripcionesBodegas.length)];
        return new Bodega(descripcionRandom, nombreRandom, regionRandom);
    }

    // HECHO
    public void finCU(){
        pantalla.cerrar();
    }
}













