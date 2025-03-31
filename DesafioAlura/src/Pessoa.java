public class Pessoa {
    private String name;
    private int idade;

    public Pessoa(String name, int idade) {
        this.name = name;
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString(){
        return "Pessoa: " + name + " | " + idade;
    }
}
