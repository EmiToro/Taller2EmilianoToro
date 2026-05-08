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
		leerArchivos();
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
				jugador = cargarRegistros("Registros.txt", pokedex);
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
	
	}
	
	private static Jugador cargarRegistros(String archivo, ArrayList<Pokemon> pokedex) {
		try(Scanner sc = new Scanner(new File(archivo))){
			if(!sc.hasNextLine()) {
				return null;
			}
			String[] primera = sc.nextLine().split(";");
			String nombre = primera[0];
			int medallas = Integer.parseInt(primera[1]);
			Jugador jugador = new Jugador(nombre, medallas);
			
			while(sc.hasNextLine()) {
				String[] partes = sc.nextLine().split(";");
				String nombrePokemon = partes[0];
				String estado = partes[1];
				Pokemon p = buscarPokemon(nombrePokemon, pokedex);
				if( p != null) {
					p.setEstado(estado);
					jugador.agregarPokemon(p);
				}
			}
			return jugador;
		}catch(Exception e) {
			System.out.println("Error al cargar registros!!!");
			return null;
		}
		
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
		if(jugador.getMedallas() < 8) {
			System.out.println("Debes derrotar  a los 8 gimnasios antes de desafiar al Alto Mando!");
			return;
		}
		for(AltoMando am: altoMando) {
			System.out.println("Desafiando a " + am.getNombre() + "!!");
			for(Pokemon pAM: am.getPokemon()) {
				Pokemon pJugador = null;
				for(Pokemon pj : jugador.getEquipo()) {
					if(pj.estaVivo()) {
						pJugador = pj;
						break;
					}
				}
				if(pJugador == null) {
					System.out.println("Te has quedado sin Pokemon en tu equipo!");
					System.out.println("Volviendo al menu...");
					return;
				}
				System.out.println(am.getNombre() + " saca a " + pAM.getNombre());
				System.out.println(jugador.getNombre() + " saca a " + pJugador.getNombre());
			
				boolean enCombate = true;
				while(enCombate && pJugador.estaVivo() && pAM.estaVivo()) {
					System.out.println("¿Que deseas hacer?\n1) Atacar\n2) Cambiar de Pokemon\n3) Rendirse");
					int accion = s.nextInt();
					s.nextLine();
					if(accion == 1) {
						Combate combate = new Combate(pJugador, pAM);
						System.out.println(combate.simularBatalla());
						enCombate = false;
					}else if(accion == 2) {
						System.out.println("Elige otro Pokemon del equipo: ");
						for(int i = 0; i< jugador.getEquipo().size(); i++) {
							System.out.println((i + 1) + ") " + jugador.getEquipo().get(i).getNombre());
						}
						int nuevo = s.nextInt() - 1;
						if(nuevo >= 0 && nuevo < jugador.getEquipo().size()) {
							pJugador = jugador.getEquipo().get(nuevo);
							System.out.println(jugador.getNombre() + " cambia a " + pJugador.getNombre());
						}
					}else {
						System.out.println("Te has rendido...");
						return;
						}
					  }
					}
				}
				System.out.println("¡Felicidades! Has derrotado al Alto Mando y eres el campeon!");
			}

	private static void retarGym() {
		System.out.println("¿A cual lider deseas retar?");
		for(Gimnasio g: gimnasios) {
			System.out.println(g.getNumero() + ") " + g.getLider() + "- Estado: " + g.getEstado());
		}
		System.out.println((gimnasios.size() + 1) + ") Volver al menu");
		int opcion = s.nextInt(); s.nextLine();
		if(opcion < 1 || opcion > gimnasios.size()) {
			return;
		}
		Gimnasio gym = gimnasios.get(opcion - 1);
		if(!gym.puedeRetar(jugador, gimnasios)){
			System.out.println("Calmado Entrenador!!! No puedes retar a " + gym.getLider() + " sin haber derrotado a los anteriores!");
			return;
		}
		
		System.out.println("Desafiando a " + gym.getLider() + "!!");
		for(Pokemon pGym : gym.getPokemon()) {
			Pokemon pJugador = null;
			for(Pokemon pj : jugador.getEquipo()) {
				if(pj.estaVivo()) {
					pJugador = pj;
					break;
				}
			}
			if(pJugador == null) {
				System.out.println("Te has quedado sin Pokemon en tu equipo!");
				System.out.println("Volviendo al menu...");
				return;
			}
			System.out.println(gym.getLider() + " saca a " + pGym.getNombre());
			System.out.println(jugador.getNombre() + " saca a " + pJugador.getNombre());
			
			boolean enCombate= true;
			while(enCombate && pJugador.estaVivo() && pGym.estaVivo()) {
				System.out.println("¿Que deseas hacer?\n1) Atacar\n2) Cambiar de Pokemon\n3) Rendirse");
				int accion = s.nextInt();
				s.nextLine();
				if(accion == 1) {
					Combate combate = new Combate(pJugador, pGym);
					System.out.println(combate.simularBatalla());
					enCombate =  false;
				}else if(accion == 2) {
					System.out.println("Elige otro Pokemon del equipo: ");
					for(int i = 0; i< jugador.getEquipo().size(); i++) {
						System.out.println((i + 1) + ") " + jugador.getEquipo().get(i).getNombre());
					}
					int nuevo = s.nextInt() - 1;
					if(nuevo >= 0 && nuevo < jugador.getEquipo().size()) {
						pJugador = jugador.getEquipo().get(nuevo);
						System.out.println(jugador.getNombre() + " cambia a " + pJugador.getNombre());
					}
				}else {
					System.out.println("Te has rendido...");
					return;
					}
				}
			}			
		    if(!gym.getEstado().equals("Derrotado")) {
	              gym.setEstado("Derrotado");
	              jugador.setMedallas(jugador.getMedallas() + 1);
	              System.out.println("¡Has ganado la medalla de " + gym.getLider() + "!");
	          }
		}

	private static void accesoPC() {
	    System.out.println("--- Sistema PC Pokemon --- \n");
	    System.out.println("-Equipo activo-");
	    System.out.println("----------------------------------------------------");
	    
	    if(jugador.getEquipo().isEmpty()) {
	        System.out.println("(Sin pokemon en el equipo) \n");
	    } else {
	        for(int i = 0; i < jugador.getEquipo().size(); i++) {
	            Pokemon p = jugador.getEquipo().get(i);
	            String estado;
	            if(p.estaVivo()) {
	                estado = "Vivo";
	            } else {
	                estado = "Debilitado";
	            }
	            System.out.println("  " + (i + 1) + ") " + p.getNombre() 
	                + " [" + p.getTipo() + "]"
	                + "  |  Stats: " + p.CalcularStatsTotal()
	                + "  |  " + estado);
	        }
	    }
	    System.out.println("");
	    System.out.println("--- Pokemon Center --- \n");
	    System.out.println("----------------------------------------------------");
	    if(jugador.getPc().isEmpty()) {
	        System.out.println("  (El PC está vacío) \n");
	    } else {
	        for(int i = 0; i < jugador.getPc().size(); i++) {
	            Pokemon p = jugador.getPc().get(i);
	            String estado = p.estaVivo() ? "Vivo" : "Debilitado";
	            System.out.println("  " + (i + 1) + ") " + p.getNombre()
	                + " [" + p.getTipo() + "]"
	                + "  |  Stats: " + p.CalcularStatsTotal()
	                + "  |  " + estado);
	        }
	    }
	    
	    System.out.println("");
	    System.out.println("¿Qué deseas hacer?");
	    System.out.println("1) Intercambiar Pokemon entre equipo y PC");
	    System.out.println("2) Salir del PC");
	    System.out.print(" Ingrese opcion: ");
	    int opcion = s.nextInt();
	    s.nextLine();
	    if(opcion == 1) {
	        System.out.println("Número del pokemon en el equipo : ");
	        int posEquipo = s.nextInt() - 1;
	        System.out.println("Número del pokemon en el PC: ");
	        int posPC = s.nextInt() - 1;
	        s.nextLine();
	        if(posEquipo >= 0 && posEquipo < jugador.getEquipo().size() 
	                && posPC >= 0 && posPC < jugador.getPc().size()) {
	            jugador.cambiarPokemon(posEquipo, posPC);
	            System.out.println("¡Cambio realizado!");
	        } else {
	            System.out.println("Posición inválida.");
	        }
	    }
	}

	private static void salirCapturar() {
		System.out.println("Zonas disponibles: ");
		for(int i = 0; i< habitats.size(); i++) {
			System.out.println((i + 1) + ")" + habitats.get(i).getNombre());
		}
		int opcion = s.nextInt(); s.nextLine();
		if(opcion < 1 || opcion > habitats.size()) {
			return;
		}
		
		Habitat zona = habitats.get(opcion - 1);
		Pokemon encontrado = zona.generarPokemonA(pokedex);
		System.out.println("Oh!! Ha aparecido un increible " + encontrado.getNombre() + "!!");
		System.out.println("1) Capturar");
		System.out.println("2) Huir");
		int decision = s.nextInt(); s.nextLine();
		if(decision == 1) {
			if(!jugador.tienePokemon(encontrado.getNombre())) {
				jugador.agregarPokemon(encontrado);
				System.out.println(encontrado.getNombre() + " capturado con exito!!");
			}else {
				System.out.println("Ya tienes a " + encontrado.getNombre()+ "en tu equipo!");
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
				System.out.println(i + ")" + p.getNombre() + "|" + p.getTipo() + "|Stats: " + p.CalcularStatsTotal() +"| Estado: " + p.getEstado());
				i++;
			}
		}
	}

}
