package model;

import java.util.List;

public class Promocion3x2 extends Promocion {
	
	
	public void setPrecioFinal() {
		this.precioFinal = atracciones.get(0).getPrecio() + atracciones.get(1).getPrecio();
	}
	
	public Promocion3x2(int id) {
		super(id);
	}
	
	public Promocion3x2() {
	}
	
	public Promocion3x2(int idPromocion, String nombre, List<Atraccion> atracciones) {
		super(idPromocion, nombre, atracciones);
		this.setPrecioFinal();
	}

	@Override
	public String toString() {
		return "Promocion3x2 [nombre=" + nombre + ", atracciones=" + atracciones + ", costo=" + costo + ", precioFinal="
				+ precioFinal + ", tipoPromocion=" + tipoPromocion + ", tiempoTotal=" + tiempoTotal + "]";
	}
	
	
	
}
