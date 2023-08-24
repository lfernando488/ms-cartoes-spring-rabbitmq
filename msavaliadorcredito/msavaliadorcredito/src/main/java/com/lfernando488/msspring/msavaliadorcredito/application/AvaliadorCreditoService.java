package com.lfernando488.msspring.msavaliadorcredito.application;

import com.lfernando488.msspring.msavaliadorcredito.domain.model.DadosCliente;
import com.lfernando488.msspring.msavaliadorcredito.domain.model.SituacaoCliente;
import com.lfernando488.msspring.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clienteResourceClient;

    public SituacaoCliente obterSituacaoCliente (String cpf){
        ResponseEntity<DadosCliente> dadosClienteResponse = clienteResourceClient.dadosCliente(cpf);
        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponse.getBody())
                .build();
    }

}
