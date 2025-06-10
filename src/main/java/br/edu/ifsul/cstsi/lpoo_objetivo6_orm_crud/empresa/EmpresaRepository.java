package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Empresa entity.
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}