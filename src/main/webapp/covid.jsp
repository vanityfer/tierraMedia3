 
 <!DOCTYPE html>
 <html lang="es">
 
 <head>
 <jsp:include page="partials/head.jsp"></jsp:include>
 </head>
 
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
                
                    <a class="nav-item nav-link" href="informacion.jsp">Información</a>
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
    
 
         <div class="atracciones"><h1>PROTOCOLO COVID-19</h1></div>
            
<div class="protocolo">
         <p>Aquí queremos contarte todas las medidas de bioseguridad que implementamos en Tierra Media para que vívas días de diversión segura!<br />
<br />
-RECORDÁ TENER TU PASAPORTE SANITARIO ACTUALIZADO.<br />
<br />
-LA CAPACIDAD DE VISITANTES DE NUESTRO PARQUE SE ENCUENTRA REDUCIDA POR MEDIDAS DE BIOSEGURIDAD.<br />
<br />
-ACCESO Y COMPRA DE ENTRADAS<br />
Reforzamos los controles en los accesos a nuestro parque a fin de respetar la distancia social, para ello hemos habilitado la PRE COMPRA de tickets a través de nuestra página web www.tierramedia.com.ar<br />
<br />
Se limitan al mínimo las compras en el día y en efectivo.<br />
<br />
-CONTROL DE INGRESOS<br />
El personal de control de ingreso exigirá que los visitantes se encuentren munidos de barbijos y que los utilicen correctamente. El uso del barbijo debe ser permanente y en todas las áreas del parque. Solo se podrá retirar para comer. <br />
<br />
Las niñas y niños de salas de 3 a 5 años de edad que cuenten con la autonomía suficiente para colocarse y quitarse el tapabocas por sus propios medios, deberían usarlo durante todo el tiempo que sea posible, en términos generales y de forma continua, excepto para comer o beber.<br />
<br />
EXCEPCIONES: Niños menores de 2 años, personas con problemas para respirar y personas que no puedan sacarse el barbijo sin ayuda, no deben usarlos<br />
<br />
Los visitantes deberán pasar por el control de temperatura asegurando así las medidas preventivas. Sólo se podrá ingresar si la temperatura es menor a 37,5 C. Si uno de los integrantes del grupo tiene esta temperatura o superior, no podrá acceder todo el grupo, teniendo que reprogramar la visita para días posteriores. De esta manera se asegura el concepto de la medida preventiva para fomentar el cumplimiento de &quot;permanecer en casa cuando estás enfermo&quot;.<br />
<br />
Se distribuirá gel antibacterial para manos para todos los visitantes que ingresen al parque.<br />
<br />
-LIMPIEZA Y SATINIZACIÓN<br />
Se procederá a la limpieza y sanitización periódica de instalaciones, áreas de juegos y locales antes de la apertura, en el transcurso de la jornada y luego del cierre del parque.<br />
<br />
Hemos instalado estaciones de desinfectante de manos ubicados por todo el parque para promover la concientización de higiene personal en los visitantes.<br />
<br />
-INGRESO A ATRACCIONES<br />
Instalamos letreros en las entradas de todas las atracciones con respecto al distanciamiento físico.<br />
Establecimos puntos de control en las entradas de cada atracción para monitorear la capacidad.<br />
Hemos señalizado cada una de las atracciones con información sobre la capacidad restringida, la capacidad de las filas de espera y colocamos marcadores de distancia para señalizar las posiciones de distanciamiento físico apropiado<br />
<br />
-RESTAURANTES COMIDAS Y BEBIDAS<br />
Todos los lugares de oferta gastronómica se encuentran adaptados para dar un servicio eficiente con capacidad reducida<br />
Destinamos mayor cantidad de espacios al aire libre con mesas para que disfrutes de tu almuerzo<br />
<br />
-NOS CUIDAMOS ENTRE TODOS<br />
Recordá todas nuestras medidas de prevención y ante cualquier consulta dirigite a nuestra oficina de Atención al visitante.<br />
<br />
¡TODO EL EQUIPO DE TIERRA MEDIA TE ESTÁ ESPERANDO PARA QUE VIVAS DÍAS A PURA DIVERSIÓN!</p>
                        </div>
                    </div>