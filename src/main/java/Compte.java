import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {
    private int number;
    private String owner;
    protected double balance = 0;
    private Date openDate;
    private List<String> operationsList;

    public Compte(int number, String owner) {
        this.number = number;
        this.owner = owner;
        this.openDate = new Date();
        this.operationsList = new ArrayList<String>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public List getOperationsList() {
        return this.operationsList;
    }

    public void addToOperationsList(String action) {
        operationsList.add(action);
    }

    public void depositMoney(double amount) {
        this.balance += amount;
    }

    public void withdrawMoney(double amount) throws NotEnoughMoneyException {
        if (this.balance - amount < 0) throw new NotEnoughMoneyException("Not enough money");
        this.balance -= amount;
    }
}
