package facade;

public class Main {
    public static void main(String[] args) {
        Luzes luzes = new Luzes();
        Televisao tv = new Televisao();
        Som som = new Som();
        Pipoqueira pipoqueira = new Pipoqueira();

        HomeTheaterFacade facade = new HomeTheaterFacade(luzes,pipoqueira,som,tv);
        facade.assistirFilme("Matrix");
        facade.fimDoFilme();
    }
}
