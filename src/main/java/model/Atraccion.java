package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Atraccion{

	private String nombre;
	private int precio;
	private double tiempo;
	private int cupo;
	private TipoAtraccion tipo;
	private int idAtraccion;
	private Map<String, String> errors;
	
	public Atraccion(){
	}
	
	public Atraccion(int idAtraccion, String nombre, TipoAtraccion tipo, int precio, int cupo, double tiempo) {
		this.idAtraccion = idAtraccion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.cupo = cupo;
		this.tiempo = tiempo;
	}
	

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", precio=" + precio + ", tiempo=" + tiempo + ", cupo=" + cupo + ", tipo="
				+ tipo + "]";
	}
	

	public int getPrecio() {
		return precio;
	}
	
	public int getIdAtraccion() {
		return idAtraccion;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtraccion tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cupo, nombre, precio, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupo == other.cupo && Objects.equals(nombre, other.nombre) && precio == other.precio
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& Objects.equals(tipo, other.tipo);
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (precio <= 0) {
			errors.put("precio", "Debe ser positivo");
		}
		if (tiempo <= 0) {
			errors.put("tiempo", "Debe ser positivo");
		}
		if (tiempo > 60) {
			errors.put("tiempo", "Excede el tiempo máximo");
		}
		if (cupo <= 0) {
			errors.put("cupo", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public boolean canHost(int i) {
		return cupo >= i;
	}

	public void host(int i) {
		this.cupo -= i;
	}
}
