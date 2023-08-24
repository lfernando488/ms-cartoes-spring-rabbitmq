package com.lfernando488.msspring.mscartoes.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Table(name = "CLIENTE_CARTAO")
@Data
public class ClienteCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CPF")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "ID_CARTAO")
    private Cartao cartao;

    @Column(name = "LIMITE")
    private BigDecimal limite;
}
