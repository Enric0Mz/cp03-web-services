package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3esr.spring_boot_project.domain.instrutor.InstrutorRepository;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorInstrutorAtivo implements ValidadorAgendamentoInstrucao {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor() == null) {
            return;
        }

        Boolean instrutorAtivo = instrutorRepository.findAtivoById(dados.idInstrutor());

        if(!instrutorAtivo) {
            throw new ValidacaoException("Instrução não pode ser agendada com instrutor inativo!");
        }
    }
}