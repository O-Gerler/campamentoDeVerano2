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
	<a class="btn btn-primary" href="InsertarCliente">Insertar</a>
	 <div class="accordion" id="accordionExample">
  	   <c:forEach items="${ clientes }" var="cliente">
	    
	    <div class="accordion-item">
	      <h2 class="accordion-header" id="headingOne">
	        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${cliente.id}" aria-expanded="true" aria-controls="a${cliente.id}">
	          ${cliente.dni}
	        </button>
	      </h2>
	      <div id="a${cliente.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
	        <div class="accordion-body">
	          <div>
	            <h3>Cliente</h3>
	            <strong>Nombre:</strong> ${ cliente.nombre }<br>
	            <strong>Apellido:</strong> ${ cliente.apellido } <br>
	            <strong>DNI:</strong> ${ cliente.dni } <br>
	            <strong>email:</strong> ${ cliente.email } <br>
	            <strong>Telefono:</strong> ${ cliente.telefono } <br>
	            <strong>Fecha nacimiento:</strong> ${ cliente.fechaNacimiento }
	          </div>
	          <div>
	          	<br>
	            <h3>Grupo</h3>
	            <strong>Numero:</strong> ${ cliente.grupo.id }<br>
	          </div>
	          <div>
	            <br>
	            <h3>Monitor</h3>
	            <strong>Nombre:</strong> ${ cliente.grupo.monitor.nombre } ${ cliente.grupo.monitor.apellido }<br>
	          </div>
	          <div>
	          	<br>
	            <h3>Mascotas</h3>
	            <c:forEach items="${ cliente.mascotas }" var="mascota">
	              <strong>Numero:</strong> ${ mascota.nombre }<br>
	              <strong>Raza:</strong> ${ mascota.raza } <br>
	          	  <strong>Numero del chip:</strong> ${ mascota.numChip } <br><br>
	            </c:forEach>
	          </div>
	          <div>
	            <h3>Vehiculo</h3>
	          	<c:forEach items="${ cliente.vehiculos }" var="vehiculo">
	              <strong>Matricula:</strong> ${ vehiculo.matricula }<br>
	              <strong>Marca:</strong> ${ vehiculo.marca } <br>
	          	  <strong>Modelo:</strong> ${ vehiculo.modelo } <br>
	          	  <strong>Color:</strong> ${ vehiculo.color }
	            </c:forEach>
	          </div>
	          <br><br>
	          <a class="btn btn-primary" href="ModificarCliente?id=${cliente.id}">Modificar</a>
	          <a class="btn btn-danger" href="EliminarCliente?id=${cliente.id}">Eliminar</a>
	        </div>
	      </div>
	      
	    </div>
	    
	  </c:forEach>
	</div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>