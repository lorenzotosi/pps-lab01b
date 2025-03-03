package e1;

public class FeeBankAccount implements BankAccount {

    private final BankAccount base;
    private final FeeStrategy feeStrategy;

    public FeeBankAccount(BankAccount base, FeeStrategy feeStrategy) {
        this.base = base;
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
