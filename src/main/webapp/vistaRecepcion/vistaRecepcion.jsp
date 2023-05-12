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
	<c:set var="usuario" value="${ requestScope.usuario }"/>
  	<nav class="navbar navbar-expand-lg navbar-light bg-light d-fixed top-0" style="width: 100vw">
	  <div class="container-fluid">
	    <div class="navbar-brand">Campamento</div>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
	      <div class="nav-item dropdown"> 
	      	<a class="btn btn-primary" href="InsertarCliente">Insertar Cliente</a>
	      	<a class="btn btn-primary" href="InsertarReserva">Hacer Reserva</a>
	      </div>
	      <div class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            ${ usuario.nombre } ${ usuario.apellido }
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="MostrarPerfil">Mi Perfil</a></li>
	            <li><a class="dropdown-item" href="MostrarUsuarioVehiculo">Vehiculos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="CerrarSesion">Salir</a></li>
	          </ul>
	      </div>
	    </div>
	  </div>
	</nav>
	<div class="d-flex justify-content-between align-items-center mt-3 container">
		<button id="btnClientes" class="btn btn-primary">Ver Clientes</button>
		<button id="btnReservas" class="btn btn-primary">Ver Reservas</button>
	</div>
	<div class="accordion container mt-3" id="accordionExample">
		<h2 class="text-center mb-3">Clientes</h2>
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
    <div class="accordion container d-none mt-3" id="accordionExample2">
       <h2 class="text-center mb-3">Reservas</h2>
  	   <c:forEach items="${ reservas }" var="reserva">
	    
	    <div class="accordion-item">
	      <h2 class="accordion-header" id="headingOne">
	        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}" aria-expanded="true" aria-controls="a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}">
	          Parcela: ${reserva.parcela.id} - Cliente: ${reserva.usuario.dni} - ${reserva.usuario.nombre} ${reserva.usuario.apellido}
	        </button>
	      </h2>
	      <div id="a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample2">
	        <div class="accordion-body">
	          <strong>Tipo: </strong>${reserva.parcela.tipo.nombre} <br>
	          <strong>Fecha Ingreso: </strong>${reserva.fecha_ingreso} <br>
	          <strong>Fecha Salida: </strong>${reserva.fecha_salida} 
	          <br><br>
	          <a class="btn btn-danger" href="EliminarReserva?id_parcela=${reserva.parcela.id}&id_usuario=${reserva.usuario.id}&fecha_ingreso=${reserva.fecha_ingreso}&fecha_salida=${reserva.fecha_salida}">Eliminar</a>
	        </div>
	      </div>
	      
	    </div>
	    
	  </c:forEach>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script>
		const btnClientes = document.getElementById('btnClientes')
		const btnReservas = document.getElementById('btnReservas')
		const verClientes = document.getElementById('accordionExample')
		const verReservas = document.getElementById('accordionExample2')
		
		btnClientes.addEventListener('click', () => {
  			if (verClientes.classList.contains('d-none')) {
  				verClientes.classList.toggle('d-none')
  				verReservas.classList.toggle('d-none')
  			}
  		})
  		
  		btnReservas.addEventListener('click', () => {
  			if (verReservas.classList.contains('d-none')) {
  				verReservas.classList.toggle('d-none')
  				verClientes.classList.toggle('d-none')
  			}
  		})
	</script>
</body>
</html>