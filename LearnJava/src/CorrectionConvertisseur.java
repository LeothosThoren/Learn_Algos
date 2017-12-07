import java.util.Scanner;

public class CorrectionConvertisseur {
    public static void main (String [] args) {
        //déclaration de nos variables et appel de l'objet Scanner
        int option = 0;
        char tentative = '\0';

        Scanner sc = new Scanner(System.in);
        //Texte de présentation
        System.out.println("BIENVENUE DANS NOTRE CONVERTISSEUR DE DEVISES\n" +
                "€€€€€€€€€€€€€€€€€€€€€$$$$$$$$$$$$$$$$$$$$$$$$\n");

        //Boucle principale qui gére l'application
        do {
            //boucle qui gére les options 1)/2)/3)
            do {
                System.out.print("Sélectionner la devise parmi la liste ci-dessous:\n" +
                        "1) Dollar -> Euro\n" +
                        "2) Euro -> Dollar\n" +
                        "3) Quitter\n" +
                        "Votre saisie : ");
                //On demande de saisir un simple caractère qui soit: 1/2/3
                option = sc.nextInt();
            } while (option < 1 || option > 3);

            if (option != 3) {
                //demande de saisie
                System.out.print("Saisissez votre montant : ");
                double conversion = sc.nextDouble();
                sc.nextLine();
                //condition qui gére le calcul
                if (option == 2) {
                    double dollar = conversion * 1.0681; //Il s'agit d'un taux trouvé sur capital.fr
                    System.out.println(conversion + " euro(s) vaut " + dollar + " dollar(s) américain !");
                } else {
                    double euro = conversion * (1 / 1.0681);
                    System.out.println(conversion + " dollar(s) américain vaut " + euro + " euro(s) !");
                }

                //boucle qui gére la fin de lea conversion
                do {
                    System.out.print("Voulez-vous faire une nouvelle conversion ? (O/N) ");
                    tentative = sc.nextLine().charAt(0);
                } while (tentative != 'o' && tentative != 'O' && tentative != 'n' && tentative != 'N');

            }
        }
        while (tentative == 'o' || tentative == 'O');
        System.out.println("Au revoir");
    }
}