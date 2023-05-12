<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modificar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body  class="d-flex justify-content-center align-items-center" style="height: 100vh; width: 100vw">
  <c:set var="usuario" value="${requestScope.usuario}" />
  <c:set var="vistaUsuario" value="${sessionScope.usuario}" />
  <c:set var="vistaMonitor" value="${sessionScope.monitor}" />
  <c:set var="vistaLimpieza" value="${sessionScope.limpieza}" />
  <c:set var="vistaRecepcion" value="${sessionScope.recepcion}" />
  <div class="w-100 container">
    <h1 class="text-center">Modificar Usuario</h1>
    <form class="" method="POST" action="ModificarUsuario">
    	<input type="hidden" value="${ usuario.id }" name="id">
        <div class="mb-3">
          <label for="nombre" class="form-label">Nombre</label>
          <input type="text" class="form-control" id="nombre" name="nombre" value="${ usuario.nombre }">
        </div>
        <div class="mb-3">
          <label for="apellidos" class="form-label">Apellidos</label>
          <input type="text" class="form-control" id="apellidos" name="apellidos" value="${ usuario.apellido }">
        </div>
        <div class="mb-3">
          <label for="dni" class="form-label">DNI</label>
          <input type="text" class="form-control" id="dni" name="dni" value="${ usuario.dni }">
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">Correo electronico</label>
          <input type="email" class="form-control" id="email" name="email" value="${ usuario.email }">
        </div>
        <div class="mb-3">
          <label for="contrasena" class="form-label">Contraseña</label>
          <input type="password" class="form-control" id="contrasena" name="contrasena" value="${ usuario.contrasena }">
        </div>
        <div class="mb-3">
          <label for="telf" class="form-label">Telefono</label>
          <input type="tel" class="form-control" id="telf" name="telf" value="${ usuario.telefono }">
        </div>
        <div class="mb-3">
          <label for="fecha_nacimiento" class="form-label">Fecha nacimiento</label>
          <input type="date" class="form-control" id="fecha_nacimiento" name="fecha_nacimiento" value="${ usuario.fechaNacimiento }">
        </div>
        <div class="d-flex justify-content-between align-items-center">
        	<c:if test="${ vistaUsuario != null }">
        		<a class="btn btn-primary" href="VistaUsuario">Volver</a>
        	</c:if>
        	<c:if test="${ vistaMonitor != null }">
        		<a class="btn btn-primary" href="VistaMonitor">Volver</a>
        	</c:if>
        	<c:if test="${ vistaLimpieza != null }">
        		<a class="btn btn-primary" href="VistaLimpieza">Volver</a>
        	</c:if>
        	<c:if test="${ vistaRecepcion != null }">
        		<a class="btn btn-primary" href="VistaRecepcion">Volver</a>
        	</c:if>
        	<c:if test="${ sessionScope.manager != null }">
        		<a class="btn btn-primary" href="VistaManager">Volver</a>
        	</c:if>
        	<button type="submit" class="btn btn-primary">Modificar</button>
        </div>
        
      </form>
      <c:if test="${ vistaUsuario != null }">
      	 <a class="btn btn-danger mt-3 w-100" href="EliminarUsuario">Eliminar cuenta</a>
      </c:if>
  </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>