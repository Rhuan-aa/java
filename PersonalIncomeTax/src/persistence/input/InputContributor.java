package persistence.input;

import model.Contributor;

import java.util.Objects;
import java.util.Scanner;

public class InputContributor implements Input<Contributor> {

    @Override
    public Contributor create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF: ");
        String CPF = scanner.nextLine();
        Objects.requireNonNull(CPF, "O CPF não pode ter valor nulo");

        return new Contributor(CPF);
    }
}
