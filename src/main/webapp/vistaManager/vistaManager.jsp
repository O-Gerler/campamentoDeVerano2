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

    <title>Home</title>
    <style type="text/css">
    	.acordion{
    		width: 100%
    	}
    </style>
  </head>
  <body class="d-flex justify-content-center align-items-center flex-wrap">
  <nav class="navbar navbar-expand-lg navbar-light bg-light position-fixed top-0" style="width: 100vw">
	  <div class="container-fluid">
	    <div class="navbar-brand">Campamento</div>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
	      <div class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Admin
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="CerrarSesion">Salir</a></li>
	          </ul>
	      </div>
	    </div>
	  </div>
	</nav>
  	<div class="container mt-5 pt-4">
  			<div class="mb-3">
  				<button class="btn btn-primary mt-2" type="button" id="btnUsuarios">Usuarios</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnClientes">Clientes</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnPersonal">Personal</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnMonitores">Monitores</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnLimpieza">Limpieza</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnRecepcion">Recepcion</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnActividades">Actividades</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnActividadesGrupo">Actividades por Grupo</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnGrupos">Grupos</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnParcelas">Parcelas</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnReservas">Reservas</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnTipos">Tipos</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnVehiculos">Vehiculos</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnVehiculosUsuario">Vehiculos de Usuario</button>
  				<button class="btn btn-primary mt-2" type="button" id="btnZonas">Zonas</button>
  			</div>
  			<hr>
  			<div id="containerAccordionUsuario">
  			 	 <a class="btn btn-primary mb-2" href="InsertarUsuario">Insertar</a>
				 <div class="accordion" id="accordionUsuario">
			  	   <c:forEach items="${ usuarios }" var="usuario">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${usuario.id}" aria-expanded="true" aria-controls="a${usuario.id}">
				          ${usuario.nombre}
				        </button>
				      </h2>
				      <div id="a${usuario.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionUsuario">
				        <div class="accordion-body">
				          <strong>Nombre:</strong> ${ usuario.nombre } <br>
				          <strong>Apellido:</strong> ${ usuario.apellido } <br>
				          <strong>DNI:</strong> ${ usuario.dni } <br>
				          <strong>email:</strong> ${ usuario.email } <br>
				          <strong>Telefono:</strong> ${ usuario.telefono } <br>
				          <strong>Fecha nacimiento:</strong> ${ usuario.fechaNacimiento } <br>
				          <strong>Vehiculos:</strong> ${ usuario.dni } <br>
				          <br><br>
				          <a class="btn btn-primary" href="ModificarUsuario?id=${usuario.id}">Modificar</a>
				          <a class="btn btn-danger" href="EliminarUsuario?id=${usuario.id}">Eliminar</a>
				        </div>
				      </div>
				      
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionCliente">
  				 <a class="btn btn-primary mb-2" href="InsertarCliente">Insertar</a>
				 <div class="accordion" id="accordionCliente">
			  	   <c:forEach items="${ clientes }" var="cliente">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#b${cliente.id}" aria-expanded="true" aria-controls="b${cliente.id}">
				          ${cliente.dni}
				        </button>
				      </h2>
				      <div id="b${cliente.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionCliente">
				        <div class="accordion-body">
				          <div>
				            <h3>Cliente</h3>
				            <strong>Nombre:</strong> ${ cliente.nombre }<br>
				            <strong>Apellido:</strong> ${ cliente.apellido } <br>
				            <strong>DNI:</strong> ${ cliente.dni } <br>
				            <strong>email:</strong> ${ cliente.email } <br>
				            <strong>Telefono:</strong> ${ cliente.telefono } <br>
				            <strong>Fecha nacimiento:</strong> ${ cliente.fechaNacimiento }
				          </div>
				          <div>
				          	<br>
				            <h3>Grupo</h3>
				            <strong>Numero:</strong> ${ cliente.grupo.id }<br>
				          </div>
				          <div>
				            <br>
				            <h3>Monitor</h3>
				            <strong>Nombre:</strong> ${ cliente.grupo.monitor.nombre } ${ cliente.grupo.monitor.apellido }<br>
				          </div>
				          <div>
				            <h3>Vehiculo</h3>
				          	<c:forEach items="${ cliente.vehiculos }" var="vehiculo">
				              <strong>Matricula:</strong> ${ vehiculo.matricula }<br>
				              <strong>Marca:</strong> ${ vehiculo.marca } <br>
				          	  <strong>Modelo:</strong> ${ vehiculo.modelo } <br>
				          	  <strong>Color:</strong> ${ vehiculo.color }
				            </c:forEach>
				          </div>
				          <br><br>
				          <a class="btn btn-primary" href="ModificarCliente?id=${cliente.id}">Modificar</a>
				          <a class="btn btn-danger" href="EliminarCliente?id=${cliente.id}">Eliminar</a>
				        </div>
				      </div>
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionPersonal">
  				 <a class="btn btn-primary mb-2" href="InsertarPersonal">Insertar</a>
				 <div class="accordion" id="accordionPersonal">
			  	   <c:forEach items="${ personales }" var="personal">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#c${personal.id}" aria-expanded="true" aria-controls="c${personal.id}">
				          ${personal.nombre}
				        </button>
				      </h2>
				      <div id="c${personal.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionPersonal">
				        <div class="accordion-body">
				          <strong>Nombre:</strong> ${ personal.nombre } <br>
				          <strong>Apellido:</strong> ${ personal.apellido } <br>
				          <strong>DNI:</strong> ${ personal.dni } <br>
				          <strong>email:</strong> ${ personal.email } <br>
				          <strong>Telefono:</strong> ${ personal.telefono } <br>
				          <strong>Fecha nacimiento:</strong> ${ personal.fechaNacimiento } <br>
				          <strong>Fecha Ingreso:</strong> ${ personal.fechaIngreso } <br>
				          <strong>Jefe:</strong> ${ personal.director } <br>
				          <strong>Vehiculos:</strong> ${ personal.dni } <br>
				          
				          <br><br>
				          <a class="btn btn-primary" href="ModificarPersonal?id=${personal.id}">Modificar</a>
				          <a class="btn btn-danger" href="EliminarPersonal?id=${personal.id}">Eliminar</a>
				        </div>
				      </div>
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionMonitor">
  				<a class="btn btn-primary mb-2" href="InsertarMonitor">Insertar</a>
				 <div class="accordion" id="accordionMonitor">
			  	   <c:forEach items="${ monitores }" var="monitor">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#d${monitor.id}" aria-expanded="true" aria-controls="d${monitor.id}">
				          ${monitor.nombre}
				        </button>
				      </h2>
				      <div id="d${monitor.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionMonitor">
				        <div class="accordion-body">
				          <strong>Nombre:</strong> ${ monitor.nombre } <br>
				          <strong>Apellido:</strong> ${ monitor.apellido } <br>
				          <strong>DNI:</strong> ${ monitor.dni } <br>
				          <strong>email:</strong> ${ monitor.email } <br>
				          <strong>Telefono:</strong> ${ monitor.telefono } <br>
				          <strong>Fecha nacimiento:</strong> ${ monitor.fechaNacimiento } <br>
				          <strong>Fecha Ingreso:</strong> ${ monitor.fechaIngreso } <br>
				          <strong>Jefe:</strong> ${ monitor.director } <br>
				          <strong>Vehiculos:</strong> ${ monitor.dni } <br>
				          
				          <br><br>
				          <a class="btn btn-danger" href="EliminarMonitor?id=${monitor.id}">Eliminar</a>
				        </div>
				      </div>
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionLimpieza">
  				<a class="btn btn-primary mb-2" href="InsertarLimpieza">Insertar</a>
				 <div class="accordion" id="accordionLimpieza">
			  	   <c:forEach items="${ limpiezas }" var="limpieza">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#e${limpieza.id}" aria-expanded="true" aria-controls="e${limpieza.id}">
				          ${limpieza.nombre}
				        </button>
				      </h2>
				      <div id="e${limpieza.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionLimpieza">
				        <div class="accordion-body">
				          <strong>Nombre:</strong> ${ limpieza.nombre } <br>
				          <strong>Apellido:</strong> ${ limpieza.apellido } <br>
				          <strong>DNI:</strong> ${ limpieza.dni } <br>
				          <strong>email:</strong> ${ limpieza.email } <br>
				          <strong>Telefono:</strong> ${ limpieza.telefono } <br>
				          <strong>Fecha nacimiento:</strong> ${ limpieza.fechaNacimiento } <br>
				          <strong>Fecha Ingreso:</strong> ${ limpieza.fechaIngreso } <br>
				          <strong>Jefe:</strong> ${ limpieza.director } <br>
				          <strong>Zona:</strong> ${ limpieza.zona.nombre } <br>
				          <strong>Vehiculos:</strong> ${ limpieza.dni } <br>
				          
				          <br><br>
				          <a class="btn btn-primary" href="ModificarLimpieza?id=${limpieza.id}">Modificar</a>
				          <a class="btn btn-danger" href="EliminarLimpieza?id=${limpieza.id}">Eliminar</a>
				        </div>
				      </div>
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionRecepcion">
  				<a class="btn btn-primary mb-2" href="InsertarRecepcion">Insertar</a>
				 <div class="accordion" id="accordionRecepcion">
			  	   <c:forEach items="${ recepciones }" var="recepcion">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#f${recepcion.id}" aria-expanded="true" aria-controls="f${recepcion.id}">
				          ${recepcion.nombre}
				        </button>
				      </h2>
				      <div id="f${recepcion.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionRecepcion">
				        <div class="accordion-body">
				          <strong>Nombre:</strong> ${ recepcion.nombre } <br>
				          <strong>Apellido:</strong> ${ recepcion.apellido } <br>
				          <strong>DNI:</strong> ${ recepcion.dni } <br>
				          <strong>email:</strong> ${ recepcion.email } <br>
				          <strong>Telefono:</strong> ${ recepcion.telefono } <br>
				          <strong>Fecha nacimiento:</strong> ${ recepcion.fechaNacimiento } <br>
				          <strong>Fecha Ingreso:</strong> ${ recepcion.fechaIngreso } <br>
				          <strong>Jefe:</strong> ${ recepcion.director } <br>
				          <strong>Vehiculos:</strong> ${ recepcion.dni } <br>
				          
				          <br><br>
				          <a class="btn btn-danger" href="EliminarRecepcion?id=${recepcion.id}">Eliminar</a>
				        </div>
				      </div>
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionActividad">
  			  <a class="btn btn-primary mb-2" href="InsertarActividad">Insertar</a>
			  <div class="accordion" id="accordionActividad">
			  	<c:forEach items="${ actividades }" var="actividad">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#g${actividad.id}" aria-expanded="true" aria-controls="g${actividad.id}">
				          ${actividad.nombre}
				        </button>
				      </h2>
				      <div id="g${actividad.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionActividad">
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
  			</div>
  			<div class="d-none" id="containerAccordionActividadesGrupo">
  				<a class="btn btn-primary mb-2" href="InsertarActividadesGrupo">Insertar</a>
	  			<div class="accordion" id="accordionActividadesGrupos">
			  	   <c:forEach items="${ actividadesPorGrupos }" var="aGrupos">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${aGrupos.actividad.id}${aGrupos.grupo.id}${aGrupos.fecha}${aGrupos.hora.replace(':','_')}" aria-expanded="true" aria-controls="a${aGrupos.actividad.id}${aGrupos.grupo.id}${aGrupos.fecha}${aGrupos.hora.replace(':','_')}">
				          ${aGrupos.actividad.nombre} -> ${aGrupos.actividad.zona.nombre} //<strong> ${aGrupos.fecha} ${aGrupos.hora}</strong>
				        </button>
				      </h2>
				      <div id="a${aGrupos.actividad.id}${aGrupos.grupo.id}${aGrupos.fecha}${aGrupos.hora.replace(':','_')}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionActividadesGrupos">
				        <div class="accordion-body">
				          <a class="btn btn-danger" href="EliminarActividadesGrupo?id_actividad=${aGrupos.actividad.id}&id_grupo=${aGrupos.grupo.id}&fecha=${aGrupos.fecha}&hora=${aGrupos.hora}">Eliminar</a>
				        </div>
				      </div>
				      
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionGrupo">
  				<a class="btn btn-primary mb-2" href="InsertarGrupo">Insertar</a>
  				<div class="accordion" id="accordionGrupo">
			  	   <c:forEach items="${ grupos }" var="grupo">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#h${grupo.id}" aria-expanded="true" aria-controls="h${grupo.id}">
				          <strong>Grupo:</strong> ${ grupo.id }
				        </button>
				      </h2>
				      <div id="h${grupo.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionGrupo">
				        <div class="accordion-body">
				          <div>
				            <strong>Monitor: </strong>${ grupo.monitor.nombre } ${ grupo.monitor.apellido }
				          </div>
				          <br><br>
				          <a class="btn btn-danger" href="EliminarGrupo?id=${grupo.id}">Eliminar</a>
				        </div>
				      </div>
				      
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionParcela">
  				<div class="accordion" id="accordionParcela">
  				<a class="btn btn-primary mb-2" href="InsertarParcela">Insertar</a>
			  	   <c:forEach items="${ parcelas }" var="parcela">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#j${parcela.id}" aria-expanded="true" aria-controls="j${parcela.id}">
				          <strong>Parcela: </strong> ${parcela.id }
				          
				        </button>
				      </h2>
				      <div id="j${parcela.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionParcela">
				        <div class="accordion-body">
				          <div>
					          <strong>Tipo: </strong> ${parcela.tipo.nombre } <br>
					          <strong>Zona: </strong> ${parcela.zona.nombre } <br>
					          <strong>Grupo: </strong> ${parcela.grupo.id } <br>
					          <strong>Limpia :</strong> ${parcela.limpia }
				          </div>
				          <br>
						  <a class="btn btn-primary" href="ModificarParcela?id=${parcela.id}">Modificar</a>				          
				          <a class="btn btn-danger" href="EliminarParcela?id=${parcela.id}">Eliminar</a>
				        </div>
				      </div>
				      
				    </div>
				    
				  </c:forEach>
				</div>
  			</div>
  			<div class="d-none" id="containerAccordionReserva">
  				<a class="btn btn-primary mb-2" href="InsertarReserva">Insertar</a>
	  			<div class="accordion" id="accordionReserva">
			  	   <c:forEach items="${ reservas }" var="reserva">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}" aria-expanded="true" aria-controls="a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}">
				          Parcela: ${reserva.parcela.id} - Cliente: ${reserva.usuario.dni}
				        </button>
				      </h2>
				      <div id="a${reserva.parcela.id}${reserva.usuario.id}${reserva.fecha_ingreso}${reserva.fecha_salida}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionReserva">
				        <div class="accordion-body">
				            <strong>Tipo: </strong>${reserva.parcela.tipo.nombre} <br>
	          				<strong>Fecha Ingreso: </strong>${reserva.fecha_ingreso} <br>
	          				<strong>Fecha Salida: </strong>${reserva.fecha_salida} 
				          <br><br>
				          <c:if test="${ sessionScope.usuario == null }">
				            <a class="btn btn-danger" href="EliminarReserva?id_parcela=${reserva.parcela.id}&id_usuario=${reserva.usuario.id}&fecha_ingreso=${reserva.fecha_ingreso}&fecha_salida=${reserva.fecha_salida}">Eliminar</a>
				          </c:if>
				        </div>
				      </div>
				    </div>
				   </c:forEach>
				 </div>
	  		</div>
	  		<div  class="d-none" id="containerAccordionTipo">
	  			 <a class="btn btn-primary mb-2" href="InsertarTipo">Insertar</a>
				 <div class="accordion" id="accordionTipo">
			  	   <c:forEach items="${ tipos }" var="tipo">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#j${tipo.id}" aria-expanded="true" aria-controls="j${tipo.id}">
				          ${tipo.nombre}
				        </button>
				      </h2>
				      <div id="j${tipo.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionTipo">
				        <div class="accordion-body">
				          <strong>Nombre:</strong> ${ tipo.nombre }<br>
				          <strong>Cantidad de personas:</strong> ${ tipo.cantidad_personas }<br>
				          <strong>Descripcion:</strong><br>
				          ${ tipo.descripcion }
				          <br><br>
				          <a class="btn btn-primary" href="ModificarTipo?id=${tipo.id}">Modificar</a>
				          <a class="btn btn-danger" href="EliminarTipo?id=${tipo.id}">Eliminar</a>
				        </div>
				      </div>
				      
				    </div>
				    
				  </c:forEach>
				</div>
	  		</div>
	  		<div class="d-none" id="containerAccordionVehiculo">
	  			<a class="btn btn-primary mb-2" href="InsertarVehiculo">Insertar</a>
				 <div class="accordion" id="accordionVehiculo">
			  	   <c:forEach items="${ vehiculos }" var="vehiculo">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#k${vehiculo.id}" aria-expanded="true" aria-controls="k${vehiculo.id}">
				          ${vehiculo.matricula}
				        </button>
				      </h2>
				      <div id="k${vehiculo.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionVehiculo">
				        <div class="accordion-body">
				          <strong>Marca:</strong> ${ vehiculo.marca } <br>
				          <strong>Modelo:</strong> ${ vehiculo.modelo } <br>
				          <strong>Color:</strong> ${ vehiculo.color }
				          <br><br>
				          <a class="btn btn-primary" href="ModificarVehiculo?id=${vehiculo.id}">Modificar</a>
				          <a class="btn btn-danger" href="EliminarVehiculo?id=${vehiculo.id}">Eliminar</a>
				        </div>
				      </div>
				      
				    </div>
				    
				  </c:forEach>
				</div>
	  		</div>
	  		<div  class="d-none" id="containerAccordionVehiculoUsuario">
	  			 <a class="btn btn-primary mb-2" href="InsertarUsuarioVehiculo">Insertar</a>
				 <div class="accordion" id="accordionVehiculoUsuario">
			  	   <c:forEach items="${ usuarioVehiculos }" var="usuarioVehiculo">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#m${usuarioVehiculo.vehiculo.id}" aria-expanded="true" aria-controls="m${usuarioVehiculo.vehiculo.id}">
				          <strong>DNI: ${usuarioVehiculo.usuario.dni} </strong>  //  
				          <strong>MATRICULA: ${usuarioVehiculo.vehiculo.matricula}</strong>
				        </button>
				      </h2>
				      <div id="m${usuarioVehiculo.vehiculo.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionVehiculoUsuario">
				        <div class="accordion-body">
				          <div class=" d-flex justify-content-between">
				            <div>
				              <strong>Nombre:</strong> ${ usuarioVehiculo.usuario.nombre } <br>
				              <strong>Apellido:</strong> ${ usuarioVehiculo.usuario.apellido } <br>
				              <strong>DNI:</strong> ${ usuarioVehiculo.usuario.dni } <br>
				              <strong>email:</strong> ${ usuarioVehiculo.usuario.email } <br>
				              <strong>Telefono:</strong> ${ usuarioVehiculo.usuario.telefono } <br>
				              <strong>Fecha nacimiento:</strong> ${ usuarioVehiculo.usuario.fechaNacimiento }
				            </div>
				            <div>
				              <strong>Marca:</strong> ${ usuarioVehiculo.vehiculo.marca } <br>
				          	  <strong>Modelo:</strong> ${ usuarioVehiculo.vehiculo.modelo } <br>
				          	  <strong>Color:</strong> ${ usuarioVehiculo.vehiculo.color }
				            </div>
				          </div>
				          <br><br>
				          <a class="btn btn-danger" href="EliminarUsuarioVehiculo?id_usuario=${usuarioVehiculo.usuario.id}&id_vehiculo=${usuarioVehiculo.vehiculo.id}">Eliminar</a>
				        </div>
				      </div>
				      
				    </div>
				    
				  </c:forEach>
				</div>
	  		</div>
	  		<div class="d-none" id="containerAccordionZona">
	  			 <a class="btn btn-primary mb-2" href="InsertarZona">Insertar</a>
				 <div class="accordion" id="accordionZonas">
			  	   <c:forEach items="${ zonas }" var="zona">
				    
				    <div class="accordion-item">
				      <h2 class="accordion-header" id="headingOne">
				        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#m${zona.id}" aria-expanded="true" aria-controls="m${zona.id}">
				          ${zona.nombre}
				        </button>
				      </h2>
				      <div id="m${zona.id}" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionZonas">
				        <div class="accordion-body">
				          ${ zona.descripcion }
				          <br><br>
				          <a class="btn btn-primary" href="ModificarZona?id=${zona.id}">Modificar</a>
				          <a class="btn btn-danger" href="EliminarZona?id=${zona.id}">Eliminar</a>
				        </div>
				      </div>
				      
				    </div>
				    
				  </c:forEach>
				</div>
	  		</div>
  		</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  	<script type="text/javascript">
  	const verUsuarios = document.getElementById('containerAccordionUsuario');
  	const verClientes = document.getElementById('containerAccordionCliente');
  	const verPersonal = document.getElementById('containerAccordionPersonal');
  	const verMonitores = document.getElementById('containerAccordionMonitor');
  	const verLimpieza = document.getElementById('containerAccordionLimpieza');
  	const verRecepcion = document.getElementById('containerAccordionRecepcion');
  	const verActividades = document.getElementById('containerAccordionActividad');
  	const verActividadesGrupo = document.getElementById('containerAccordionActividadesGrupo');
  	const verGrupos = document.getElementById('containerAccordionGrupo');
  	const verParcelas = document.getElementById('containerAccordionParcela');
  	const verReservas = document.getElementById('containerAccordionReserva');
  	const verTipos = document.getElementById('containerAccordionTipo');
  	const verVehiculos = document.getElementById('containerAccordionVehiculo');
  	const verVehiculosUsuario = document.getElementById('containerAccordionVehiculoUsuario');
  	const verZonas = document.getElementById('containerAccordionZona');

  	const btnUsuarios = document.getElementById('btnUsuarios');
  	const btnClientes = document.getElementById('btnClientes');
  	const btnPersonal = document.getElementById('btnPersonal');
  	const btnMonitores = document.getElementById('btnMonitores');
  	const btnLimpieza = document.getElementById('btnLimpieza');
  	const btnRecepcion = document.getElementById('btnRecepcion');
  	const btnActividades = document.getElementById('btnActividades');
  	const btnActividadesGrupo = document.getElementById('btnActividadesGrupo');
  	const btnGrupos = document.getElementById('btnGrupos');
  	const btnParcelas = document.getElementById('btnParcelas');
  	const btnReservas = document.getElementById('btnReservas');
  	const btnTipos = document.getElementById('btnTipos');
  	const btnVehiculos = document.getElementById('btnVehiculos');
  	const btnVehiculosUsuario = document.getElementById('btnVehiculosUsuario');
  	const btnZonas = document.getElementById('btnZonas');

  	btnUsuarios.addEventListener('click', () => {
  	        verUsuarios.classList.remove('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.add('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnClientes.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.remove('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.add('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnPersonal.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.remove('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.add('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnMonitores.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.remove('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.add('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnLimpieza.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.remove('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.add('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnRecepcion.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.remove('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.add('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnActividades.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.remove('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.add('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnActividadesGrupo.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.remove('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.add('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnGrupos.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.remove('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.add('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnParcelas.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.remove('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.add('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnReservas.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.remove('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.add('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnTipos.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.remove('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.add('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnVehiculos.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.remove('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.add('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnVehiculosUsuario.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.remove('d-none');
  	        verZonas.classList.add('d-none');

  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.add('active')
  	        btnZonas.classList.remove('active')
  	})

  	btnZonas.addEventListener('click', () => {
  	        verUsuarios.classList.add('d-none');
  	        verClientes.classList.add('d-none');
  	        verPersonal.classList.add('d-none');
  	        verMonitores.classList.add('d-none');
  	        verLimpieza.classList.add('d-none');
  	        verRecepcion.classList.add('d-none');
  	        verActividades.classList.add('d-none');
  	        verActividadesGrupo.classList.add('d-none');
  	        verGrupos.classList.add('d-none');
  	        verParcelas.classList.add('d-none');
  	        verReservas.classList.add('d-none');
  	        verTipos.classList.add('d-none');
  	        verVehiculos.classList.add('d-none');
  	        verVehiculosUsuario.classList.add('d-none');
  	        verZonas.classList.remove('d-none');
  	        
  	        btnUsuarios.classList.remove('active')
  	        btnClientes.classList.remove('active')
  	        btnPersonal.classList.remove('active')
  	        btnMonitores.classList.remove('active')
  	        btnLimpieza.classList.remove('active')
  	        btnRecepcion.classList.remove('active')
  	        btnActividades.classList.remove('active')
  	        btnActividadesGrupo.classList.remove('active')
  	        btnGrupos.classList.remove('active')
  	        btnParcelas.classList.remove('active')
  	        btnReservas.classList.remove('active')
  	        btnTipos.classList.remove('active')
  	        btnVehiculos.classList.remove('active')
  	        btnVehiculosUsuario.classList.remove('active')
  	        btnZonas.classList.add('active')
  	})
	</script>
  </body>
</html>