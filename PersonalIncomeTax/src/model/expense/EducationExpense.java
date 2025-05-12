package model.expense;

import java.util.Objects;

public final class EducationExpense extends Expense {
    private final String institutionName;
    public static final double MAX_EDUCATION_DEDUCTION = 2000;

    public EducationExpense(long id, String description, double value, String CNPJ, String institutionName) {
        super(id, description, value, CNPJ);
        this.institutionName = institutionName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EducationExpense that = (EducationExpense) o;
        return Objects.equals(institutionName, that.institutionName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(institutionName);
    }

    @Override
    public String toString() {
        return super.toString() + "\nNome da Instituição: " + institutionName;
    }
}
