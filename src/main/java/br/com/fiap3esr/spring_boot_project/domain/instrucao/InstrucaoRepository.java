package br.com.fiap3esr.spring_boot_project.domain.instrucao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {
    Boolean existsByInstrutorIdAndData(Long id, LocalDateTime data);

    Boolean existsByAlunoIdAndDataBetween(Long id, LocalDateTime inicioExpediente, LocalDateTime fimExpediente);
}