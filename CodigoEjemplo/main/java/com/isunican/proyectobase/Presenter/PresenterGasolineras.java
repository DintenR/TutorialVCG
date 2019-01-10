package com.isunican.proyectobase.Presenter;

import com.isunican.proyectobase.Model.*;

/*
------------------------------------------------------------------
    Clase presenter con la logica de gasolineras
    Mantiene un objeto ListaGasolineras que es el que mantendrá
    los datos de las gasolineras cargadas en nuestra aplicación
    Incluye métodos para gestionar la lista de gasolineras y
    cargar datos en ella.
------------------------------------------------------------------
*/
public class PresenterGasolineras {

    private ListaGasolineras listaGasolineras;

    /**
     * Constructor, getters y setters
     */
    public PresenterGasolineras(){
        listaGasolineras = new ListaGasolineras();
    }

    public ListaGasolineras getListaGasolineras(){
        return listaGasolineras;
    }


    /**
     * cargaDatosGasolineras
     *
     * Carga los datos de las gasolineras en la lista de gasolineras de la clase.
     * Para ello llama a métodos de carga de datos internos de la clase ListaGasolineras.
     * En este caso realiza una carga de datos remotos dada una URL
     *
     * Habría que mejorar el método para que permita pasar un parámetro
     * con los datos a cargar (id de la ciudad, comunidad autónoma, etc.)
     *
     * @param
     * @return boolean Devuelve true si se han podido cargar los datos
     */
    public boolean cargaDatosGasolineras() {
        return listaGasolineras.cargaDatosRemotos(ListaGasolineras.URL_GASOLINERAS_CANTABRIA);
    }

}
