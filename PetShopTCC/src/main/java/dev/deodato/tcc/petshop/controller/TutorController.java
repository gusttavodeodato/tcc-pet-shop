package dev.deodato.tcc.petshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TutorController {

    @GetMapping("/cadastro")
    public String boasVindas() {
        return "Primeira mensagem nessa rota";
    }
}
