package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

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
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawGold() {
        this.goldBA.deposit(1000);
        this.goldBA.withdraw(200);
        assertEquals(800, this.goldBA.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

}
