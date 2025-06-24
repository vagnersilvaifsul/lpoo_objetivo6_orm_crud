package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.empresa;

import br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma empresa.
 */
@Entity
@Table(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tecnologias;
    private String endereco;
    private Double latitude;
    private Double longitude;
    private String urlLogo;
    @OneToMany(mappedBy = "empresa", fetch =  FetchType.LAZY)
    @ToString.Exclude
    private List<Usuario> usuarios = new ArrayList<>();
}
