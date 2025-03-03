package e1;

public class FeeBankAccount implements BankAccount {

    private final BankAccount base;
    private final int fee;
    private FeeStrategy feeStrategy;

    public FeeBankAccount(BankAccount base) {
        this.base = base;
        this.fee = 1;
    }

    public FeeBankAccount(BankAccount base, int fee) {
        this.base = base;
        this.fee = fee;
    }

    public FeeBankAccount(BankAccount base, FeeStrategy feeStrategy) {
        this.base = base;
        this.fee = 1;
        this.feeStrategy = feeStrategy;
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
        base.withdraw(amount + this.feeStrategy.calculateFee(amount));
    }
}
