package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.curso;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class CursoController {
    private static final Scanner input = new Scanner(System.in);
    private static CursoRepository repository;

    //injeção da dependência para a repository
    public CursoController(CursoRepository repository) {
        CursoController.repository = repository;
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"-------  MENU Curso -------\"");
            System.out.print(
                    """
    
                        1. Inserir novo Curso
                        2. Atualizar um Curso
                        3. Excluir um Curso
                        4. Listar todos os Cursos
                        5. Buscar Curso pelo código
                        6. Buscar Cursos pelo nome
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectTodos();
                case 5 -> selectUsuarioById();
                case 6 -> selectUsurioByNome();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    //opção 1
    private static void inserir() {
        Curso curso = new Curso();
        System.out.println("\n++++++ Cadastro de novo Curso ++++++");
        System.out.print("Digite o nome do Curso: ");
        curso.setNome(input.nextLine());
        System.out.print("\nDigite a sigla do Curso: ");
        curso.setSigla(input.nextLine());
        System.out.println("Curso salvo com sucesso:\n" + repository.save(curso));
    }

    //opção 2
    private static void atualizar() {
        System.out.println("\n++++++ Alterar um Curso ++++++");
        Curso curso;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do Curso (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                curso = repository.getCursoById(codigo);
                if (curso == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Nome: " + curso.getNome());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome do Curso: ");
                        curso.setNome(input.nextLine());
                    }
                    System.out.println("Sigla: " + curso.getSigla());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo sobrenome do Curso: ");
                        curso.setSigla(input.nextLine());
                    }
                    System.out.println("Curso atualizado com sucesso. " + repository.save(curso));
                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    //opção 3
    private static void excluir() {
        System.out.println("\n++++++ Excluir um Curso ++++++");
        Curso curso;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do Curso (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                curso = repository.getCursoById(codigo);
                if (curso == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(curso);
                    System.out.print("Excluir este Curso? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        input.nextLine();
                        repository.delete(curso);
                        System.out.println("Curso excluído com sucesso:" + curso);
                    }

                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    //opção 4
    private static void selectTodos() {
        System.out.println("\nLista de Cursos cadastrados no banco de dados:\n" + repository.findAll());
    }

    //opção 5
    private static void selectUsuarioById() {
        System.out.print("\nDigite o código do Curso: ");
        Curso curso = repository.getCursoById(input.nextLong());
        input.nextLine();
        if (curso != null) {
            System.out.println(curso);
        } else {
            System.out.println("Código não localizado.");
        }
    }

    //opção 6
    private static void selectUsurioByNome() {
        System.out.print("Digite o nome do Curso: ");
        String nome = input.next();
        System.out.println("Chave de pesquisa: " + nome);
        List<Curso> cursos = repository.getCursosByNome("%" + nome + "%");
        if (cursos.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + nome);
        } else {
            System.out.println(cursos);
        }
    }
}
