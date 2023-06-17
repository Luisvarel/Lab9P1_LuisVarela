/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_luisvarela;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luis Andres Varela
 */
public class Lab9P1_LuisVarela {

    static Libros m = new Libros();
    static Scanner lea = new Scanner(System.in);
    static ArrayList<Libros> libros = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir1 = true;
        int libros_cantidad = 0;
        while (seguir1) {
            int opcion1 = m.menu();
            switch (opcion1) {

                case 1: {
                    boolean seguir2 = true;
                    while (seguir2) {
                        System.out.println("Elija una opción:");
                        System.out.println("1.Agregar Libro:");
                        System.out.println("2.Listar libros:");
                        System.out.println("3.Modificar libro:");
                        System.out.println("4.Eliminar libro:");
                        System.out.println("5.Buscar libro por titulo:");
                        System.out.println("6.Buscar libros según autor:");
                        System.out.println("7.Búsqueda con filtro de genero:");
                        System.out.println("8.Salir:");
                        int submenu = lea.nextInt();
                        switch (submenu) {
                            case 1: {
                                libros_cantidad++;
                                Agregar_Libro();
                            }
                            break;
                            case 2: {
                                if (libros_cantidad >= 1) {
                                    imprimir();
                                } else {
                                    System.out.println("primero necesita un libro");
                                }
                            }
                            break;
                            case 3: {
                                if (libros_cantidad >= 1) {
                                    int opcionmod = opcion_Modificar();
                                    Modificar_libro(opcionmod);
                                } else {
                                    System.out.println("primero necesita un libro");
                                }
                            }
                            break;
                            case 4: {
                                if (libros_cantidad >= 1) {
                                    int eliminar = eliminar();
                                    libros.remove(eliminar - 1);
                                    libros_cantidad--;
                                } else {
                                    System.out.println("primero necesita un libro");
                                }

                            }
                            break;
                            case 5: {
                                if (libros_cantidad >= 1) {
                                    String titulo_buscar = m.titulo();
                                    busqueda_titulo(titulo_buscar);
                                } else {
                                    System.out.println("primero necesita un libro");
                                }
                            }
                            break;
                            case 6: {
                                if (libros_cantidad >= 1) {
                                    String autor_buscar = m.autor();
                                    busqueda_autor(autor_buscar);
                                } else {
                                    System.out.println("primero necesita un libro");
                                }

                            }
                            break;
                            case 7: {
                                if (libros_cantidad >= 1) {
                                    String genero_buscar = m.genero();
                                    busqueda_genero(genero_buscar);
                                } else {
                                    System.out.println("primero necesita un libro");
                                }

                            }
                            break;
                            case 8: {
                                seguir2 = false;
                            }
                            break;
                            default:
                                System.out.println("Error");
                        }

                    }
                }
                break;
                case 2: {
                    seguir1 = false;
                }
                break;
                default:
                    System.out.println("Error");
            }
        }

