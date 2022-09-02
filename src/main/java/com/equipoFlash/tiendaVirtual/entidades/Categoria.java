
package com.equipoFlash.tiendaVirtual.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name="tcategorias")
public class Categoria 
{
    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", length = 45, nullable = false, unique = true)
    private String nombre;
    
    @Column(name = "habilitado", columnDefinition = "TINYINT", nullable = false)
    private boolean habilitado;
    
    public Categoria(){}
    public Categoria(int id, String nombre, boolean habilitado)
    {
        this.id = id;
        this.nombre = nombre;
        this.habilitado = habilitado;
    }
    public Categoria(String nombre, boolean habilitado)
    {
        this.nombre = nombre;
        this.habilitado = habilitado;
    }
   
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
}
