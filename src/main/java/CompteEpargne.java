public class CompteEpargne extends Compte {

    private double rate;

    public CompteEpargne(int number, String owner, double rate) {
        super(number, owner);
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
