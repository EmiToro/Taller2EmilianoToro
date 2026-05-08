package taller2;

import java.util.ArrayList;

public class Gimnasio {
	private int numero;
	private  String lider;
	private  String estado;
	private  ArrayList<Pokemon> pokemon;
	
	public Gimnasio(int numero, String lider) {
		this.numero = numero;
		this.lider = lider;
		this.estado = "Sin derrotar";
		this.pokemon = new ArrayList<>();
	}
	
	public int getNumero() {
		return numero;
	}

	public String getLider() {
		return lider;
	}

	public String getEstado() {
		return estado;
	}

	public ArrayList<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void agregarPokemon(Pokemon p) {
		pokemon.add(p);
	}
	
	public boolean puedeRetar(Jugador jugador, ArrayList<Gimnasio> gimnasios) {
		for(int i = 0 ; i< numero - 1; i++) {
			if(!gimnasios.get(i).getEstado().equalsIgnoreCase("Derrotado")) {
				return false;
			}
		}
		return true;
	}
	
	
}
