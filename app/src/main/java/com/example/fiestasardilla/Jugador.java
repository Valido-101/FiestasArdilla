package com.example.fiestasardilla;

public class Jugador {

    private String nombre;
    private int imagen;
    private int cancion;
    private int inicio_reproduccion;

    //Constructor con canción
    public Jugador(String nombre, int imagen, int cancion, int inicio_reproduccion)
    {
        this.nombre = nombre;
        this.imagen = imagen;
        this.cancion = cancion;
        this.inicio_reproduccion = inicio_reproduccion;
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

    public int getInicio_reproduccion() {
        return inicio_reproduccion;
    }
}
