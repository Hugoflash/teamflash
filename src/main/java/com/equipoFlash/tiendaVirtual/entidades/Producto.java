
package com.equipoFlash.tiendaVirtual.entidades;

/**
 *
 * @author anderson
 */
public class Producto 
{
    private int id;
    private String nombre;
    private String marca;
    private double precio;
    private String presentacion;
    private Categoria categoria;
    
    public Producto(){}
    public Producto(int id,String nombre,String marca,double precio,String presentacion, Categoria categoria)
    {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.presentacion = presentacion;
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

    public Categoria getCategoria() {
        return categoria;
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
