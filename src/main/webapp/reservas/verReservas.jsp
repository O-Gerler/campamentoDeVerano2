<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
</head>
<body>
	<a class="btn btn-primary" href="InsertarReserva">Insertar</a>
	 <div class="accordion" id="accordionExample">
  	   <c:forEach items="${ reservas }" var="reserva">
	    
	    <div class="accordion-item">
	      <h2 class="accordion-header" id="headingOne">
	        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${reserva.parcela.id}${reserva.cliente.id}${reserva.fecha_ingreso}${reserva.fecha_salida}" aria-expanded="true" aria-controls="a${reserva.parcela.id}${reserva.cliente.id}${reserva.fecha_ingreso}${reserva.fecha_salida}">
	          Parcela: ${reserva.parcela.id} - Cliente: ${reserva.cliente.dni}
	        </button>
	      </h2>
	      <div id="a${reserva.parcela.id}${reserva.cliente.id}${reserva.fecha_ingreso}${reserva.fecha_salida}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
	        <div class="accordion-body">
	          aaaaaaaa
	          <br><br>
	          <a class="btn btn-primary" href="ModificarZona?id_parcela=${reserva.parcela.id}&id_cliente${reserva.cliente.id}&fecha_ingreso${reserva.fecha_ingreso}&fecha_salida${reserva.fecha_salida}">Modificar</a>
	          <a class="btn btn-danger" href="EliminarZona?id_parcela=${reserva.parcela.id}&id_cliente${reserva.cliente.id}&fecha_ingreso${reserva.fecha_ingreso}&fecha_salida${reserva.fecha_salida}">Eliminar</a>
	        </div>
	      </div>
	      
	    </div>
	    
	  </c:forEach>
	</div>
     <div class="d-flex justify-content-between align-items-center">
       	<c:if test="${ vistaUsuario != null }">
       		<a class="btn btn-primary" href="VistaUsuario">Volver</a>
       	</c:if>
       	<c:if test="${ vistaRecepcion != null }">
       		<a class="btn btn-primary" href="VistaRecepcion">Volver</a>
       	</c:if>
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>