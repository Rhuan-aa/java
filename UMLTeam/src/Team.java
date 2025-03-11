public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player captain;
    private Player[] players = new Player[18];
    private int numberOfPlayers = 0;

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
        if (substitute.getTeam() == starter.getTeam()) {
            substitute.setFielded(true);
            starter.setFielded(false);
        }
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public Player[] getFieldedPlayers() {
        Player[] fieldedPlayers = new Player[11];
        int count = 0;

        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i] != null && players[i].isFielded()) {
                fieldedPlayers[count] = players[i];
                count++;
            }
        }

        Player[] result = new Player[count];
        for (int i = 0; i < count; i++) {
            result[i] = fieldedPlayers[i];
        }

        return result;
    }

    public Player[] getOutfieldedPlayers() {
        Player[] outfieldedPlayers = new Player[11];
        int count = 0;

        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i] != null && !players[i].isFielded()) {
                outfieldedPlayers[count] = players[i];
                count++;
            }
        }

        Player[] result = new Player[count];
        for (int i = 0; i < count; i++) {
            result[i] = outfieldedPlayers[i];
        }

        return result;
    }
}