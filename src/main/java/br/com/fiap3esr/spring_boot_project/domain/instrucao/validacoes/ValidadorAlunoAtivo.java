package br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes;

import br.com.fiap3esr.spring_boot_project.domain.aluno.AlunoRepository;
import br.com.fiap3esr.spring_boot_project.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlunoAtivo implements ValidadorAgendamentoInstrucao {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Boolean alunoAtivo = alunoRepository.findAtivoById(dados.idAluno());

        if(!alunoAtivo) {
            throw new ValidacaoException("Instrução não pode ser agendada para aluno inativo!");
        }
    }
}