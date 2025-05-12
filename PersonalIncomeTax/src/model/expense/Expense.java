package model.expense;

import java.util.Objects;

public abstract sealed class Expense permits EducationExpense, HealthExpense{
    protected final long id;
    protected final String description;
    protected final double value;
    protected final String CNPJ;

    public Expense(long id, String description, double value, String CNPJ) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.CNPJ = CNPJ;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return id == expense.id
                && Double.compare(value, expense.value) == 0
                && Objects.equals(description, expense.description)
                && Objects.equals(CNPJ, expense.CNPJ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, value, CNPJ);
    }

    @Override
    public String toString() {
        return String.format("""
                \n
                ----------- Gasto: %d
                    CNPJ: %s
                    %s
                    Valor: R$ %.2f
                """, id, CNPJ, description, value);
    }
}
