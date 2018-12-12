package Objetos;

import java.util.ArrayList;

public class Libro {
	
	/**
	 * Propiedades
	 * String: ISBN, titulo, autor
	 * int: ano
	 */
	String ISBN, titulo, autor;
	int ano;
	
	
	/**
	 * Constructor Libro
	 * @param ISBN
	 * @param titulo
	 * @param autor
	 * @param ano
	 */
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
	
	
	
		
}
