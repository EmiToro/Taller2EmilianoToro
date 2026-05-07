package taller2;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static ArrayList<Pokemon> pokedex = new ArrayList<>();
	static ArrayList<Habitat> habitats = new ArrayList<>();
	static ArrayList<Gimnasio> gimnasios = new ArrayList<>();
	static ArrayList<AltoMando> altoMando = new ArrayList<>();
	static Scanner s = new Scanner(System.in);
	static Jugador jugador;
	
	public static void main(String[] args) {
	
		int opcion;
		do {
			System.out.println("1) Continuar");
			System.out.println("2) Nueva partida.");
			System.out.println("3) Salir");
			System.out.println("Ingrese una opcion: ");
			opcion = s.nextInt();
			s.nextLine();
			switch(opcion) {
			case 1:
				jugador = Registro.cargarRegistros("Registros.txt", pokedex);
				if(jugador == null) {
					System.out.println("No hay partida guardada. Cree una nueva partida. ");
				}else {
					System.out.println("Bienvenido de nuevo " + jugador.getNombre() + "!");
					menu2(jugador.getNombre());
				}
				break;
			case 2:
				System.out.println("Ingrese apodo: ");
				String apodo = s.nextLine();
				jugador = new Jugador(apodo, 0);
				System.out.println("Bienvenido " + apodo + "!!");
				menu2(apodo);
				break;
			case 3:
				
				break;
			default:
				System.out.println();
			}
			
		}while(opcion!= 3);
	
		leerArchivos();
		
		
		
	}

	
	
	private static void menu2(String apodo) {
		int opcion ;
		do {
			System.out.println(apodo + ", que deseas hacer?");
			System.out.println();
			System.out.println("1) Revisar equipo.");
			System.out.println("2) Salir a capturar.");
			System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
			System.out.println("4) Retar un gimnasio.");
			System.out.println("5) Desafío al Alto Mando.");
			System.out.println("6) Curar Pokémon.");
			System.out.println("7) Guardar.");
			System.out.println("8) Guardar y Salir.");
			System.out.println("\n Ingrese su opcion: ");
			opcion = s.nextInt(); 
			s.nextLine();
				
			
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
					//salir = true;
					break;
				default:
					System.out.println("Saliendo y guardando cambios.");
			}		
		}while(opcion != 8) ;
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



	private static Pokemon buscarPokemon(String nombrePokemon, ArrayList<Pokemon> pokedex) {
		for(Pokemon p: pokedex) {
			if(p.getNombre().equalsIgnoreCase(nombrePokemon)) {
				return p;
			}
		}
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
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("Registros.txt"))){
			bw.write(jugador.getNombre() + ";" + jugador.getMedallas());
			bw.newLine();
			for(Pokemon p: jugador.getEquipo()) {
				bw.write(p.getNombre() + ";" + p.getEstado());
				bw.newLine();
			}
			for(Pokemon p : jugador.getPc()) {
				bw.write(p.getNombre() + ";" + p.getEstado());
				bw.newLine();
			}
			System.out.println("Partida guardada!");
		}catch(IOException e) {
			System.out.println("Error al guardar partida.");
		}
	}

	private static void curarPkm() {
		jugador.curarEquipo();
		System.out.println("Tu equipo se ha recuperado!");
	}

	private static void desafiarAltoMando() {
		// TODO Auto-generated method stub
		
	}

	private static void retarGym() {
		// TODO Auto-generated method stub
		
	}

	private static void accesoPC() {
		System.out.println("Pokemon en PC: ");
		for(int i = 0; i< jugador.getPc().size(); i++) {
			System.out.println(( i + 1) + ") " + jugador.getPc().get(i).getNombre());
		}
		
		System.out.println("¿Quieres cambiar un Pokemon? ");
		System.out.println("(1 = Si, 2 = No)");
		int opcion = s.nextInt();
		if(opcion == 1) {
			System.out.println("Numero del pokemon en el equipo: ");
			int posEquipo = s.nextInt() - 1;
			System.out.println("Numero del pokemon en el PC:");
			int posPC = s.nextInt();
			s.nextLine();
			jugador.cambiarPokemon(posEquipo, posPC);
			System.out.println("Cambio realizado!");
		}
	}

	private static void salirCapturar() {
		System.out.println("Zonas disponibles: ");
		for(int i = 0; i< habitats.size(); i++) {
			System.out.println((i + 1) + ")" + habitats.get(i).getNombre());
		}
		int opcion = s.nextInt();
		if(opcion < 1 || opcion > habitats.size()) {
			return;
			
			
			
		}
		
		Habitat zona = habitats.get(opcion - 1);
		Pokemon encontrado = zona.generarPokemonA(pokedex);
		System.out.println("Oh!! Ha aparecido un increible " + encontrado.getNombre() + "!!");
		System.out.println("1) Capturar");
		System.out.println("2) Huir");
		int decision = s.nextInt();
		if(decision == 1) {
			if(!jugador.tienePokemon(encontrado.getNombre())) {
				jugador.agregarPokemon(encontrado);
				System.out.println(encontrado.getNombre() + " capturado con exito!! ");
			}else {
				System.out.println("Ya tienes a " + encontrado.getNombre());
			}
		}else {
			System.out.println("Has huido...");
		}
	}

	private static void revisarEquipo() {
		if(jugador.getEquipo().isEmpty()) {
			System.out.println("Tu equipo esta vacío. ");
		}else {
			System.out.println("Equipo actual: ");
			int i = 1;
			for(Pokemon p: jugador.getEquipo()) {
				System.out.println(i + ")" + p.getNombre() + "|" + p.getTipo() + "|Stats: " + p.calcularStats() +"| Estado: " + p.getEstado());
			}
		}
	}

}
