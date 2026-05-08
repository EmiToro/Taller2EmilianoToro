package taller2;

import java.util.ArrayList;
import java.util.Random;
/**
 * Clase Habitat
 * Representa un hábitat donde pueden aparecer Pokémon según su porcentaje de aparición.
 */
public class Habitat {
	private String nombre;
	private ArrayList<Pokemon> pokemonDispo;
	 /**
     * Constructor de Habitat.
     * @param nombre Nombre del hábitat.
     */
	public Habitat(String nombre) {
		this.nombre = nombre;
		this.pokemonDispo = new ArrayList<>();
	}
    /** @return Nombre del hábitat. */
	public String getNombre() {
		return nombre;
	}
    /** @return Lista de Pokémon disponibles en el hábitat. */
	public ArrayList<Pokemon> getPokemonDispo() {
		return pokemonDispo;
	}
	/**
     * Genera un Pokémon aleatorio de la pokedex que pertenezca a este hábitat,
     * considerando su porcentaje de aparición.
     * @param pokedex Lista completa de Pokémon.
     * @return Pokémon generado aleatoriamente.
     */
	public Pokemon generarPokemonA(ArrayList<Pokemon> pokedex) {
		ArrayList<Pokemon> candidatos = new ArrayList<>();
		for(Pokemon p: pokedex) {
			if(p.getHabitat().equalsIgnoreCase(nombre)) {
				candidatos.add(p);
			}
		}
		if(candidatos.isEmpty()) {
			return null;
		}
		Random rand = new Random();
		double prob = rand.nextDouble();
		double acumular = 0.0;
		
		for(Pokemon p: candidatos) {
			acumular += p.getPorcentajeAparicion();
			if(prob <= acumular) {
				return p;
			}
		}
		return candidatos.get(rand.nextInt(candidatos.size()));
	}

}
