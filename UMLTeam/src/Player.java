public class Player {
    private String name;
    private int number;
    private Position position;
    private boolean isFielded;
    private Team team;

    public Player(String name, int number, Position position, boolean isFielded, Team team) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
        this.team = team;
    }

    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public Team getTeam() {
        return team;
    }

    public String getStateAsString() {
        return "Name: " + name +
                "\nNumber: " + number +
                "\nPosition: " + position +
                "\nFielded: " + isFielded;
    }
}