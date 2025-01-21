package com.alura.desafio.literalura.principal;

import com.alura.desafio.literalura.model.Book;
import com.alura.desafio.literalura.model.DataBook;
import com.alura.desafio.literalura.repository.BookRepository;
import com.alura.desafio.literalura.service.ConsumoAPI;
import com.alura.desafio.literalura.service.ConvertidorDeDatos;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final String URL_BASE= "http://gutendex.com/books/";
    private ConsumoAPI consumidor = new ConsumoAPI();
    private ConvertidorDeDatos conversor = new ConvertidorDeDatos();
    private Scanner entrada = new Scanner(System.in);
    private BookRepository repositorioLibro;
    private List<Book> librosRegistrados;

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
                MostrarYGuardarLibro();
            break;
            case 2:
                ListarLibrosRegistrados();
            break;
            case 3:
                ListarAutoresRegistrados();
            break;
            case 4:
                ListarAutoresVivosSegunAnio();
            break;
            case 5:
                ListarLibrosPorIdioma();
            break;
            case 0:
                System.out.println("Cerrando la aplicación...");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }

    }

    public void MostrarYGuardarLibro(){
        DataBook datosLibro = ObtenerDatosDeUnLibro();
        Book libro = new Book(datosLibro);
        repositorioLibro.save(libro);
    }

    public DataBook ObtenerDatosDeUnLibro(){
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        String tituloLibro = entrada.nextLine();
        var json=consumidor.obtenerDatos(URL_BASE+"/?search="+tituloLibro.replace(" ","+"));
        DataBook datosLibro = conversor.obtenerDatos(json, DataBook.class);
        return datosLibro;
        //tener libros.stream y eso
        //Buscar
        //sino encuentra que devuelva el mensaje Libro no encontrado
    }
    public void ListarLibrosRegistrados(){
        //metodo que trabaja con lo base de datos
        librosRegistrados = repositorioLibro.findAll();
        librosRegistrados.stream().sorted(Comparator.comparing(Book::getTitulo)).forEach(System.out::println);
    }
    public void ListarAutoresRegistrados(){
        //metodo que trabaja con lo base de datos
        autoresRegistrados=repositorioAutor.findAll();
    }
    public void ListarAutoresVivosSegunAnio(){
        //metodo que trabaja con lo base de datos
    }
    public void ListarLibrosPorIdioma(){
        System.out.println("Ingrese el idioma para buscar los libros");
        var submenu = """ 
                es - español
                en - ingles
                fr - frances
                pt - portugues
                """;
        System.out.println(submenu);
        String abreviatura = entrada.nextLine();
        //enviar a repositorio la abreviatura

    }
}

