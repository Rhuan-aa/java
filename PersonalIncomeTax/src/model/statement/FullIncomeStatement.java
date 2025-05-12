package model.statement;

import model.expense.EducationExpense;
import model.expense.Expense;
import model.expense.HealthExpense;

import java.util.*;

public final class FullIncomeStatement extends IncomeStatement {
    private final List<Expense> expenseList = new ArrayList<>();

    public FullIncomeStatement(double taxableGain, double paidValue) {
        super(taxableGain, paidValue);
    }

    public void addSpent(Expense expense) {
        Objects.requireNonNull(expense, "O gasto não pode ser nulo");
        if (expenseList.contains(expense)) return;

        expenseList.add(expense);
    }

    public void removeSpent(Expense expense) {
        Objects.requireNonNull(expense, "O gasto não pode ser nulo");
        if (!expenseList.removeIf(e -> e.equals(expense)))
            throw new NoSuchElementException("Este gasto não existe");
    }

    private double getValueByExpenseType(Class<? extends Expense> expenseClass) {
        return expenseList.stream()
                .filter(e -> e.getClass().equals(expenseClass))
                .mapToDouble(Expense::getValue)
                .sum();
    }

    @Override
    public double getDeductibleExpense() {
        double healthExpenses = getValueByExpenseType(HealthExpense.class);
        double educationExpenses = getValueByExpenseType(EducationExpense.class);

        return Math.min(healthExpenses, HealthExpense.MAX_HEALTH_DEDUCTION) +
                Math.min(educationExpenses, EducationExpense.MAX_EDUCATION_DEDUCTION);
    }

    @Override
    public double getTaxValue() {
        double[] limits = {55_976.16, 45_012.72, 33_919.92, 22_847.88};
        double[] rates = {0.275, 0.225, 0.15, 0.075};
        double taxValue = 0;
        double amount = taxableGain;

        for (int i = 0; i < limits.length; i++) {
            if (amount > limits[i]) {
                double comparedValue = amount - limits[i];
                taxValue += comparedValue * rates[i];
                amount = limits[i];
            }
        }

        return taxValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FullIncomeStatement that = (FullIncomeStatement) o;
        return Objects.equals(expenseList, that.expenseList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(expenseList);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString()) ;

        for (Expense expense : expenseList) {
            builder.append(expense);
        }

        return builder.toString();
    }
}
