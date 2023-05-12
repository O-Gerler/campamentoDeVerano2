<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hacer Reserva</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
<body class="d-flex justify-content-center align-items-center flex-column" style="min-height: 100vh">
	<c:if test="${ requestScope.incorrecto }">
		<div class="alert alert-danger position-absolute top-0 text-center" style="width: 100vw" role="alert">
  			La actividad ya ha sido reservada
		</div>
	</c:if>
	<h1 class="text-center">Reservar</h1>
	<form class="container" method="POST" action="InsertarReserva">
	  <div class="mb-3">
			<c:if test = "${sessionScope.recepcion != null || sessionScope.manager != null}">
			  <label for="id_usuario" class="form-label" style="max-width: 120px">Usuario</label>
			  <select id="id_usuario" name="id_usuario" class="form-select">
		         <c:forEach items="${ usuarios }" var="usuario">
		           <option value="${usuario.id}">${usuario.dni} - ${usuario.nombre} ${usuario.apellido}</option>
		         </c:forEach>
		      </select>
			</c:if>
			<c:if test="${sessionScope.usuario != null}">
				<label for="id_usuario" class="form-label" style="max-width: 120px"><strong>DNI:</strong> ${sessionScope.usuario.dni}</label>
				<input type="hidden" value="${sessionScope.usuario.id}" name="id_usuario">
			</c:if>
		</div>
        <div class="mb-3">
          <label for="id_parcela" class="form-label" style="max-width: 120px">Parcela</label>
		  <select id="id_parcela" name="id_parcela" class="form-select">
		    <c:forEach items="${ parcelas }" var="parcela">
		      <option value="${parcela.id}">${parcela.id}</option>
		    </c:forEach>
		  </select>
        </div>
        <div class="mb-3">
          <label for="fecha_ingreso" class="form-label">Fecha Ingreso</label>
          <input type="date" class="form-control" id="fecha_ingreso" name="fecha_ingreso">
        </div>
        <div class="mb-3">
          <label for="fecha_salida" class="form-label">Fecha Salida</label>
          <input type="date" class="form-control" id="fecha_salida" name="fecha_salida">
        </div>
        <div class="d-flex justify-content-between align-items-center">
				<c:if test="${sessionScope.manager != null}">
					<a class="btn btn-primary" href="VistaManager">Volver</a>
				</c:if>
				<c:if test="${sessionScope.recepcion != null}">
					<a class="btn btn-primary" href="VistaRecepcion">Volver</a>
				</c:if>
				<c:if test="${sessionScope.usuario != null}">
					<a class="btn btn-primary" href="VistaUsuario">Volver</a>
				</c:if>
				<button type="submit" class="btn btn-primary">Insertar</button>
			</div>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>