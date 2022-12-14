
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
        return repo.save(producto);
    }
    
     public List<Producto> consultarProductos() // funciona para consultar todos los producto y las retorna en una lista.
    {
        return repo.findAll();
    }
     
    public Producto consultarProductoById(int id) // consultar por el id
    {
        return repo.findById(id).orElse(null); // si no encuentra el producto devuelve null.
    }
    
     public List<Producto> consultarProductoByCriterio(String criterio)  // consultar segun el nombre y lo retorna en una lista.
    {
        return repo.findByNombreContainingOrMarcaContaining(criterio,criterio);
    }
    
//    public void eliminar(Producto p)
//    {
//        repo.delete(p);
//    }
     
    public boolean eliminarProducto(int id) // Elimina por Id y retorna un booleano
    {
       Producto p = repo.findById(id).orElse(null);
       if( p == null)
       {
           return false;
       }
       else
       {
           repo.delete(p);
           return true;
       }
    }
}
