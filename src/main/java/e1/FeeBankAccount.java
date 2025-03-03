package e1;

public class FeeBankAccount implements BankAccount {

    private final BankAccount base;
    private final int fee;

    public FeeBankAccount(BankAccount base) {
        this.base = base;
        this.fee = 1;
    }

    public FeeBankAccount(BankAccount base, int fee) {
        this.base = base;
        this.fee = fee;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        base.withdraw(amount + fee);
    }
}
