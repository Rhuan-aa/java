package br.com.challenge.bankAccount;

public class BankAccount {
    protected double balance = 0.00;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value){
        if (value <= balance) this.balance -= value;
        System.out.println("ERRO: Saldo insuficiente");
    }

    public void checkBalance(){
        System.out.println("Seu saldo é de: " + balance);
    }
}
