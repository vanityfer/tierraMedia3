package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import utils.Crypt;

public class Usuario {
	private int idUsuario;
	private String nombre, contrasenia;
	private Boolean admin;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoAtraccion preferencia;
	private int presupuestoUsado;
	private double tiempoUsado;
	private List <Promocion> itinerarioPromociones = new ArrayList<Promocion>();
	private List <Atraccion> itinerarioAtracciones = new ArrayList<Atraccion>();
	private HashMap<String, String> errors;
	
	public Usuario(int idUsuario, String nombre, String contrasenia, TipoAtraccion preferencia, int presupuesto, double tiempoDisponible, Boolean admin) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
		this.setAdmin(admin);
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", preferencia=" + preferencia + ", presupuestoUsado=" + presupuestoUsado + ", tiempoUsado="
				+ tiempoUsado + ", itinerarioPromociones=" + itinerarioPromociones + ", itinerarioAtracciones="
				+ itinerarioAtracciones + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public TipoAtraccion getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(TipoAtraccion preferencia) {
		this.preferencia = preferencia;
	}
	
	public void agregarPromocionAItinerario(Promocion promo) {
		itinerarioPromociones.add(promo);
		this.setPresupuesto(this.getPresupuesto() - promo.getPrecioFinal());
		this.setTiempoDisponible(this.getTiempoDisponible() - promo.getTiempoTotal());
		this.setTiempoUsado(this.getTiempoUsado() + promo.getTiempoTotal());
		this.setPresupuestoUsado(this.getPresupuestoUsado() + promo.getPrecioFinal());
	}
	
	public void agregarAtraccionAItinerario(Atraccion atracc) {
		itinerarioAtracciones.add(atracc);
		this.setPresupuesto(this.getPresupuesto() - atracc.getPrecio());
		this.setTiempoDisponible(this.getTiempoDisponible() - atracc.getTiempo());
		this.setTiempoUsado(this.getTiempoUsado() + atracc.getTiempo());
		this.setPresupuestoUsado(this.getPresupuestoUsado() + atracc.getPrecio());
	}

	public List<Promocion> getItinerarioPromociones() {
		return itinerarioPromociones;
	}

	public List<Atraccion> getItinerarioAtracciones() {
		return itinerarioAtracciones;
	}
	
	public String decirItinerario() {
		String salida = "";
		salida+="Gracias por utilizar nuestro servicio " + getNombre() + "." + "\n";
		if (getItinerarioAtracciones().isEmpty() && getItinerarioPromociones().isEmpty()) {
			salida += "No ha seleccionado ninguna actividad para el d�a de hoy. �Vuelva pronto!";
		} else if (!getItinerarioAtracciones().isEmpty() && getItinerarioPromociones().isEmpty()) {
			salida += decirItinerarioAtracciones();
			salida += "El itinerario le llevara " + tiempoUsado + "hs y su valor total es de $" + presupuestoUsado
					+ ".";
		} else if (getItinerarioAtracciones().isEmpty() && !getItinerarioPromociones().isEmpty()) {
			salida+= decirItinerarioPromociones();
			salida += "El itinerario le llevara " + tiempoUsado + "hs y su valor total es de $" + presupuestoUsado
					+ ".";
		} else {
			salida+= decirItinerarioPromociones()+ "\n";
			salida+=decirItinerarioAtracciones()+ "\n";

			salida +=
			"El itinerario le llevara " + tiempoUsado + "hs y su valor total es de $" + presupuestoUsado
					+ ".";
		}
		return salida;
	}
	
	private String decirItinerarioPromociones() {
		String salida = "";
		salida += "Las promociones elegidas fueron: "+ "\n";
		for (Promocion promo : itinerarioPromociones) {
			salida += "La promocion " + promo.getNombre() + " que contiene las atracciones: ";
			for (Atraccion atracc : promo.atracciones) {
				salida += atracc.getNombre() + ", ";
			}
		}
		salida = salida.substring(0, salida.length()-2) + ". ";
		return salida;
	}
	
	public String decirItinerarioAtracciones() {
		String salida= "";
		salida+="Las atracciones elegidas fueron: "+ "\n";
		for (Atraccion atracc : itinerarioAtracciones) {
			salida+="La atraccion " + atracc.getNombre() + ".";
		}
		return salida;
	}

	public int getPresupuestoUsado() {
		return presupuestoUsado;
	}

	public void setPresupuestoUsado(int presupuestoUsado) {
		this.presupuestoUsado = presupuestoUsado;
	}

	public double getTiempoUsado() {
		return tiempoUsado;
	}

	public void setTiempoUsado(double tiempoUsado) {
		this.tiempoUsado = tiempoUsado;
	}
	
	public boolean isNull() {
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itinerarioAtracciones, itinerarioPromociones, nombre, preferencia, presupuesto,
				presupuestoUsado, tiempoDisponible, tiempoUsado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(itinerarioAtracciones, other.itinerarioAtracciones)
				&& Objects.equals(itinerarioPromociones, other.itinerarioPromociones)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(preferencia, other.preferencia)
				&& presupuesto == other.presupuesto && presupuestoUsado == other.presupuestoUsado
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible)
				&& Double.doubleToLongBits(tiempoUsado) == Double.doubleToLongBits(other.tiempoUsado);
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = Crypt.hash(contrasenia);
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public boolean canAfford(Atraccion atraccion) {
		return atraccion.getPrecio() <= this.presupuesto;
	}
	
	public boolean canAfford(Promocion promocion) {
		return promocion.getPrecioFinal() <= this.presupuesto;
	}

	public boolean canAttend(Atraccion atraccion) {
		return atraccion.getTiempo() <= this.tiempoDisponible;
	}
	
	public boolean canAttend(Promocion promocion) {
		return promocion.getTiempoTotal() <= this.tiempoDisponible;
	}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.contrasenia);
	}
	
	public Boolean isAdmin() {
		return admin;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (presupuesto < 0) {
			errors.put("presupuesto", "No debe ser negativo");
		}
		if (tiempoDisponible < 0) {
			errors.put("tiempoDisponible", "No debe ser negativo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
}
