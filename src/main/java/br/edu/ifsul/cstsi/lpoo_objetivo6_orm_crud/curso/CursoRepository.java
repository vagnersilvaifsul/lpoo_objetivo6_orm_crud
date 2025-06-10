package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Curso entity.
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso getCursoById(Long id);

    @Query(value = "SELECT c FROM Curso c where c.nome like ?1")
    List<Curso> getCursosByNome(String nome);
}