package taller2;

import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private  int medallas;
	private  ArrayList<Pokemon> equipo;
	private  ArrayList<Pokemon> pc;
	
	public Jugador(String nombre, int medallas) {
		this.nombre = nombre;
		this.medallas = medallas;
		this.equipo = new ArrayList<>();
		this.pc = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getMedallas() {
		return medallas;
	}

	public ArrayList<Pokemon> getEquipo() {
		return equipo;
	}

	public ArrayList<Pokemon> getPc() {
		return pc;
	}

	public boolean tienePokemon(String n) {
		return false;
	}

	public void agregarPokemon(Pokemon encontrado) {
		
	}

	public void curarEquipo() {
		
	}

	public void cambiarPokemon(int posEquipo, int posPC) {
		
	}
	
	
}
