package com.example.catalogoastronomico;
/**
 *
 * @author (IOT)
 * @version (2020)
 *
 */
public class Galaxia extends Astro {

    public Galaxia(String nombre, double brillo, double distancia){
        super(nombre, brillo, distancia);
    }

    @Override
    public String toString() {
        return "objeto-Astro {" +
                "nombre: " + getNombre() +
                ", tipo: " + getClass().getSimpleName() +
                ", brillo: " + getBrillo() +
                ", distancia: " + getDistancia() +
                '}';
    }
}
