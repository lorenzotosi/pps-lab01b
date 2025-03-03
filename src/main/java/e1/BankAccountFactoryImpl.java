package e1;

public class BankAccountFactoryImpl implements BankAccountFactory {
    @Override
    public BankAccount createSilverBankAccount() {
        return new WithdrawBankAccount(
                new FeeBankAccount(new CoreBankAccount(), (amount) -> 1),
                (balance, amount) -> balance < amount
        );
    }

    @Override
    public BankAccount createGoldBankAccount() {
        return new WithdrawBankAccount(
                new FeeBankAccount(new CoreBankAccount(), (amount) -> 0),
                    (balance, amount) -> balance < amount + 500
        );
    }

    @Override
    public BankAccount createBronzeBankAccount() {
        return new WithdrawBankAccount(
                new FeeBankAccount(new CoreBankAccount(), (amount) -> amount < 100 ? 0 : 1),
                    (balance, amount) -> balance < amount
        );
    }
}
