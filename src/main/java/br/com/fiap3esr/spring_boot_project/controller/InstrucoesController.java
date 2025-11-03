package br.com.fiap3esr.spring_boot_project.controller;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.AgendaDeInstrucoes;
import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosDetalhamentoInstrucao;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrucoes")
public class InstrucoesController {

    @Autowired
    private AgendaDeInstrucoes agenda;

    @PostMapping
    public ResponseEntity agendarInstrucao(@RequestBody @Valid DadosAgendamentoInstrucao dados) {
        DadosDetalhamentoInstrucao dto = agenda.agendarInstrucao(dados);
        return ResponseEntity.ok(dto);
    }
}