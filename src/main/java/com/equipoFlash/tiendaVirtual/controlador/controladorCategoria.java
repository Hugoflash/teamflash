
package com.equipoFlash.tiendaVirtual.controlador;

import com.equipoFlash.tiendaVirtual.entidades.Categoria;
import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
      
   @GetMapping("/categorias")
   public String cargarCategorias(Model model, @RequestParam(value ="criterio", required = false) String criterio)
   {
       if (criterio == null)
       {
           model.addAttribute("categorias",servicio.consultarCategoria());
       }
       else
       {
           model.addAttribute("categorias",servicio.consultarCategoriasByCriterio(criterio));
           model.addAttribute("criterio",criterio);
       }
       
       return "categorias";
   }
   
   @GetMapping("/categoria/crearcategoria")
   public String crearNuevaCategoria(Model modelo)
   {
       Categoria categoria = new Categoria();
       modelo.addAttribute("categoria",categoria);
       return "nueva_categoria";
   } 
   
   @PostMapping("/categorias")
   public String guardarCategoria(@ModelAttribute Categoria categoria) // Sirve para guardar y actualizar
   {
       servicio.guardarCategoria(categoria);
       
       return "redirect:/categorias";
   }
   
   @GetMapping("/categoria/crearcategoria/{id}")
   public String cargarCategoriasById(Model modelo, @PathVariable int id )
   {
       Categoria resultado = servicio.consultarCategoriaById(id);
       modelo.addAttribute("categoria",resultado);
       return "nueva_categoria";
   }
   
   @GetMapping("/categoria/eliminar/{id}")
   public String eliminarCategoria(@PathVariable int id)
   {
       Categoria guardado = servicio.consultarCategoriaById(id);
       servicio.eliminarCategoria(guardado);
       
       return "redirect:/categorias";
   }
   
   
}
