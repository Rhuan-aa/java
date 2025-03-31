import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome da pessoa: ");
            String nome = scanner.nextLine();
            Pessoa pessoa = new Pessoa(nome, 20);
            listaDePessoas.add(pessoa);
        }

        for (Pessoa pessoa : listaDePessoas){
            System.out.println(pessoa.toString());
        }

    }
}