/**
 * Created by leothos on 03/04/17.
 */
import java.util.Scanner;

public class ConvertisseurDegreeFarenheit {

    public static void main(String[] args) {

        char saisie = ' ', tentative = ' ';
        double temperature;
        Scanner sc = new Scanner(System.in);

        //Présentation de l'application
        System.out.println("CONVERTISSEUR DEGRES CELSIUS ET DEGRES FAHRENHEIT");
        System.out.println("-------------------------------------------------");

       do{
            //Initialisation de la boucle
            do {
                System.out.println("Choisissez le mode de conversion :");
                System.out.println("1 - Convertisseur Celsisus - Fahrenheit");
                System.out.println("2 - Convertisseur Fahrenheit - Celsisus");
                // On saisie soit '1 soit '2'
                saisie = sc.nextLine().charAt(0);

            }while(saisie != '1' && saisie != '2');

           //On saisie la température souhaitée
            System.out.println("Température à convertir :");
            temperature = sc.nextDouble();
            sc.nextLine();

            //On détermine le type de conversion en fonction de la sélection : initialisation de la condition
            if(saisie == '1') {
                double fahrenheit = ((9.0 / 5.0) * temperature)+ 32;
                System.out.println(temperature + " C° correspond ~ à : " + fahrenheit + " F°.");

            }
            else{
                double celsius = ((temperature - 32) * 5.0) / 9.0;
                System.out.println(temperature + " F° correspond ~ à : " + celsius + " C°.");
            }

            //Boucle qui sert à demander si on veut recommencer

                    do {
                        System.out.println("Voulez-vous faire une nouvelle conversion ? (O/N)");
                        tentative = sc.nextLine().charAt(0);
                    }while(tentative != 'O' && tentative != 'N');

        } while(tentative == 'O');

        System.out.println("Au revoir");
    }

}