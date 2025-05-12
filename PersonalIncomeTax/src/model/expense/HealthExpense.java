package model.expense;

import java.util.Objects;

public final class HealthExpense extends Expense {
    private final String councilRegistration;
    public static final double MAX_HEALTH_DEDUCTION = 1500;

    public HealthExpense(long id, String description, double value, String CNPJ, String councilRegistration) {
        super(id, description, value, CNPJ);
        this.councilRegistration = councilRegistration;
    }

    public String getCouncilRegistration() {
        return councilRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HealthExpense that = (HealthExpense) o;
        return Objects.equals(councilRegistration, that.councilRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), councilRegistration);
    }

    @Override
    public String toString() {
        return super.toString() + "\nRegistro do Conselho: " + councilRegistration;
    }
}
