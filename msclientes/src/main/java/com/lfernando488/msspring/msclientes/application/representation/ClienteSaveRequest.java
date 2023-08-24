package com.lfernando488.msspring.msclientes.application.representation;

import com.lfernando488.msspring.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {

    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel (){
        return new Cliente(cpf, nome, idade);
    }

}
