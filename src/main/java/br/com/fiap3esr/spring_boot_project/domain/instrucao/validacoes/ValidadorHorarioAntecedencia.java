package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoInstrucao {
    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataInstrucao = dados.data();
        LocalDateTime agora = LocalDateTime.now();

        Long antecedencia = Duration.between(agora, dataInstrucao).toMinutes();

        if(antecedencia < 30) {
            throw new ValidacaoException("Instrução deve ser agendada com antecedência mínima de 30 minutos!");
        }
    }
}