        // TODO code application logic here
    }

    public static void Agregar_Libro() {
        System.out.println("Ha elegido la opción para agregar un libro, por favor aporte la información solicitada\n");
        System.out.println("Título:");
        String titulo = lea.next();
        System.out.println("Autor:");
        String autor = lea.next();
        System.out.println("Género:");
        String genero = lea.next();
        System.out.println("Edad mínima:");
        int edad = lea.nextInt();
        Libros m = new Libros(titulo, autor, genero, edad);
        libros.add(m);
        System.out.println("Libro agregado exitosamente!\n");
    }

    public static void imprimir() {
        int num1 = 1;
        Libros a;
        while (num1 <= libros.size()) {
            a = libros.get(num1 - 1);
            System.out.println("Libros Disponibles:\n");
            System.out.println("Libros " + num1);
            System.out.println("Título:\n" + a.getTitulo());
            System.out.println("Autor:\n" + a.getAutor());
            System.out.println("Genero\n" + a.getGenero());
            System.out.println("Edad mínima:\n" + a.getEdad());
            num1++;
        }
    }

    public static int opcion_Modificar() {
        int opcion_mod;
        do {
            System.out.println("Ha ingresado la opción de modificar libros, elija el libro que modificara:");
            imprimir();
            System.out.println("\nIngrese el numero del libro que desea modificar:");
            opcion_mod = lea.nextInt();
        } while (opcion_mod < 1 || opcion_mod > libros.size());
        return opcion_mod;
    }

    public static void Modificar_libro(int opcionmod) {
        Libros a;
        a = libros.get(opcionmod - 1);

        System.out.println("Ha seleccionado el libro " + a.getTitulo() + ",¿qué atributo desea modificar?");
        int especifico;
        do {
            System.out.println("1.Titulo:");
            System.out.println("2.Autor:");
            System.out.println("3.Genero:");
            System.out.println("4.Edad Minima:");
            especifico = lea.nextInt();
        } while (especifico < 1 || especifico > 4);
        switch (especifico) {
            case 1: {
                System.out.println("Modificara el Titulo del libro, ingrese un nuevo titulo:");
                String titulo = lea.next();
                a.setTitulo(titulo);
                System.out.println("¡Libro modificado exitosamente!");
            }
            break;
            case 2: {
                System.out.println("Modificara el Autor del libro, ingrese un nuevo Autor:");
                String Autor = lea.next();
                a.setAutor(Autor);
                System.out.println("¡Libro modificado exitosamente!");

            }
            break;
            case 3: {
                System.out.println("Modificara el Genero del libro, ingrese un nuevo genero:");
                String genero = lea.next();
                a.setGenero(genero);
                System.out.println("¡Libro modificado exitosamente!");

            }
            break;
            case 4: {
                System.out.println("Modificara el edad minima del libro, ingrese un nuevo edad minima:");
                int edad = lea.nextInt();
                a.setEdad(edad);
                System.out.println("¡Libro modificado exitosamente!");
            }
            break;
        }
        libros.set(opcionmod - 1, a);
    }

    public static int eliminar() {
        int eliminar;
        do {
            System.out.println("Ha ingresado la opción de eliminar libros, elija el libro que decea eliminar:");
            imprimir();
            eliminar = lea.nextInt();
        } while (eliminar < 1 || eliminar > libros.size());
        return eliminar;
    }

    public static void busqueda_titulo(String titulo_buscar) {
        int contador = 1;
        int contador2 = 0;
        Libros a;
        while (contador <= libros.size()) {
            a = libros.get(contador - 1);
            if (a.getTitulo().equalsIgnoreCase(titulo_buscar)) {
                System.out.println("Libros Disponibles:\n");
                System.out.println("Libros " + contador);
                System.out.println("Título:\n" + a.getTitulo());
                System.out.println("Autor:\n" + a.getAutor());
                System.out.println("Genero\n" + a.getGenero());
                System.out.println("Edad mínima:\n" + a.getEdad());
                contador2++;
            }
            contador++;
        }
        if (contador2 == 0) {
            System.out.println("No se encontro ninguno libro con estas caracteristicas");
        }
    }

    public static void busqueda_autor(String autor_buscar) {
        int contador = 1;
        int contador2 = 0;
        Libros a;
        while (contador <= libros.size()) {
            a = libros.get(contador - 1);
            if (a.getAutor().equalsIgnoreCase(autor_buscar)) {
                System.out.println("Libros Disponibles:\n");
                System.out.println("Libros " + contador);
                System.out.println("Título:\n" + a.getTitulo());
                System.out.println("Autor:\n" + a.getAutor());
                System.out.println("Genero\n" + a.getGenero());
                System.out.println("Edad mínima:\n" + a.getEdad());
                contador2++;
            }
            contador++;
        }
        if (contador2 == 0) {
            System.out.println("No se encontro ninguno libro con estas caracteristicas");
        }
    }

    public static void busqueda_genero(String genero_buscar) {
        int contador = 1;
        int contador2 = 0;
        Libros a;
        while (contador <= libros.size()) {
            a = libros.get(contador - 1);
            if (a.getGenero().equalsIgnoreCase(genero_buscar)) {
                System.out.println("Libros Disponibles:\n");
                System.out.println("Libros " + contador);
                System.out.println("Título:\n" + a.getTitulo());
                System.out.println("Autor:\n" + a.getAutor());
                System.out.println("Genero\n" + a.getGenero());
                System.out.println("Edad mínima:\n" + a.getEdad());
                contador2++;
            }
            contador++;
        }
        if (contador2 == 0) {
            System.out.println("No se encontro ninguno libro con estas caracteristicas");
        }
    }
}
