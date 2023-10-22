package br.com.rafa.sistemabanco.repository;

import br.com.rafa.sistemabanco.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
