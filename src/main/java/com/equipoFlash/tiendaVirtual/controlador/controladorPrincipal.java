
package com.equipoFlash.tiendaVirtual.controlador;

import com.equipoFlash.tiendaVirtual.servicios.servicioCategoria;
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
public class controladorPrincipal 
{
    @GetMapping("/")
    public String cargarIndex()
    {
        return "index";
    }
    
    @GetMapping("/administrar")
    public String cargarPanel()
    {
        return "panel";
    }
    
    @GetMapping("/clientes")
    public String cargarClietes()
    {
        return "clientes";
    }
}
