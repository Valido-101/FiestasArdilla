package com.example.fiestasardilla;

public class Jugador {

    private String nombre;
    private int imagen;
    private int cancion;

    //Constructor con canción
    public Jugador(String nombre, int imagen, int cancion)
    {
        this.nombre = nombre;
        this.imagen = imagen;
        this.cancion = cancion;
    }

    //Constructor sin canción
    public Jugador(String nombre, int imagen)
    {
        this.nombre = nombre;
        this.imagen = imagen;
        cancion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public int getCancion() {
        return cancion;
    }
}
