package taller2;

import java.util.*;
/**
 * Clase Pokemon
 * Representa un Pokémon con sus atributos de combate, tipo,
 * hábitat de aparición y estado actual.
 */
public class Pokemon {
	private String nombre;
	private String habitat;
	private double porcentajeAparicion;
	private int vida;
	private int ataque;
	private int defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private String tipo;
	private String estado;
	private List<Habitat> habitats;
	/**
     * Constructor de Pokémon.
     * @param nombre Nombre del Pokémon.
     * @param habitat Hábitat de aparición.
     * @param porcentajeAparicion Probabilidad de aparición.
     * @param vida Puntos de vida.
     * @param ataque Valor de ataque físico.
     * @param defensa Valor de defensa física.
     * @param ataqueEspecial Valor de ataque especial.
     * @param defensaEspecial Valor de defensa especial.
     * @param velocidad Velocidad del Pokémon.
     * @param tipo Tipo elemental del Pokémon.
     */
	public Pokemon(String nombre, String habitat, double porcentajeAparicion, int vida, int ataque, int defensa,
			int ataqueEspecial, int defensaEspecial, int velocidad, String tipo) {
		super();
		this.nombre = nombre;
		this.habitat = habitat;
		this.porcentajeAparicion = porcentajeAparicion;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.tipo = tipo;
		this.estado = "Vivo";
		this.habitats = new ArrayList<Habitat>();	
	}
    /** @return Nombre del Pokémon. */
	public String getNombre() {
		return nombre;
	}
    /** @return Hábitat del Pokémon. */
	public String getHabitat() {
		return habitat;
	}
    /** @return Porcentaje de aparición en hábitat. */
	public double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}
    /** @return Puntos de vida. */
	public int getVida() {
		return vida;
	}
    /** @return Valor de ataque físico. */
	public int getAtaque() {
		return ataque;
	}
    /** @return Valor de defensa física. */
	public int getDefensa() {
		return defensa;
	}
    /** @return Valor de ataque especial. */
	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}
    /** @return Valor de defensa especial. */
	public int getDefensaEspecial() {
		return defensaEspecial;
	}
    /** @return Velocidad del Pokémon. */
	public int getVelocidad() {
		return velocidad;
	}
    /** @return Tipo elemental del Pokémon. */
	public String getTipo() {
		return tipo;
	}
    /** @return Lista de hábitats asociados. */
	public List<Habitat> getHabitats() {
		return habitats;
	}
    /** Agrega un hábitat asociado. */
	public void addHabitats(Habitat h) {
		this.habitats.add(h);
	}
    /** @return true si el Pokémon está vivo. */
	public boolean estaVivo() {
		return estado.equals("Vivo");
	}
    /** @return Estado actual del Pokémon. */
	public String getEstado() {
		return estado;
	}
    /** Cambia el estado del Pokémon. */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
     * Calcula el total de estadísticas sumando todos los atributos.
     * @return Valor total de stats.
     */
	public int CalcularStatsTotal() {
	    return vida + ataque + defensa + ataqueEspecial + defensaEspecial + velocidad;
	}
	@Override
	public String toString() {
		return  nombre + " | " + tipo + " Stats: " + CalcularStatsTotal() + " | Estado: " + estado;
	}
	

}
