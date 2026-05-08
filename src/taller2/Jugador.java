package taller2;

import java.util.ArrayList;
/**
 * Clase Jugador
 * Representa al jugador con su nombre, cantidad de medallas,
 * equipo activo de hasta 6 Pokémon y el resto almacenado en el PC.
 */
public class Jugador {
	private String nombre;
	private  int medallas;
	private  ArrayList<Pokemon> equipo;
	private  ArrayList<Pokemon> pc;
	/**
     * Constructor de Jugador.
     * @param nombre Nombre del jugador.
     * @param medallas Número inicial de medallas.
     */
	public Jugador(String nombre, int medallas) {
		this.nombre = nombre;
		this.medallas = medallas;
		this.equipo = new ArrayList<>();
		this.pc = new ArrayList<>();
	}
    /** @return Nombre del jugador. */
	public String getNombre() {
		return nombre;
	}
    /** @return Número de medallas obtenidas. */
	public int getMedallas() {
		return medallas;
	}
	
    /** Cambia la cantidad de medallas. */
	public void setMedallas(int medallas) {
		this.medallas = medallas;
	}
    /** @return Lista de Pokémon en el equipo activo. */
	public ArrayList<Pokemon> getEquipo() {
		return equipo;
	}
    /** @return Lista de Pokémon almacenados en el PC. */
	public ArrayList<Pokemon> getPc() {
		return pc;
	}

    /**
     * Verifica si el jugador ya posee un Pokémon por nombre.
     * @param n Nombre del Pokémon.
     * @return true si ya lo tiene, false en caso contrario.
     */
	public boolean tienePokemon(String n) {
		for(Pokemon p: equipo) {
			if(p.getNombre().equalsIgnoreCase(n)) {
				return true;
			}
		}
		for(Pokemon p : pc) {
			if(p.getNombre().equalsIgnoreCase(n)) {
				return true;
			}
		}
		return false;
	}
	 /**
     * Agrega un Pokémon al equipo si hay espacio, si no lo envía al PC.
     * @param p Pokémon a agregar.
     */
	public void agregarPokemon(Pokemon p) {
		if(equipo.size() < 6) {
			equipo.add(p);
		}else {
			pc.add(p);
		}
	}
    /** Cura todos los Pokémon del equipo y del PC. */
	public void curarEquipo() {
		for(Pokemon p : equipo) {
			p.setEstado("Vivo");
		}for(Pokemon p : pc) {
			p.setEstado("Vivo");
		}
	}
	/**
     * Intercambia un Pokémon entre el equipo y el PC.
     * @param posEquipo Índice del Pokémon en el equipo.
     * @param posPC Índice del Pokémon en el PC.
     */
	public void cambiarPokemon(int posEquipo, int posPC) {
		Pokemon t = equipo.get(posEquipo);
		equipo.set(posEquipo, pc.get(posPC));
		pc.set(posPC, t);
	}
	
	
}
