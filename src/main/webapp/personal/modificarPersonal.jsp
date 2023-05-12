<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modificar Personal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body class="d-flex justify-content-center align-items-center my-5 my-md-0" style="min-height: 100vh; width: 100vw">
  	<div class="d-flex justify-content-center align-items-center flex-column gap-3 w-100 container">
	  	<h1>Modificar Personal</h1>
	    <form class="container d-flex justify-content-center align-items-start flex-column w-100" method="POST" action="ModificarPersonal" id="formUser">
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center w-100">
		        <label for="id_personal" class="form-label">Personal</label>
		        <input type="text" class="form-control" readonly="readonly" value="${ requestScope.personal.id }" name="id_personal" id="id_personal">
	        </div>
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center w-100">
		        <label for="fecha_ingreso" class="form-label">Fecha Ingreso</label>
		        <input type="date" class="form-control" value="${ requestScope.personal.fechaIngreso }" name="fecha_ingreso" id="fecha_ingreso">
	        </div>
	        <div class="mb-3 d-flex gap-3 justify-content-center align-items-center w-100">
	          <label for="id_grupo" class="form-label" sty>Jefe</label>
	          <select id="dirige" name="dirige" class="form-select">
	          	<c:forEach items="${ personales }" var="personal">
	          		<c:if test="${ requestScope.personal.id == personal.id }">
	          			<option value="${personal.id}" selected>${personal.dni} -- ${ personal.nombre } ${ personal.apellido }</option>
	          		</c:if>
	          		<c:if test="${ requestScope.personal.id != personal.id }">
	          			<option value="${personal.id}">${personal.dni} -- ${ personal.nombre } ${ personal.apellido }</option>
	          		</c:if>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="d-flex justify-content-between align-items-center w-100">
				<c:if test="${sessionScope.manager != null}">
    				<a class="btn btn-primary" href="VistaManager" >Volver</a>
				</c:if>		
	        	<button type="submit" class="btn btn-primary">Modificar</button>
	        </div>
	     </form>
  	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>