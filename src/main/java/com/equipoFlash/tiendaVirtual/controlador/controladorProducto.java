
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
   public String cargarProductos(Model modelo, @RequestParam(value = "criterio",required = false) String criterio)
   {
       if (criterio == null)
       {
           modelo.addAttribute("productos", servicio.consultarProductos());
       }
       else
       {
           modelo.addAttribute("productos", servicio.consultarProductosByCriterio(criterio));
           modelo.addAttribute("criterio", criterio);
       }
       
       return "productos";
   }
   
   @GetMapping("/productos/nuevoproducto")
   public String cargarNuevoProducto()
   {
       return "nuevo_producto";
   }
}
