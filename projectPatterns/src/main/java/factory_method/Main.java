package factory_method;

import factory_method.logistica.Logistica;
import factory_method.logistica.LogisticaMaritima;
import factory_method.logistica.LogisticaTerrestre;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Pedido via Estrada ---");
        Logistica logistica1 = new LogisticaTerrestre();
        logistica1.planejarEntrega();

        System.out.println("\n--- Pedido via Mar ---");
        Logistica logistica2 = new LogisticaMaritima();
        logistica2.planejarEntrega();
    }
}
