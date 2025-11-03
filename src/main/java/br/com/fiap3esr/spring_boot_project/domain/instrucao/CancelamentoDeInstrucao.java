package br.com.fiap3esr.spring_boot_project.domain.instrucao;

import br.com.fiap3esr.spring_boot_project.domain.instrucao.validacoes.ValidadorCancelamentoInstrucao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap3esr.spring_boot_project.infra.exception.ValidacaoException; 


import java.util.List;

@Service
public class CancelamentoDeInstrucao {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private List<ValidadorCancelamentoInstrucao> validadores;

    @Transactional
    public void cancelar(DadosCancelamentoInstrucao dados) {
        if (!instrucaoRepository.existsById(dados.idInstrucao())) {
            throw new ValidacaoException("ID da instrução informado não existe!");
        }

        Instrucao instrucao = instrucaoRepository.getReferenceById(dados.idInstrucao());

        validadores.forEach(v -> v.validar(instrucao));

        instrucao.cancelar(dados.motivo());
    }
}