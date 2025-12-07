package facade;

public class Televisao {
    public void ligar() { System.out.println("TV ligada."); }
    public void desligar() { System.out.println("TV desligada."); }
    public void setInput(String input) { System.out.println("TV input setado para: " + input); }
}