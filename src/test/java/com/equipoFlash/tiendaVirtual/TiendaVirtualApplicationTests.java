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
	void testGuardarCategoria() 
        {
            Categoria categoria = new Categoria(1,"Aseo personal",true);
            Categoria guardado = servicio.actualizarCategoria(categoria);
            Assertions.assertTrue(guardado.getId() > 0, "¡¡Error al guardar nueva categoria!!");
	}

}
