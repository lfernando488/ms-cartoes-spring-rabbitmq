package com.lfernando488.msspring.mscartoes.application.representation;

import com.lfernando488.msspring.mscartoes.domain.BandeiraCartao;
import com.lfernando488.msspring.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}
