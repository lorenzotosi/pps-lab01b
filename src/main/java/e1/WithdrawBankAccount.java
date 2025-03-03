package e1;

public class WithdrawBankAccount extends FeeBankAccount {

    private final BankAccount base;
    private final WithdrawStrategy withdrawStrategy;

    public WithdrawBankAccount(BankAccount base, WithdrawStrategy withdrawStrategy) {
        super(base);
        this.base = base;
        this.withdrawStrategy = withdrawStrategy;
    }

    @Override
    public void withdraw(int amount) {
        if (this.withdrawStrategy.checkWithdrawal(this.getBalance(), amount)) {
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
