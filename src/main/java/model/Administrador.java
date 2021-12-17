package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Administrador {
	protected List <Atraccion> atracciones = new ArrayList<Atraccion>();
	protected List <Promocion> promociones = new ArrayList<Promocion>();
	protected List <Usuario> usuarios = new ArrayList<Usuario>();
	Scanner teclado;

	public Administrador() {
	}

	public Administrador(List <Atraccion> atracciones, List <Usuario> usuarios) {
		this.atracciones = atracciones;
		this.usuarios = usuarios;
	}


	
	public void agregarTodasAtracciones(List <Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public void agregarTodosUsuarios(List <Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void agregarTodasPromociones(List <Promocion> promociones) {
		this.promociones = promociones;
	}

	public Atraccion obtenerAtraccionPorNombre(String nombre) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equalsIgnoreCase(nombre)) {
				return atraccion;
			}
		}
		return null;
	}

	private String escribirPorPantallaItinerario(Usuario usu) {
		return usu.decirItinerario();
	}

	private void ofrecerPromocionesIgualPreferencia(Usuario usu) {
		teclado = new Scanner(System.in);
		boolean noRepiteAtraccion;
		for (Promocion promoTotal : this.promociones) {
			if (!usu.getItinerarioPromociones().isEmpty()) {
				noRepiteAtraccion = true;
				for (Promocion promoItinerario : usu.getItinerarioPromociones()) {
					for (Atraccion atraccTotal : promoTotal.getAtracciones()) {
						for (Atraccion atraccItinerario : promoItinerario.getAtracciones()) {
							if (atraccItinerario.getNombre().equals(atraccTotal.getNombre())) {
								noRepiteAtraccion = false;
							}
						}
					}
				}
				if (usu.getTiempoDisponible() >= promoTotal.getTiempoTotal()
						&& usu.getPresupuesto() >= promoTotal.getPrecioFinal() && promoTotal.corroborarCupo()
						&& promoTotal.getTipoPromocion().equals(usu.getPreferencia()) && noRepiteAtraccion) {
					System.out.println("Le sugerimos:");
					System.out.println("       La promoci�n " + promoTotal.getNombre()
							+ " que incluye las atracciones: " + promoTotal.decirAtracciones()
							+ "por un precio total de $" + promoTotal.getPrecioFinal() + ". Le llevar� "
							+ promoTotal.getTiempoTotal() + "hs.");
					System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
					String acepto = teclado.nextLine();
					if (acepto.equalsIgnoreCase("SI")) {
						usu.agregarPromocionAItinerario(promoTotal);
						for (Atraccion atraccPromo : promoTotal.getAtracciones()) {
							Atraccion atraccParticular = obtenerAtraccionPorNombre(atraccPromo.getNombre());
							atraccParticular.setCupo(atraccParticular.getCupo() - 1);
							atraccPromo.setCupo(atraccPromo.getCupo() - 1);
						}
					}
				}

			} else {
				if (usu.getTiempoDisponible() >= promoTotal.getTiempoTotal()
						&& usu.getPresupuesto() >= promoTotal.getPrecioFinal() && promoTotal.corroborarCupo()
						&& promoTotal.getTipoPromocion().equals(usu.getPreferencia())) {
					System.out.println("Le sugerimos:");
					System.out.println("       La promoci�n " + promoTotal.getNombre()
							+ " que incluye las atracciones: " + promoTotal.decirAtracciones()
							+ "por un precio total de $" + promoTotal.getPrecioFinal() + ". Le llevar� "
							+ promoTotal.getTiempoTotal() + "hs.");
					System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
					String acepto = teclado.nextLine();
					if (acepto.equalsIgnoreCase("SI")) {
						usu.agregarPromocionAItinerario(promoTotal);
						for (Atraccion atraccPromo : promoTotal.getAtracciones()) {
							Atraccion atraccParticular = obtenerAtraccionPorNombre(atraccPromo.getNombre());
							atraccParticular.setCupo(atraccParticular.getCupo() - 1);
							atraccPromo.setCupo(atraccPromo.getCupo() - 1);
						}
					}
				}
			}
		}
	}

	private void ofrecerPromocionesDistintaPreferencia(Usuario usu) {
		teclado = new Scanner(System.in);
		boolean noRepiteAtraccion;
		for (Promocion promoTotal : this.promociones) {
			if (!usu.getItinerarioPromociones().isEmpty()) {
				noRepiteAtraccion = true;
				for (Promocion promoItinerario : usu.getItinerarioPromociones()) {
					for (Atraccion atraccTotal : promoTotal.getAtracciones()) {
						for (Atraccion atraccItinerario : promoItinerario.getAtracciones()) {
							if (atraccItinerario.getNombre().equals(atraccTotal.getNombre())) {
								noRepiteAtraccion = false;
							}
						}
					}
				}
				if (usu.getTiempoDisponible() >= promoTotal.getTiempoTotal()
						&& usu.getPresupuesto() >= promoTotal.getPrecioFinal() && promoTotal.corroborarCupo()
						&& !(promoTotal.getTipoPromocion().equals(usu.getPreferencia())) && noRepiteAtraccion) {
					System.out.println("Le sugerimos:");
					System.out.println("       La promoci�n " + promoTotal.getNombre()
							+ " que incluye las atracciones: " + promoTotal.decirAtracciones()
							+ "por un precio total de $" + promoTotal.getPrecioFinal() + ". Le llevar� "
							+ promoTotal.getTiempoTotal() + "hs.");
					System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
					String acepto = teclado.nextLine();
					if (acepto.equalsIgnoreCase("SI")) {
						usu.agregarPromocionAItinerario(promoTotal);
						for (Atraccion atraccPromo : promoTotal.getAtracciones()) {
							Atraccion atraccParticular = obtenerAtraccionPorNombre(atraccPromo.getNombre());
							atraccParticular.setCupo(atraccParticular.getCupo() - 1);
							atraccPromo.setCupo(atraccPromo.getCupo() - 1);
						}
					}
				}

			} else {
				if (usu.getTiempoDisponible() >= promoTotal.getTiempoTotal()
						&& usu.getPresupuesto() >= promoTotal.getPrecioFinal() && promoTotal.corroborarCupo()
						&& !(promoTotal.getTipoPromocion().equals(usu.getPreferencia()))) {
					System.out.println("Le sugerimos:");
					System.out.println("       La promoci�n " + promoTotal.getNombre()
							+ " que incluye las atracciones: " + promoTotal.decirAtracciones()
							+ "por un precio total de $" + promoTotal.getPrecioFinal() + ". Le llevar� "
							+ promoTotal.getTiempoTotal() + "hs.");
					System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
					String acepto = teclado.nextLine();
					if (acepto.equalsIgnoreCase("SI")) {
						usu.agregarPromocionAItinerario(promoTotal);
						for (Atraccion atraccPromo : promoTotal.getAtracciones()) {
							Atraccion atraccParticular = obtenerAtraccionPorNombre(atraccPromo.getNombre());
							atraccParticular.setCupo(atraccParticular.getCupo() - 1);
							atraccPromo.setCupo(atraccPromo.getCupo() - 1);
						}
					}
				}
			}
		}
	}

	public List <Atraccion> listarAtraccionesIgualPreferencia(Usuario usu) {
		List <Atraccion> atraccionesIgualPreferencia = new ArrayList<Atraccion>();
		for (Atraccion atracc : this.atracciones) {
			if (usu.getPreferencia().getID() == atracc.getTipo().getID()){
				atraccionesIgualPreferencia.add(atracc);
					}
		}
		Collections.sort(atraccionesIgualPreferencia, new ComparadorAtraccionTipoPrecioTiempo());
		return atraccionesIgualPreferencia;
	}
	
	public List <Atraccion> listarAtraccionesDistintaPreferencia(Usuario usu) {
		List <Atraccion> atraccionesDistintaPreferencia = new ArrayList<Atraccion>();
		for (Atraccion atracc : this.atracciones) {
			if (usu.getPreferencia().getID() != atracc.getTipo().getID()){
				atraccionesDistintaPreferencia.add(atracc);
					}
		}
		Collections.sort(atraccionesDistintaPreferencia, new ComparadorAtraccionTipoPrecioTiempo());
		return atraccionesDistintaPreferencia;
	}
	
	public List <Promocion> listarPromocionesIgualPreferencia(Usuario usu) {
		List <Promocion> promocionesIgualPrefe = new ArrayList<Promocion>();
		for (Promocion promo : this.promociones) {
			if (usu.getPreferencia().getID() == promo.getTipoPromocion().getID()){
				promocionesIgualPrefe.add(promo);
					}
		}
		Collections.sort(promocionesIgualPrefe, new ComparadorPromocionTipoPrecioTiempo());
		return promocionesIgualPrefe;
	}
	
	public List <Promocion> listarPromocionesDistintaPreferencia(Usuario usu) {
		List <Promocion> promocionesDistintaPrefe = new ArrayList<Promocion>();
		for (Promocion promo : this.promociones) {
			if (usu.getPreferencia().getID() != promo.getTipoPromocion().getID()){
				promocionesDistintaPrefe.add(promo);
					}
		}
		Collections.sort(promocionesDistintaPrefe, new ComparadorPromocionTipoPrecioTiempo());
		return promocionesDistintaPrefe;
	}

	protected void ofrecerAtraccionesDistintaPreferencia(Usuario usu) {
		teclado = new Scanner(System.in);
		boolean noRepiteAtraccion;
		for (Atraccion atracc : this.atracciones) {
			if (!usu.getItinerarioPromociones().isEmpty()) {
				noRepiteAtraccion = true;
				for (Promocion promo : usu.getItinerarioPromociones()) {
					for (Atraccion atraccEnPromo : promo.getAtracciones()) {
						if (atraccEnPromo.getNombre().equals(atracc.getNombre())) {
							noRepiteAtraccion = false;
						}
					}
				}
					if (noRepiteAtraccion && usu.getTiempoDisponible() >= atracc.getTiempo()
							&& usu.getPresupuesto() >= atracc.getPrecio() && atracc.getCupo() > 0
							&& !(atracc.getTipo().equals(usu.getPreferencia()))) {
						System.out.println("Le sugerimos:");
						System.out.println("La atracci�n " + atracc.getNombre() + ", por un precio de $"
								+ atracc.getPrecio() + ". Le llevar� " + atracc.getTiempo() + "hs.");
						System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
						String acepto = teclado.nextLine();
						if (acepto.equalsIgnoreCase("SI")) {
							usu.agregarAtraccionAItinerario(atracc);
							atracc.setCupo(atracc.getCupo() - 1);
						}
					}
			} else {
				if (usu.getTiempoDisponible() >= atracc.getTiempo() && usu.getPresupuesto() >= atracc.getPrecio()
						&& !(atracc.getTipo().equals(usu.getPreferencia()))) {
					System.out.println("Le sugerimos:");
					System.out.println("La atracci�n " + atracc.getNombre() + ", por un precio de $"
							+ atracc.getPrecio() + ". Le llevar� " + atracc.getTiempo() + "hs.");
					System.out.println("Ingrese SI si acepta la oferta o NO para declinarla");
					String acepto = teclado.nextLine();
					if (acepto.equalsIgnoreCase("SI")) {
						usu.agregarAtraccionAItinerario(atracc);
						atracc.setCupo(atracc.getCupo() - 1);
					}
				}
			}
		}
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Administrador [atracciones=" + atracciones + ", promociones=" + promociones + ", usuarios=" + usuarios
				+ "]";
	}


}
