package br.com.rafa.sistemabanco.controllers;

import br.com.rafa.sistemabanco.model.Transacao;
import br.com.rafa.sistemabanco.service.ContaTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final ContaTransacaoService contaTransacaoService;

    @Autowired
    public TransacaoController(ContaTransacaoService contaTransacaoService) {
        this.contaTransacaoService = contaTransacaoService;
    }



    @PostMapping("/deposito/{idConta}")
    public ResponseEntity<Transacao> realizarDeposito(@PathVariable Long idConta, @RequestParam BigDecimal valor) {

        Transacao transacao = contaTransacaoService.realizarDeposito(idConta, valor);

        return ResponseEntity.ok(transacao);
    }

    @PostMapping("/saque/{idConta}")
    public ResponseEntity<Transacao> realizarSaque(@PathVariable Long idConta, @RequestParam BigDecimal valor) {

        Transacao transacao = contaTransacaoService.realizarSaque(idConta, valor);

        return ResponseEntity.ok(transacao);
    }
}
