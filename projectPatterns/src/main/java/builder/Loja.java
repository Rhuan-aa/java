package builder;

public class Loja {
    public static void main(String[] args) {

        Computador pcGamer = new Computador.Builder("Intel i9", "32GB")
                .comPlacaDeVideo("RTX 4090")
                .comArmazenamento("SSD 2TB M.2")
                .comWaterCooler()
                .comRGB()
                .build();

        // PC de Escritório (Básico)
        Computador pcEscritorio = new Computador.Builder("Intel i3", "8GB")
                .comSistemaOperacional("Linux Ubuntu")
                .build();

        System.out.println(pcGamer);
        System.out.println(pcEscritorio);
    }
}