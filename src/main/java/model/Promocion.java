package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Promocion {
	protected int promocionId;
	protected String nombre;
	protected List <Atraccion> atracciones = new ArrayList<Atraccion>();
	protected int costo;
	protected int precioFinal;
	protected TipoAtraccion tipoPromocion;
	protected double tiempoTotal;
	protected int cupo;
	private Map<String, String> errors;
	
	public void setCupo() {
		int atraccionConMenorCupo = 50000;
		for(Atraccion atraccion : atracciones) {
			if(atraccion.getCupo() < atraccionConMenorCupo) {
				atraccionConMenorCupo = atraccion.getCupo();
			}
		}
		this.cupo = atraccionConMenorCupo;
	}
	public int getPromocionId() {
		return promocionId;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto() {
		for(Atraccion atraccion: atracciones) {
			this.costo += atraccion.getPrecio();
		}
	}
	
	public Promocion(int id) {
		this.promocionId = id;
	}
	
	public Promocion(int promocionId, String nombre, List<Atraccion> atracciones) {
		this.promocionId = promocionId;
		this.nombre = nombre;
		this.atracciones = atracciones;
		this.setCosto();
		this.setTipoPromocion();
		this.setTiempoTotal();
		this.setCupo();
	}
	
	public Promocion() {
	}
	
	protected void setTipoPromocion(){
		this.tipoPromocion = atracciones.get(0).getTipo();
	}
	
	public boolean canHost(int i) {
		for(Atraccion atraccion: atracciones) {
			if(atraccion.getCupo() < i) {
				return false;
		}
	}
		return true;
	}
	
	public void host(int i) {
		for(Atraccion atraccion: atracciones) {
			atraccion.host(i);
		}
	}
	
	
	public TipoAtraccion getTipoPromocion() {
		return tipoPromocion;
	}

	public abstract void setPrecioFinal();
	
	public int getPrecioFinal() {
		return precioFinal;
	}
	
	public double getTiempoTotal() {
		return tiempoTotal;
	}
	
	
	public void setTiempoTotal() {
		for(Atraccion atraccion: atracciones) {
			this.tiempoTotal += atraccion.getTiempo();
		}
	}
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}	
	
	public boolean corroborarCupo() {
		for (Atraccion atracc : atracciones) {
			if(atracc.getCupo() == 0) {
				return false;
			}
		}
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPromocionId(int id) {
		this.promocionId = id;
	}
	
	public String decirAtracciones() {
		String atraccionesString = "";
		for (Atraccion atracc : atracciones) {
			atraccionesString += atracc.getNombre() + ", ";
			}
		return atraccionesString;
	}
	@Override
	public int hashCode() {
		return Objects.hash(atracciones, costo, nombre, precioFinal, tiempoTotal, tipoPromocion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atracciones, other.atracciones) && costo == other.costo
				&& Objects.equals(nombre, other.nombre) && precioFinal == other.precioFinal
				&& Double.doubleToLongBits(tiempoTotal) == Double.doubleToLongBits(other.tiempoTotal)
				&& Objects.equals(tipoPromocion, other.tipoPromocion);
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (precioFinal <= 0) {
			errors.put("precioFinal", "Debe ser positivo");
		}
		if (tiempoTotal <= 0) {
			errors.put("tiempoTotal", "Debe ser positivo");
		}
		if (tiempoTotal > 120) {
			errors.put("tiempoTotal", "Excede el tiempo máximo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setPrecioFinal(int precioFinal) {
		
	}	
}
