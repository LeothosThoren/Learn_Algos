/**
 * Created by leothos on 05/04/17.
 */
import java.util.Scanner;

public class ConvertisseurMonnaie {

    public static void main (String [] args) {

        //déclaration de nos variables et appel de l'objet Scanner
        char option = ' ', tentative = ' ';
        double conversion;
        Scanner sc = new Scanner(System.in);

        //Texte de présentation
        System.out.println("BIENVENUE DANS NOTRE CONVERTISSEUR DE DEVISES");
        System.out.println("€€€€€€€€€€€€€€€€€€€€€$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(" ");
        //Boucle principale qui gére l'application
        do {
            //boucle qui gére les options 1)/2)/3)
            do {
                System.out.println("Sélectionner la devise parmi la liste ci-dessous :");
                System.out.println("1) Dollar -> Euro");
                System.out.println("2) Euro -> Dollar");
                System.out.println("3) Quitter");
                System.out.println("Votre saisie : ");

                //On demande de saisir un simple caractère qui sont soit 1/2/3
                option = sc.nextLine().charAt(0);

            } while (option != '1' && option != '2' && option != '3');

            if (option != '3') {
                //demande de saisie
                System.out.println("Saisissez votre montant : ");
                conversion = sc.nextDouble();
                sc.nextLine();

                //condition qui gére le calcul
                if (option == '2') {
                    double dollar = conversion * 1.0681; //Il s'agit d'un taux trouvé sur capital.fr
                    System.out.println(conversion + " euro(s) vaut " + dollar + " dollar(s) américain !");

                } else {
                    double euro = conversion * (1 / 1.0681);
                    System.out.println(conversion + " dollar(s) américain vaut " + euro + " euro(s) !");
                }

                //boucle qui gére la fin de lea conversion
                do {
                    System.out.println("Voulez-vous faire une nouvelle conversion ? (O/N)");
                    tentative = sc.nextLine().charAt(0);
                } while (tentative != 'O' && tentative != 'N');

            }
        }
            while (tentative == 'O') ;

            System.out.println("Au revoir");

    }
}
