package com.equipoFlash.tiendaVirtual.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author anderson
 */
@Controller
public class controladorPrincipal 
{
    @GetMapping("/")
    public String cargarIndex()
    {
        return "index";
    }
}
