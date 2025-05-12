import model.expense.EducationExpense;
import model.expense.Expense;
import model.expense.HealthExpense;
import model.statement.FullIncomeStatement;
import model.statement.IncomeStatement;
import model.statement.SimplifiedIncomeStatement;
import persistence.input.InputContributor;
import persistence.input.InputFactory;

public class Main {
    public static void main(String[] args) {
        // Criação de objetos das classes solicitadas

        Expense educationExpense = new EducationExpense(
                1L, "Curso de Java", 1800.0, "12.345.678/0001-99", "Santa Casa"
        );

        Expense healthExpense = new HealthExpense(
                2L, "Consulta médica", 1200.0, "98.765.432/0001-11", "CRM12345"
        );

        IncomeStatement fullIncomeStatement = new FullIncomeStatement(
                50000.0, 5000.0
        );

        IncomeStatement simplifiedIncomeStatement = new SimplifiedIncomeStatement(
                30000.0, 3000.0
        );

        InputFactory.crate(new InputContributor());

        System.out.println(educationExpense);

        System.out.println(healthExpense);

        System.out.println(fullIncomeStatement);

        System.out.println(simplifiedIncomeStatement);

    }
}