package persistence.input;

import exception.IllegalValueException;
import model.expense.EducationExpense;
import model.expense.Expense;
import model.expense.HealthExpense;

import java.util.Scanner;

public class InputExpense implements Input<Expense> {
    @Override
    public Expense create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                /n
                1 - Gasto com Saúde
                2 - Gasto com Educação
                /n
                """);
        int option = scanner.nextInt();
        if (option != 1 && option != 2) throw new IllegalValueException("Opção Inválida");

        long id = scanner.nextLong();
        scanner.nextLine();
        String description = scanner.nextLine();
        double value = scanner.nextDouble();
        scanner.nextLine();
        String CNPJ = scanner.nextLine();
        String text = scanner.nextLine();
        Expense expense = option == 1 ? new HealthExpense(id, description, value, CNPJ, text)
                : new EducationExpense(id, description, value, CNPJ, text);

        scanner.close();
        return expense;
    }
}
