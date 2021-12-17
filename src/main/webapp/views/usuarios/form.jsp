<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value="${tmp_usuario.nombre}">
</div>
<div class="mb-3">
	<label for="presupuesto"
		class='col-form-label ${tmp_usuario.errors.get("presupuesto") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" id="presupuesto" name="presupuesto"
		required value="${tmp_usuario.presupuesto}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_usuario.errors.get("presupuesto")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="preferencia"
		class='col-form-label'>Preferencia:</label> 
		<select class="form-select" aria-label="Default select example"
		id="preferencia" name="preferencia">
		<option <c:if test="${usuario == null}"> selected </c:if>>Seleccione el tipo de atracción:</option>
		<c:forEach items="${tiposAtraccion}" var="tipoAtraccion">
			<option <c:if test="${usuario != null && usuario.preferencia.ID == tipoAtraccion.ID}">selected </c:if> value="${tipoAtraccion.ID}"><c:out value="${tipoAtraccion.name}" ></c:out></option>
		</c:forEach>
	</select>
</div>
<div class="mb-3">
	<label for="tiempoDisponible"
		class='col-form-label ${tmp_usuario.errors.get("tiempoDisponible") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="tiempoDisponible" name="tiempoDisponible"
		required value="${tmp_usuario.tiempoDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_usuario.errors.get("tiempoDisponible")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="password"
		class='col-form-label ${tmp_usuario.errors.get("contrasenia") != null ? "is-invalid" : "" }'>Contraseña:</label>
	<input class="form-control" type="password" id="contrasenia" name="contrasenia"
		required></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_usuario.errors.get("contrasenia")}'></c:out>
	</div>
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
