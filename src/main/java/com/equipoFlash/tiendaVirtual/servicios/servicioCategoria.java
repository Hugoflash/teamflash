
package com.equipoFlash.tiendaVirtual.servicios;

import com.equipoFlash.tiendaVirtual.entidades.Categoria;
import com.equipoFlash.tiendaVirtual.repositorios.interCategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicioCategoria 
{
    @Autowired
    private interCategoriaRepositorio repo;
    
    public Categoria crearCategoria(Categoria newCategoria)
    {
        Categoria guardado = repo.save(newCategoria);
        return guardado;
    }
    public void actualizarCategoria()
    {
        
    }
    public void consultarCategoria()
    {
        
    }
    public void eliminarCategoria()
    {
        
    }
}
