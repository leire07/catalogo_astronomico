package com.example.catalogoastronomico;

import java.util.Objects;

/**
 *
 * @author (IOT)
 * @version (2020)
 *
 */

public class Astro {




    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getBrillo() {
        return brillo;
    }

    public void setBrillo(double brillo) {
        this.brillo = brillo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    // declaración de atributos
    private String nombre;
    private double distancia;
    public double brillo;

//declaración del constructor


    public Astro (String nombre, double brillo, double distancia){
        this.nombre=nombre;
        this.brillo=brillo;
        this.distancia=distancia;
    }
    public Astro(){
        this.nombre= "Sirius";
        this.brillo=-1.42;
        this.distancia=8.7;
    }

    public boolean masDistante(Astro otro) {
        if (this.distancia > otro.distancia){
            return true;
        }
        return false;
    }

    public int masBrillante(Astro otro) {
        if(this.brillo > otro.brillo){
            return 1;
        }if (this.brillo < otro.brillo){
            return -1;
        }else{
            return 0;
        }
    }

    public String visibleCon() {
        if (this.brillo < 5){
            return "a simple vista";
        }else if ((this.brillo>=5) && (this.brillo<7)){
            return "con prismáticos";
        }else if ((this.brillo >=7) && (this.brillo<25)){
            return "con telescopio";
        }else{
            return "con grandes telescopios";
        }
    }

    @Override
    public String toString() {
        return "objeto-Astro {" +
                "nombre: " + nombre  +
                ", brillo: " + brillo +
                ", distancia: " + distancia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Astro astro = (Astro) o;
        return Double.compare(astro.brillo, brillo) == 0 &&
                Double.compare(astro.distancia, distancia) == 0 &&
                Objects.equals(nombre, astro.nombre);
    }
}
