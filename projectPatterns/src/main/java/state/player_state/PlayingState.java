package state.player_state;

import state.Player;

public class PlayingState implements State {
    @Override
    public void pressPlay(Player player) {
        System.out.println("Pausando a música...");
        player.setState(new PausedState());
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("Parando a música...");
        player.setState(new StoppedState());
    }
}
