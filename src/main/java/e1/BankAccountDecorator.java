package e1;

public abstract class BankAccountDecorator implements BankAccount {

    private final BankAccount base;

    public BankAccountDecorator(BankAccount base) {
        this.base = base;
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
    public abstract void withdraw(int amount);
}
