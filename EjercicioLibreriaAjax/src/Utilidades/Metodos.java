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
				boolean var = false;
        		for (Libro lib: lista) {
        			if (lib.getISBN().equals(milibro.getISBN())) {
        				var = true;
        				resultado = "El ISBN introducido está asociado a otro libro o el libro que introduces ya existe";
        			}
        		}
        		
        		if (!var) {
        			if (milibro.getAutor().length() > 0) {
        				if(milibro.getTitulo().length() > 0) {
        					lista.add(milibro);
        					resultado = "El libro se ha añadido correctamente";
        				} else {
        					resultado = "Introduzca el título del libro";
        				}
        			} else {
        				resultado = "Debe introducir un autor";
        			}
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
