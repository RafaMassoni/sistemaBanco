package br.com.rafa.sistemabanco.service;

import br.com.rafa.sistemabanco.exceptions.NaoEncontradoException;
import br.com.rafa.sistemabanco.model.ContaCorrente;
import br.com.rafa.sistemabanco.repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaCorrenteService {

    private final ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    public ContaCorrenteService(ContaCorrenteRepository contaCorrenteRepository) {
        this.contaCorrenteRepository = contaCorrenteRepository;
    }

    public List<ContaCorrente> listarContasCorrentes() {
        return contaCorrenteRepository.findAll();
    }

    public ContaCorrente criarContaCorrente(ContaCorrente contaCorrente) {
        return contaCorrenteRepository.save(contaCorrente);
    }

    public ContaCorrente buscarPorId(Long idContaCorrente) {
        return contaCorrenteRepository.findById(idContaCorrente)
                .orElseThrow(() -> new NaoEncontradoException("Conta não existe"));
    }

}
