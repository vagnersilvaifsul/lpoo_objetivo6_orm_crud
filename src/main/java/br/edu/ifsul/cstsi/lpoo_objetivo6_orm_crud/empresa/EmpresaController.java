package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud.empresa;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class EmpresaController {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Empresa CRUD");
        input.nextLine();
    }
}
