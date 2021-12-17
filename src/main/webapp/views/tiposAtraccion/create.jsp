<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../partials/head.jsp"></jsp:include>
</head>

	
	

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

<body>
	
<jsp:include page="../../partials/navfeo.jsp"></jsp:include>


	<main class="container">
		<div class="bg p-4 mb-3 rounded"> <h1>Crear tipo de atracción</h1> </div>
		



		<form action="/turismo/tiposAtraccion/create.do" method="post">
			<jsp:include page="/views/tiposAtraccion/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
