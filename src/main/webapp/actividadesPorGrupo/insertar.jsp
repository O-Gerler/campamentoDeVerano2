<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Actividades por Grupo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body
	class="d-flex justify-content-center align-items-center flex-column"
	style="min-height: 100vh">
	<c:if test="${ requestScope.incorrecto }">
		<div class="alert alert-danger position-absolute top-0 text-center" style="width: 100vw" role="alert">
  			La actividad ya ha sido reservada
		</div>
	</c:if>
	<h1 class="text-center">Insertar Actividades por Grupo</h1>
	<form class="container" method="POST" action="InsertarActividadesGrupo">
		<div class="mb-3">
			<label for="id_actividad" class="form-label" style="max-width: 120px">Actividad</label>
			<select id="id_actividad" name="id_actividad" class="form-select">
				<c:forEach items="${ actividades }" var="actividad">
					<option value="${actividad.id}">${actividad.nombre}</option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3">
			<c:if test="${sessionScope.manager != null}">
				<label for="id_grupo" class="form-label" style="max-width: 120px">Grupo</label>
				<select id="id_grupo" name="id_grupo" class="form-select">
					<c:forEach items="${ grupos }" var="grupo">
						<option value="${grupo.id}">${grupo.id}</option>
					</c:forEach>
				</select>
			</c:if>
			<c:if test="${sessionScope.monitor != null}">
				<label for="id_usuario" class="form-label" style="max-width: 120px"><strong>DNI:</strong>
					${sessionScope.usuario.dni}</label>
				<input type="text" readonly="readonly" class="form-control"
					value="${sessionScope.usuario.id}" name="id_usuario">
			</c:if>
		</div>
		<div class="mb-3">
			<label for="fecha" class="form-label">Fecha</label> <input
				type="date" class="form-control" id="fecha" name="fecha">
		</div>
		<div class="mb-3">
			<label for="hora" class="form-label" style="max-width: 120px">Hora</label>
			<select id="hora" name="hora" class="form-select">
				<option value="8:00">8:00</option>
				<option value="10:00">10:00</option>
				<option value="12:00">12:00</option>
				<option value="16:00">16:00</option>
				<option value="18:00">18:00</option>
				<option value="20:00">20:00</option>
			</select>
		</div>
		<div class="d-flex justify-content-between align-items-center">
				<c:if test="${sessionScope.manager != null}">
					<a class="btn btn-primary" href="VistaManager">Volver</a>
				</c:if>
				<c:if test="${sessionScope.monitor != null}">
					<a class="btn btn-primary" href="VistaMonitor">Volver</a>
				</c:if>
				<button type="submit" class="btn btn-primary">Insertar</button>
			</div>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>