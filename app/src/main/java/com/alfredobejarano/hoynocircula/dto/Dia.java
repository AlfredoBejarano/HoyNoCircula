package com.alfredobejarano.hoynocircula.dto;

/**
 * Created by Alfredo on 24/03/2017.
 */

public class Dia {
    private String title; // Texto que muestra que autos no circulan ese dia.
    private int color; // Color de engomado.

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
