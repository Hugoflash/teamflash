
package com.equipoFlash.tiendaVirtual;

import com.equipoFlash.tiendaVirtual.entidades.Producto;
import com.equipoFlash.tiendaVirtual.servicios.servicioProducto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 *
 * @author Pandar
 */
@SpringBootTest
public class pruebasProducto 
{
    @Autowired
    private servicioProducto servicio;
  
    @Test
    void testGuardarProducto()
    {
         Producto producto = new Producto("Protectores Nosotras","Nosotras",300,"sobre",180,1);
         Assertions.assertDoesNotThrow(()->{servicio.guardarProducto(producto);
         },"No se pudo guardar la categoria");
    }
    
}
