<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
</head>
<body>
	<a class="btn btn-primary" href="InsertarUsuario">Insertar</a>
	 <div class="accordion" id="accordionExample">
  	   <c:forEach items="${ usuarios }" var="usuario">
	    
	    <div class="accordion-item">
	      <h2 class="accordion-header" id="headingOne">
	        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${usuario.id}" aria-expanded="true" aria-controls="a${usuario.id}">
	          ${usuario.nombre}
	        </button>
	      </h2>
	      <div id="a${usuario.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
	        <div class="accordion-body">
	          <strong>Nombre:</strong> ${ usuario.nombre } <br>
	          <strong>Apellido:</strong> ${ usuario.apellido } <br>
	          <strong>DNI:</strong> ${ usuario.dni } <br>
	          <strong>email:</strong> ${ usuario.email } <br>
	          <strong>Telefono:</strong> ${ usuario.telefono } <br>
	          <strong>Fecha nacimiento:</strong> ${ usuario.fechaNacimiento } <br>
	          <strong>Vehiculos:</strong> ${ usuario.dni } <br>
	          <br><br>
	          <a class="btn btn-primary" href="ModificarUsuario?id=${usuario.id}">Modificar</a>
	          <a class="btn btn-danger" href="EliminarUsuario?id=${usuario.id}">Eliminar</a>
	        </div>
	      </div>
	      
	    </div>
	    
	  </c:forEach>
	</div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>