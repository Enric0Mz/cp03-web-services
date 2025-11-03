package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamentoInstrucao {
    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataInstrucao = dados.data();

        Boolean domingo = dataInstrucao.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        Boolean preAbertura = dataInstrucao.getHour() < 6;
        Boolean posFechamento = dataInstrucao.getHour() > (21 - 1);

        if(domingo || preAbertura || posFechamento) {
            throw new ValidacaoException("Tentativa de agendamento de instrução fora do horário de funcionamento da auto-escola!");
        }
    }
}