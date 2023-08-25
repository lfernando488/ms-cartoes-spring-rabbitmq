package com.lfernando488.msspring.msavaliadorcredito.application;

import com.lfernando488.msspring.msavaliadorcredito.domain.model.DadosAvaliacao;
import com.lfernando488.msspring.msavaliadorcredito.domain.model.RetornoAvaliacaoCliente;
import com.lfernando488.msspring.msavaliadorcredito.domain.model.SituacaoCliente;
import com.lfernando488.msspring.msavaliadorcredito.ex.DadosClienteNotFoundException;
import com.lfernando488.msspring.msavaliadorcredito.ex.ErroComunicacaoMicroservicesException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("avaliacoes-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String status(){
        return "MS Avaliador crédito ok!";
    }

    @GetMapping(value="situacao-cliente", params="cpf")
    public ResponseEntity consultaSituacaoCliente(@RequestParam("cpf") String cpf){

        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dadosAvaliacao){
        try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliadorCreditoService
                    .realizarAvaliacao(dadosAvaliacao.getCpf(), dadosAvaliacao.getRenda());
            return ResponseEntity.ok(retornoAvaliacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }
}
