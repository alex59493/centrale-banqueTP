import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class BanqueTest {

    @Test
    public void withdrawMoneyWorks() {
        Compte compte = new CompteEpargne(123, "Me", 0);
        compte.depositMoney(100);
        try {
            compte.withdrawMoney(10);
        }
        catch (NotEnoughMoneyException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(compte.getBalance(), 90, 0.0f);
    }

    @Test
    public void withdrawMoneyDoesntWorkIfNotEnoughMoney() {
        Compte compte = new CompteEpargne(123, "Me", 0);
        compte.depositMoney(100);
        try {
            compte.withdrawMoney(1000);
            fail("withdrawMoney() is supposed to throw an exception");
        }
        catch (NotEnoughMoneyException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(compte.getBalance(), 100, 0.0f);
    }

    @Test
    public void withdrawMoneyCompteCourantAuthorizeOverdraft() {
        CompteCourant compte = new CompteCourant(123, "Me", 100);
        try {
            compte.withdrawMoney(10);
        }
        catch (NotEnoughMoneyException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(compte.getBalance(), -10, 0.0f);
    }
}
