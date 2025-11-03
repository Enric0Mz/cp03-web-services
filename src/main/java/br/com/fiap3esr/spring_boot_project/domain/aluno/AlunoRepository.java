package br.com.fiap3esr.spring_boot_project.domain.aluno;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
                select e.ativo
                from Aluno e
                where
                e.id = :id
    """)
    Boolean findAtivoById(Long id);
}