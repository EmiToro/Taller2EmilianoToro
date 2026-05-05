package taller2;

import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private  int medallas;
	private  ArrayList<Pokemon> equipo;
	private  ArrayList<Pokemon> pc;
	
	public Jugador(String nombre, int medallas, ArrayList<Pokemon> equipo, ArrayList<Pokemon> pc) {
		this.nombre = nombre;
		this.medallas = medallas;
		this.equipo = equipo;
		this.pc = pc;
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
	
	
}
