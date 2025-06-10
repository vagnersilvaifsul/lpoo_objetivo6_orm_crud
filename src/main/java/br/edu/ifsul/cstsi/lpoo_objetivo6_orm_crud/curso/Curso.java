package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.curso;

import br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um curso.
 */
@Entity
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    @OneToMany(mappedBy = "curso")
    @ToString.Exclude
    private List<Usuario> usuarios = new ArrayList<>();
}
