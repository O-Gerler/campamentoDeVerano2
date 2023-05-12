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
  <body class="d-flex justify-content-center align-items-center flex-column" style="min-height: 100vh">
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
	<div class="d-flex justify-content-evenly align-items-center flex-column">
		<c:forEach items="${ parcelas }" var="parcela">
			<div class="d-flex justify-content-evenly align-items-center flex-column gap-2">
				<c:if test="${ parcela.limpia }">
				  <div style="width: 200px; height: 200px; background-color: green"></div>
				</c:if>
				<c:if test="${ !parcela.limpia }">
				  <div style="width: 200px; height: 200px; background-color: red"></div>
				</c:if>
				<h2 class="text-center"><strong>Numero: </strong>${ parcela.id }</h2>
				<a class="d-block btn btn-primary" href="LimpiarParcela?id_parcela=${ parcela.id }">Limpiar</a>
			</div>
		</c:forEach>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>