package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.usuario;

import br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.curso.Curso;
import br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.empresa.Empresa;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um usuário.
 */
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String nome;
    private String urlFoto;
    @Enumerated(EnumType.STRING)
    private Perfil perfil;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @ManyToMany
    @JoinTable(
        name = "usuario_contatos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "contato_id")
    )
    @ToString.Exclude
    private List<Usuario> contatos = new ArrayList<>();

}
