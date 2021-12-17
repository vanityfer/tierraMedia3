<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../partials/head.jsp"></jsp:include>
<style>
* { font-family: 'MedievalSharp', cursive; 
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}
h1 {
margin-top:30px;
}
</style>
</head>
<body>
	<jsp:include page="../../partials/navfeo.jsp"></jsp:include>


	<main class="container">
		<div class="bg p-4 mb-3 rounded"> <h1>Crear atracción</h1> </div>
		

		<c:if test="${atraccion != null && !atraccion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear la atracción.</p>
			</div>
		</c:if>

		<form action="/turismo/atracciones/create.do" method="post">
			<jsp:include page="/views/atracciones/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
