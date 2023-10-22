package br.com.rafa.sistemabanco.controllers;

import br.com.rafa.sistemabanco.model.ContaCorrente;
import br.com.rafa.sistemabanco.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    @Autowired
    public ContaCorrenteController(ContaCorrenteService contaCorrenteService) {
        this.contaCorrenteService = contaCorrenteService;
    }

    @GetMapping
    public ResponseEntity<List<ContaCorrente>> listarContasCorrentes() {
        return ResponseEntity.ok()
                .body(contaCorrenteService.listarContasCorrentes());
    }

    @PostMapping
    public ResponseEntity<ContaCorrente> criarContaCorrente(@RequestBody ContaCorrente contaCorrente) {
        return ResponseEntity.ok()
                .body(contaCorrenteService.criarContaCorrente(contaCorrente));
    }
}
