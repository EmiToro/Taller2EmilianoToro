package taller2;

import java.util.ArrayList;
/*
 * Clase AltoMando
 * Representa a un miembro del Alto Mando con un numero identificador, un nombre
 * y una lista de Pokemon asociados.
 */
public class AltoMando {
	private int numero;
	private String nombre;
	private ArrayList<Pokemon> pokemon;
	/**
     * Constructor de AltoMando.
     * @param numero Numero identificador del miembro del Alto Mando.
     * @param nombre Nombre del miembro del Alto Mando.
     */
	public AltoMando(int numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
		this.pokemon = new ArrayList<>();
	}
    /** @return Número identificador del miembro. */
	public int getNumero() {
		return numero;
	}
    /** @return Nombre del miembro del Alto Mando. */
	public String getNombre() {
		return nombre;
	}
    /** @return Lista de Pokémon del miembro. */
	public ArrayList<Pokemon> getPokemon() {
		return pokemon;
	}
	/**
     * Agrega un Pokémon al equipo del miembro.
     * @param p Pokémon a agregar.
     */
	public void agregarPokemon(Pokemon p) {
		pokemon.add(p);
	}
	
	
}
