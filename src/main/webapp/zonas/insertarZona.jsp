<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insertar Zona</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body class="d-flex justify-content-center align-items-center flex-column" style="min-height: 100vh">
    <h1 class="text-center">Insertar Zona</h1>
    <form class="container" method="POST" action="InsertarZona">
        <div class="mb-3">
          <label for="nombre" class="form-label">Nombre</label>
          <input type="text" class="form-control" id="nombre" name="nombre">
        </div>
        <div class="form-group">
		    <label for="exampleFormControlTextarea1">Descripcion</label>
		    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="descripcion"></textarea>
 	 	</div>
 	 	<div class="d-flex justify-content-between align-items-center w-100 mt-2">
 	 		<c:if test="${ sessionScope.manager != null }">
 	 			<a class="btn btn-primary" href="VistaManager">Volver</a>
 	 		</c:if>
        	<button type="submit" class="btn btn-primary">Insertar</button>
        </div>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>