package com.lfernando488.msspring.msavaliadorcredito.application;

import com.lfernando488.msspring.msavaliadorcredito.domain.model.CartaoCliente;
import com.lfernando488.msspring.msavaliadorcredito.domain.model.DadosCliente;
import com.lfernando488.msspring.msavaliadorcredito.domain.model.SituacaoCliente;
import com.lfernando488.msspring.msavaliadorcredito.infra.clients.CartoesResourceClient;
import com.lfernando488.msspring.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clienteResourceClient;
    private final CartoesResourceClient cartoesResourceClient;

    public SituacaoCliente obterSituacaoCliente (String cpf){
        ResponseEntity<DadosCliente> dadosClienteResponse = clienteResourceClient.dadosCliente(cpf);
        ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesResourceClient.getCartoesByCliente(cpf);

        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponse.getBody())
                .cartoes(cartoesResponse.getBody())
                .build();
    }

}
