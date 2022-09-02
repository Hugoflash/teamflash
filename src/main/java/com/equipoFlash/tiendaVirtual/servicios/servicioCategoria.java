
package com.equipoFlash.tiendaVirtual.servicios;

import com.equipoFlash.tiendaVirtual.entidades.Categoria;
import com.equipoFlash.tiendaVirtual.repositorios.interCategoriaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicioCategoria 
{
    @Autowired // inyeccion de la interfaz interCategoriaRepositorio
    private interCategoriaRepositorio repo;
    
    public Categoria crearCategoria(Categoria newCategoria)
    {
        Categoria guardado = repo.save(newCategoria);
        return guardado;
    }
    
    public void actualizarCategoria()
    {
        
    }
    public Categoria consultarCategoria(int id)
    {
        Categoria categoria = repo.findById(id).get();
        return categoria;
    }
    
    public List<Categoria> consultarCategorias(String criterio)
    {
        List<Categoria> lista = repo.findByNombreContainig(criterio);
        return lista;
    }
    
    public void eliminarCategoria()
    {
        
    }
}
