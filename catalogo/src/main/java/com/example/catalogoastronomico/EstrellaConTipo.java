package com.example.catalogoastronomico;

import java.util.Objects;

/**
 *
 * @author (IOT)
 * @version (2020)
 */
public class EstrellaConTipo extends Estrella{

    //Declaración de atributos
    public TipoEstrella tipo;

    public TipoEstrella getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstrella tipo) {
        this.tipo = tipo;
    }

    public EstrellaConTipo(String nombre, double brillo, double distancia, int planetas, Galaxia galaxia, TipoEstrella tipo) {
        super(nombre, brillo, distancia, planetas, galaxia);
        this.tipo=tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EstrellaConTipo that = (EstrellaConTipo) o;
        return tipo == that.tipo;
    }

    @Override
    public String toString() {
        return "objeto-Astro {" +
                "nombre: " + getNombre() +
                ", tipo: " + getClass().getSimpleName() +
                ", brillo: " + getBrillo() +
                ", distancia: " + getDistancia() +
                ", planetas: " + getPlanetas() +
                ", galaxia: " + getGalaxia().getNombre() +
                ", info: " +  getTipo().getNombreTipo()+ " " + "\"" +  getTipo().getEnlaceTipo()+ "\"" +
                '}';
    }
}
