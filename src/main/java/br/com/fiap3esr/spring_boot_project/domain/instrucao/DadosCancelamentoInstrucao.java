package br.com.fiap3esr.spring_boot_project.domain.instrucao;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInstrucao(
    @NotNull
    Long idInstrucao,

    @NotNull
    MotivoCancelamento motivo
) {}