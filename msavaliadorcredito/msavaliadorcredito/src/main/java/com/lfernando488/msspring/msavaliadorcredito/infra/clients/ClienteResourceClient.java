package com.lfernando488.msspring.msavaliadorcredito.infra.clients;

import com.lfernando488.msspring.msavaliadorcredito.domain.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(url ="http://localhost:8080", path = "/clientes")
@FeignClient(value = "msclientes", path = "/clientes") //usando o balanceamento de carga pelo cloudgateway
public interface ClienteResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> dadosCliente(@RequestParam("cpf") String cpf);

}
