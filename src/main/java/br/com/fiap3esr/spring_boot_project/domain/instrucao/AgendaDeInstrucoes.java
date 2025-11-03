package br.com.fiap3esr.spring_boot_project.domain.instrucao;

import br.com.fiap3esr.spring_boot_project.domain.aluno.Aluno;
import br.com.fiap3esr.spring_boot_project.domain.aluno.AlunoRepository;
import br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes.ValidadorAgendamentoInstrucao;
import br.com.fiap3esr.spring_boot_project.domain.instrutor.Instrutor;
import br.com.fiap3esr.spring_boot_project.domain.instrutor.InstrutorRepository;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeInstrucoes {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    InstrutorRepository instrutorRepository;

    @Autowired
    private List<ValidadorAgendamentoInstrucao> validadoresAgendamentoInstrucao;

    @Transactional
    public DadosDetalhamentoInstrucao agendarInstrucao(DadosAgendamentoInstrucao dados) {
        if(!alunoRepository.existsById(dados.idAluno())) {
            throw new ValidacaoException("ID do aluno informado não existe!");
        }

        if(dados.idInstrutor() != null && !instrutorRepository.existsById(dados.idInstrutor())) {
            throw new ValidacaoException("ID do instrutor informado não existe!");
        }

        validadoresAgendamentoInstrucao.forEach(v -> v.validar(dados));

        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());

        Instrutor instrutor = escolherInstrutor(dados);
        if(instrutor == null) {
            throw new ValidacaoException("Não existe instrutor disponível para agendamento na data/hora escolhida!");
        }

        Instrucao instrucao = new Instrucao(null, aluno, instrutor, dados.data());
        instrucaoRepository.save(instrucao);

        return new DadosDetalhamentoInstrucao(instrucao);
    }

    private Instrutor escolherInstrutor(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor() != null) {
            return instrutorRepository.getReferenceById(dados.idInstrutor());
        }

        if(dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatório, quando o instrutor não é informado!");
        }

        return instrutorRepository.escolherInstrutorAleatorioLivreNaData(dados.especialidade(), dados.data());
    }
}