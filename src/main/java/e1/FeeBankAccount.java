package e1;

public class FeeBankAccount extends BankAccountDecorator {

    private final FeeStrategy feeStrategy;

    public FeeBankAccount(BankAccount base, FeeStrategy feeStrategy) {
        super(base);
        this.feeStrategy = feeStrategy;
    }


    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + this.feeStrategy.calculateFee(amount));
    }
}
