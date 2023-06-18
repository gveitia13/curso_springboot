package com.example.curso.web;

import com.example.curso.dao.PersonaDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/")
    public String inicio(Model model) {
        var personas = personaDao.findAll();
        model.addAttribute("personas", personas);
        log.info("Ejecutando el controlador Spring mvc");
        return "index";
    }
}
