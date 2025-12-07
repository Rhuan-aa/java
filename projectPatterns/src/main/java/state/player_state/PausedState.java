package state.player_state;

import state.Player;

public class PausedState implements State{
    @Override
    public void pressPlay(Player player) {
        System.out.println("Retomando a música...");
        player.setState(new PlayingState());
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("Parando a música (estava em pausa)...");
        player.setState(new StoppedState());
    }
}
