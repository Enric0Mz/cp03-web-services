package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3esr.spring_boot_project.domain.instrucao.InstrucaoRepository;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorLimiteDiarioAluno implements ValidadorAgendamentoInstrucao {
    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime inicioExpediente = dados.data().withHour(6);
        LocalDateTime fimExpediente = dados.data().withHour(21 - 1);
        Boolean alunoReincidenciaDiaria = instrucaoRepository.existsByAlunoIdAndDataBetween(dados.idAluno(), inicioExpediente, fimExpediente);

        if(alunoReincidenciaDiaria) {
            throw new ValidacaoException("Permitido o agendamento diário de apenas uma instrução por aluno!");
        }
    }
}
