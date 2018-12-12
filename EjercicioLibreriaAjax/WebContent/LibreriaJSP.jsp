<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script  type="text/javascript">

	function buscarLibro(){
		var opcion = document.getElementById("opcion").value;
		
		if (opcion == 1){
			var datos ='opcion=' + document.getElementById("opcion").value + '&isbn=' + document.getElementById("isbnABuscar").value;
 			var xmlhttp = new XMLHttpRequest();  // objeto XMLHttpRequest
		    xmlhttp.onreadystatechange = function() {
		    	//si el resultado está listo (readyState==4) y la respuesta es correcta (status==200)
		       if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		    	   var respuesta = xmlhttp.responseText;
		    	   document.getElementById("inputTexto").innerHTML = respuesta;
		       }
		    }
		} else if (opcion == 2){
			//opcion 2 --  Recuperar todos los libros
			var datos ='opcion=' + document.getElementById("opcion").value;
			var xmlhttp = new XMLHttpRequest();  // objeto XMLHttpRequest
		    xmlhttp.onreadystatechange = function() {
		    	//si el resultado está listo (readyState==4) y la respuesta es correcta (status==200)
		       if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		    	   var respuesta = xmlhttp.responseText;
		    	   document.getElementById("inputTexto").innerHTML = respuesta;
		       }
		    }
 		} else if (opcion == 3){
 			var datos ='opcion=' + document.getElementById("opcion").value + '&isbn=' + document.getElementById("isbnABuscar").value;
 			var xmlhttp = new XMLHttpRequest();  // objeto XMLHttpRequest
		    xmlhttp.onreadystatechange = function() {
		    	//si el resultado está listo (readyState==4) y la respuesta es correcta (status==200)
		       if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		    	   var respuesta = xmlhttp.responseText;
		    	   document.getElementById("inputTexto").innerHTML = respuesta;
		       }
		    } 			
 		}
		xmlhttp.open("GET","LibreriaServlet?" + datos ,true);  // crea la conexión con parámetros: método, url, asíncrono?
	    xmlhttp.setRequestHeader("X-Requested-With", "xmlhttprequest");  // establece la cabecera HTTP necesaria
	    xmlhttp.send();  // lanza la solicitud
	}
	
	
	function funcionOpciones(){
		var opcion = document.getElementById("opcion").value;
		//opcion 1 = "Recuperar el libro a partir de ISBN"
		if (opcion == 1){
			//Al entrar lo primero limpiamos le div de cosas que pueda haber anteriormente
			document.getElementById("inputTexto").innerHTML = "";

			//creamos un input type text para recoger el ISBN del libro
			var x = document.createElement("input");
			x.setAttribute("type", "text");
			x.setAttribute("id", "isbnABuscar");
			inputTexto.appendChild(x);
			
			//salto entre input y botton
			inputTexto.appendChild(document.createElement("br"));
			inputTexto.appendChild(document.createElement("br"));
			
			//creamos el botón "Buscar" para buscar libro por buscarLibro()
			var y = document.createElement("input");
			y.setAttribute("type", "button");
			y.setAttribute("value", "Buscar libro");
			y.setAttribute("onClick", "buscarLibro();");
			inputTexto.appendChild(y);	
		} else if (opcion == 2) {
			//Al entrar lo primero limpiamos le div de cosas que pueda haber anteriormente
			//document.getElementById("inputTexto").innerHTML = "";
			buscarLibro();
		} else if (opcion == 3) {
			//Al entrar lo primero limpiamos le div de cosas que pueda haber anteriormente
			document.getElementById("inputTexto").innerHTML = "";

			//creamos un input type text para recoger el ISBN del libro
			var x = document.createElement("input");
			x.setAttribute("type", "text");
			x.setAttribute("id", "isbnABuscar");
			inputTexto.appendChild(x);
			
			//salto entre input y botton
			inputTexto.appendChild(document.createElement("br"));
			inputTexto.appendChild(document.createElement("br"));
			
			//creamos el botón "Borrar" para enviar los datos por buscarLibro()
			var y = document.createElement("input");
			y.setAttribute("type", "button");
			y.setAttribute("value", "Borrar libro");
			y.setAttribute("onClick", "buscarLibro();");
			inputTexto.appendChild(y);	
		} else if (opcion == 4){
			//Al entrar lo primero limpiamos le div de cosas que pueda haber anteriormente
			document.getElementById("inputTexto").innerHTML = "";
			
			//creamos un input type text para recoger el ISBN del libro
			var x = document.createElement("input");
			x.setAttribute("type", "text");
			x.setAttribute("id", "isbn");
			inputTexto.appendChild(x);
		
			//creamos el input type text para recoger el titulo
			var y = document.createElement("input");
			y.setAttribute("type", "text");
			y.setAttribute("id", "titulo");
			inputTexto.appendChild(y);
			
			//creamos el input type text para recoger el autor
			var z = document.createElement("input");
			z.setAttribute("type", "text");
			z.setAttribute("id", "autor");
			inputTexto.appendChild(z);
			
			//creamos el input type text para recoger el autor
			var w = document.createElement("input");
			w.setAttribute("type", "text");
			w.setAttribute("id", "ano");
			inputTexto.appendChild(w);
			
			//creamos el botón "Añadir libro" para enviar los datos por buscarLibro()
			var q = document.createElement("input");
			q.setAttribute("type", "button");
			q.setAttribute("value", "Añadir libro");
			q.setAttribute("onClick", "buscarLibro();");
			inputTexto.appendChild(q);
			
		}
	}


</script>

<body align="center">
	<div>
		<h1> Biblioteca </h1>
		Seleccione opción:
			<select id="opcion" size="1" onChange="funcionOpciones();">
			  <option value="0" selected> Selecciona opción...</option>
			  <option value="1">Recuperar el libro a partir de ISBN</option>
			  <option value="2">Recuperar todos los libros de la biblioteca</option>
			  <option value="3">Borrar libro por ISBN</option>
			  <option value="4">Añadir libro</option>
			</select>
			
			</br></br>
			
		<div id="inputTexto"></div>
	</div>
</body>
</html>