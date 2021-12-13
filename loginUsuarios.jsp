<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/stylesheets/estilos.css">
    <title>Tierra Media</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=MedievalSharp&display=swap" rel="stylesheet">
     <!-- ÍCONOS TWITTER ETC -->
     <link href="vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">



</head>
<body>
<div class="container-fluid contenedor">
            <div class="row" id="filaPrincipal">
                <div class="col-6" id="columnaIzquierdaGrande">
                    <div class="row">
                        <div class="col-12" id="columnaInternaArriba">
                            <div class="float-right" id="contenedorImagenIzquierdaArriba">
                                <img src="assets/img/imagenIzquierdaArriba.jpg" alt="imagen izquierda arriba"
                                    id="imagenIzquierdaArriba">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12" id="columnaInternaAbajo">
                            <div class="float-right" id="contenedorImagenIzquierdaAbajo">
                                <img src="assets/img/imagenIzquierdaAbajo.jpg" alt="imagen izquierda abajo"
                                    id="imagenIzquierdaAbajo">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6" id="columnaDerechaGrande">
                    <div id="contenedorImagenDerecha">
                        <img src="assets/img/imagenDerecha.jpg" alt="imagen derecha" id="imagenDerecha">
                    </div>
                </div>
            </div>
        
            <div class="row" id="bloqueNegativo">
            </div>
                <div class="col-12">
                    <div class="mx-auto" id="recuadroCentral">
                        <div class="encabezados">
                            <h1 class="titulo">TIERRA MEDIA</h1>
                            <p>Bienvenido/a al sistema. Por favor ingrese sus datos:</p>
                        </div>
               

	<div class="col-lg-12 mx-auto p-3 py-md-4">

		<main>
			
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			
			<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>

			<div id="formulario">
			<form action="loginUsuarios" method="POST">

				<div class="form-group">
					<label for="nombreUsuario">Usuario</label> 
					<input type="text" class="form-control" name="nombreUsuario"placeholder="Introduzca su usuario">
				</div>

				<div class="form-group">
					<label for="contrasenia">Contraseña</label> <input
						type="password" class="form-control" name="contrasenia" placeholder="Introduzca la contraseña">
				</div>

				<div class="boton">
					<button type="submit" class="btn btn-default" id="botonEnviar">INGRESAR</button>
				</div>
			</form>
			</div>

		</main>
	</div>



                     
   
    

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous">
    </script>
      
</body>





</html>