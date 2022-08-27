
package com.equipoFlash.tiendaVirtual.entidades;

public class Categoria 
{
    private int id;
    private String nombre;
    
    public Categoria(){}
    public Categoria(int id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
