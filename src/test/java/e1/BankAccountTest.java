package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    public static final int STANDARD_DEPOSIT_AMOUNT = 1000;
    public static final int STANDARD_WITHDRAW_AMOUNT = 200;
    private BankAccount account;
    private final BankAccountFactory bankAccountFactory = new BankAccountFactoryImpl();
    private BankAccount goldBA;
    private BankAccount bronzeBA;
    private List<BankAccount> baList;

    @BeforeEach
    void init(){
        this.account = bankAccountFactory.createSilverBankAccount();
        this.goldBA = bankAccountFactory.createGoldBankAccount();
        this.bronzeBA = bankAccountFactory.createBronzeBankAccount();
        this.baList = List.of(account, goldBA, bronzeBA);
    }

    @Test
    public void testInitiallyEmpty() {
        //assertEquals(0, this.account.getBalance());
        assertEquals(0, baList.stream().mapToInt(BankAccount::getBalance).sum());

    }

    @Test
    public void testCanDeposit() {
        //this.account.deposit(1000);
        //assertEquals(1000, this.account.getBalance());
        this.baList.forEach(x -> x.deposit(STANDARD_DEPOSIT_AMOUNT));
        assertAll(() -> assertEquals(STANDARD_DEPOSIT_AMOUNT, account.getBalance()),
                () -> assertEquals(STANDARD_DEPOSIT_AMOUNT, goldBA.getBalance()),
                () -> assertEquals(STANDARD_DEPOSIT_AMOUNT, bronzeBA.getBalance()));
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(STANDARD_DEPOSIT_AMOUNT);
        this.account.withdraw(STANDARD_WITHDRAW_AMOUNT);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawGold() {
        this.goldBA.deposit(STANDARD_DEPOSIT_AMOUNT);
        this.goldBA.withdraw(STANDARD_WITHDRAW_AMOUNT);
        assertEquals(800, this.goldBA.getBalance());
    }

    @Test
    public void testCanWithdrawBronzeWithFee() {
        this.bronzeBA.deposit(STANDARD_DEPOSIT_AMOUNT);
        this.bronzeBA.withdraw(STANDARD_WITHDRAW_AMOUNT);
        assertEquals(799, this.bronzeBA.getBalance());
    }

    @Test
    public void testCanWithdrawBronzeNoFee() {
        this.bronzeBA.deposit(STANDARD_DEPOSIT_AMOUNT);
        this.bronzeBA.withdraw(50);
        assertEquals(950, this.bronzeBA.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(STANDARD_DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

}
