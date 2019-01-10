package com.isunican.proyectobase.Model;

import com.isunican.proyectobase.Model.DataLoaders.*;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/*
------------------------------------------------------------------
    Clase que almacena la informacion del conjunto de gasolineras
    Mantiene una lista de objetos Gasolinera,
    un RemoteFetch para cargar datos remotos a partir de una URL
    y varias cadenas con URLs de descarga manejadas por la aplicación
------------------------------------------------------------------
*/
public class ListaGasolineras {

    private List<Gasolinera> lista;

    private RemoteFetch remoteFetch;

    //URLs para obtener datos de las gasolineras
    //https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/help
    public static final String URL_GASOLINERAS_SPAIN="https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/";
    public static final String URL_GASOLINERAS_CANTABRIA="https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroCCAA/06";
    public static final String URL_GASOLINERAS_SANTANDER="https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroMunicipio/5819";
    public static final String SANTANDER="Santander";

    /**
     * Constructor, getters y setters
     */
    public ListaGasolineras(){
        this.remoteFetch = new RemoteFetch();
        this.lista = new ArrayList<>();
    }

    public List<Gasolinera> getLista(){ return lista; }
    public void setLista(List<Gasolinera> l){ this.lista = l; }


    /**
     * cargaDatosDummy
     *
     * Carga en la lista de gasolineras varias gasolineras definidas a "mano"
     * para hacer pruebas de funcionamiento
     *
     * @param
     * @return boolean
     */
    public boolean cargaDatosDummy(){
        this.lista.add(new Gasolinera(1000,SANTANDER,SANTANDER, "Av Valdecilla", 1.299,1.359,"AVIA"));
        this.lista.add(new Gasolinera(1053,SANTANDER,SANTANDER, "Plaza Matias Montero", 1.270,1.349,"CAMPSA"));
        this.lista.add(new Gasolinera(420,SANTANDER,SANTANDER, "Area Arrabal Puerto de Raos", 1.249,1.279,"E.E.S.S. MAS, S.L."));
        this.lista.add(new Gasolinera(9564,SANTANDER,SANTANDER, "Av Parayas", 1.189,1.269,"EASYGAS"));
        this.lista.add(new Gasolinera(1025,SANTANDER,SANTANDER, "Calle el Empalme", 1.259,1.319,"CARREFOUR"));
        return true;
    }

    /**
     * cargaDatosLocales
     *
     * A partir de la dirección de un fichero JSON pasado como parámetro:
     * Parsea la información para obtener una lista de gasolineras.
     * Finalmente, dicha lista queda almacenada en la clase.
     *
     * @param String Nombre del fichero
     * @return boolean Devuelve true si se han podido cargar los datos
     */
    public boolean cargaDatosLocales(String fichero){
        return(fichero != null);
    }


    /**
     * cargaDatosRemotos
     *
     * A partir de la dirección pasada como parámetro:
     * Utiliza RemoteFetch para cargar el fichero JSON ubicado en dicha URL
     * en un stream de datos.
     * Luego utiliza ParserJSONGasolineras para parsear dicho stream
     * y extraer una lista de gasolineras.
     * Finalmente, dicha lista queda almacenada en la clase.
     *
     * @param String Dirección URL del JSON con los datos
     * @return boolean Devuelve true si se han podido cargar los datos
     */
    public boolean cargaDatosRemotos(String direccion){
        try {
            remoteFetch.cargaBufferDesdeURL(direccion);
            lista = ParserJSONGasolineras.parseaArrayGasolineras(remoteFetch.getStream());
            Log.d("ENTRA", "Obten gasolineras:" + lista.size());
            return true;
        } catch (Exception e) {
            Log.e("ERROR", "Error en la obtención de gasolineras: " + e.getMessage());
            return false;
        }
    }


    /**
     * toString
     *
     * Redefine el método toString para obtener los datos
     * de la lista de gasolineras en formato texto
     *
     * @param
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder textoGasolineras = new StringBuilder();

        if(lista!=null){
            for (int i=0; i<lista.size(); i++){
                textoGasolineras.append(lista.get(i).toString());
                textoGasolineras.append(" \n\n");
            }
        }else{
            textoGasolineras.append("Sin gasolineras");
        }
        return textoGasolineras.toString();
    }

}
