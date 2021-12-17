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
		<div class="bg p-4 mb-3 rounded"> <h1>Editar atracción</h1> </div>




	<main class="container">

		<c:if test="${atraccion != null && !atraccion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la atracción.</p>
			</div>
		</c:if>

		<form action="/turismo/atracciones/edit.do" method="post">
			<input type="hidden" name="id" value="${atraccion.idAtraccion}">
			<jsp:include page="/views/atracciones/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
