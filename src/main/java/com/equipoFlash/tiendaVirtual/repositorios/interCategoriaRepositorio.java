
package com.equipoFlash.tiendaVirtual.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.equipoFlash.tiendaVirtual.entidades.Categoria;
import java.util.List;
import org.springframework.stereotype.Repository;


/**
 *
 * @author anderson
 */
@Repository
public interface interCategoriaRepositorio extends JpaRepository<Categoria,Integer>
{
    public List<Categoria> findByNombreContaining(String criterio);
    public List<Categoria> findByHabilitadoTrue();
}

