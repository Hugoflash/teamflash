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
        @Autowired
        private servicioCategoria servicio;
    
	@Test
	void testGuardarCategoria() 
        {
            Categoria newcategoria = new Categoria("Aseo Personal",true);
            Categoria guardado = servicio.crearCategoria(newcategoria);
            Assertions.assertTrue(guardado.getId() > 0, "¡¡Error al guardar nueva categoria!!");
	}

}
