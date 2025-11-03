package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.Instrucao;

public interface ValidadorCancelamentoInstrucao {
    void validar(Instrucao instrucao);
}