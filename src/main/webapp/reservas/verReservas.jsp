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
	<c:if test="${ sessionScope.usuario == null }">
	  <a class="btn btn-primary" href="InsertarReserva">Insertar</a>
	</c:if>
	<c:if test="${ sessionScope.usuario != null }">
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
		      	<a class="nav-link btn btn-warning" href="InsertarReserva">Reservar</a>
		      </div>
		      <div class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            ${ usuario.nombre } ${ usuario.apellido }
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <li><a class="dropdown-item" href="VistaUsuario">Home</a></li>
		            <li><a class="dropdown-item" href="MostrarPerfil">Mi Perfil</a></li>
		            <li><a class="dropdown-item" href="MostrarReservas">Mis Reservas</a></li>
		            <li><a class="dropdown-item" href="MostrarUsuarioVehiculo">Vehiculos</a></li>
		            <li><hr class="dropdown-divider"></li>
		            <li><a class="dropdown-item" href="CerrarSesion">Salir</a></li>
		          </ul>
		      </div>
		    </div>
		  </div>
		</nav> 		
    </c:if>
	 <div class="accordion container mt-3" id="accordionExample">
  	   <c:forEach items="${ reservas }" var="reserva">
	    
	    <div class="accordion-item">
	      <h2 class="accordion-header" id="headingOne">
	        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}" aria-expanded="true" aria-controls="a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}">
	          Parcela: ${reserva.parcela.id} - Cliente: ${reserva.usuario.dni}
	        </button>
	      </h2>
	      <div id="a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
	        <div class="accordion-body">
	          <strong>Tipo: </strong>${reserva.parcela.tipo.nombre} <br>
	          <strong>Fecha Ingreso: </strong>${reserva.fecha_ingreso} <br>
	          <strong>Fecha Salida: </strong>${reserva.fecha_salida} 
	          <br><br>
	          <c:if test="${ sessionScope.usuario != null }">
	            <a class="btn btn-danger" href="EliminarReserva?id_parcela=${reserva.parcela.id}&id_usuario=${reserva.usuario.id}&fecha_ingreso=${reserva.fecha_ingreso}&fecha_salida=${reserva.fecha_salida}">Eliminar</a>
	          </c:if>
	        </div>
	      </div>
	    </div>
	    
	  </c:forEach>
	  <div class="d-flex justify-content-between align-items-center mt-2">
       	<c:if test="${ sessionScope.usuario != null }">
       		<a class="btn btn-primary" href="VistaUsuario">Volver</a>
       	</c:if>
       	<c:if test="${ sessionScope.recepcion != null }">
       		<a class="btn btn-primary" href="VistaRecepcion">Volver</a>
       	</c:if>
      </div>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>