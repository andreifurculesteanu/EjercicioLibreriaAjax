<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestionar biblioteca</title>
	<script type="text/javascript">
		
	function buscarLibro(){
			var opcion = document.getElementById("opcion").value;
			
			if (opcion == 1 || opcion == 3){
				var datos ='opcion=' + document.getElementById("opcion").value + '&isbn=' + document.getElementById("isbnABuscar").value;
			} else if (opcion == 2){
				//opcion 2 --  Recuperar todos los libros
				var datos ='opcion=' + document.getElementById("opcion").value;
	 		} else if (opcion == 4 || opcion == 5){
	 			var datos ='opcion=' + document.getElementById("opcion").value + 
	 						'&isbn=' + document.getElementById("isbn").value + 
	 						'&titulo=' + document.getElementById("titulo").value + 
	 						'&autor=' + document.getElementById("autor").value + 
	 						'&ano=' + document.getElementById("ano").value;
	 		} 
			
			var xmlhttp = new XMLHttpRequest();  // objeto XMLHttpRequest
		    xmlhttp.onreadystatechange = function() {
		    	//si el resultado está listo (readyState==4) y la respuesta es correcta (status==200)
		       if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		    	   var respuesta = xmlhttp.responseText; 
		    	   if (opcion == 1 || opcion == 3){
		    		   document.getElementById("isbnABuscar").value="";
		    	   } else if (opcion == 4 || opcion == 5){
		    		   document.getElementById("isbn").value="";
		    		   document.getElementById("titulo").value="";
		    		   document.getElementById("autor").value="";
		    		   document.getElementById("ano").value="";
		    	   }
		    	   document.getElementById("mostrar").innerHTML = respuesta;
		       }
		    }
			
			xmlhttp.open("GET","LibreriaServlet?" + datos ,true);  // crea la conexión con parámetros: método, url, asíncrono?
		    xmlhttp.setRequestHeader("X-Requested-With", "xmlhttprequest");  // establece la cabecera HTTP necesaria
		    xmlhttp.send();  // lanza la solicitud
		}
		
		/* Método que género los input para las diferentes opciones seleccionadas*/
		function funcionOpciones(){
			var opcion = document.getElementById("opcion").value;
			//opcion 1 = "Recuperar el libro a partir de ISBN"
			//opcion 3 = "Borrar libro a partir de un ISBN"
			if (opcion == 1 || opcion == 3){
				//Al entrar lo primero limpiamos los div de cosas que pueda haber anteriormente
				document.getElementById("inputTexto").innerHTML = "";
				document.getElementById("mostrar").innerHTML = "";
				
				//creamos un input type text para recoger el ISBN del libro
				var x = document.createElement("input");
				x.setAttribute("type", "text");
				x.setAttribute("id", "isbnABuscar");
				x.setAttribute("placeholder", "Introduzca ISBN");
				inputTexto.appendChild(x);
				
				//salto entre input y botton
				inputTexto.appendChild(document.createElement("br"));
				inputTexto.appendChild(document.createElement("br"));
				
				if (opcion == 1){
					//creamos el botón "Buscar" para buscar libro por buscarLibro()
					var y = document.createElement("input");
					y.setAttribute("type", "button");
					y.setAttribute("id", "boton");
					y.setAttribute("value", "Buscar libro");
					y.setAttribute("onClick", "buscarLibro();");
					inputTexto.appendChild(y);	
				} else if (opcion == 3){
					//creamos el botón "Borrar" para enviar los datos por buscarLibro()
					var y = document.createElement("input");
					y.setAttribute("type", "button");
					y.setAttribute("id", "boton");
					y.setAttribute("value", "Borrar libro");
					y.setAttribute("onClick", "buscarLibro();");
					inputTexto.appendChild(y);	
				}
			} else if (opcion == 2) {
				//Al entrar lo primero limpiamos los div de cosas que pueda haber anteriormente
				document.getElementById("inputTexto").innerHTML = "";
				document.getElementById("mostrar").innerHTML = "";
				buscarLibro();
			} else if (opcion == 4 || opcion == 5) {
				//opcion 4 = "Añadir libro"
				//opcion 5 = "Modificar libro"
				
				//Al entrar lo primero limpiamos los div de cosas que pueda haber anteriormente
				document.getElementById("inputTexto").innerHTML = "";
				document.getElementById("mostrar").innerHTML = "";
				//creamos un input type text para recoger el ISBN del libro
				var x = document.createElement("input");
				x.setAttribute("type", "text");
				x.setAttribute("id", "isbn");
				x.setAttribute("placeholder", "Introduzca ISBN");
				inputTexto.appendChild(x);
				
				//salto entre input y botton
				inputTexto.appendChild(document.createElement("br"));
				inputTexto.appendChild(document.createElement("br"));
				
				//creamos el input type text para recoger el titulo
				var y = document.createElement("input");
				y.setAttribute("type", "text");
				y.setAttribute("id", "titulo");
				y.setAttribute("placeholder", "Introduzca titulo");
				inputTexto.appendChild(y);
				
				//salto entre input y botton
				inputTexto.appendChild(document.createElement("br"));
				inputTexto.appendChild(document.createElement("br"));
				
				//creamos el input type text para recoger el autor
				var z = document.createElement("input");
				z.setAttribute("type", "text");
				z.setAttribute("id", "autor");
				z.setAttribute("placeholder", "Introduzca autor");
				inputTexto.appendChild(z);
				
				//salto entre input y botton
				inputTexto.appendChild(document.createElement("br"));
				inputTexto.appendChild(document.createElement("br"));
				
				//creamos el input type text para recoger el autor
				var w = document.createElement("input");
				w.setAttribute("type", "text");
				w.setAttribute("id", "ano");
				w.setAttribute("placeholder", "Introduzca año");
				inputTexto.appendChild(w);
				
				//salto entre input y botton
				inputTexto.appendChild(document.createElement("br"));
				inputTexto.appendChild(document.createElement("br"));
				
				if (opcion == 4){
					//creamos el botón "Añadir libro" para enviar los datos por buscarLibro()
					var q = document.createElement("input");
					q.setAttribute("type", "button");
					q.setAttribute("id", "boton");
					q.setAttribute("value", "Añadir libro");
					q.setAttribute("onClick", "buscarLibro();");
					inputTexto.appendChild(q);
				} else if (opcion == 5) {
					//creamos el botón "Añadir libro" para enviar los datos por buscarLibro()
					var q = document.createElement("input");
					q.setAttribute("type", "button");
					q.setAttribute("id", "boton");
					q.setAttribute("value", "Modificar libro");
					q.setAttribute("onClick", "buscarLibro();");
					inputTexto.appendChild(q);
				}
			} else if (opcion == 0){
				document.getElementById("inputTexto").innerHTML = "";
				document.getElementById("mostrar").innerHTML = "";
			}
		}
		
		document.addEventListener("keyup", intro);
		
		function intro(evento){
			if (evento.which == 13){
				document.getElementById("boton").click();
			}
		}
	</script>
	
	<style type="text/css">
		#principal {
			background-color: #F7E4C0;
			border: 2px solid black;
		  	border-radius: 25px;
		  	margin: auto;
		  	padding: 10%;
		  	width: 60%;
		  	height: 25%;
		  	align-content: center;
		}
	</style>
</head>
<body align="center">
	<div id="principal">
		<h1> Biblioteca </h1>
		Seleccione opción:
		</br></br>
			<select id="opcion" size="1" onChange="funcionOpciones();">
			  <option value="0" selected> Selecciona opción...</option>
			  <option value="1">Recuperar el libro a partir de ISBN</option>
			  <option value="2">Recuperar todos los libros de la biblioteca</option>
			  <option value="3">Borrar libro por ISBN</option>
			  <option value="4">Añadir libro</option>
			  <option value="5">Modificar libro</option>
			</select>
			
		</br></br>
			
		<div id="inputTexto"></div>
		
		</br></br>
		
		<div id="mostrar"></div>
		
	</div>
</body>
</html>