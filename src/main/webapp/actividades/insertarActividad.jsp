<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insertar Actividad</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body class="d-flex justify-content-center align-items-center flex-column" style="min-height: 100vh; width: 100vw">
    <h1 class="text-center">Insertar Actividad</h1>
    <form class="container" method="POST" action="InsertarActividad">
        <div class="mb-3">
          <label for="zona" class="form-label">Zona</label>
          <select name="id_zona" id="zona" class="form-select">
            <c:forEach items="${ zonas }" var="zona">
              <option value="${zona.id}">${zona.nombre}</option>
            </c:forEach>
          </select>
        </div>
        <div class="mb-3">
          <label for="nombre" class="form-label">Nombre</label>
          <input type="text" class="form-control" id="nombre" name="nombre">
        </div>
        <div class="mb-3">
          <label for="cantidad_max" class="form-label">Cantidad Maxima de Personas</label>
          <input type="number" class="form-control" id="cantidad_max" name="cantidad_max">
        </div>
        <div class="mb-3">
            <label for="edad_min" class="form-label">Edad Minima</label>
            <input type="number" class="form-control" id="edad_min" name="edad_min">
        </div>
        <div class="w-100 d-flex justify-content-between align-items-center">
        	<c:if test="${ sessionScope.manager != null }">
        		<a class="btn btn-primary" href="VistaManager">Volver</a>
        	</c:if>
        	<button type="submit" class="btn btn-primary">Insertar</button>
        </div>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>