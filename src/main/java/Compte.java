import java.util.Date;

public abstract class Compte {
    private int number;
    private String owner;
    private double balance = 0;
    private Date openDate;
    private String[] operationsList;


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

    public String[] getOperationsList() {
        return operationsList;
    }

    public void setOperationsList(String[] operationsList) {
        this.operationsList = operationsList;
    }

    public Compte(int number, String owner) {
        this.number = number;
        this.owner = owner;
        this.openDate = new Date();
    }

    public void depositMoney(double amount) {
        this.balance += amount;
    }

    public void withdrawMoney(double amount) {
        // TODO: Checker si la balance est supérieur au découvert autorisé (Pour compte courant)
        this.balance -= amount;
    }
}
