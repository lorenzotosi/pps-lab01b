package e1;

public class BankAccountFactoryImpl implements BankAccountFactory {
    @Override
    public BankAccount createSilverBankAccount() {
        return new WithdrawBankAccount(new FeeBankAccount(new CoreBankAccount()), (balance, amount) -> balance < amount);
    }

    @Override
    public BankAccount createGoldBankAccount() {
        return null;
    }

    @Override
    public BankAccount createBronzeBankAccount() {
        return null;
    }
}
