package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3esr.spring_boot_project.domain.instrucao.InstrucaoRepository;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConflitoHorarioInstrutor implements ValidadorAgendamentoInstrucao {
    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Boolean instrutorOcupado = instrucaoRepository.existsByInstrutorIdAndData(dados.idInstrutor(), dados.data());

        if(instrutorOcupado) {
            throw new ValidacaoException("Instrutor ocupada na data e horário informados!");
        }
    }
}