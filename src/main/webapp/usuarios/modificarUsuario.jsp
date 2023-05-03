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
  <body>
  <c:set var="usuario" value="${requestScope.usuario}" />
    <h1>Modificar Usuario</h1>
    <form class="container" method="POST" action="InsertarUsuario">
    	<input type="hidden" value="${ usuario.id }">
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
          <label for="contrasena" class="form-label">Contraseņa</label>
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
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>