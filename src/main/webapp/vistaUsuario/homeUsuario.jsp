<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
     <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Campamento de Verano</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="./styles/index.css">
    <!-- pet icon -->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <!-- activity icon -->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <!-- recycling icon -->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <!-- wheelchair icon -->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <!-- font poppins 100, 300, 500, 700 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;300;500;700&display=swap" rel="stylesheet">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Home</title>
  </head>
  <body class="d-flex justify-content-center align-items-center flex-column">
  	<c:set var="usuario" value="${ requestScope.usuario }"/>
  	<nav class="navbar navbar-expand-lg navbar-light bg-light position-fixed top-0" style="width: 100vw">
	  <div class="container-fluid">
	    <div class="navbar-brand">Campamento</div>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
	      <div class="nav-item dropdown"> 
	      	<a class="nav-link btn btn-warning" href="InsertarReserva">Reservar</a>
	      </div>
	      <div class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            ${ usuario.nombre } ${ usuario.apellido }
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="#">Home</a></li>
	            <li><a class="dropdown-item" href="MostrarPerfil">Mi Perfil</a></li>
	            <li><a class="dropdown-item" href="MostrarReservas">Mis Reservas</a></li>
	            <li><a class="dropdown-item" href="MostrarUsuarioVehiculo">Vehiculos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="CerrarSesion">Salir</a></li>
	          </ul>
	      </div>
	    </div>
	  </div>
	</nav>
	 <section id="video-section">
        <video autoplay loop muted>
            <source src="resources/videos/homeVideo.mp4" type="video/mp4" />
        </video>
        <div class="info-panel d-none d-md-flex">
            <div class="info">
                <span class="material-symbols-outlined">
                    pets
                </span>
                <span>Pet-Friendly</span>
            </div>
            <div class="info">
                <span class="material-symbols-outlined">
                    camping
                </span>
                <span>Actividades</span>
            </div>
            <div class="info">
                <span class="material-symbols-outlined">
                    recycling
                </span>
                <span>Eco-Friendly</span>
            </div>
            <div class="info">
                <span class="material-symbols-outlined">
                    accessible_forward
                </span>
                <span>Acceso discapacitados</span>
            </div>
        </div>
    </section>
    <section id="alojamiento">
        <header>
            <h2>Elije tu alojamiento</h2>
            <div class="elecciones">
                <span id="bungalow" class="active">Bungalow</span><span id="parcela">Parcela</span>
            </div>
        </header>
        <div id="bungalow-card" class="image-container container">
            <div class="alojamiento-info">
                <h3>Bungalow</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Facere vitae ratione amet aliquid quos
                    inventore autem repudiandae culpa animi cumque, quidem at! Reprehenderit asperiores consequuntur,
                    debitis maxime perferendis harum incidunt.</p>
                <button>+ info</button>
            </div>
        </div>
        <div id="parcela-card" class="image-container container hidden">
            <div class="alojamiento-info">
                <h3>Parcela</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Facere vitae ratione amet aliquid quos
                    inventore autem repudiandae culpa animi cumque, quidem at! Reprehenderit asperiores consequuntur,
                    debitis maxime perferendis harum incidunt.</p>
                <button>+ info</button>
            </div>
        </div>
    </section>
    <section id="actividades">
        <h2>Actividades</h2>
        <div class="container card-container flex-wrap justify-content-evenly">
            <div class="actividad-card a1 mt-3">
                <div class="texto">
                    <h3>Lorem ipsum dolor sit.</h3>
                    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Delectus minus unde distinctio. Totam
                        quidem, dignissimos itaque ipsam enim voluptate voluptatum.</p>
                </div>
            </div>
            <div class="actividad-card a2 mt-3">
                <div class="texto">
                    <h3>Lorem ipsum dolor sit.</h3>
                    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Delectus minus unde distinctio. Totam
                        quidem, dignissimos itaque ipsam enim voluptate voluptatum.</p>
                </div>
            </div>
            <div class="actividad-card a3 mt-3">
                <div class="texto">
                    <h3>Lorem ipsum dolor sit.</h3>
                    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Delectus minus unde distinctio. Totam
                        quidem, dignissimos itaque ipsam enim voluptate voluptatum.</p>
                </div>
            </div>
        </div>
    </section>

    <section id="sobre-nosotros">
        <div class="container-sobre-nosotros">
            <div class="info-sobre-nosotros w-100 w-md-50 w-ld-50 w-xl-50">
                <h2>Sobre Nosotros</h2>
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Saepe quod sit perspiciatis incidunt ipsum
                    ab quos quas illo ipsam dicta ipsa delectus autem aliquid temporibus id magni eaque, mollitia
                    voluptate. <br><br> Delectus ullam possimus et numquam ad doloremque quas ipsa pariatur explicabo,
                    obcaecati nostrum a eius consectetur suscipit repellat itaque, ab autem corrupti asperiores
                    aspernatur iure. <br><br> Porro, repellendus inventore sunt rerum consequatur omnis. Suscipit rem,
                    nemo voluptate fugiat necessitatibus porro libero quae neque facilis, esse consectetur ea iure
                    laborum, debitis deleniti?</p>
            </div>
        </div>
    </section>

    <section id="pet-friendly">
        <div class="container-pet-friendly">
            <div class="info-pet-friendly w-100 w-md-50">
                <h2>Pet-Friendly</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi ut sunt praesentium in! Cumque
                    repellendus quo, omnis doloremque labore ex quod adipisci facilis aperiam ducimus qui possimus minus
                    odio nam!
                    Facere voluptas, asperiores cupiditate saepe obcaecati quasi accusantium fugiat, ratione
                    necessitatibus blanditiis amet cum delectus fugit corporis. Doloribus eligendi, nisi pariatur
                    laudantium vel, voluptatum exercitationem veritatis nihil ex iste sed.
                    Numquam tempore atque distinctio alias rem suscipit sit sint cum officia corrupti reprehenderit quis
                    a quibusdam corporis temporibus aliquid, minima nesciunt adipisci unde accusamus natus in!
                    Doloremque sapiente aliquam expedita.
                    <br>
                    Doloribus excepturi neque eum corporis dicta officia quam, cumque harum molestiae porro consequuntur
                    eligendi veritatis facere voluptas vel perferendis laborum aspernatur autem impedit quasi, aliquam
                    ducimus tempore sapiente ex. Voluptate.
                    Eaque, quibusdam eum! Quasi quam quidem, blanditiis quisquam atque dicta corrupti modi eligendi
                    illum consequuntur omnis aut dolore quas eaque alias ipsa quaerat incidunt enim at tempora velit!
                    Quasi, aut.
                </p>
            </div>
        </div>
    </section>

    <section id="zonas">
        <h1>Mapa Zonas del Campamento</h1>
        <div class="mapa-zonas"></div>
    </section>

    <section id="prestaciones">
        <h1>Prestaciones ofrecidas</h1>
        <div class="container-prestaciones">
            <div class="info-prestaciones">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi ut sunt praesentium in! Cumque
                    repellendus quo, omnis doloremque labore ex quod adipisci facilis aperiam ducimus qui possimus minus
                    odio nam!
                    Facere voluptas, asperiores cupiditate saepe obcaecati quasi accusantium fugiat, ratione
                    necessitatibus blanditiis amet cum delectus fugit corporis. Doloribus eligendi, nisi pariatur
                    laudantium vel, voluptatum exercitationem veritatis nihil ex iste sed.
                    Numquam tempore atque distinctio alias rem suscipit sit sint cum officia corrupti reprehenderit quis
                    a quibusdam corporis temporibus aliquid, minima nesciunt adipisci unde accusamus natus in!
                    Doloremque sapiente aliquam expedita.
                    <br>
                    Doloribus excepturi neque eum corporis dicta officia quam, cumque harum molestiae porro consequuntur
                    eligendi veritatis facere voluptas vel perferendis laborum aspernatur autem impedit quasi, aliquam
                    ducimus tempore sapiente ex. Voluptate.
                    Eaque, quibusdam eum! Quasi quam quidem, blanditiis quisquam atque dicta corrupti modi eligendi
                    illum consequuntur omnis aut dolore quas eaque alias ipsa quaerat incidunt enim at tempora velit!
                    Quasi, aut.
                </p>
            </div>
        </div>
    </section>

    <footer id="pie">
        <div class="logo-corporativo">
            <div class="logo"></div>
        </div>
        <div class="redes-sociales">
            <a class="instagram" href="https://www.instagram.com/"></a>
            <a class="facebook" href="https://es-es.facebook.com/"></a>
            <a class="twitter" href="https://twitter.com/?lang=es"></a>
            <a class="youtube" href="https://www.youtube.com/"></a>
        </div>
        <div class="contacto">
            <div class="telefono">
                <p>+34 910 123 456</p>
            </div>
            <div class="horario">
                <p>L-D 9:00-13:30 y 16:00-20:00</p>
            </div>
            <div class="correo">
                <p type="email">BSerenityS@gmail.com</p>
            </div>
        </div>
        <div class="documentacion">
            <div class="vigencia">Barba's Serenity Spot © 2023 |</div>
            <div class="terminos-condiciones"><a href="/campamento/resources/pdf's/TerminosCondiciones.pdf"> Términos y
                    Condiciones |</a></div>
            <div class="politica-privacidad"><a href="/campamento/resources/pdf's/PolíticaPrivacidad.pdf"> Política de
                    Privacidad |</a></div>
            <div class="politica-cookies"><a href="/campamento/resources/pdf's/PolíticaCookies.pdf"> Política de Cookies
                    |</a></div>
            <div class="aviso-legal"><a href="/campamento/resources/pdf's/Aviso legal.pdf"> Aviso Legal</a></div>
        </div>
    </footer>
    <script>
        const spanBungalow = document.getElementById('bungalow')
        const spanParcela = document.getElementById('parcela')
        const panelInfoBungalow = document.getElementById('bungalow-card')
        const panelInfoParcela = document.getElementById('parcela-card')

        const cambiarInfo = () => {
            spanBungalow.classList.toggle('active')
            spanParcela.classList.toggle('active')
            panelInfoBungalow.classList.toggle('hidden')
            panelInfoParcela.classList.toggle('hidden')
        }

        spanBungalow.addEventListener('click', () => cambiarInfo())

        spanParcela.addEventListener('click', () => cambiarInfo())
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>