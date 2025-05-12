package model;

import model.statement.IncomeStatement;

public class Contributor {
    private final String CPF;
    private IncomeStatement incomeStatement;

    public Contributor(String CPF) {
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setIncomeStatement(IncomeStatement incomeStatement) {
        this.incomeStatement = incomeStatement;
    }

    public IncomeStatement getIncomeStatement() {
        return incomeStatement;
    }
}
