package persistence.input;

import exception.IllegalValueException;
import model.statement.FullIncomeStatement;
import model.statement.IncomeStatement;
import model.statement.SimplifiedIncomeStatement;

import java.util.Objects;
import java.util.Scanner;

public class InputIncomeStatement implements Input <IncomeStatement> {
    @Override
    public IncomeStatement create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                /n
                1 - Declaração Simples
                2 - Declaração Completa
                /n
                """);
        int option = scanner.nextInt();
        if (option != 1 && option != 2) throw new IllegalValueException("Opção Inválida");

        double taxableGain = scanner.nextDouble();
        double paidValue = scanner.nextDouble();
        IncomeStatement incomeStatement = option == 1 ? new SimplifiedIncomeStatement(taxableGain, paidValue)
                : new FullIncomeStatement(taxableGain, paidValue);

        scanner.close();
        return incomeStatement;
    }
}
