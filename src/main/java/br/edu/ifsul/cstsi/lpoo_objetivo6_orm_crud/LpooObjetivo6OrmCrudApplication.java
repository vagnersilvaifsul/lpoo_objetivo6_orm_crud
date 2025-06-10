package br.edu.ifsul.cstsi.lpoo_objetivo6_orm_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LpooObjetivo6OrmCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpooObjetivo6OrmCrudApplication.class, args);
        HomeController.main(null);
    }

}
