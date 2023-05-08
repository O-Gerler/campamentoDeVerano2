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

    <title>Inicio de Sesion</title>
  </head>
  <body class="d-flex justify-content-center align-items-center flex-column gap-3" style="height: 100vh">
  	<h1>Inicio Sesion del Personal</h1>
  	<form class="container" method="POST" action="ComprobarLoginPersonal" style="max-width: 600px">
        <div class="mb-3">
          <label for="usuario" class="form-label">DNI</label>
          <input type="text" class="form-control" id="usuario" name="dni">
        </div>
        <div class="mb-3">
          <label for="contrasena" class="form-label">Contraseņa</label>
          <input type="text" class="form-control" id="contrasena" name="contrasena">
        </div>
        <div class="mb-3">
          <label for="rol" class="form-label">Rol</label>
	      <select name="id_rol" id="rol" class="form-select">
	        <option value="1">Monitor</option>
	        <option value="2">Limpieza</option>
	        <option value="3">Recepcion</option>
	        <option value="4">ADMIN</option>
	      </select>
        </div>
        <button type="submit" class="btn btn-primary">Iniciar Sesion</button>
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>