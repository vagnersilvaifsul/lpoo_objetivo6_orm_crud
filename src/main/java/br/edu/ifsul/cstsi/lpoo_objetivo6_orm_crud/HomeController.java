package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud;

import br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.curso.CursoController;
import br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.empresa.EmpresaController;
import br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.usuario.UsuarioController;

import java.util.Scanner;

public class HomeController {
	
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao;
		do {
			System.out.print("\n-------  Home -------");
			System.out.print(
				"""

					1. Manter Curso
					2. Manter Empresa
					3. Manter Usuario
					Opção (Zero p/sair):\s""");
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
				case 1 -> CursoController.main(null);
				case 2 -> EmpresaController.main(null);
				case 3 -> UsuarioController.main(null);
				default -> {
					if (opcao != 0) System.out.println("Opção inválida.");
				}
			}
		} while(opcao != 0) ;
		System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
		input.close(); //libera o recurso
	}

}//fim classe
