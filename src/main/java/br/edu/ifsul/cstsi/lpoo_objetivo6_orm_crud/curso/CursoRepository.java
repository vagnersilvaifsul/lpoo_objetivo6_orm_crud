package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Curso entity.
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}