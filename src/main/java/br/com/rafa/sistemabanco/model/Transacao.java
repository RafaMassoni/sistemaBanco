package br.com.rafa.sistemabanco.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal valor;

    private LocalDateTime data;


    @NotNull
    @Column(name = "ID_CONTA", nullable = false)
    private Long idConta;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CONTA", insertable = false, updatable = false)
    private ContaCorrente Conta;



}