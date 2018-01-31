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

                    int currentSize = compte.getOperationsList().length;
                    String[] newArray = new String[currentSize + 1];
                    for (int i=0; i < currentSize; i++)
                    {
                        newArray[i] = compte.getOperationsList()[i];
                    }
                    newArray[currentSize] = "Truc en plus";
                    compte.setOperationsList(newArray);

                    System.out.println(compte.getOperationsList());

                    break;
                }
                case 2: {
                    System.out.println("Combien d'argent voulez-vous déposer ?");
                    double amount = scanner.nextDouble();
                    compte.depositMoney(amount);
                    System.out.println("Votre nouveau solde est de " + compte.getBalance());
                    break;
                }
                case 3: {
                    System.out.println("Combien d'argent voulez-vous retirer ?");
                    double amount = scanner.nextDouble();
                    compte.withdrawMoney(amount);
                    System.out.println("Votre nouveau solde est de " + compte.getBalance());
                    break;
                }
                case 5: {
                    if (choiceAccountType != 2) {
                        System.out.println("Votre compte n'est pas concerné par cette action");
                        break;
                    }
                    else {

                        System.out.println("Intérêts : ");
                    }
                }
            }

            if (action == 10) {
                quitter = true ;
                continue;
            }
        } while (!quitter);
    }
}
