package state.player_state;

import state.Player;

public class StoppedState implements State {
    @Override
    public void pressPlay(Player player) {
        System.out.println("Iniciando a música...");
        player.setState(new PlayingState());
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("O player já está parado.");
    }
}
