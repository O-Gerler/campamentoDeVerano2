<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modificar Vehiculo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body>
    <c:set var="vehiculo" value="${requestScope.vehiculo}" />
    <h1 class="text-center">Modificar Vehiculo</h1>
    <form class="container" method="POST" action="ModificarVehiculo">
    	<input type="hidden" name="id" value="${ vehiculo.id }">
        <div class="mb-3">
          <label for="matricula" class="form-label">Matricula</label>
          <input type="text" class="form-control" id="matricula" name="matricula" value="${ vehiculo.matricula }">
        </div>
        <div class="mb-3">
          <label for="marca" class="form-label">Marca</label>
          <input type="text" class="form-control" id="marca" name="marca" value="${ vehiculo.marca }">
        </div>
        <div class="mb-3">
          <label for="modelo" class="form-label">Modelo</label>
          <input type="text" class="form-control" id="modelo" name="modelo" value="${ vehiculo.modelo }">
        </div>
        <div class="mb-3">
          <label for="color" class="form-label">Color</label>
          <input type="text" class="form-control" id="color" name="color" value="${ vehiculo.color }">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>