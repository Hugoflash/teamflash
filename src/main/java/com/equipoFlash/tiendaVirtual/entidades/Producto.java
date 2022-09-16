
package com.equipoFlash.tiendaVirtual.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author anderson
 */
@Entity
@Table(name="tproductos") 
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
    private double precio;
    
    @Column(name = "presentacion", length = 45, nullable = false)
    private String presentacion;
    
    @Column(name = "existencia", nullable = false)
    private double existencia;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    
    public Producto(){}
    public Producto(int id,String nombre,String marca,double precio,String presentacion,double existencia,Categoria categoria)
    {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.presentacion = presentacion;
        this.existencia = existencia;
        this.categoria = categoria;
    }
    
    public Producto(String nombre,String marca,double precio,String presentacion,double existencia,Categoria categoria)
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

    public Categoria getCategoria() {
        return categoria;
    }

    public double getExistencia() {
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setExistencia(double existencia) {
        this.existencia = existencia;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
