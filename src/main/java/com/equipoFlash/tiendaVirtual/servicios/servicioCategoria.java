
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
    
    public Categoria crearCategoria(Categoria Categoria)
    {
        Categoria guardado = repo.save(Categoria);
        return guardado;
    }
    
    public Categoria actualizarCategoria(Categoria categoria )
    {
        Categoria actualizado = repo.save(categoria);
        return actualizado;
    }
    public Categoria consultarCategoria(int id)
    {
        Categoria categoria = repo.findById(id).get();
        return categoria;
    }
    
    public List<Categoria> consultarCategorias(String criterio)
    {
        List<Categoria> lista = repo.findByNombreContaining(criterio);
        return lista;
    }
    
    public void eliminarCategoria(Categoria categoria)
    {
        repo.delete(categoria);
    }
}
