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
	<a class="btn btn-primary" href="InsertarVehiculo">Insertar</a>
	 <div class="accordion" id="accordionExample">
  	   <c:forEach items="${ vehiculos }" var="vehiculo">
	    
	    <div class="accordion-item">
	      <h2 class="accordion-header" id="headingOne">
	        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${vehiculo.id}" aria-expanded="true" aria-controls="a${vehiculo.id}">
	          ${vehiculo.matricula}
	        </button>
	      </h2>
	      <div id="a${vehiculo.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
	        <div class="accordion-body">
	          <strong>Marca:</strong> ${ vehiculo.marca } <br>
	          <strong>Modelo:</strong> ${ vehiculo.modelo } <br>
	          <strong>Color:</strong> ${ vehiculo.color }
	          <br><br>
	          <a class="btn btn-primary" href="ModificarVehiculo?id=${vehiculo.id}">Modificar</a>
	          <a class="btn btn-danger" href="EliminarVehiculo?id=${vehiculo.id}">Eliminar</a>
	        </div>
	      </div>
	      
	    </div>
	    
	  </c:forEach>
	</div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>