package com.lfernando488.msspring.msclientes.application;

import com.lfernando488.msspring.msclientes.domain.Cliente;
import com.lfernando488.msspring.msclientes.infra.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){
        return  clienteRepository.findByCpf(cpf);
    }

    public Optional<Cliente> getById(Long id){
        return  clienteRepository.findById(id);
    }

}
