package br.com.rafa.sistemabanco.repository;

import br.com.rafa.sistemabanco.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

}
