package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.Instrucao;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoAntecedencia implements ValidadorCancelamentoInstrucao {

    @Override
    public void validar(Instrucao instrucao) {
        LocalDateTime agora = LocalDateTime.now();
        long antecedenciaEmHoras = Duration.between(agora, instrucao.getData()).toHours();

        if (antecedenciaEmHoras < 24) {
            throw new ValidacaoException("Instrução somente pode ser cancelada com antecedência mínima de 24 horas!");
        }
    }
}