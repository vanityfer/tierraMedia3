package model;

import java.util.List;

public class PromocionFinal extends Promocion {

	@Override
	public void setPrecioFinal(int precioFinal) {
		this.precioFinal = precioFinal;
	}

	public PromocionFinal(int idPromocion, String nombre, List<Atraccion> atracciones, int precioFinal) {
		super(idPromocion, nombre, atracciones);
		this.precioFinal = precioFinal;
	}
	
	public PromocionFinal() {
	}

	@Override
	public String toString() {
		return "PromocionFinal [nombre=" + nombre + ", atracciones=" + atracciones + ", costo=" + costo
				+ ", precioFinal=" + precioFinal + ", tipoPromocion=" + tipoPromocion + ", tiempoTotal=" + tiempoTotal
				+ "]";
	}

	@Override
	public void setPrecioFinal() {
		this.precioFinal = precioFinal;
	}

	




}
