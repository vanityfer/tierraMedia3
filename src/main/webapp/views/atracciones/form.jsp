<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value="${atraccion.nombre}">
</div>
<div class="mb-3">
	<label for="tipo"
		class='col-form-label'>Tipo:</label> 
		<select class="form-select" aria-label="Default select example"
		id="tipo" name="tipo">
		<option <c:if test="${atraccion == null}"> selected </c:if>>Seleccione el tipo de atracción:</option>
		<c:forEach items="${tiposAtraccion}" var="tipoAtraccion">
			<option <c:if test="${atraccion != null && atraccion.tipo.ID == tipoAtraccion.ID}">selected </c:if> value="${tipoAtraccion.ID}"><c:out value="${tipoAtraccion.name}" ></c:out></option>
		</c:forEach>
	</select>
</div>
<div class="mb-3">
	<label for="precio"
		class='col-form-label ${atraccion.errors.get("precio") != null ? "is-invalid" : "" }'>Precio:</label>
	<input class="form-control" type="number" id="precio" name="precio"
		required value="${atraccion.precio}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("precio")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="tiempo"
		class='col-form-label ${atraccion.errors.get("tiempo") != null ? "is-invalid" : "" }'>Duracion:</label>
	<input class="form-control" type="number" id="tiempo" name="tiempo"
		required value="${atraccion.tiempo}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("tiempo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="cupo"
		class='col-form-label ${atraccion.errors.get("cupo") != null ? "is-invalid" : "" }'>Capacidad:</label>
	<input class="form-control" type="number" id="cupo" name="cupo"
		required value="${atraccion.cupo}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("cupo")}'></c:out>
	</div>
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
