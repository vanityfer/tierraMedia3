<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre" required
		value="<c:choose><c:when test="${promocionFinal != null}">${promocionFinal.nombre} </c:when><c:when test="${promocionPorcentual != null}">${promocionPorcentual.nombre} </c:when><c:otherwise>${promocion3x2.nombre}</c:otherwise></c:choose>">
</div>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Elija el tipo de promoción</label> 
     <p>
    <input type="radio" name="interesado" value="porcentual" id="porcentual"> Porcentual
    <input type="radio" name="interesado" value="final" id="final"> Precio Final
    <input type="radio" name="interesado" value="tres" id="tres"> 3x2
  </p>
    
</div>   
  
<div class="mb-3">
	<label for="cost"
		class='col-form-label'>Precio final:</label> <input class="form-control" type="number" id="precioFinal"
		name="precioFinal" value=<c:if test="${promocionFinal != null}">"${promocionFinal.precioFinal}"</c:if>>
	<div class="invalid-feedback">
		<c:out value='${promocion.errors.get("precioFinal")}'></c:out>
	</div>
</div>




<div class="mb-3">
	<label for="porcentaje"
		class='col-form-label'>Porcentaje de descuento:</label>
	<input class="form-control" type="number" id="porcentaje" name="porcentaje"  value=<c:if test="${promocionPorcentual != null}">"${promocionPorcentual.porcentajePromo}"</c:if>>
</div>
 
<div class="mb-3">
	<label for="atraccion1"
		class='col-form-label'>Atracción 1:</label> <select class="form-select" aria-label="Default select example"
		id="atraccion1" name="atraccion1">
		<option <c:if test="${promocionFinal == null && promocionPorcentual == null && promocion3x2 == null}"> selected </c:if>>Seleccione la primera atracción</option>
		<c:forEach items="${atracciones}" var="atraccion">
			<option <c:if test="${promocionFinal != null && atraccion.idAtraccion == promocionFinal.atracciones.get(0).getIdAtraccion()}">selected </c:if> <c:if test="${promocionPorcentual != null && atraccion.idAtraccion == promocionPorcentual.atracciones.get(0).getIdAtraccion()}">selected </c:if><c:if test="${promocion3x2 != null && atraccion.idAtraccion == promocion3x2.atracciones.get(0).getIdAtraccion()}">selected</c:if> value="${atraccion.idAtraccion}"><c:out value="${atraccion.nombre}" ></c:out></option>
		</c:forEach>
	</select>
	<div class="mb-3">
	<label for="atraccion2"
		class='col-form-label'>Atracción 2:</label> <select class="form-select" aria-label="Default select example"
		id="atraccion1" name="atraccion2">
		<option <c:if test="${promocionFinal == null && promocionPorcentual == null && promocion3x2 == null}"> selected </c:if>>Seleccione la segunda atracción</option>
		<c:forEach items="${atracciones}" var="atraccion">
			<option <c:if test="${promocionFinal != null && atraccion.idAtraccion == promocionFinal.atracciones.get(1).getIdAtraccion()}">selected </c:if> <c:if test="${promocionPorcentual != null && atraccion.idAtraccion == promocionPorcentual.atracciones.get(1).getIdAtraccion()}">selected </c:if><c:if test="${promocion3x2 != null && atraccion.idAtraccion == promocion3x2.atracciones.get(1).getIdAtraccion()}">selected</c:if> value="${atraccion.idAtraccion}"><c:out value="${atraccion.nombre}" ></c:out></option>
		</c:forEach>
	</select>
	<label for="atraccion3"
		class='col-form-label'>Atracción 3:</label> <select class="form-select" aria-label="Default select example"
		id="atraccion3" name="atraccion3">
		<option <c:if test="${promocionFinal == null && promocionPorcentual == null && promocion3x2 == null}"> selected </c:if>value="-1">Seleccione la tercera atracción si corresponde:</option>
		<c:forEach items="${atracciones}" var="atraccion">
			<option  <c:if test="${promocion3x2 != null && atraccion.idAtraccion == promocion3x2.atracciones.get(2).getIdAtraccion()}"> selected </c:if>value="${atraccion.idAtraccion}"><c:out value="${atraccion.nombre}" ></c:out></option>
		</c:forEach>
	</select>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>

<script> var precioFinal = document.getElementById('precioFinal'); 
var porcentaje = document.getElementById('porcentaje'); 
var atraccion3 = document.getElementById('atraccion3'); 


document.getElementById('final').addEventListener('click', function(e) {
	
	  precioFinal.disabled = false;
	  porcentaje.disabled = true;
	  atraccion3.disabled = true;
	  
	  
	});

	
document.getElementById('porcentual').addEventListener('click', function(e) {
	
	  precioFinal.disabled = true;
	  porcentaje.disabled = false;
	  atraccion3.disabled = true;
	 
	});
	
document.getElementById('tres').addEventListener('click', function(e) {
	
	  precioFinal.disabled = true;
	  porcentaje.disabled = true;
	  atraccion3.disabled = false;
	 
	});

</script>


