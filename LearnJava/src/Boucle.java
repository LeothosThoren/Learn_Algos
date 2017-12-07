/**
 * Created by leothos on 03/04/17.
 */
import java.util.Scanner;

public class Boucle {
    public static void main(String[] args) {
        String prenom;
        char reponse = 'O';
        Scanner sc = new Scanner(System.in);

        while (reponse == 'O') {

            System.out.println("Donnez moi un prénom");
            prenom = sc.nextLine();
            System.out.println("Bonjour " + prenom + ", comment vas-tu ?");
            System.out.println("Voulez-vous réésayer ? (O/N)");
            reponse = sc.nextLine().charAt(0);
            for (int i = 0, j = 2; (i < 10 && j < 6); i++, j+=2){
                System.out.println("i = " +i+ ", j = "+j );
        }

        System.out.println("Au revoir");

        }
    }
}