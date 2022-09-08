
package com.equipoFlash.tiendaVirtual.controlador;

import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;
import com.equipoFlash.tiendaVirtual.servicios.servicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pandar
 */
@Controller
public class controladorProducto 
{
    @Autowired
    private servicioProducto servicio;
    
   @GetMapping("/productos")
   public String cargarProductos()
   {
       return "productos";
   }
}