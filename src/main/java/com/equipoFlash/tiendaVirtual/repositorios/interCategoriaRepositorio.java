
package com.equipoFlash.tiendaVirtual.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.equipoFlash.tiendaVirtual.entidades.Categoria;
import java.util.List;

/**
 *
 * @author anderson
 */
public interface interCategoriaRepositorio extends JpaRepository<Categoria,Integer>
{
    public List<Categoria> findByNombreContaining(String criterio);
}
