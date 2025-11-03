package br.com.fiap3esr.spring_boot_project.domain.instrucao;

import br.com.fiap3esr.spring_boot_project.domain.aluno.Aluno;
import br.com.fiap3esr.spring_boot_project.domain.instrutor.Especialidade;
import br.com.fiap3esr.spring_boot_project.domain.instrutor.Instrutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "instrucoes")
@Entity(name = "Instrucao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instrucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    private Boolean ativo;

    public Instrucao(Long id, Aluno aluno, Instrutor instrutor, LocalDateTime data) {
        this.id = id;
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.data = data;
        this.ativo = true;
        this.motivoCancelamento = null;
    }

    public void cancelar(MotivoCancelamento motivo) {
        this.ativo = false;
        this.motivoCancelamento = motivo;
    }
}