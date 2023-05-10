<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ModificarCliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body class="d-flex justify-content-center align-items-center my-5 my-md-0" style="min-height: 100vh; width: 100vw">
  	<div class="d-flex justify-content-center align-items-center flex-column gap-3" style="max-width: 700px">
	  	<h1>Insertar Cliente</h1>
	    <form class="container" method="POST" action="InsertarCliente" id="formUser" style="max-width: 700px">
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
  	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>