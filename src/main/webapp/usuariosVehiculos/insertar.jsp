<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insertar Usuario-Vehiculo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body class="d-flex justify-content-center align-items-center flex-column" style="min-height: 100vh">
    <h1 class="text-center">Insertar Usuario-Vehiculo</h1>
    <form class="container mt-4" method="POST" action="InsertarUsuarioVehiculo">
        <div class="mb-3">
        <label for="id_usuario" class="form-label">Usuario</label>
          <select id="id_usuario" name="id_usuario" class="form-select">
          	<c:forEach items="${ usuarios }" var="usuario">
          		<option value="${usuario.id}">${usuario.dni}</option>
          	</c:forEach>
          </select>
        </div>
        <div class="mb-3">
          <label for="id_vehiculo" class="form-label">Vehiculo</label>
          <select id="id_vehiculo" name="id_vehiculo" class="form-select">
          	<c:forEach items="${ vehiculos }" var="vehiculo">
          		<option value="${vehiculo.id}">${vehiculo.matricula}</option>
          	</c:forEach>
          </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>