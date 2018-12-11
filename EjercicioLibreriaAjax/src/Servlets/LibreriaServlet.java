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
    
 
    Libro libro1 = new Libro("1", "Hola mundo", "Pepe Rodriguez", 2001);
    Libro libro2 = new Libro("2", "Hola mundo", "Pepe Rodriguez", 2001);
    Libro libro3 = new Libro("3", "Hola mundo", "Pepe Rodriguez", 2001);
    Libro libro4 = new Libro("4", "Hola mundo", "Pepe Rodriguez", 2001);
    Libro libro5 = new Libro("5", "Hola mundo", "Pepe Rodriguez", 2001);
    
    ArrayList<Libro> biblioteca = new ArrayList<Libro>(Arrays.asList(libro1, libro2, libro3, libro4, libro5));
    

    
    private void procesaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        

    	// Comprobar si la petición es mediante Ajax
    	Boolean esAjax;
        esAjax="XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")); // Cabecera X-Requested-With
        
        if (esAjax) {
        	
        	int opcion = Integer.parseInt(request.getParameter("opcion"));
        	
        	if (opcion == 1) {
        		//String isbn = request.getParameter("isbnABuscar");
        		
        		
        		
        	} else if (opcion == 2) {
        		String respuesta = Libro.showAllBooks(biblioteca);
        		out.println(respuesta);
        	} else if (opcion == 3) {
        		
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
