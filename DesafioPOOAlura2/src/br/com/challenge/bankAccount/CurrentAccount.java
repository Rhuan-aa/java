package br.com.challenge.bankAccount;

public class CurrentAccount extends BankAccount{
    private double monthlyFee;

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void chargeMonthlyFee(){
        this.balance -= monthlyFee;
    }
}
