public class Main {
    public static void main(String[] args) {
        Team brasil = new Team("Brasil", "Rio de Janeiro", "Tite");

        Player pele = new Player("Pele", 10, Position.STRIKER, true, brasil);
        System.out.println(pele.getStateAsString());

        Player neymar = new Player("Neymar", 11, Position.STRIKER, false, brasil);
        System.out.println(neymar.getStateAsString());

        brasil.addPlayer(pele);
        brasil.addPlayer(neymar);
        brasil.setCaptain(pele);
        brasil.substitute(neymar, pele);

        Player[] fieldedPlayers = brasil.getFieldedPlayers();
        for (Player player : fieldedPlayers) {
            System.out.println(player.getStateAsString());
        }
    }
}