package Objetos;

import java.util.ArrayList;

public class Libro {
	
	//Propiedades
	String ISBN, titulo, autor;
	int ano;
	
	
	//Constructor
	public Libro(String ISBN, String titulo, String autor, int ano) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}


	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	//Método para añadir un libro
		public String addBook(ArrayList<Libro> lista, Libro milibro) {
			String resultado = " ";
			if(!lista.contains(milibro.getISBN())) {
				lista.add(milibro);
				resultado = "Libro añadido correctamente";
			} else {
				resultado = "Ya existe un libro con ese ISBN";
			}
			return resultado;
		}
	
	
		//Metodo de ver todos los libros
		public String showAllBooks(ArrayList<Libro> lista) {
			String resultado = "";
			for(Libro lib: lista) {
				if (resultado == "") {
					resultado = "ISBN: " + lib.getISBN() + " -- TITULO: " + lib.getTitulo() + " -- AUTOR: " 
							+ lib.getAutor() + " -- Año: " + lib.getAno() + "\n";  
				} else {
					resultado += "ISBN: " + lib.getISBN() + " -- TITULO: " + lib.getTitulo() + " -- AUTOR: " 
							+ lib.getAutor() + " -- Año: " + lib.getAno() + "\n";  
				}
			}
			return resultado;
		}
		
		//Metodo que busca libro por ISBN
		public String showBookByISBN(ArrayList<Libro> lista, String isbn) {
			String resultado = " ";
			for (Libro lib: lista) {
				if(lib.getISBN().equals(isbn)) {
					resultado = "ISBN: " + lib.getISBN() + " -- TITULO: " + lib.getTitulo() + " -- AUTOR: " 
							+ lib.getAutor() + " -- Año: " + lib.getAno() + "\n"; 
				}
			}
			return resultado;
		}
		
		//Metodo para eliminar libros por ISBN
		public String deleteBookByISBN(ArrayList<Libro> lista, String isbn) {
			String resultado = "El libro no existe";
			for (Libro lib: lista) {
				if(lib.getISBN().equals(isbn)) {
					lista.remove(lib);
					resultado = "El libro se ha eliminado correctamente";
				}
			}
			return resultado;
		}
		
		
}
