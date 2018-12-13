package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objetos.Libro;
import Utilidades.Metodos;

/**
 * Servlet implementation class LibreriaServlet
 */
@WebServlet("/LibreriaServlet")
public class LibreriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibreriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 
    Libro libro1 = new Libro("9788497594196", "Diario de Ana Frank", "Ana Frank", 1947);
    Libro libro2 = new Libro("9780552172127", "Inferno", "Dan Brown", 2013);
    Libro libro3 = new Libro("9788499890944", "1984", "George Orwell", 1948);
    Libro libro4 = new Libro("9788499890951", "Rebelión en la granja", "George Orwell", 1945);
    
    ArrayList<Libro> biblioteca = new ArrayList<Libro>(Arrays.asList(libro1, libro2, libro3, libro4));
    

    /**
     * Método que procesa la solicitud por Ajax
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void procesaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
    	// Comprobar si la petición es mediante Ajax
    	Boolean esAjax;
        esAjax="XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")); // Cabecera X-Requested-With
        
        if (esAjax) {
        	int opcion = Integer.parseInt(request.getParameter("opcion"));
        	if (opcion == 1) {
        		String isbn = request.getParameter("isbn");
        		String respuesta = Metodos.showBookByISBN(biblioteca, isbn);
        		out.println(respuesta);
        	} else if (opcion == 2) {
        		String respuesta = Metodos.showAllBooks(biblioteca);
        		out.println(respuesta);
        	} else if (opcion == 3) {
        		String isbn = request.getParameter("isbn");
        		String respuesta = Metodos.deleteBookByISBN(biblioteca, isbn);
        		out.println(respuesta);
        	} else if (opcion == 4) {
        		String isbn = request.getParameter("isbn");
        		String autor = request.getParameter("autor");
        		String titulo = request.getParameter("titulo");
        		int ano = 0;
        		if (!request.getParameter("ano").equals("")) {
        			ano = Integer.parseInt(request.getParameter("ano"));
        		}
        		
        		Libro milibro = new Libro(isbn, titulo, autor, ano);
        		
        		String respuesta = Metodos.addBook(biblioteca, milibro);
        		out.println(respuesta);
        	} else if (opcion == 5) {
        		String isbn = request.getParameter("isbn");
        		String autor = request.getParameter("autor");
        		String titulo = request.getParameter("titulo");
        		int ano = 0;
        		if (!request.getParameter("ano").equals("")) {
        			ano = Integer.parseInt(request.getParameter("ano"));
        		}
        		
        		Libro milibro = new Libro(isbn, titulo, autor, ano);
        		
        		String respuesta = Metodos.modifyBook(biblioteca, milibro);
        		out.println(respuesta);
        	}
        } else {
        	out.println("Este servlet solo se puede invocar por Ajax");
        }
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaSolicitud (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaSolicitud (request, response);
	}

}
