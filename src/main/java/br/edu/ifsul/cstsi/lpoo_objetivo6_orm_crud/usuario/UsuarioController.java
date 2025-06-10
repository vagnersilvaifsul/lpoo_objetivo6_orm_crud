package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.usuario;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class UsuarioController {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Usuario CRUD");
        input.nextLine();
    }
}
