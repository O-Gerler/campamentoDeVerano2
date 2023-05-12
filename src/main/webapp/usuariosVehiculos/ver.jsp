<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body class="pb-5 mb-5">
	<c:if test="${ sessionScope.usuario != null }">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light position-fixed top-0"
			style="width: 100vw">
			<div class="container-fluid">
				<div class="navbar-brand">Campamento</div>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
					<div class="nav-item dropdown">
						<a class="nav-link btn btn-warning" href="InsertarReserva">Reservar</a>
					</div>
					<div class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							${ sessionScope.usuario.nombre } ${ sessionScope.usuario.apellido } </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="VistaUsuario">Home</a></li>
							<li><a class="dropdown-item" href="MostrarPerfil">Mi
									Perfil</a></li>
							<li><a class="dropdown-item" href="MostrarReservas">Mis
									Reservas</a></li>
							<li><a class="dropdown-item" href="#">Vehiculos</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="CerrarSesion">Salir</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</c:if>
	<c:if test="${ sessionScope.monitor != null }">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light position-fixed top-0"
			style="width: 100vw">
			<div class="container-fluid">
				<div class="navbar-brand">Campamento</div>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
					<div class="nav-item dropdown"></div>
					<div class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							${ sessionScope.monitor.nombre } ${ sessionScope.monitor.apellido } </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="VistaMonitor">Home</a></li>
							<li><a class="dropdown-item" href="MostrarPerfil">Mi
									Perfil</a></li>
							<li><a class="dropdown-item" href="#">Vehiculos</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="CerrarSesion">Salir</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</c:if>
	<c:if test="${ sessionScope.limpieza != null }">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light position-fixed top-0"
			style="width: 100vw">
			<div class="container-fluid">
				<div class="navbar-brand">Campamento</div>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
					<div class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							${ sessionScope.limpieza.nombre } ${ sessionScope.limpieza.apellido } </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="VistaLimpieza">Home</a></li>
							<li><a class="dropdown-item" href="MostrarPerfil">Mi
									Perfil</a></li>
							<li><a class="dropdown-item" href="MostrarVehiculos">Vehiculos</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="CerrarSesion">Salir</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</c:if>
	<c:if test="${ sessionScope.recepcion != null }">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light position-fixed top-0"
			style="width: 100vw">
			<div class="container-fluid">
				<div class="navbar-brand">Campamento</div>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
					<div class="nav-item dropdown">
						<a class="btn btn-primary" href="InsertarCliente">Insertar
							Cliente</a> <a class="btn btn-primary" href="InsertarReserva">Hacer
							Reserva</a>
					</div>
					<div class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							${ sessionScope.recepcion.nombre } ${ sessionScope.recepcion.apellido } </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="VistaRecepcion">Home</a></li>
							<li><a class="dropdown-item" href="MostrarPerfil">Mi
									Perfil</a></li>
							<li><a class="dropdown-item" href="#">Vehiculos</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="CerrarSesion">Salir</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</c:if>
	<div class="mt-4 container">
		<a class="btn btn-primary mt-5 mb-2" href="InsertarVehiculo">Insertar</a>
		<div class="accordion" id="accordionExample">
			<c:forEach items="${ usuarioVehiculos }" var="usuarioVehiculo">

				<div class="accordion-item">
					<h2 class="accordion-header" id="headingOne">
						<button class="accordion-button" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#a${usuarioVehiculo.id}" aria-expanded="true"
							aria-controls="a${usuarioVehiculo.id}">
							<strong>MATRICULA: ${usuarioVehiculo.matricula}</strong>
						</button>
					</h2>
					<div id="a${usuarioVehiculo.id}"
						class="accordion-collapse collapse" aria-labelledby="headingOne"
						data-bs-parent="#accordionExample">
						<div class="accordion-body">
								<strong>Marca: </strong>${ usuarioVehiculo.marca } <br> 
								<strong>Modelo: </strong>${ usuarioVehiculo.modelo } <br> 
								<strong>Color: </strong> ${ usuarioVehiculo.color }
								<br> <br> 
								<a class="btn btn-primary" href="ModificarVehiculo?id=${usuarioVehiculo.id}">Modificar</a>								
								<a class="btn btn-danger"
								href="EliminarVehiculo?id=${usuarioVehiculo.id}">Eliminar</a>
						</div>
					</div>

				</div>

			</c:forEach>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>