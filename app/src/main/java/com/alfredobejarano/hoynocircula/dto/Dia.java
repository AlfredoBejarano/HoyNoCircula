package com.alfredobejarano.hoynocircula.dto;

/**
 * Created by Alfredo on 24/03/2017.
 */

public class Dia {
    private String terminaciones; // Texto que muestra que autos no circulan ese dia.
    private String hologramas;
    private int color; // Color de engomado.

    public Dia(String terminaciones, String hologramas, int color) {
        this.terminaciones = terminaciones;
        this.hologramas = hologramas;
        this.color = color;
    }

    public String getHologramas() {
        return hologramas;
    }

    public void setHologramas(String hologramas) {
        this.hologramas = hologramas;
    }

    public String getTerminaciones() {
        return terminaciones;
    }

    public void setTerminaciones(String terminaciones) {
        this.terminaciones = terminaciones;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
