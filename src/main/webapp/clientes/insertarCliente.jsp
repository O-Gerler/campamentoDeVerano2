<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insertar Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body class="d-flex justify-content-center align-items-center my-5 my-md-0" style="min-height: 100vh; width: 100vw">
  	<div class="d-flex justify-content-center align-items-center flex-column gap-3 w-100 container">
	  	<h1>Insertar Cliente</h1>
	  	<div class="d-flex justify-content-center align-items-center gap-3 w-100">
	  		<button id="btnUser" class="btn btn-primary w-50">Usuario existente</button>
	  		<button id="btnNewUser" class="btn btn-primary w-50">Nuevo usuario</button>
	  	</div>
	    <form class="container" method="POST" action="InsertarCliente" id="formUser"">
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center">
	        <label for="id_usuario" class="form-label" style="max-width: 120px">Usuario</label>
	          <select id="id_usuario" name="id_cliente" class="form-select">
	          	<c:forEach items="${ usuarios }" var="usuario">
	          		<option value="${usuario.id}">${usuario.dni} - ${usuario.nombre} ${usuario.apellido}</option>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center">
	          <label for="id_grupo" class="form-label" sty>Grupo</label>
	          <select id="id_grupo" name="id_grupo" class="form-select">
	          	<c:forEach items="${ grupos }" var="grupo">
	          		<option value="${grupo.id}">${grupo.id}</option>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="d-flex justify-content-between align-items-center">
	        	<c:if test="${sessionScope.recepcion != null}">
    				<a class="btn btn-primary" href="VistaRecepcion" >Volver</a>
				</c:if>
				<c:if test="${sessionScope.manager != null}">
    				<a class="btn btn-primary" href="VistaManager" >Volver</a>
				</c:if>		
	        	<button type="submit" class="btn btn-primary">Insertar</button>
	        </div>
	     </form>
	     <form class="container d-none" method="POST" action="InsertarNuevoCliente" id="formNewUser" style="min-width: 400px">
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
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center">
	          <label for="id_grupo" class="form-label" sty>Grupo</label>
	          <select id="id_grupo" name="id_grupo" class="form-select">
	          	<c:forEach items="${ grupos }" var="grupo">
	          		<option value="${grupo.id}">${grupo.id}</option>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="d-flex justify-content-between align-items-center">
	        	<c:if test="${sessionScope.recepcion != null}">
    				<a class="btn btn-primary" href="VistaRecepcion" >Volver</a>
				</c:if>	
				<c:if test="${sessionScope.manager != null}">
    				<a class="btn btn-primary" href="VistaManager" >Volver</a>
				</c:if>	
	        	<button type="submit" class="btn btn-primary">Insertar</button>
	        </div>
	        
      	</form>
  	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  	<script >
  		const btnUser = document.getElementById('btnUser')
  		const btnNewUser = document.getElementById('btnNewUser')
  		const formUser = document.getElementById('formUser')
  		const formNewUser = document.getElementById('formNewUser')
  		
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