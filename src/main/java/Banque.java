import java.util.Scanner;

public class Banque {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        // On récupère le type de compte voulu
        int choiceAccountType;
        do {
            System.out.println("Bonjour, veuillez sélectionner un type de compte");
            System.out.println("1. Compte courant");
            System.out.println("2. Compte épargne");
            choiceAccountType = scanner.nextInt();

            if (!(choiceAccountType == 1 || choiceAccountType == 2)) {
                System.out.println("Veuillez saisir un choix valide");
            }
        } while (!(choiceAccountType == 1 || choiceAccountType == 2));


        // On crée le compte
        System.out.println("Numéro de compte :");
        int number = scanner.nextInt();

        System.out.println("Propriétaire");
        String owner = scanner.next();

        Compte compte;

        switch (choiceAccountType) {
            case 1: {
                System.out.println("Découvert autorisé");
                double authorizedOverdraft = scanner.nextDouble();

                compte = new CompteCourant(number, owner, authorizedOverdraft);

                break;
            }
            default: {
                System.out.println("Taux");
                double rate = scanner.nextDouble();

                compte = new CompteEpargne(number, owner, rate);

                break;
            }
        }


        // On peut maintenant faire diverses opérations
        boolean quitter = false ;
        do {
            System.out.println("1. Afficher le solde du compte");
            System.out.println("2. Verser de l'argent");
            System.out.println("3. Retirer de l'argent");
            System.out.println("4. Afficher historique des opérations");
            System.out.println("5. Calcul et ajout des intérêts");
            System.out.println("10. Quitter");
            int action = scanner.nextInt();

            switch (action) {
                case 1: {
                    System.out.println(compte.getBalance());

                    // Log user action
                    compte.addToOperationsList("Affichage du solde");

                    break;
                }
                case 2: {
                    System.out.println("Combien d'argent voulez-vous déposer ?");
                    double amount = scanner.nextDouble();
                    compte.depositMoney(amount);
                    System.out.println("Votre nouveau solde est de " + compte.getBalance());

                    // Log user action
                    compte.addToOperationsList("Dépot d'argent sur le compte");

                    break;
                }
                case 3: {
                    System.out.println("Combien d'argent voulez-vous retirer ?");
                    double amount = scanner.nextDouble();
                    try {
                        compte.withdrawMoney(amount);
                    }
                    catch (Exception e) {
                        // If not enough money on the account, throw an exception
                        System.err.println("Caught Exception: " + e.getMessage());
                        break;
                    }
                    System.out.println("Votre nouveau solde est de " + compte.getBalance());

                    // Log user action
                    compte.addToOperationsList("Retrait d'argent de votre compte");

                    break;
                }
                case 4: {
                    System.out.println(compte.getOperationsList());
                    break;
                }
                case 5: {
                    if (choiceAccountType != 2) {
                        System.out.println("Seul les comptes épargnes ont accès à cette fonctionnalité");
                        break;
                    }
                    else {
                        double rate = ((CompteEpargne) compte).getRate();
                        System.out.println("Intérêts : " + rate);

                        // Log user action
                        compte.addToOperationsList("Affichage des intérêts");

                        break;
                    }
                }
                case 10: {
                    quitter = true ;
                    break;
                }
                default: {
                    System.out.println("Veuillez renseigner un choix valide");
                    break;
                }
            }
        } while (!quitter);
    }
}
