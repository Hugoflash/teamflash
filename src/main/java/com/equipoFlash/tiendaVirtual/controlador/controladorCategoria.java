
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
       
       model.addAttribute("newCategoria",new Categoria());
       
       return "categorias";
   }
   
   @GetMapping("/categoria/crearcategoria")  // ruta de acceso a la pagina nueva_categoria
   public String crearNuevaCategoria(Model modelo)
   {
       Categoria categoria = new Categoria();
       modelo.addAttribute("categoria",categoria);
       return "editar_categoria";
   } 
   
   @PostMapping("/categorias")
   public String guardarCategoria(@ModelAttribute Categoria categoria) // Sirve para guardar y actualizar
   {
       servicio.guardarCategoria(categoria);
       
       return "redirect:/categorias";
   }
   
    @PostMapping("/categorias/crear")
    public String agregarCategoria(@ModelAttribute Categoria categoria) //crear nueva categoria con Modal
    {
       servicio.guardarCategoria(categoria);
       
       return "redirect:/categorias";
    }
   
   @GetMapping("/categoria/editar/{id}")
   public String modificarCategoriasById(Model modelo, @PathVariable int id ) //modifica la categoria con el id de la fila
   {
       Categoria resultado = servicio.consultarCategoriaById(id);
       modelo.addAttribute("categoria",resultado);
       return "editar_categoria";
   }
   
   @GetMapping("/categoria/eliminar/{id}")  // elimina la categoria con el id directamente, sin advertencia.
   public String eliminarCategoria(@PathVariable int id)
   {
       Categoria guardado = servicio.consultarCategoriaById(id);
       servicio.eliminarCategoria(guardado);
       
       return "redirect:/categorias";
   }
  
   @GetMapping("/categoria/eliminar")
   public String eliminarCategoriaConModal(@RequestParam(value="idAux", required=false) int id) //elimina la categoria al confirmar en el Modal.
   {
       if(id > 0)
       {
           Categoria eliminado = servicio.consultarCategoriaById(id);
           servicio.eliminarCategoria(eliminado);
       }
       else
       {
           System.out.println(" !!! Error al eliminar categoria !!!\n");
       }
       return "redirect:/categorias";
   }
   
  
   
}
