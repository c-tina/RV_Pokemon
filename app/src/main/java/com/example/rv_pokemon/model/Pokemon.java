package com.example.rv_pokemon.model;

public class Pokemon {
    public String nombre;
    public int imagen;
    public String tipo;
    public String descripcion;
    public String generacion;

    public Pokemon (String nombre, String tipo, int imagen, String generacion, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
        this.generacion = generacion;
        this.descripcion = descripcion;
    }
}
