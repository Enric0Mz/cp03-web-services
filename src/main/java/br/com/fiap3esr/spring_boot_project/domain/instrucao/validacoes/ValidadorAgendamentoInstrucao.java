package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosAgendamentoInstrucao;

public interface ValidadorAgendamentoInstrucao {
    void validar(DadosAgendamentoInstrucao dados);
}