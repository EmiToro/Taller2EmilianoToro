package taller2;

import java.util.ArrayList;
import java.util.Random;

public class Habitat {
	private String nombre;
	private ArrayList<Pokemon> pokemonDispo;
	
	public Habitat(String nombre) {
		this.nombre = nombre;
		this.pokemonDispo = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Pokemon> getPokemonDispo() {
		return pokemonDispo;
	}

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
