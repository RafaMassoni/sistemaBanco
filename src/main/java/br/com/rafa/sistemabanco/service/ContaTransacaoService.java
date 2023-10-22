package br.com.rafa.sistemabanco.service;

import br.com.rafa.sistemabanco.model.ContaCorrente;
import br.com.rafa.sistemabanco.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Service
public class ContaTransacaoService {

    private final TransacaoService transacaoService;
    private final ContaCorrenteService contaCorrenteService;

    @Autowired
    public ContaTransacaoService(TransacaoService transacaoService, ContaCorrenteService contaCorrenteService) {
        this.transacaoService = transacaoService;
        this.contaCorrenteService = contaCorrenteService;
    }



    public Transacao realizarDeposito(Long idConta, BigDecimal valor) {

        ContaCorrente contaCorrente = contaCorrenteService.buscarPorId(idConta);
        return transacaoService.realizarDeposito(contaCorrente,valor);
    }

    @PostMapping("/saque/{contaId}")
    public Transacao realizarSaque( Long idConta,  BigDecimal valor) {
        ContaCorrente contaCorrente = contaCorrenteService.buscarPorId(idConta);
        return transacaoService.realizarSaque(contaCorrente,valor);
    }


}
