package com.alura.desafio.literalura.principal;

import java.util.Scanner;

public class Principal {

    private Scanner entrada = new Scanner(System.in);

    public void ejecutar() {

    }

    public void imprimirMenu(){
        var menu = """
                    Elija la opción a traves de su numero:
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    
                    0 - Salir
                    """;
        System.out.println(menu);
    }

    public void seleccionarOpcionMenu() {
        var opcion = -1;
        while (opcion != 0) {
            imprimirMenu();
            opcion = entrada.nextInt();
            entrada.nextLine();
        }
        switch (opcion){
            case 1:

            break;
            case 2:

            break;
            case 3:

            break;
            case 4:

            break;
            case 5:

            break;
            case 0:
                System.out.println("Cerrando la aplicación...");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }

    }

}

