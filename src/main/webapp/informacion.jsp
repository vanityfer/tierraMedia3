<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<jsp:include page="partials/head.jsp"></jsp:include>



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
                    <a class="nav-item nav-link active" href="index.jsp">Inicio</a>
                    <a class="nav-item nav-link" href="covid.jsp">Protocolo covid-19</a>
                
                    <a class="nav-item nav-link" href="informacion.jsp">Informaci髇</a>
                    <a class="nav-item nav-link" href="#">Contacto</a>
                     
               
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
						aria-current="page" href="/turismo/tiposAtraccion/index.do">Tipos de atracci髇</a></li>
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
						<li><a href="../turismo/logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>	
			</c:if>	
			
			<c:if test="${usuario.isAdmin()}">
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
        <div class="atracciones"><h1>ATRACCIONES DE LA TIERRA MEDIA</h1></div>
        
        <div class= "tablatracc">
        <table class="table">
            <thead>
              <tr>
                <th scope="col">ATRACCI覰N</th>
                <th scope="col">Costo</th>
                <th scope="col">Duraci髇</th>
                <th scope="col">Cupo</th>
                <th scope="col">Tipo</th>
                <th scope="col">Acciones</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=moria">Moria</a></th>
                <td>10</td>
                <td>2</td>
                <td>6</td>
                <td>Aventura</td>
                <td><button type="button" class="btn btn-success">Comprar</button></td>
              </tr>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=minas_tirith">Minas Tirith</a></th>
                <td>5</td>
                <td>2.5</td>
                <td>25</td>
                <td>Paisaje</td>
                <td><button type="button" class="btn btn-secondary">Comprar</button></td>
              </tr>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=la_comarca">La Comarca</a></th>
                <td>3</td>
                <td>6.5</td>
                <td>150</td>
                <td>Degustaci贸n</td>
                <td><button type="button" class="btn btn-success">Comprar</button></td>
              </tr>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=mordor">Mordor</a></th>
                <td>25</td>
                <td>3</td>
                <td>4</td>
                <td>Aventura</td>
                <td><button type="button" class="btn btn-secondary">Comprar</button></td>
              </tr>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=abismo_de_helm">Abismo de Helm</a></th>
                <td>5</td>
                <td>2</td>
                <td>15</td>
                <td>Paisaje</td>
                <td><button type="button" class="btn btn-success">Comprar</button></td>
              </tr>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=la_comarca">La Comarca</a></th>
                <td>3</td>
                <td>6.5</td>
                <td>150</td>
                <td>Degustaci贸n</td>
                <td><button type="button" class="btn btn-success">Comprar</button></td>
              </tr>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=lothlorien">Lothl贸rien</a></th>
                <td>35</td>
                <td>1</td>
                <td>30</td>
                <td>Degustaci贸n</td>
                <td><button type="button" class="btn btn-secondary">Comprar</button></td>
              </tr>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=erebor">Erebor</a></th>
                <td>12</td>
                <td>3</td>
                <td>32</td>
                <td>Paisaje</td>
                <td><button type="button" class="btn btn-secondary">Comprar</button></td>
              </tr>
              <tr>
                <th scope="row"><a href="atraccion.jsp?v=bosque_negro">Bosque Negro</a></th>
                <td>3</td>
                <td>4</td>
                <td>12</td>
                <td>Aventura</td>
                <td><button type="button" class="btn btn-success">Comprar</button></td>
              </tr>
            </tbody>
          </table>
        </div>
 <!-- Javascript -->
 <script src="js/main.js"></script>  
      
</body>

</html>