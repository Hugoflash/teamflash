
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
    
    public Categoria guardarCategoria(Categoria categoria) // funciona tanto para crear y actualizar, para actualizar el objeto debe contener el "id" de la fila a actualizar.
    {
        Categoria guardado = repo.save(categoria);
        return guardado;
    }
    
    public List<Categoria> consultarCategoria() // funciona para consultar todas las categorias y las retorna en una lista.
    {
        List<Categoria> lista = repo.findAll();
        return lista;
    }
    
    public Categoria consultarCategoriaById(int id) // consultar por el id
    {
        Categoria categoria = repo.findById(id).orElse(null); // si no encuentra la categoria devuelve null.
        return categoria;
    }
    
    public List<Categoria> consultarCategoriasByCriterio(String criterio)  // consultar segun el nombre y lo retorna en una lista.
    {
        List<Categoria> lista = repo.findByNombreContaining(criterio);
        return lista;
    }
    
    public List<Categoria> consultarCategoriasHabilitadas()
    {
        List<Categoria> lista = repo.findByHabilitadoTrue();
        return lista;
    }
    
    public void eliminarCategoria(Categoria categoria) // eliminar categoria recibiendo un objeto de la misma clase
    {
        repo.delete(categoria);
    }
    
    public Categoria inhabilitarCategoria(int id,boolean habilitado) // inhabilitar categoria, por id y estado.
    {
        Categoria categoria = repo.findById(id).orElse(null); // findById(id).get() devuelve un objeto de categoria
        categoria.setHabilitado(habilitado);
        Categoria result = repo.save(categoria);
        return result;
    }
}
