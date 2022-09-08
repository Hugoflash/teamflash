
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
            @Disabled
    void testGuardarProducto() // Guarda o actualiza el producto, para guardar no se envia ID, para actualizar se debe enviar ID del producto a actualizar.
    {
         Producto producto = new Producto("Protectores Nosotras","Nosotras",300,"sobre",180,1);
         Assertions.assertDoesNotThrow(()->{servicio.guardarProducto(producto);
         },"Error!! No se pudo guardar la categoria");
    }
    
    @Test
            @Disabled
    void testConsultarProductos() // consulta todos los productos de la tabla
    {
         Assertions.assertDoesNotThrow(()->{if (servicio.consultarProductos().size() > 0);
         },"Error!! No se pudo consultar los productos");
    }
    
    @Test
            @Disabled
    void testConsutarProductosById()
    {
        Assertions.assertDoesNotThrow(()->{servicio.consultarProductosById(1);
        },"Error!! No se pudo consultar por ID");
    }
}
