
package com.equipoFlash.tiendaVirtual.controlador;

import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author anderson
 */
@Controller
public class controladorPrincipal 
{
    @Autowired
    private servicioCategoria servicio;
    
    @GetMapping("/")
   public String cargarIndex()
   {
       return "index";
   }
   
   @GetMapping("/categorias")
   public String cargarCategorias(Model model)
   {
       model.addAttribute("categorias",servicio.consultarCategoria());
       
       return "categorias";
   }
   
}
