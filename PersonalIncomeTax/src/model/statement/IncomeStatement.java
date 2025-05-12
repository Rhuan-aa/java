package model.statement;

import java.util.Objects;

public abstract sealed class IncomeStatement permits FullIncomeStatement, SimplifiedIncomeStatement {
    protected double taxableGain;
    protected double paidValue;

    public IncomeStatement(double taxableGain, double paidValue) {
        this.taxableGain = taxableGain;
        this.paidValue = paidValue;
    }

    public abstract double getTaxValue();

    public double getTaxableGain() {
        return taxableGain;
    }

    public void setTaxableGain(double taxableGain) {
        this.taxableGain = taxableGain;
    }

    public double getPaidValue() {
        return paidValue;
    }

    public void setPaidValue(double paidValue) {
        this.paidValue = paidValue;
    }

    public final double getAmountToPay() {
        return getTaxValue() - paidValue - getDeductibleExpense();
    }

    public double getDeductibleExpense() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IncomeStatement that = (IncomeStatement) o;
        return Double.compare(taxableGain, that.taxableGain) == 0 && Double.compare(paidValue, that.paidValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxableGain, paidValue);
    }

    @Override
    public String toString() {
        return String.format("""
                ================================================================
                \n
                Ganho Tributável = R$ %.2f
                Valor Pago = R$ %.2f
                \n
                ================================================================
                """, taxableGain, paidValue);
    }
}
