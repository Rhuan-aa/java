package memento;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        // 1. Escreve e Salva
        editor.setContent("Texto A");
        history.push(editor.createState()); // Salva A
        System.out.println("Escreveu: " + editor.getContent());

        // 2. Escreve e Salva
        editor.setContent("Texto B");
        history.push(editor.createState()); // Salva B
        System.out.println("Escreveu: " + editor.getContent());

        // 3. Escreve e NÃO salva (cometeu erro)
        editor.setContent("Texto C (Erro)");
        System.out.println("Escreveu: " + editor.getContent());

        System.out.println("--- Clicou em DESFAZER ---");

        // 4. Desfazer
        // Lógica: Tira o último estado salvo da pilha (que é o B) e restaura
        try {
            EditorState lastState = history.pop();
            editor.restore(lastState);
        } catch (RuntimeException e) {
            System.out.println("Nada para desfazer!");
        }

        System.out.println("Atual: " + editor.getContent()); // Deve imprimir "Texto B"

        System.out.println("--- Clicou em DESFAZER novamente ---");

        try {
            EditorState lastState = history.pop();
            editor.restore(lastState);
        } catch (RuntimeException e) {
            System.out.println("Nada para desfazer!");
        }

        System.out.println("Atual: " + editor.getContent()); // Deve imprimir "Texto A"
    }
}