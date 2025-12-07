package state;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        // Teste o fluxo
        System.out.println("1. Apertando Play:");
        player.pressPlay(); // Deve ir para Tocando

        System.out.println("\n2. Apertando Play de novo:");
        player.pressPlay(); // Deve ir para Pausado

        System.out.println("\n3. Apertando Play de novo:");
        player.pressPlay(); // Deve voltar a Tocar

        System.out.println("\n4. Apertando Stop:");
        player.pressStop(); // Deve Parar

        System.out.println("\n5. Apertando Stop de novo:");
        player.pressStop(); // Deve avisar que já está parado
    }
}
