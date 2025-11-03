package br.com.fiap3esr.spring_boot_project.domain.aluno;

import br.com.fiap3esr.spring_boot_project.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}