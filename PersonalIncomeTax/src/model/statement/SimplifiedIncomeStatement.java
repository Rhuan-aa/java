package model.statement;

import exception.IllegalValueException;

public final class SimplifiedIncomeStatement extends IncomeStatement {
    public SimplifiedIncomeStatement(double taxableGain, double paidValue) {
        super(taxableGain, paidValue);
    }

    @Override
    public double getTaxValue() {
        if (taxableGain < 22_847.88)
            throw new IllegalValueException("Esse valor não é apropriado para esse método de declaração");
        return taxableGain * 0.15;
    }

    
}
