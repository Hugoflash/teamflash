package com.equipoFlash.tiendaVirtual;

import com.equipoFlash.tiendaVirtual.entidades.Categoria;
import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class pruebasCategoria 
{
        @Autowired  //inyeccion de la clase servicioCategoria
        private servicioCategoria servicio;
    
	@Test
        @Disabled
	void testInhabilitarrCategoria() 
        {
            Assertions.assertDoesNotThrow(()->{
                servicio.inhabilitarCategoria(3, false);
            }, "No se pudo inhabilitar la categoria");
	}
        
        @Test
        @Disabled
        void testGuardar()
        {
            Categoria categoria = new Categoria("Enlatados",true);
            Assertions.assertDoesNotThrow(()->{servicio.guardarCategoria(categoria);
            },"No se pudo guardar la categoria");
            
        }
        
        @Test
        @Disabled
        void pruebaEliminarCategoria()
        {
            Categoria categoria = new Categoria("Enlatados",true);
            Categoria guardado = servicio.guardarCategoria(categoria);
            Assertions.assertTrue(guardado.getId() > 0,"No se pudo crear la categoria para eliminar");
            servicio.eliminarCategoria(guardado);
            Categoria eliminado = servicio.consultarCategoriaById(guardado.getId());
            Assertions.assertNull(eliminado, "No se elimino categoria creada");
        }

}
