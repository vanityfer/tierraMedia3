<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
     
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="assets/stylesheets/estilos.css">
    <title>Tierra Media</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=MedievalSharp&display=swap" rel="stylesheet">

    <!-- BOOTSTRAP-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
    <!-- ÃCONOS TWITTER ETC -->
    <link href="vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">



<body>


   <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">-->

    <div class="container-fluid px-0">
        <nav class="navbar navbar-expand-lg navbar-light bg-dark">
            <div class="navbar-brand d-flex align-items-center">
                <a class="nav-link position-absolute start-45" href="#"><img src="img/logo-tierra-media.png" width="150" height="150"></a>
            </div>
            <div class="d-flex">
                <button class="navbar-toggler justify-content-start" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">

              <div class="navbar-nav ms-auto barraIcons align-items-right"> 
             
                   <!--<a href="http://twitter.com/vanityfer"><span class="bi bi-twitter"></span></a>
                    <a href="https://www.facebook.com/fernanda.mugica/"><span class="bi bi-facebook"></span></a>
                    <a href="https://www.instagram.com/vanity.fer/?hl=fr"><span class="bi bi-instagram"></span></a>-->
                    <a class="nav-item nav-link" href="#"><span class="bi-facebook" alt="" width="30" height="24"></a>
                    <a class="nav-item nav-link " href="#"><span class="bi-instagram" alt="" width="30" height="24"></a>
                    <a class="nav-item nav-link " href="#"><span class="bi-twitter" alt="" width="30" height="24"></a>
                </div>

                
            </div>
        </nav>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
        <nav class="navbar navbar-expand-lg navbar-light bg-light d-flex">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="navbar-nav w-100 justify-content-evenly">
                    <a class="nav-item nav-link active" href="index.html">Inicio</a>
                    <a class="nav-item nav-link" href="covid.html">Protocolo covid-19</a>
                    <a class="nav-item nav-link" href="atracciones.html">Comprar</a>
                    <a class="nav-item nav-link" href="#">Circuito</a>
                    <a class="nav-item nav-link" href="#">Espectáculos</a>
                    <a class="nav-item nav-link" href="#">Información</a>
                    <a class="nav-item nav-link" href="#">Contacto</a>
                    
                    
                    
                   <c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/TurismoTierraMedia_Capitulo03/usuarios/index.do">USUARIOS</a></li>
					
					
					
	<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${usuario.nombre}"></c:out>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: gold;" class="bi bi-coin"></i> <c:out value="${usuario.presupuesto}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i> <c:out value="${usuario.tiempoDisponible}"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="/logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>	
			</c:if>			
					<c:if test="${success != null}">
	<div class="alert alert-success">
		<p>
			<c:out value="${success}" />
		</p>
	</div>
</c:if>
					

