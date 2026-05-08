package taller2;

import java.util.ArrayList;

public class AltoMando {
	private int numero;
	private String nombre;
	private ArrayList<Pokemon> pokemon;
	
	public AltoMando(int numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
		this.pokemon = new ArrayList<>();
	}
	
	
	
	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Pokemon> getPokemon() {
		return pokemon;
	}

	public void agregarPokemon(Pokemon p) {
		pokemon.add(p);
	}
	
	
}
