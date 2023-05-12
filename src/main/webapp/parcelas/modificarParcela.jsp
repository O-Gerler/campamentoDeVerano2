<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modificar Parcela</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body
	class="d-flex justify-content-center align-items-center my-5 my-md-0 flex-column gap-3"
	style="min-height: 100vh; width: 100vw">
	<h1>Modificar Parcela</h1>
	<div
		class="d-flex justify-content-center align-items-center flex-column gap-3"
		style="max-width: 700px">
		<form class="container" method="POST" action="ModificarParcela"
			id="formPersonal" style="width: 100%">
			<input type="hidden" name="id_parcela"
				value="${ requestScope.parcela.id }">
			<div
				class="mb-3 d-flex gap-3 justify-content-center align-items-center">
				<label for="id_grupo" class="form-label" style="max-width: 120px">Grupo</label>
				<select id="id_grupo" name="id_grupo" class="form-select" readonly>
					<option value="${ requestScope.parcela.id }">${ requestScope.parcela.id }</option>
				</select>
			</div>
			<div
				class="mb-3 d-flex gap-3 justify-content-center align-items-center">
				<label for="id_tipo" class="form-label" style="max-width: 120px">Tipo</label>
				<select id="id_tipo" name="id_tipo" class="form-select">
					<c:forEach items="${ tipos }" var="tipo">
						<c:if test="${ tipo.id == requestScope.parcela.id }">
							<option value="${tipo.id}" selected="selected">${tipo.nombre}</option>
						</c:if>
						<c:if test="${ tipo.id != requestScope.parcela.id }">
							<option value="${tipo.id}">${tipo.nombre}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div
				class="mb-3 d-flex gap-3 justify-content-center align-items-center">
				<label for="id_zona" class="form-label" style="max-width: 120px">Zona</label>
				<select id="id_zona" name="id_zona" class="form-select">
					<c:forEach items="${ zonas }" var="zona">
						<c:if test="${ zona.id == requestScope.parcela.zona.id }">
							<option value="${zona.id}" selected="selected">${zona.nombre}</option>
						</c:if>
						<c:if test="${ zona.id != requestScope.parcela.zona.id }">
							<option value="${zona.id}">${zona.nombre}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="d-flex justify-content-between align-items-center">
				<c:if test="${sessionScope.manager != null}">
					<a class="btn btn-primary" href="VistaManager">Volver</a>
				</c:if>
				<button type="submit" class="btn btn-primary">Insertar</button>
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>