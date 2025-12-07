package state.player_state;

import state.Player;

public interface State {
    void pressPlay(Player player);
    void pressStop(Player player);
}
