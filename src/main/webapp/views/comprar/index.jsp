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
			<h1>Estas son las promociones y atracciones de la Tierra Media</h1>
		</div>
		
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Producto</th>
					<th>Tipo</th>
					<th>Precio</th>
					<th>Duraci&oacute;n</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promocionesIgual}" var="promocionIgual">
					<tr>
						<td><strong><c:out value="${promocionIgual.nombre}"></c:out></strong>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Cras pretium eros urna. Sed quis erat congue, bibendum tortor
								malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
						<td><c:out value="${promocionIgual.tipoPromocion.name}"></c:out></td>
						<td><c:out value="${promocionIgual.precioFinal}"></c:out></td>
						<td><c:out value="${promocionIgual.tiempoTotal}"></c:out></td>
						<td>
							<c:choose>
								<c:when
									test="${usuario.canAfford(promocionIgual) && usuario.canAttend(promocionIgual) && promocionIgual.canHost(1)}">
									<a href="/turismo/promociones/buy.do?id=${promocionIgual.promocionId}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
				<c:forEach items="${atraccionesIgual}" var="atraccionIgual">
					<tr>
						<td><strong><c:out value="${atraccionIgual.nombre}"></c:out></strong>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Cras pretium eros urna. Sed quis erat congue, bibendum tortor
								malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
						<td><c:out value="${atraccionIgual.tipo.name}"></c:out></td>
						<td><c:out value="${atraccionIgual.precio}"></c:out></td>
						<td><c:out value="${atraccionIgual.tiempo}"></c:out></td>
						<td>
							<c:choose>
								<c:when
									test="${usuario.canAfford(atraccionIgual) && usuario.canAttend(atraccionIgual) && atraccionIgual.canHost(1)}">
									<a href="/turismo/atracciones/buy.do?id=${atraccionIgual.idAtraccion}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
				<c:forEach items="${promocionesDistinta}" var="promocionDistinta">
					<tr>
						<td><strong><c:out value="${promocionDistinta.nombre}"></c:out></strong>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Cras pretium eros urna. Sed quis erat congue, bibendum tortor
								malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
						<td><c:out value="${promocionDistinta.tipoPromocion.name}"></c:out></td>
						<td><c:out value="${promocionDistinta.precioFinal}"></c:out></td>
						<td><c:out value="${promocionDistinta.tiempoTotal}"></c:out></td>
						<td>
							<c:choose>
								<c:when
									test="${usuario.canAfford(promocionDistinta) && usuario.canAttend(promocionDistinta) && promocionDistinta.canHost(1)}">
									<a href="/turismo/promociones/buy.do?id=${promocionDistinta.promocionId}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>

				<c:forEach items="${atraccionesDistinta}" var="atraccionDistinta">
					<tr>
						<td><strong><c:out value="${atraccionDistinta.nombre}"></c:out></strong>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Cras pretium eros urna. Sed quis erat congue, bibendum tortor
								malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
						<td><c:out value="${atraccionDistinta.tipo.name}"></c:out></td>
						<td><c:out value="${atraccionDistinta.precio}"></c:out></td>
						<td><c:out value="${atraccionDistinta.tiempo}"></c:out></td>
						<td>
							<c:choose>
								<c:when
									test="${usuario.canAfford(atraccionDistinta) && usuario.canAttend(atraccionDistinta) && atraccionDistinta.canHost(1)}">
									<a href="/turismo/atracciones/buy.do?id=${atraccionDistinta.idAtraccion}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>