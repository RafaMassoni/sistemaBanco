package br.com.rafa.sistemabanco.service;

import br.com.rafa.sistemabanco.exceptions.SaldoInsuficiente;
import br.com.rafa.sistemabanco.model.ContaCorrente;
import br.com.rafa.sistemabanco.model.Transacao;
import br.com.rafa.sistemabanco.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao criarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public Transacao realizarDeposito(ContaCorrente contaDestino, BigDecimal valor) {
        Transacao transacao = Transacao.builder()
                .valor(valor)
                .data(LocalDateTime.now())
                .idConta(contaDestino.getId())
                .build();


        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
        return criarTransacao(transacao);
    }

    public Transacao realizarSaque(ContaCorrente contaOrigem, BigDecimal valor) {

        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            throw new SaldoInsuficiente("Conta não possue saldo suficiente");
        }

        Transacao transacao = Transacao.builder()
                .valor(valor)
                .data(LocalDateTime.now())
                .idConta(contaOrigem.getId())
                .build();

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));

        return criarTransacao(transacao);


    }
}
