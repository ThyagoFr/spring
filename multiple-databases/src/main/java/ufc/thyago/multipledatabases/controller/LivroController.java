package ufc.thyago.multipledatabases.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufc.thyago.multipledatabases.service.LivroService;

/**
 * Criado por : Thyago Freitas
 * Data :  02/11/2020
 * Projeto  : multiple-databases
 **/

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }


}
