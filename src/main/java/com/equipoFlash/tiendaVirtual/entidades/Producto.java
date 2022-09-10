
package com.equipoFlash.tiendaVirtual.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author anderson
 */
@Entity (name = "tproductos")
public class Producto 
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;
    
    @Column(name = "marca", length = 45, nullable = false)
    private String marca;
    
    @Column(name = "precio", nullable = false)
    private int precio;
    
    @Column(name = "presentacion", length = 45, nullable = false)
    private String presentacion;
    
    @Column(name = "existencia", nullable = false)
    private int existencia;
    
    @Column(name = "id_categoria", nullable = false)
    private int categoria;
    
    public Producto(){}
    public Producto(int id,String nombre,String marca,int precio,String presentacion,int existencia,int categoria)
    {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.presentacion = presentacion;
        this.existencia = existencia;
        this.categoria = categoria;
    }
    
    public Producto(String nombre,String marca,int precio,String presentacion,int existencia,int categoria)
    {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.presentacion = presentacion;
        this.existencia = existencia;
        this.categoria = categoria;
        
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getExistencia() {
        return existencia;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
}
