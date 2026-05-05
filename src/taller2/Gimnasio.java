package taller2;

import java.util.ArrayList;

public class Gimnasio {
	private int numero;
	private  String lider;
	private  String estado;
	private  ArrayList<Pokemon> pokemon;
	
	public Gimnasio(int numero, String lider) {
		super();
		this.numero = numero;
		this.lider = lider;
		this.estado = "Sin derrotar";
		this.pokemon = new ArrayList<>();
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void agregarPokemon(Pokemon p) {
		// TODO Auto-generated method stub
		
	}
	
	
}
