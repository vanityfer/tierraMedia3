<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<jsp:include page="partials/head.jsp"></jsp:include>



<body>


   <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">-->

    <div class="container-fluid px-0">
        <nav class="navbar navbar-expand-lg navbar-light bg-dark">
            <div class="navbar-brand d-flex align-items-center">
                <a class="nav-link active position-absolute start-45" href="#"><img src="img/logo-tierra-media.png" width="150" height="150"></a>
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
                    <a class="nav-item nav-link active" href="#"><span class="bi-facebook" alt="" width="30" height="24"></a>
                    <a class="nav-item nav-link active " href="#"><span class="bi-instagram" alt="" width="30" height="24"></a>
                    <a class="nav-item nav-link active " href="#"><span class="bi-twitter" alt="" width="30" height="24"></a>
                </div>

                
            </div>
        </nav>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
        <nav class="navbar navbar-expand-lg navbar-light bg-light d-flex">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="navbar-nav w-100 justify-content-evenly">
                    <a class="nav-item nav-link active" href="index.jsp">Inicio</a>
                    <a class="nav-item nav-link active" href="covid.jsp">Protocolo covid-19</a>
                
                    <a class="nav-item nav-link active" href="informacion.jsp">Información</a>
                    <a class="nav-item nav-link active" href="#">Contacto</a>
                     
               
    <c:if test="${!usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/comprar/index.do?id=${usuario.idUsuario}">Comprar</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="loginUsuarios.jsp">Login</a></li>
					
</c:if>					
		                     
                    
                   <c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/usuarios/index.do">Usuarios</a></li>
					</c:if>
					
					   <c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/atracciones/index.do">Atracciones</a></li>
					</c:if>
					<c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/tiposAtraccion/index.do">Tipos de atracción</a></li>
					</c:if>
					   <c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/promociones/index.do">Promociones</a></li>
					</c:if>
					<c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="loginUsuarios.jsp">Login</a></li>
					</c:if>
					
					
					
	<c:if test="${!usuario.isAdmin()}">
	<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
						<li><a href="../turismo/logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>	
			</c:if>	
			
			<c:if test="${usuario.isAdmin()}">
	<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
						<li><a href="../turismo/logout" class="dropdown-item">Salir</a></li>
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

			
                    
                    
                </div>
            </div>
        </nav>
    </div><!--//container-fluid-->
    
    <main class="container">
		<div class="bienvenido">
			<h1>
				¡Bienvenido a Tierra Media, <c:out value="${usuario.nombre}" />!
			</h1>
		</div>
	</main>
    
    
 <!-- Javascript -->
 <script src="js/main.js"></script>  
 
 <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
           <a title="uno" href="../../turismo/informacion.jsp"><img src="assets/img/carousel2.jpg" class="d-block w-100" alt="uno"></a>
                  
            <div class="carousel-caption d-none d-md-block">
            
              <h5 >CONOCÉ NUESTRAS ATRACCIONES</h5>
              
              <p class ="titcarru">No te pierdas las Aventuras de la Tierra Media</p>
            </div>
          </div>
          <div class="carousel-item">
           <a title="dos" href="/turismo/comprar/index.do"><img src="assets/img/imagenDerecha.jpg" class="d-block w-100" alt="dos"></a>
            <div class="carousel-caption d-none d-md-block">
              <h5>CONOCÉ NUESTRAS PROMOCIONES</h5>
              <p class ="titcarru">No te pierdas las Aventuras de la Tierra Media</p>
            </div>
          </div>
          <div class="carousel-item">
            <a title="tres" href="/turismo/comprar/index.do"><img src="assets/img/paisaje.jpg" class="d-block w-100" alt="tres"></a>
            <div class="carousel-caption d-none d-md-block">
              <h5>¡HAY COMBOS ESPECIALES PARA VOS!</h5>
              <p class="titcarru">No te pierdas las Aventuras de la Tierra Media</p>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
 
      
</body>

</html>