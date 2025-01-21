package com.alura.desafio.literalura.principal;

import com.alura.desafio.literalura.model.*;
import com.alura.desafio.literalura.repository.AuthorRepository;
import com.alura.desafio.literalura.repository.BookRepository;
import com.alura.desafio.literalura.service.ConsumoAPI;
import com.alura.desafio.literalura.service.ConvertidorDeDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Principal {

    private final String URL_BASE= "http://gutendex.com/books/";
    private ConsumoAPI consumidor = new ConsumoAPI();
    private ConvertidorDeDatos conversor = new ConvertidorDeDatos();
    private Scanner entrada = new Scanner(System.in);

    @Autowired
    private BookRepository repositorioLibro ;

    @Autowired
    private AuthorRepository repositorioAutor;

    private List<Book> librosRegistrados;

    public void ejecutar() {
        seleccionarOpcionMenu();
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
    }

    public void MostrarYGuardarLibro(){
        List<DataBook> datosLibro = ObtenerDatosDeLibros();
        if(datosLibro.isEmpty()){
            System.out.println("No se encontro el libro");
        } else {
            datosLibro.stream().forEach(db -> {
                Book libro = new Book(db);
                // Asociar autores sin duplicarlos
                List<Author> autores = new ArrayList<>();
                for (DataAuthor da : db.autores()) {
                    // Verificar si el autor ya existe
                    Optional<Author> autorExistente = repositorioAutor.findByNombreContainsIgnoreCase(da.nombre());
                    Author autor;
                    if (autorExistente.isPresent()) {
                        autor = autorExistente.get();
                    } else {
                        autor = new Author(da.nombre(), da.fechaDeNacimiento(), da.fechaDeFallecimiento());
                        repositorioAutor.save(autor);  // Guardar autor nuevo si no existe
                    }
                    autores.add(autor);
                }

                libro.setAutor_es(autores);


                repositorioLibro.save(libro);
                System.out.println(libro);
            } );
        }
        //Book libro = new Book(datosLibro);
       // repositorioLibro.save(libro);
    }

    public List<DataBook> ObtenerDatosDeLibros(){
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        String tituloLibro = entrada.nextLine();
        var json=consumidor.obtenerDatos(URL_BASE+"/?search="+tituloLibro.replace(" ","+").toLowerCase());
        DataBookList datosLibros = conversor.obtenerDatos(json, DataBookList.class);
        return datosLibros.listaDeLibros();
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
        List<Author> autoresRegistrados=repositorioAutor.findAll();
        autoresRegistrados.stream().sorted(Comparator.comparing(Author::getNombre)).forEach(System.out::println);
    }

    public void ListarAutoresVivosSegunAnio(){
        //metodo que trabaja con lo base de datos
        System.out.println("Ingrese el año vivo de autor(es)");
        int anioBuscado=Integer.parseInt(entrada.nextLine());
        Optional<List<Author>> autoresVivosBuscados = repositorioAutor.findByYearAlive(anioBuscado);
        if(autoresVivosBuscados.isPresent()){
            List<Author> autoresVivos = autoresVivosBuscados.get();
            autoresVivos.stream().sorted(Comparator.comparing(Author::getFechaDeNacimiento)).forEach(System.out::println);
        } else{
            System.out.println("\nNo se encontraron autores que se encontraran vivos en el año:"+anioBuscado+"\n");
        }

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
        String abreviaturaIdioma = entrada.nextLine();
        //enviar a repositorio la abreviatura
        List<Book> todosLosLibros = repositorioLibro.findAll();
        List<Book> librosPorIdioma = todosLosLibros.stream()
                .filter(l -> l.getIdioma_s().stream()
                        .anyMatch(i ->i.equalsIgnoreCase(abreviaturaIdioma)))
                .collect(Collectors.toList());
        librosPorIdioma.stream().sorted(Comparator.comparing(Book::getTitulo)).forEach(System.out::println);

    }
}

