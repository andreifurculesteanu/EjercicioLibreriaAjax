package Utilidades;

import java.util.ArrayList;
import java.util.Calendar;

import Objetos.Libro;

public class Metodos {

	/**
	 * M�todo que a�ade libros
	 * @param lista
	 * @param milibro
	 * @return resultado
	 */
	public static String addBook(ArrayList<Libro> lista, Libro milibro) {
		String resultado = " ";
		boolean var = false;
		String reg10 = "^[0-9]{10}$";
		String reg13 = "^[0-9]{13}$";
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		for (Libro lib : lista) {
			if (lib.getISBN().equals(milibro.getISBN())) {
				var = true;
				resultado = "El ISBN introducido est� asociado a otro libro o el libro que introduces ya existe";
			}
		}
		if (!var) {
			if (milibro.getISBN().matches(reg10) || milibro.getISBN().matches(reg13)) {
				if (milibro.getAutor().length() > 0) {
					if (milibro.getTitulo().length() > 0) {
						if (milibro.getAno() != 0) {
							if(milibro.getAno() <= year + 2) {
								lista.add(milibro);
								resultado = "El libro se ha a�adido correctamente";
							} else {
								resultado = "A�o m�ximo: " + year + " + 2";
							}
						}else {
							resultado = "Debe introducir el a�o de publicaci�n";
						}	
					} else {
						resultado = "Debe introducir el t�tulo del libro";
					}
				} else {
					resultado = "Debe introducir un autor";
				}
			} else {
				resultado = "Debe introducir correctamente el ISBN. 10 o 13 car�cteres";
			}
			
		}
		return resultado;
	}

	/**
	 * Metodo de ver todos los libros
	 * @param lista
	 * @return resultado
	 */
	public static String showAllBooks(ArrayList<Libro> lista) {
		String resultado = "";
		for (Libro lib : lista) {
			resultado += lib.toString() + "</br></br>";
		}
		return resultado;
	}

	/**
	 * Metodo que busca libro por ISBN
	 * @param lista
	 * @param isbn
	 * @return resultado
	 */
	public static String showBookByISBN(ArrayList<Libro> lista, String isbn) {
		String resultado = "El libro con ISBN: " + isbn + " no existe";
		for (Libro lib : lista) {
			if (lib.getISBN().equals(isbn)) {
				resultado = lib.toString();
			}
		}
		return resultado;
	}

	/**
	 * Metodo para eliminar libros por ISBN
	 * @param lista
	 * @param isbn
	 * @return resultado
	 */
	public static String deleteBookByISBN(ArrayList<Libro> lista, String isbn) {
		String resultado = "El libro con ISBN: " + isbn + " no existe";
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getISBN().equals(isbn)) {
				lista.remove(i);
				i--;
				resultado = "El libro con ISBN: " + isbn + " se ha eliminado correctamente";
			}
		}
		return resultado;
	}

	/**
	 * M�todo que modifica un libro
	 * 
	 * @param lista
	 * @param milibro
	 * @return resultado
	 */
	public static String modifyBook(ArrayList<Libro> lista, Libro milibro) {
		String resultado = "El libro que quiere modificar no existe";
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (Libro lib : lista) {
			if (lib.getISBN().equals(milibro.getISBN())) {
				if (!milibro.getAutor().equals(lib.getAutor()) && !milibro.getAutor().equals("")) {
					lib.setAutor(milibro.getAutor());
				}
				if (!milibro.getTitulo().equals(lib.getTitulo()) && !milibro.getTitulo().equals("")) {
					lib.setTitulo(milibro.getTitulo());
				}
				if (milibro.getAno() != 0) {
					if(milibro.getAno() <= year + 2) {
						lib.setAno(milibro.getAno());
					} 
				}
				resultado = "El libro se ha modificado correctamente";
			}
		}
		return resultado;
	}
}
