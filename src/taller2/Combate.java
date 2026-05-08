package taller2;
/**
 * Clase Combate
 * Simula una batalla entre dos Pokémon considerando sus estadísticas
 * y la efectividad de tipos definida en la TablaTipos.
 */
public class Combate {
    private Pokemon atacante;
    private Pokemon defensor;
    /**
     * Constructor de Combate.
     * @param atacante Pokémon que inicia el ataque.
     * @param defensor Pokémon que recibe el ataque.
     */
    public Combate(Pokemon atacante, Pokemon defensor) {
        this.atacante = atacante;
        this.defensor = defensor;
    }
    /**
     * Simula la batalla entre atacante y defensor.
     * Calcula los stats totales, aplica multiplicador de tipo y
     * determina el ganador debilitando al perdedor.
     * @return Mensaje indicando el resultado del combate.
     */
    public String simularBatalla() {
        int statsAtacante = atacante.CalcularStatsTotal();
        int statsDefensor = defensor.CalcularStatsTotal();

        double multiplicador = TablaTipos.obtenerMultiplicador(atacante.getTipo(), defensor.getTipo());
        statsAtacante = (int)( statsAtacante * multiplicador);

        System.out.println(atacante.getNombre() + " -> " + statsAtacante + " puntos");
        System.out.println(defensor.getNombre() + " -> " + statsDefensor + " puntos");
        
        if (multiplicador == 2.0) {
            System.out.println("¡" + atacante.getNombre() + " es super efectivo contra " + defensor.getNombre() + "!");
        } else if (multiplicador == 0.5) {
            System.out.println(atacante.getNombre() + " no es muy efectivo contra " + defensor.getNombre() + "!");
        } else if (multiplicador == 0.0) {
            System.out.println("¡El ataque de " + atacante.getNombre() + " no tiene efecto sobre " + defensor.getNombre() + "!");
        }

        if (statsAtacante > statsDefensor) {
            defensor.setEstado("Debilitado");
            return atacante.getNombre() + " ha ganado!";
        } else {
            atacante.setEstado("Debilitado");
            return defensor.getNombre() + " ha ganado!";
        }
    }
}