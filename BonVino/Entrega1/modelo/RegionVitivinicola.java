package Entrega1.modelo;

public class RegionVitivinicola{
    private String nombre;
    private String descripcion;
    
    public RegionVitivinicola(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }

    // public Provincia getProvincia(ArrayList<Pais> paises){
    //     for (Pais cadaPais : paises) {
    //         for (Provincia cadaProvincia : cadaPais.getProvincias()) {
    //             for (RegionVitivinicola cadaRegion : cadaProvincia.getRegiones()) {
    //                 if(cadaRegion == this){
    //                     return cadaProvincia;
    //                 }
    //             }
    //         }
    //     }
    //     return null;
    // }
}