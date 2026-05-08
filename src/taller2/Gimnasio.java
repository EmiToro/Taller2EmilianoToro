package taller2;

import java.util.ArrayList;
/**
 * Clase Gimnasio
 * Representa un gimnasio con un líder, estado y lista de Pokémon.
 */
public class Gimnasio {
	private int numero;
	private  String lider;
	private  String estado;
	private  ArrayList<Pokemon> pokemon;
	/**
     * Constructor de Gimnasio.
     * @param numero Número identificador del gimnasio.
     * @param lider Nombre del líder del gimnasio.
     */
	public Gimnasio(int numero, String lider) {
		this.numero = numero;
		this.lider = lider;
		this.estado = "Sin derrotar";
		this.pokemon = new ArrayList<>();
	}
    /** @return Número del gimnasio. */
	public int getNumero() {
		return numero;
	}
    /** @return Nombre del líder del gimnasio. */
	public String getLider() {
		return lider;
	}
    /** @return Estado actual del gimnasio (Derrotado/Sin derrotar). */
	public String getEstado() {
		return estado;
	}
    /** @return Lista de Pokémon del gimnasio. */
	public ArrayList<Pokemon> getPokemon() {
		return pokemon;
	}
    /** Cambia el estado del gimnasio. */
	public void setEstado(String estado) {
		this.estado = estado;
	}
    /** Agrega un Pokémon al gimnasio. */
	public void agregarPokemon(Pokemon p) {
		pokemon.add(p);
	}
	/**
     * Verifica si el jugador puede retar este gimnasio.
     * Solo se puede retar si todos los gimnasios anteriores están derrotados.
     * @param jugador Jugador que quiere retar.
     * @param gimnasios Lista de todos los gimnasios.
     * @return true si puede retar, false en caso contrario.
     */
	public boolean puedeRetar(Jugador jugador, ArrayList<Gimnasio> gimnasios) {
		for(int i = 0 ; i< numero - 1; i++) {
			if(!gimnasios.get(i).getEstado().equalsIgnoreCase("Derrotado")) {
				return false;
			}
		}
		return true;
	}
	
	
}
