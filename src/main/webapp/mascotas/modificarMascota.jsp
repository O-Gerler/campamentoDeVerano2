<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modificar Mascota</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body>
  <c:set var="mascota" value="${requestScope.mascota}" />
    <h1 class="text-center">Modificar Mascota</h1>
    <form class="container" method="POST" action="ModificarMascota">
    	<input type="hidden" id="id" name="id" value="${mascota.id }" />
        <div class="mb-3">
          <label for="nombre" class="form-label">Nombre</label>
          <input type="text" class="form-control" id="nombre" name="nombre" value="${ mascota.nombre }">
        </div>
        <div class="mb-3">
          <label for="numChip" class="form-label">Numero del chip</label>
          <input type="text" class="form-control" id="numChip" name="numChip" value="${ mascota.numChip }">
        </div>
        <div class="mb-3">
          <label for="raza" class="form-label">Raza</label>
          <input type="text" class="form-control" id="raza" name="raza" value="${ mascota.raza }">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>