package Utilidades;

import java.util.ArrayList;

import Objetos.Libro;

public class Metodos {
	
			/**
			 * Método que añade libros
			 * @param lista
			 * @param milibro
			 * @return
			 */
			public static String addBook(ArrayList<Libro> lista, Libro milibro) {
				String resultado = " ";
				if(!lista.contains(milibro.getISBN())) {
					lista.add(milibro);
					resultado = "Libro añadido correctamente";
				} else {
					resultado = "Ya existe un libro con ese ISBN";
				}
				return resultado;
			}
				
			/**
			 * Metodo de ver todos los libros
			 * @param lista
			 * @return
			 */
			public static String showAllBooks(ArrayList<Libro> lista) {
				String resultado = "";
				for(Libro lib: lista) {
					resultado += "ISBN: " + lib.getISBN() + " -- TITULO: " + lib.getTitulo() + " -- AUTOR: " 
							+ lib.getAutor() + " -- Año: " + lib.getAno() + "<br/>";  
				}
				return resultado;
			}
			
			
			/**
			 * Metodo que busca libro por ISBN
			 * @param lista
			 * @param isbn
			 * @return
			 */
			public static String showBookByISBN(ArrayList<Libro> lista, String isbn) {
				String resultado = "El libro con ISBN: " + isbn + " no existe";
				for (Libro lib: lista) {
					if(lib.getISBN().equals(isbn)) {
						resultado = "ISBN: " + lib.getISBN() + " -- TITULO: " + lib.getTitulo() + " -- AUTOR: " 
								+ lib.getAutor() + " -- Año: " + lib.getAno(); 
					}
				}
				return resultado;
			}
			
		
			/**
			 * Metodo para eliminar libros por ISBN
			 * @param lista
			 * @param isbn
			 * @return
			 */
			public static String deleteBookByISBN(ArrayList<Libro> lista, String isbn) {
				String resultado = "El libro con ISBN: " + isbn + " no existe";
				for (int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getISBN().equals(isbn)) {
						lista.remove(i);
						i--;
						resultado = "El libro con ISBN: "+ isbn + "se ha eliminado correctamente";
					}
				}
				return resultado;
			}
			
}
