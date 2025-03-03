package e1;

public class WithdrawBankAccount implements BankAccount {

    private final BankAccount base;
    private final WithdrawStrategy withdrawStrategy;

    public WithdrawBankAccount(BankAccount base, WithdrawStrategy withdrawStrategy) {
        this.base = base;
        this.withdrawStrategy = withdrawStrategy;
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
        if (this.withdrawStrategy.checkWithdrawal(this.getBalance(), amount)) {
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
