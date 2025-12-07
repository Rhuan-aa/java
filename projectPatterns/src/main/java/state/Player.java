package state;

import state.player_state.State;
import state.player_state.StoppedState;

public class Player {
    private State state;

    public Player() {
        this.state = new StoppedState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void pressPlay() {
        state.pressPlay(this);
    }

    public void pressStop() {
        state.pressStop(this);
    }
}
