public class CompteCourant extends Compte {

    private double authorizedOverdraft;

    public CompteCourant(int number, String owner, double authorizedOverdraft) {
        super(number, owner);
        this.authorizedOverdraft = authorizedOverdraft;
    }

    public double getAuthorizedOverdraft() {
        return authorizedOverdraft;
    }

    public void setAuthorizedOverdraft(double authorizedOverdraft) {
        this.authorizedOverdraft = authorizedOverdraft;
    }

    @Override
    public void withdrawMoney(double amount) throws NotEnoughMoneyException {
        System.out.println("Utilisation de la méthode overright");
        if (this.balance - amount + this.authorizedOverdraft < 0) throw new NotEnoughMoneyException("Not enough money");
        this.balance -= amount;
    }
}
