import java.util.Scanner;

public class nombreMystere {
    public static void main(String[] args) {
        //Gérer quand la saisie est un mot : à voir
        //Simplifier le code répétitif avec les fonctions : à voir
        //Faudra développer en Orienté Objet pour réduire les lignes de codes : à voir
        int nbAlea;
        int nombre = ' ', niveau = 0;
        char continu = '\0', chance = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("LE NOMBRE MYSTERE\n" +
                "?????????????????");
        //boucle principale
        do {
            //1/2/3
            do {
                //S2lection du niveau de difficulté
                System.out.println("\nSélectionne ton niveau de difficulté : \n" +
                        "1 - Facile (15 essais)\n" +
                        "2 - Normal (10 essais)\n" +
                        "3 - Difficile (5 essais)\n");
                System.out.print("Choix du niveau : ");
                niveau = sc.nextInt(); //Ici si on saisit du texte ça fait planter
                sc.nextLine();
            } while (niveau < 1 || niveau > 3);

            //Niveau facile
            if (niveau == 1) {
                do {
                    nbAlea = (int) Math.ceil(Math.random() * 1000);
                    System.out.println("Niveau " + niveau + ": Hum... On est pas très courageux :P" +
                            "\nDevine le nombre mystère entre 1 et 1000. ");
                    for (int essai = 14; essai > -1 && nombre != nbAlea; essai--) {

                        System.out.print("\nUne idée ? : ");
                        //demande de saisie
                        nombre = sc.nextInt();//Ici si on saisit du texte ça fait planter
                        sc.nextLine();

                        //On contrôle la saisi par rapport au nombre alétoire
                        if (nombre < nbAlea && essai != 0) {
                            System.out.println("C'est plus ! Il te reste encore " + essai + " essai(s)");
                        } else if (nombre > nbAlea && essai != 0) {
                            System.out.println("C'est moins ! Il te reste encore " + essai + " essai(s)");
                        } else if (essai == 0 && nombre != nbAlea) {
                            System.out.println("\nPerdu ! :(\n" +
                                    "Tu as épuisé tout tes essais...");
                        }
                    }
                    //Gestion des victoires ou défaites niveau 1
                    if (nombre != nbAlea) {
                        System.out.println("Le nombre mystère était : " + nbAlea);
                    } else {
                        System.out.println("\nBravo tu as gagné !!!\n" +
                                "Le nombre mystère était " + nbAlea);
                    }
                    do {
                        System.out.println("\nVeux-tu recommencer au niveau facile ? (O/N)");
                        chance = sc.nextLine().charAt(0);
                        sc.nextLine();
                    } while ((char) (chance | 32) != 'o' && (char) (chance | 32) != 'n');

                } while (chance == 'o' || chance == 'O');
            }
            //Niveau normal
            if (niveau == 2) {
                do {
                    nbAlea = (int) Math.ceil(Math.random() * 1000);
                    System.out.println("Niveau " + niveau + ": Courageux mais prudent." +
                            "\nDevine le nombre mystère entre 1 et 1000.");
                    for (int essai = 9; essai > -1 && nombre != nbAlea; essai--) {

                        System.out.print("\nUne idée ? : ");
                        //demande de saisie
                        nombre = sc.nextInt();//Ici si on saisit du texte ça fait planter
                        sc.nextLine();

                        //On contrôle la saisi par rapport au nombre alétoire
                        if (nombre < nbAlea && essai != 0) {
                            System.out.println("C'est plus ! Il te reste encore " + essai + " essai(s)");
                        } else if (nombre > nbAlea && essai != 0) {
                            System.out.println("C'est moins ! Il te reste encore " + essai + " essai(s)");
                        } else if (essai == 0 && nombre != nbAlea) {
                            System.out.println("\nPerdu ! :(\n" +
                                    "Tu as épuisé tout tes essais...");
                        }
                    }
                    //Gestion des victoires ou défaites niveau 2
                    if (nombre != nbAlea) {
                        System.out.println("Le nombre mystère était : " + nbAlea);
                    } else {
                        System.out.println("\nBravo tu as gagné !!!\n" +
                                "Le nombre mystère était " + nbAlea);
                    }
                    do {
                        System.out.println("\nVeux-tu recommencer au niveau moyen ? (O/N)");
                        chance = sc.nextLine().charAt(0);
                        sc.nextLine();
                    } while ((char) (chance | 32) != 'o' && (char) (chance | 32) != 'n');

                } while (chance == 'o' || chance == 'O');
            }
            //niveau difficile
            if (niveau == 3) {
                do {
                    nbAlea = (int) Math.ceil(Math.random() * 1000);
                    System.out.println("Niveau " + niveau + ": Quelle bravoure !!!" +
                            "\nDevine le nombre mystère entre 1 et 1000.");
                    for (int essai = 4; essai > -1 && nombre != nbAlea; essai--) {

                        System.out.print("\nUne idée ? : ");
                        //demande de saisie
                        nombre = sc.nextInt();//Ici si on saisit du texte ça fait planter
                        sc.nextLine();

                        //On contrôle la saisi par rapport au nombre alétoire
                        if (nombre < nbAlea && essai != 0) {
                            System.out.println("C'est plus ! Il te reste encore " + essai + " essai(s)");
                        } else if (nombre > nbAlea && essai != 0) {
                            System.out.println("C'est moins ! Il te reste encore " + essai + " essai(s)");
                        } else if (essai == 0 && nombre != nbAlea) {
                            System.out.println("\nPerdu ! :(\n" +
                                    "Tu as épuisé tout tes essais...");
                        }
                    }
                    //Gestion des victoires ou défaites niveau 3
                    if (nombre != nbAlea) {
                        System.out.println("Le nombre mystère était : " + nbAlea);
                    } else {
                        System.out.println("\nBravo tu as gagné !!!\n" +
                                "Le nombre mystère était " + nbAlea);
                    }
                    do {
                        System.out.println("\nVeux-tu recommencer au niveau difficile ? (O/N)");
                        chance = sc.nextLine().charAt(0);
                        sc.nextLine();
                    } while ((char) (chance | 32) != 'o' && (char) (chance | 32) != 'n');

                } while (chance == 'o' || chance == 'O');
            }

            //boucle qui gère la fin de du jeu
            do {
                System.out.println("Veux-tu recommencer depuis le début ? (O/N)");
                continu = sc.nextLine().charAt(0);
                sc.nextLine();
            } while ((char) (continu | 32) != 'o' && (char) (continu | 32) != 'n');

        } while (continu == 'o' || continu == 'O');
        System.out.println("Merci d'avoir joué, à plus tard...");
    }
}
