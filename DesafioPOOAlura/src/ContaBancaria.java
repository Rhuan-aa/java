public class ContaBancaria {
    private int accountNumber;
    private float accountCurrent;
    public String accountHolder;

    public int getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public float getAccountCurrent(){
        return accountCurrent;
    }

    public void setAccountCurrent(float accountCurrent) {
        this.accountCurrent = accountCurrent;
    }
}
