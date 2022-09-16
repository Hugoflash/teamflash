
package com.equipoFlash.tiendaVirtual.controlador;


import com.equipoFlash.tiendaVirtual.entidades.Producto;
import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;
import com.equipoFlash.tiendaVirtual.servicios.servicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @Autowired
    private servicioCategoria servicioCategoria;
    
   @GetMapping("/productos")   // Ruta de acceso a productos.html y consulta todos los productos y por criterio
   public String cargarProductos(Model modelo, @RequestParam(value = "criterio",required = false) String criterio)
   {       
       if (criterio == null)
       {
           modelo.addAttribute("productos", servicio.consultarProductos());
       }
       else
       {
           modelo.addAttribute("productos", servicio.consultarProductoByCriterio(criterio));
           modelo.addAttribute("criterio", criterio);
       }
       
       return "productos";
   }
   
   @PostMapping("/productos")
   public String guardarProducto(@ModelAttribute Producto p)
   {
       servicio.guardarProducto(p);
       
       return "redirect:/productos";
   }
   
   @GetMapping("/producto/editar/{id}")
   public String modificarProductoById(Model modelo, @PathVariable int id ) //modifica el producto segun el id de producto en la fila
   {
       modelo.addAttribute("producto", servicio.consultarProductoById(id));
       modelo.addAttribute("categorias", servicioCategoria.consultarCategoria());
       return "nuevo_producto";
   }
   
   @GetMapping("/productos/nuevo")  // ruta de acceso a nuevo_producto.html
   public String cargarEditarProducto(Model modelo)
   {
       modelo.addAttribute("categorias", servicioCategoria.consultarCategoria());
       
       modelo.addAttribute("producto", new Producto());
       return "nuevo_producto";
   }
   
   @GetMapping("/producto/eliminar/{id}")  // elimina el producto con el id directamente, sin advertencia.
   public String eliminarProducto(@PathVariable int id)
   {
       servicio.eliminarProducto(id);
       
       return "redirect:/productos";
   }
   
   @GetMapping("/producto/eliminar")
   public String eliminarProductoConModal(@RequestParam(value="idAux", required=false) int id) //elimina la categoria al confirmar en el Modal.
   {
       if(id > 0)
       {
           servicio.eliminarProducto(id);
       }
       else
       {
           System.out.println(" !!! Error al eliminar categoria !!!\n");
       }
       return "redirect:/productos";
   }
}
