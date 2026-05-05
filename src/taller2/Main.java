package taller2;


import java.util.*;
import java.io.*;


public class Main {
	static ArrayList<Pokemon> pokedex = new ArrayList<>();
	static ArrayList<Habitat> habitats = new ArrayList<>();
	static ArrayList<Gimnasio> gimnasios = new ArrayList<>();
	static ArrayList<AltoMando> altoMando = new ArrayList<>();
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
	
		System.out.println("--- Bienvenido al menu de Pokemon!! ---/n");
		boolean salir = false;
		leerArchivos();
		
		
		
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
			int opcion = s.nextInt(); 
			s.nextLine();
			
			while(opcion <= 0 || opcion > 8) {
				System.out.println("ERROR, porfavor ingrese una opcion valida: ");
				opcion = s.nextInt(); 
				s.nextLine();
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

	
	
	private static void leerArchivos() {
		leerPoxedex("Pokedex.txt");
		leerAltoMando("Alto Mando.txt");
		leerGimnasios("Gimnasios.txt");
		leerHabitats("Habitats.txt");
	}



	private static void leerPoxedex(String archivo) {
		try {
			Scanner sc = new Scanner(new File(archivo));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String habitat = partes[1];
				double porcentaje = Double.parseDouble(partes[2]);
				int vida = Integer.parseInt(partes[3]);
				int ataque = Integer.parseInt(partes[4]);
				int defensa = Integer.parseInt(partes[5]);
				int ataqueEsp = Integer.parseInt(partes[6]);
				int defensaEsp = Integer.parseInt(partes[7]);
				int velocidad = Integer.parseInt(partes[8]);
				String tipo = partes[9];
				Pokemon p = new Pokemon(nombre, habitat, porcentaje, vida, ataque, defensa, ataqueEsp, defensaEsp, velocidad, tipo);
				pokedex.add(p);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo " + archivo);
		}
	
	}

	private static void leerAltoMando(String archivo) {
		try {
			Scanner sc = new Scanner(new File(archivo));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				int numero = Integer.parseInt(partes[0]);
				String nombre = partes[1];
				
				AltoMando am = new AltoMando(numero, nombre);
				
				for(int i = 2; i< partes.length; i++) {
					String nombrePokemon = partes[i];
					Pokemon p = buscarPokemon(nombrePokemon, pokedex);
					if(p!= null) {
						am.agregarPokemon(p);
					}
				}
				altoMando.add(am);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo " + archivo);
		}
	}



	private static void leerGimnasios(String archivo) {
		try {
			Scanner sc = new Scanner(new File(archivo));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				int numero = Integer.parseInt(partes[0]);
				String lider = partes[1];
				String estado = partes[2];
				int cantPokemon = Integer.parseInt(partes[3]);
				
				Gimnasio g =new Gimnasio(numero,lider);
				g.setEstado(estado);
				
				for(int i = 0; i< cantPokemon; i++) {
					String nombrePokemon = partes[4 + i];
					Pokemon p = buscarPokemon(nombrePokemon, pokedex);
					if(p != null) {
						g.agregarPokemon(p);
					}
				}
				gimnasios.add(g);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo " + archivo);
		}
	}



	private static Pokemon buscarPokemon(String nombrePokemon, ArrayList<Pokemon> pokedex2) {
		// TODO Auto-generated method stub
		return null;
	}



	private static void leerHabitats(String archivo) {
		try {
			Scanner sc = new Scanner(new File(archivo));
			while(sc.hasNextLine()) {
				String nombre = sc.nextLine();
				Habitat h = new Habitat(nombre);
				habitats.add(h);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo " + archivo);
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
