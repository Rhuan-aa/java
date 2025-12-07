package facade;

public class HomeTheaterFacade {
    private final Luzes luzes;
    private final Pipoqueira pipoqueira;
    private final Som som;
    private final Televisao televisao;

    public HomeTheaterFacade(Luzes luzes, Pipoqueira pipoqueira, Som som, Televisao televisao) {
        this.luzes = luzes;
        this.pipoqueira = pipoqueira;
        this.som = som;
        this.televisao = televisao;
    }

    public void assistirFilme(String filme) {
        System.out.println("--- Preparando o cinema para assistir " + filme + " ---");
        pipoqueira.ligar();
        pipoqueira.estourar();
        pipoqueira.desligar();
        luzes.desligar();
        televisao.ligar();
        televisao.setInput("HDMI");
        som.ligar();
        som.setVolume(5);
    }

    public void fimDoFilme() {
        System.out.println("--- Desligando o cinema ---");
        televisao.desligar();
        som.desligar();
        luzes.ligar();
    }
}
