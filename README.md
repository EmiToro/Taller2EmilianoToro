# Taller 2 - Programación Orientada a Objetos (POO)

## Descripción del proyecto
Este proyecto implementa un juego de simulación inspirado en Pokémon, donde el jugador puede:
- Capturar Pokémon en distintos hábitats.
- Formar un equipo de hasta 6 Pokémon y gestionar el resto en el PC.
- Retar gimnasios en orden y obtener medallas.
- Desafiar al Alto Mando una vez obtenidas las 8 medallas.
- Guardar y cargar partidas desde un archivo de registros.
- Realizar combates con efectividad de tipos, estados de los Pokémon y cálculo de estadísticas.

El código está desarrollado en **Java** utilizando conceptos de Programación Orientada a Objetos como clases, objetos, encapsulación, herencia y relaciones entre entidades.

---

## Integrantes
- **Constanza Araya** – 21.609.057-8 – Bunnyybundy  
- **Emiliano Toro** – 21.512.702-8 – EmiToro  

---

## Estructura del proyecto
El proyecto está organizado en clases principales:

- **Main**: Clase principal, contiene el menú inicial y el menú de juego.  
- **Jugador**: Representa al jugador, su equipo y su PC.  
- **Pokemon**: Define las características de cada Pokémon (stats, tipo, estado, hábitat).  
- **Habitat**: Genera Pokémon según porcentajes de aparición.  
- **Gimnasio**: Representa un gimnasio con su líder y Pokémon.  
- **AltoMando**: Representa a los miembros del Alto Mando y sus Pokémon.  
- **Combate**: Simula batallas entre Pokémon considerando efectividad de tipos.  
- **TablaTipos**: Matriz de efectividad entre tipos de Pokémon.  

Archivos externos utilizados:
- `Pokedex.txt` → Lista de Pokémon disponibles.  
- `Habitats.txt` → Lista de hábitats.  
- `Gimnasios.txt` → Información de gimnasios y líderes.  
- `Alto Mando.txt` → Información de miembros del Alto Mando.  
- `Registros.txt` → Archivo de guardado de partidas.  

---

##  Instrucciones de ejecución
1. Clonar el repositorio desde GitHub:
   ```bash
   git clone 
 
2. Abrir el proyecto en Eclipse (o cualquier IDE compatible con Java).
3. Asegurarse de que los archivos externos(Pokedex.txt, Habitats.txt, Gimnasios.txt, Alto Mando.txt) esten en la carpeta raíz del proyecto.
4. Ejecutar la clase **Main**.
5. Menú inicial:
  - **1) Continuar** → Cargar partida desde `Registros.txt`.
  - **2) Nueva Partida** → Crear un nuevo jugador.   
  - **3) Salir** → Terminar el programa.
6. Menú principal:
  - Revisar equipo.
  - Salir a capturar.
  - Acceso al PC.
  - Retar un gimnasio.
  - Desafiar al Alto Mando.
  - Curar Pokémon.
  - Guardar.
  - Guardar y salir.
    
 
