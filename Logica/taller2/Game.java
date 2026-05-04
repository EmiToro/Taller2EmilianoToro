package taller2;


import java.util.*;
import java.io.*;


public class Game {
	private static ArrayList<Pokemon> Pokedex = new ArrayList<Pokemon>();

	public static void main(String[] args) {
		Scanner esc = new Scanner(System.in);
		System.out.println("--- Bienvenido al menu de Pokemon!! ---/n");
		boolean salir = false;
		
		while(!salir) {
			System.out.println("1) Revisar equipo.");
			System.out.println("2) Salir a capturar.");
			System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
			System.out.println("4) Retar un gimnasio.");
			System.out.println("5) Desafío al Alto Mando.");
			System.out.println("6) Curar Pokémon.");
			System.out.println("7) Guardar.");
			System.out.println("8) Guardar y Salir.");
			System.out.println("/n -Porfavor ingrese su opcion: ");
			int opcion = esc.nextInt(); esc.nextLine();
			
			while(opcion <= 0 || opcion > 8) {
				System.out.println("ERROR, porfavor ingrese una opcion valida: ");
				opcion = esc.nextInt(); esc.nextLine();
			}
			
			switch(opcion) {
				case 1:
					revisarEquipo();
					break;
				case 2:
					salirCapturar();
					break;
				case 3:
					accesoPC();
					break;
				case 4:
					retarGym();
					break;
				case 5:
					desafiarAltoMando();
					break;
				case 6:
					curarPkm();
					break;
				case 7:
					Guardar();
					break;
				case 8:
					Guardar();
					salir = true;
					break;
			}
		}
	}

	
	
	private static void Guardar() {
		// TODO Auto-generated method stub
		
	}

	private static void curarPkm() {
		// TODO Auto-generated method stub
		
	}

	private static void desafiarAltoMando() {
		// TODO Auto-generated method stub
		
	}

	private static void retarGym() {
		// TODO Auto-generated method stub
		
	}

	private static void accesoPC() {
		// TODO Auto-generated method stub
		
	}

	private static void salirCapturar() {
		// TODO Auto-generated method stub
		
	}

	private static void revisarEquipo() {
		// TODO Auto-generated method stub
		
	}

}
