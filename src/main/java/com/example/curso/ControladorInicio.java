package com.example.curso;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Hola mundo con thymeleaf";
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@email.com");
        persona.setTelefono("5445645654");

        var persona2 = new Persona();
        persona2.setNombre("karla");
        persona2.setApellido("Gomez");
        persona2.setEmail("karla@email.com");
        persona2.setTelefono("5445645654");

        var personas = new ArrayList<Persona>();
        personas.add(persona);
        personas.add(persona2);
//        var personas = Arrays.asList(persona2, persona);
        System.out.println(personas);

        log.info("Ejecutando el controlador Spring mvc");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        return "index";
    }
}
