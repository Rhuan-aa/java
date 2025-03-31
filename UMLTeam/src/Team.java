public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player captain;
    private final Player[] players = new Player[18];
    private int numberOfPlayers = 0;
    private final Player[] fieldedPlayers = new Player[11];
    private final Player[] outfieldedPlayers = new Player[7];


    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void addPlayer(Player player) {
        if (numberOfPlayers < 18) {
            players[numberOfPlayers] = player;
            numberOfPlayers++;
        }
    }

    public void removePlayer(Player player) {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i] == player) {
                for (int j = i; j < numberOfPlayers - 1; j++) {
                    players[j] = players[j + 1];
                }
                players[numberOfPlayers - 1] = null;
                numberOfPlayers--;
                return;
            }
        }
    }

    public void substitute(Player substitute, Player starter) {

        if (substitute.getTeam().equals(this) && starter.getTeam().equals(this)) {
            substitute.setFielded(true);
            starter.setFielded(false);
        }
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public void getPlayersComposition() {
        Player[] fieldedPlayers = new Player[11];
        Player[] outfieldedPlayers = new Player[7];

        int countFielded = 0;
        int countOutfielded = 0;

        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i] != null && players[i].isFielded()) {
                fieldedPlayers[countFielded++] = players[i];
            }
            if (players[i] != null && players[i].isFielded()) {
                outfieldedPlayers[countOutfielded++] = players[i];
            }
        }
    }

    public Player[] getFieldedPlayers() {
        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers() {
        return outfieldedPlayers;
    }
}