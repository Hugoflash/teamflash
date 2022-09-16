
package com.equipoFlash.tiendaVirtual.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.equipoFlash.tiendaVirtual.entidades.Producto;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pandar
 */

@Repository
public interface interProductoRepositorio extends JpaRepository<Producto,Integer>
{
    public List<Producto> findByNombreContainingOrMarcaContaining(String criterio1, String criterio2);
}
