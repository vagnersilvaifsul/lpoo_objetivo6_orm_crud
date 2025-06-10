package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Usuario entity.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}