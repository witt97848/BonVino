package org.gvredonditos.model;


import jakarta.persistence.*;

@Entity
@Table(name="paises")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @Override
    public String toString() {
        return "id=" + id + ", nombre='" + nombre + '\'';
    }

    public Pais(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
}
