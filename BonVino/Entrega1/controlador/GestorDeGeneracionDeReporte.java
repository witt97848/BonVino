package Entrega1.controlador;

import java.util.ArrayList;
import java.util.Random;

import Entrega1.interfaz.InterfazExcel;
import Entrega1.interfaz.PantallaGenerarReporteDeRankingDeVinos;
import Entrega1.modelo.Bodega;
import Entrega1.modelo.Pais;
import Entrega1.modelo.Provincia;
import Entrega1.modelo.RegionVitivinicola;
import Entrega1.modelo.Vino;

public class GestorDeGeneracionDeReporte {
    public PantallaGenerarReporteDeRankingDeVinos pantalla;
    public InterfazExcel interfazExcel;
    private String fechaDesde, fechaHasta, seleccionTipoReseñas, seleccionFormatoVisualizacion, formatoVisualizacion;
    private ArrayList<Vino> vinos = new ArrayList<Vino>();

    private ArrayList<Pais> paises = new ArrayList<Pais>();
    private ArrayList<Provincia> provincias = new ArrayList<Provincia>();
    private ArrayList<RegionVitivinicola> regiones = new ArrayList<RegionVitivinicola>();
    private ArrayList<Bodega> bodegas = new ArrayList<Bodega>();
    private Random random = new Random();

    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla){
        this.pantalla = pantalla;
        this.interfazExcel = new InterfazExcel();
    }
    
    public void generarRankingDeVino(){
        System.out.println("Se generaran Datos aleatorios para el ranking de vinos: ");
        generarVinosRandom(); // Agregamos a vinos los vinos creados
        for (Vino vino : vinos){
            System.out.println(vino.toString());
        }
        pantalla.solicitarFechaDesdeYFechaHasta(); // Mensaje 4 del DS
    };
        
    public void fechaDesdeFechaHasta(String fechaDesde, String fechaHasta){
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        pantalla.solicitarTipoDeReseña();
    }

    // TODO cambiar en el diagrama el nombre de tomarSeleccionSommelier por tomarTipoReseñaSeleccionada()
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
            generarVinosRandom();
            buscarVinosConReseñaSolicitada();
        } else {
            finCU();
        }
        //pantalla.mostrarMensaje("Generando reporte...");
    }

    public Vino[] buscarVinosConReseñaSolicitada(){
        System.out.println("Buscando vinos con reseña solicitada...");
        return null;
    }

    public void generarArchivo(){
        // TODO
    }

    public Vino[] ordenarVinosSegunCalificacion(){
        // TODO
        return null;
    }


    private void testCrearPaisesProvinciasYRegiones(){
        regiones.add(new RegionVitivinicola("Maipu", "Región vitivinícola de Argentina, Mendoza"));
        regiones.add(new RegionVitivinicola("Valle de Uco", "Región vitivinícola de Argentina, Mendoza"));
        regiones.add(new RegionVitivinicola("Lujan de Cuyo", "Región vitivinícola de Argentina, Mendoza"));
        regiones.add(new RegionVitivinicola("Region San Juan", "Región vitivinícola de Argentina, San Juan"));
        regiones.add(new RegionVitivinicola("Region del Sur", "Región vitivinícola de Argentina, Neuquén"));

        Provincia mendoza = new Provincia("Mendoza", new ArrayList<>(regiones.subList(0, 3)));
        provincias.add(mendoza);

        Provincia sanJuan = new Provincia("San Juan", new ArrayList<>(regiones.subList(3, 4)));
        provincias.add(sanJuan);

        Provincia neuquen = new Provincia("Neuquén", new ArrayList<>(regiones.subList(4, 5)));
        provincias.add(neuquen);

        paises.add(new Pais("Argentina"));

        for (Pais pais : paises){
            for (Provincia provincia : provincias){
                pais.agregarProvincia(provincia);
            }
        }
    }

    private void generarVinosRandom(){
        // TODO
        testCrearPaisesProvinciasYRegiones();
        for (int i = 0; i < 5; i++){
            Bodega bodega = bodegaRandom();
            bodegas.add(bodega);
        }
        for (int i = 0; i < 15; i++){
            String nombreRandom = "Vino" + i;
            Vino vino = new Vino(nombreRandom, bodegas.get(random.nextInt(bodegas.size())));
            vino.testCrearReseñasAleatorias();
            vino.testCrearVarietal();
            vinos.add(vino);
        }
    }

    private Bodega bodegaRandom(){
        String[] nombresBodegas = {"Fernandez", "Wine", "Bodega", "Vinos", "Bodeguita", "Bodegon"};
        String[] descripcionesBodegas = {"Bodega de vinos", "Bodega de vinos de calidad", "Bodega de vinos de excelencia", "Bodega de vinos de lujo", "Bodega de vinos de alta gama", "Bodega de vinos de baja gama"};
        RegionVitivinicola regionRandom = regiones.get(random.nextInt(regiones.size()));
        String nombreRandom = nombresBodegas[random.nextInt(nombresBodegas.length - 1)];
        String descripcionRandom = descripcionesBodegas[random.nextInt(descripcionesBodegas.length - 1)];
        return new Bodega(descripcionRandom, nombreRandom, regionRandom);
    }

    

    // private Vino testCrearVino(){
    //     Vino vino = new Vino();
    //     vino.testCrearReseñasAleatorias();
    //     vino.testCrearVarietal();
    //     return vino;
    // }

    // private void testCrearVinos(){
    //     int cantidadVinos = 15;
    //     for (int i = 0; i < cantidadVinos; i++){
    //         vinos.add(testCrearVino());
    //     }
    // }

    public void finCU(){
        pantalla.cerrar();
    }
}
