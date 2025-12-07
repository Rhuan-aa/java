package memento;

import java.util.Stack;

//Caretaker
public class History {
    private Stack<EditorState> history = new Stack<>();

    public void push(EditorState state) {
        history.push(state);
    }

    public EditorState pop() {
        if (history.isEmpty()) throw new RuntimeException("Histórico está vazio");
        return history.pop();
    }
}
