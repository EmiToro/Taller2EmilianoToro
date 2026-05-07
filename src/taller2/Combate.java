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

        double multiplicador = TablaTipos.obtenerMultiplicador(atacante.getTipo(), defensor.getTipo());
        statsAtacante *= multiplicador;

        System.out.println(atacante.getNombre() + " -> " + statsAtacante + " puntos");
        System.out.println(defensor.getNombre() + " -> " + statsDefensor + " puntos");

        if (statsAtacante > statsDefensor) {
            defensor.setEstado("Debilitado");
            return atacante.getNombre() + " ha ganado!";
        } else {
            atacante.setEstado("Debilitado");
            return defensor.getNombre() + " ha ganado!";
        }
    }
}