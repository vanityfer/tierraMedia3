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

.titulo {
width:100%;
}

</style>

</head>
<body>

	<jsp:include page="../../partials/navfeo.jsp"></jsp:include>


	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Estas son las promociones de la Tierra Media</h1>
		</div>

		<c:if test="${usuario.isAdmin()}">
			<div class="mb-3">
				<a href="/turismo/promociones/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva
					Promoci&oacute;n
				</a>
				<a href="../../turismo/index.jsp" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Volver
				</a>
			</div>
		</c:if>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Promoci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Atracciones</th>
					<th>Tipo de promoci&oacute;n</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promociones}" var="promocion">
					<tr>
						<td><strong><c:out value="${promocion.nombre}"></c:out></strong>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Cras pretium eros urna. Sed quis erat congue, bibendum tortor
								malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
						<td><c:out value="${promocion.precioFinal}"></c:out></td>
						<td><c:out value="${promocion.tiempoTotal}"></c:out></td>
						<c:set var="stringAtracciones" value="" />
						<td><c:forEach items="${promocion.atracciones}"
								var="atraccionPromo">
								<c:set var="stringAtracciones"
									value="${stringAtracciones} - ${atraccionPromo.nombre}" />
							</c:forEach> <c:out value="${stringAtracciones}"></c:out></td>
						<td><c:out value="${promocion.tipoPromocion.name}"></c:out></td>

						<td><c:if test="${usuario.admin}">
								<a
									href="/turismo/promociones/edit.do?id=${promocion.promocionId}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a
									href="/turismo/promociones/delete.do?id=${promocion.promocionId}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>