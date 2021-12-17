

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>





<body>


   <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">-->

    <div class="container-fluid px-0"> <div class="collapse navbar-collapse" id="navbarSupportedContent">

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
        
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="navbar-nav w-100 justify-content-evenly">
                    <a class="nav-item nav-link active" href="../index.jsp">Inicio</a>
                    <a class="nav-item nav-link" href="covid.jsp">Protocolo covid-19</a>
                
                    <a class="nav-item nav-link" href="#">Circuito</a>
                   
                    <a class="nav-item nav-link" href="#">Información</a>
                    <a class="nav-item nav-link" href="#">Contacto</a>
               
    <c:if test="${!usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/usuarios/index.do">Comprar</a></li>
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/usuarios/index.do">Login</a></li>
					
</c:if>					
		                     
                    
                   <c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/usuarios/index.do">Usuarios</a></li>
					</c:if>
					
					   <c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/usuarios/index.do">Atracciones</a></li>
					</c:if>
					   <c:if test="${usuario.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/usuarios/index.do">Promociones</a></li>
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

			
                    
                    
                </div>
            </div>
        </nav>
    </div><!--//container-fluid-->
    
