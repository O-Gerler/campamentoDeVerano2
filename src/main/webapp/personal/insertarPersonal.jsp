<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insertar Personal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body class="d-flex justify-content-center align-items-center my-5 my-md-0" style="min-height: 100vh; width: 100vw">
  	<div class="d-flex justify-content-center align-items-center flex-column gap-3 w-100 container">
	  	<h1>Insertar Personal</h1>
	  	<div class="d-flex justify-content-center align-items-center gap-3 w-100">
	  		<button id="btnPersonal" class="btn btn-primary w-50">Personal existente</button>
	  		<button id="btnNewPersonal" class="btn btn-primary w-50">Nuevo Personal</button>
	  	</div>
	    <form class="container" method="POST" action="InsertarPersonal" id="formPersonal">
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center">
	        <label for="id_usuario" class="form-label" style="max-width: 120px">Usuario</label>
	          <select id="id_usuario" name="id_usuario" class="form-select">
	          	<c:forEach items="${ usuarios }" var="personal">
	          		<option value="${personal.id}">${personal.dni} - ${personal.nombre} ${personal.apellido}</option>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="mb-3">
	          <label for="fecha_ingreso" class="form-label">Fecha Ingreso</label>
	          <input type="date" class="form-control" id="fecha_ingreso" name="fecha_ingreso">
	        </div>
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center">
	        <label for="dirige" class="form-label" style="max-width: 120px">Director</label>
	          <select id="dirige" name="dirige" class="form-select">
	          	<c:forEach items="${ personales }" var="personal">
	          		<option value="${personal.id}">${personal.dni} - ${personal.nombre} ${personal.apellido}</option>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="d-flex justify-content-between align-items-center">
	        	<c:if test="${sessionScope.manager != null}">
    				<a class="btn btn-primary" href="VistaManager" >Volver</a>
				</c:if>		
	        	<button type="submit" class="btn btn-primary">Insertar</button>
	        </div>
	     </form>
	     <form class="container d-none" method="POST" action="InsertarNuevoPersonal" id="formNewPersonal" style="min-width: 400px">
	        <div class="mb-3">
	          <label for="nombre" class="form-label">Nombre</label>
	          <input type="text" class="form-control" id="nombre" name="nombre">
	        </div>
	        <div class="mb-3">
	          <label for="apellidos" class="form-label">Apellidos</label>
	          <input type="text" class="form-control" id="apellidos" name="apellidos">
	        </div>
	        <div class="mb-3">
	          <label for="dni" class="form-label">DNI</label>
	          <input type="text" class="form-control" id="dni" name="dni">
	        </div>
	        <div class="mb-3">
	          <label for="email" class="form-label">Correo electronico</label>
	          <input type="email" class="form-control" id="email" name="email">
	        </div>
	        <div class="mb-3">
	          <label for="contrasena" class="form-label">Contraseña</label>
	          <input type="password" class="form-control" id="contrasena" name="contrasena">
	        </div>
	        <div class="mb-3">
	          <label for="telf" class="form-label">Telefono</label>
	          <input type="tel" class="form-control" id="telf" name="telf">
	        </div>
	        <div class="mb-3">
	          <label for="fecha_nacimiento" class="form-label">Fecha nacimiento</label>
	          <input type="date" class="form-control" id="fecha_nacimiento" name="fecha_nacimiento">
	        </div>
	        <div class="mb-3">
	          <label for="fecha_ingreso" class="form-label">Fecha Ingreso</label>
	          <input type="date" class="form-control" id="fecha_ingreso" name="fecha_ingreso">
	        </div>
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center">
	        <label for="dirige" class="form-label" style="max-width: 120px">Director</label>
	          <select id="dirige" name="dirige" class="form-select">
	          	<c:forEach items="${ personales }" var="personal">
	          		<option value="${personal.id}">${personal.dni} - ${personal.nombre} ${personal.apellido}</option>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="d-flex justify-content-between align-items-center">
	        	<c:if test="${sessionScope.manager != null}">
    				<a class="btn btn-primary" href="VistaManager" >Volver</a>
				</c:if>		
	        	<button type="submit" class="btn btn-primary">Insertar</button>
	        </div>
      	</form>
  	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  	<script >
  		const btnUser = document.getElementById('btnPersonal')
  		const btnNewUser = document.getElementById('btnNewPersonal')
  		const formUser = document.getElementById('formPersonal')
  		const formNewUser = document.getElementById('formNewPersonal')
  		
  		btnUser.addEventListener('click', () => {
  			if (formUser.classList.contains('d-none')) {
  				formUser.classList.toggle('d-none')
  				formNewUser.classList.toggle('d-none')
  			}
  		})
  		
  		btnNewUser.addEventListener('click', () => {
  			if (formNewUser.classList.contains('d-none')) {
  				formNewUser.classList.toggle('d-none')
  				formUser.classList.toggle('d-none')
  			}
  		})
  	</script>
  </body>
</html>