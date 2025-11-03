package br.com.fiap3esr.spring_boot_project.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(

        @NotBlank
        String login,

        @NotBlank
        String senha) {
}