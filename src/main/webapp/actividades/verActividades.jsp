<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Actividade_s</title>
  </head>
  <body>
  <a class="btn btn-primary" href="InsertarActividad">Insertar</a>
  <div class="accordion" id="accordionExample">
  	<c:forEach items="${ actividades }" var="actividad">
	    
	    <div class="accordion-item">
	      <h2 class="accordion-header" id="headingOne">
	        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${actividad.id}" aria-expanded="true" aria-controls="a${actividad.id}">
	          ${actividad.nombre}
	        </button>
	      </h2>
	      <div id="a${actividad.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
	        <div class="accordion-body">
	          <strong>Cantidad de personas maximas:</strong> ${ actividad.cantidad_max } <br>
	          <strong>Edad minima para participar:</strong> ${ actividad.edad_min } <br>
	          <strong>Zona:</strong> ${ actividad.zona.nombre }
	          <br><br>
	          <a class="btn btn-primary" href="ModificarActividad?id=${actividad.id}">Modificar</a>
	          <a class="btn btn-danger" href="EliminarActividad?id=${actividad.id}">Eliminar</a>
	        </div>
	      </div>
	      
	    </div>
	    
	  </c:forEach>
	</div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>