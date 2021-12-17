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
			<h1>Usuarios</h1>
		</div>

		<c:if test="${usuario.isAdmin()}">
			<div class="mb-3">
				<a href="/turismo/usuarios/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario
				</a>
				<a href="../../turismo/index.jsp" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Volver
				</a>
			</div>
		</c:if>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Preferencia</th>
					<th>Monedas</th>
					<th>Tiempo</th>
					<th>Rol</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="tmp_usuario">
					<tr>
						<td><strong><c:out value="${tmp_usuario.nombre}"></c:out></strong></td>
						<td><c:out value="${tmp_usuario.preferencia.name}"></c:out></td>
						<td><c:out value="${tmp_usuario.presupuesto}"></c:out></td>
						<td><c:out value="${tmp_usuario.tiempoDisponible}"></c:out></td>
						<td>
							<c:choose>
								<c:when test="${tmp_usuario.admin}">
									Admin
								</c:when>
								<c:otherwise>
									Normal
								</c:otherwise>
							</c:choose>						
						</td>
						<td><c:if test="${usuario.admin && (!tmp_usuario.admin || tmp_usuario.idUsuario == usuario.idUsuario)}">
								<a href="/turismo/usuarios/edit.do?id=${tmp_usuario.idUsuario}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="/turismo/usuarios/delete.do?id=${tmp_usuario.idUsuario}"
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