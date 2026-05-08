package taller2;

public class Combate {
    private Pokemon atacante;
    private Pokemon defensor;

    public Combate(Pokemon atacante, Pokemon defensor) {
        this.atacante = atacante;
        this.defensor = defensor;
    }

    public String simularBatalla() {
        int statsAtacante = atacante.CalcularStatsTotal();
        int statsDefensor = defensor.CalcularStatsTotal();

        System.out.println(atacante.getNombre() + " -> " + statsAtacante + " puntos");
        System.out.println(defensor.getNombre() + " -> " + statsDefensor + " puntos");

        double multiplicador = TablaTipos.obtenerMultiplicador(atacante.getTipo(), defensor.getTipo());

        if (multiplicador == 2.0) {
            System.out.println("\n¡" + atacante.getNombre() + " es super efectivo contra " + defensor.getNombre() + "!");
        } else if (multiplicador == 0.5) {
            System.out.println("\n" + atacante.getNombre() + " no es efectivo contra " + defensor.getNombre() + "!");
        } else if (multiplicador == 0.0) {
            System.out.println("\n¡El ataque de " + atacante.getNombre() + " no tiene efecto sobre " + defensor.getNombre() + "!");
        }

        if (multiplicador != 1.0) {
            statsAtacante = (int)(statsAtacante * multiplicador); // solo aquí, UNA vez
            System.out.println("Nuevo puntaje:");
            System.out.println(atacante.getNombre() + " -> " + statsAtacante + " puntos");
            System.out.println(defensor.getNombre() + " -> " + statsDefensor + " puntos");
        }

        System.out.println();

        if (statsAtacante > statsDefensor) {
            defensor.setEstado("Debilitado");
            return defensor.getNombre() + " ha sido derrotado...";
        } else {
            atacante.setEstado("Debilitado");
            return atacante.getNombre() + " ha sido derrotado...";
        }
    
    }
    
}