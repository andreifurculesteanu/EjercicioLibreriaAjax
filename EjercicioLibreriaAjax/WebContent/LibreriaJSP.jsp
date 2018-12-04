<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script  type="text/javascript">

	function buscarLibro(){
		if (document.getElementById("isbnABuscar").value == null){
			//opcion 2
			
		} else {
			//opcion 1 y 3
			
		}
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
			document.getElementById("inputTexto").innerHTML = "";
			
			buscarLibros();
			
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
			</select>
			
			</br></br>
			
		<div id="inputTexto"></div>
	</div>
</body>
</html>