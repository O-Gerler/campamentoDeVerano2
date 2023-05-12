<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Home</title>
  </head>
  <body class="d-flex justify-content-center align-items-center flex-column">
  	<c:set var="usuario" value="${ requestScope.usuario }"/>
  	<nav class="navbar navbar-expand-lg navbar-light bg-light position-fixed top-0" style="width: 100vw">
	  <div class="container-fluid">
	    <div class="navbar-brand">Campamento</div>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
	      <div class="nav-item dropdown"> 
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
	<div class="d-flex flex-column flex-md-row mt-5 w-100 justify-content-between container gap-3">
		<div class="accordion" id="accordionActividadesGrupos" style="max-height: 100vh;width: 65%">
		<a class="btn btn-primary mb-2" href="InsertarActividadesGrupo">Insertar</a>
		   <h2 class="text-center">Actividades</h2>
	  	   <c:forEach items="${ actividadesPorGrupos }" var="aGrupos">
		    
		    <div class="accordion-item">
		      <h2 class="accordion-header" id="headingOne">
		        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${aGrupos.actividad.id}${aGrupos.grupo.id}${aGrupos.fecha}${aGrupos.hora}" aria-expanded="true" aria-controls="a${aGrupos.actividad.id}${aGrupos.grupo.id}${aGrupos.fecha}${aGrupos.hora}">
		          ${aGrupos.actividad.nombre} -> ${aGrupos.actividad.zona.nombre} //<strong> ${aGrupos.fecha} ${aGrupos.hora}</strong>
		        </button>
		      </h2>
		      <div id="a${aGrupos.actividad.id}${aGrupos.grupo.id}${aGrupos.fecha}${aGrupos.hora}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionActividadesGrupos">
		        <div class="accordion-body">
		          <div>
		            
		          </div>
		          <br><br>
		          <a class="btn btn-danger" href="EliminarCliente?id=${cliente.id}">Eliminar</a>
		        </div>
		      </div>
		      
		    </div>
		    
		  </c:forEach>
		</div>
		<div class="accordion" id="accordionClientes" style="height: 70vh;min-width: 350px;">
		   <h2 class="text-center">Grupo</h2>
	  	   <c:forEach items="${ clientes }" var="cliente">
		    
		    <div class="accordion-item">
		      <h2 class="accordion-header" id="headingOne">
		        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${cliente.id}" aria-expanded="true" aria-controls="a${cliente.id}">
		          ${cliente.dni} - ${cliente.nombre} ${cliente.apellido}
		        </button>
		      </h2>
		      <div id="a${cliente.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionClientes">
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
		          <br><br>
		          <a class="btn btn-danger" href="EliminarCliente?id=${cliente.id}">Eliminar</a>
		        </div>
		      </div>
		      
		    </div>
		    
		  </c:forEach>
		</div>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>