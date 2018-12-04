package Objetos;

import java.util.ArrayList;
import java.util.Arrays;

public class Biblioteca {
	
	Libro libro1 = new Libro("1", "Fuego y Sangre", "George RR Martin", 2012);
	Libro libro2 = new Libro("2", "Reina Roja", "Juan Gomez-Jurado", 2014);
	Libro libro3 = new Libro("3", "1000 Recetas de oro", "Karlos Arguiñano", 2018);
	Libro libro4 = new Libro("4", "A que sabe la luna", "Michael Greniec", 1999);
	Libro libro5 = new Libro("5", "La ovejita que vino a cenar", "Steve Smallman", 2005);
	
	ArrayList<Libro> miBiblioteca = new ArrayList<Libro>(Arrays.asList(libro1, libro2, libro3, libro4, libro5));
	

	
	
	
}
