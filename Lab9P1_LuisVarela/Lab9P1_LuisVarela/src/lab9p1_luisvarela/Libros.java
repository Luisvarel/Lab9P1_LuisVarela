/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_luisvarela;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Luis Andres Varela
 */
public class Libros {

    static Scanner lea = new Scanner(System.in);

    private String titulo;
    private String autor;
    private String genero;
    private int edad;
    int largo;

    public Libros() {

    }

    public int getlargo() {
        return largo;
    }

    public Libros(String titulo, String autor, String genero, int edad) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.edad = edad;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int menu() {
        System.out.println("Elija una opción:");
        System.out.println("1.Libros y más Libros REMASTERED ");
        System.out.println("2.Salir");
        int opcion1 = lea.nextInt();
        return opcion1;
    }

    public String genero() {
        String genero_buscar = "";
        System.out.println("Ha ingresado la opción de busqueda segun genero: ");
        System.out.println("Ingrese el genero del libro");
        genero_buscar = lea.next();
        return genero_buscar;
    }

    public String autor() {
        String autor_buscar = "";
        System.out.println("Ha ingresado la opción de busqueda segun autor: ");
        System.out.println("Ingrese el autor del libro");
        autor_buscar = lea.next();
        return autor_buscar;
    }

    public String titulo() {
        String titulo_buscar = "";
        System.out.println("Ha ingresado la opción de busqueda segun titulo: ");
        System.out.println("Ingrese el titulo del libro");
        titulo_buscar = lea.next();
        return titulo_buscar;
    }
}
