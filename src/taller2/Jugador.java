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
	

	public void setMedallas(int medallas) {
		this.medallas = medallas;
	}

	public ArrayList<Pokemon> getEquipo() {
		return equipo;
	}

	public ArrayList<Pokemon> getPc() {
		return pc;
	}

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

	public void agregarPokemon(Pokemon p) {
		if(equipo.size() < 6) {
			equipo.add(p);
		}else {
			pc.add(p);
		}
	}

	public void curarEquipo() {
		for(Pokemon p : equipo) {
			p.setEstado("Vivo");
		}for(Pokemon p : pc) {
			p.setEstado("Vivo");
		}
	}

	public void cambiarPokemon(int posEquipo, int posPC) {
		Pokemon t = equipo.get(posEquipo);
		equipo.set(posEquipo, pc.get(posPC));
		pc.set(posPC, t);
	}
	
	
}
