
package com.equipoFlash.tiendaVirtual.controlador;

import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * index.html           /
 * categorias.html      /categorias
 * 
 * @author anderson
 */
@Controller
public class controladorCategoria 
{
    @Autowired
    private servicioCategoria servicio;
    
    @GetMapping("/")
   public String cargarIndex()
   {
       return "index";
   }
   
   @GetMapping("/categorias")
   public String cargarCategorias(Model model, @RequestParam(value ="criterio", required = false) String criterio)
   {
       if (criterio == null)
       {
           model.addAttribute("categorias",servicio.consultarCategoria());
       }
       else
       {
           model.addAttribute("categorias",servicio.consultarCategorias(criterio));
           model.addAttribute("criterio",criterio);
       }
       
       return "categorias";
   }
   
   @GetMapping("/categoria/crearcategoria")
   public String crearNuevaCategoria()
   {
       return "nueva_categoria";
   }
   
}
