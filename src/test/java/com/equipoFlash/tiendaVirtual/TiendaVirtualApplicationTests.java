package com.equipoFlash.tiendaVirtual;

import com.equipoFlash.tiendaVirtual.entidades.Categoria;
import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TiendaVirtualApplicationTests 
{
        @Autowired  //inyeccion de la clase servicioCategoria
        private servicioCategoria servicio;
    
	@Test
        @Disabled
	void testInhabilitarrCategoria() 
        {
            Assertions.assertDoesNotThrow(()->{
                servicio.inhabilitarCategoria(1, true);
            }, "No se pudo inhabilitar la categoria");
	}
        
        @Test
        @Disabled
        void testGuardar()
        {
            Categoria categoria = new Categoria("Articulos deportivos",true);
            Assertions.assertDoesNotThrow(()->{servicio.guardarCategoria(categoria);
            },"No se pudo guardar la categoria");
            
        }

}
