package e1;

public class FeeBankAccount extends BankAccountDecorator {

    //private final BankAccount base;
    private final FeeStrategy feeStrategy;

    public FeeBankAccount(BankAccount base, FeeStrategy feeStrategy) {
        super(base);
        //this.base = base;
        this.feeStrategy = feeStrategy;
    }


    @Override
    public void withdraw(int amount) {
        //base.withdraw(amount + this.feeStrategy.calculateFee(amount));
        super.withdraw(amount + this.feeStrategy.calculateFee(amount));
    }
}
