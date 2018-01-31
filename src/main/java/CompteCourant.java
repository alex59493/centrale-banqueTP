public class CompteCourant extends Compte {

    private double authorizedOverdraft;

    public double getAuthorizedOverdraft() {
        return authorizedOverdraft;
    }

    public void setAuthorizedOverdraft(double authorizedOverdraft) {
        this.authorizedOverdraft = authorizedOverdraft;
    }

    public CompteCourant(int number, String owner, double authorizedOverdraft) {
        super(number, owner);
        this.authorizedOverdraft = authorizedOverdraft;
    }
}
