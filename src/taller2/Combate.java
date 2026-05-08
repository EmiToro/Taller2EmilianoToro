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