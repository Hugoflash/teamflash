
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
    
    public Categoria guardarCategoria(Categoria Categoria) // funciona tanto para crear y actualizar, para actualizar el objeto debe contener el "id" de la fila a actualizar.
    {
        Categoria guardado = repo.save(Categoria);
        return guardado;
    }
    
    public List<Categoria> consultarCategoria() // funciona para consultar todas las categorias y las retorna en una lista.
    {
        List<Categoria> lista = repo.findAll();
        return lista;
    }
    
    public Categoria consultarCategoria(int id) // consultar por el id
    {
        Categoria categoria = repo.findById(id).get();
        return categoria;
    }
    
    public List<Categoria> consultarCategorias(String criterio)  // consultar segun el nombre y lo retorna en una lista.
    {
        List<Categoria> lista = repo.findByNombreContaining(criterio);
        return lista;
    }
    
    public Categoria inhabilitarCategoria(int id,boolean habilitado) // inhabilitar categoria, por id y estado.
    {
        Categoria categoria = repo.findById(id).get();
        categoria.setHabilitado(habilitado);
        Categoria result = repo.save(categoria);
        return result;
    }
}
