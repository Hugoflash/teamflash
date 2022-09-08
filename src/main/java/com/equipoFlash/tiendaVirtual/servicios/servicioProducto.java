
package com.equipoFlash.tiendaVirtual.servicios;

import com.equipoFlash.tiendaVirtual.entidades.Producto;
import com.equipoFlash.tiendaVirtual.repositorios.interProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pandar
 */

@Service
public class servicioProducto 
{
    @Autowired
    private interProductoRepositorio repo;
    
    public Producto guardarProducto(Producto producto)
    {
        Producto guardado = repo.save(producto);
        return guardado;
    }
    
     public List<Producto> consultarProductos() // funciona para consultar todos los producto y las retorna en una lista.
    {
        List<Producto> lista = repo.findAll();
        return lista;
    }
     
    public Producto consultarProductosById(int id) // consultar por el id
    {
        Producto producto = repo.findById(id).orElse(null); // si no encuentra el producto devuelve null.
        return producto;
    }
    
     public List<Producto> consultarProductosByCriterio(String criterio)  // consultar segun el nombre y lo retorna en una lista.
    {
        List<Producto> lista = repo.findByNombreContaining(criterio);
        return lista;
    }
}
