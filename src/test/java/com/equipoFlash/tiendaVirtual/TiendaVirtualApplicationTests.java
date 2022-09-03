package com.equipoFlash.tiendaVirtual;

import com.equipoFlash.tiendaVirtual.entidades.Categoria;
import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TiendaVirtualApplicationTests 
{
        @Autowired  //inyeccion de la clase servicioCategoria
        private servicioCategoria servicio;
    
	@Test
	void testInhabilitarrCategoria() 
        {
            //Categoria categoria = new Categoria(1,"Aseo personal",true);
            Categoria guardado = servicio.inhabilitarCategoria(1,true);
            Assertions.assertTrue(guardado.isHabilitado() == true, "¡¡Error al inhabilitar categoria!!");
	}
        
        @Test
        void testGuardar()
        {
            Categoria categoria = new Categoria("Articulos deportivos",true);
            Categoria guardado = servicio.guardarCategoria(categoria);
            Assertions.assertTrue(guardado.getId() > 0, "¡¡Error al inhabilitar categoria!!");
            
        }

}
