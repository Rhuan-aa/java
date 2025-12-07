package memento;

//Originator
class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public EditorState createState() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        this.content = state.content();
    }
}
