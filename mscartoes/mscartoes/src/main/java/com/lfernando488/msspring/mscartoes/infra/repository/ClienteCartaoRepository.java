package com.lfernando488.msspring.mscartoes.infra.repository;

import com.lfernando488.msspring.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {

    List<ClienteCartao> findByCpf (String cpf);

}
