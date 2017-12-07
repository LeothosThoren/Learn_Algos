import java.util.Scanner;

public class masterMind {
    public static void main(String[] args) {
        char choice = '\0';
        int[] tabTries = new int[4];
        Scanner sc = new Scanner(System.in);

        System.out.println("MASTERMIND !!!");

        do {//main iteration
            final int fstNbr = (int) Math.ceil(Math.random() * 8);
            final int scdNbr = (int) Math.ceil(Math.random() * 8);
            final int thdNbr = (int) Math.ceil(Math.random() * 8);
            final int frtNbr = (int) Math.ceil(Math.random() * 8);
            int[] ia = {fstNbr, scdNbr, thdNbr, frtNbr};


            //check the user taping
            for (int p = 1; p <= 12; p++) {
                System.out.print("\nEntrez une combinaison (" + p + "): ");

                for (int i : tabTries) {
                    tabTries[i] = sc.nextInt();
                    sc.nextLine();
                    System.out.println(tabTries[i]);
                    //print ia combination
                    for (int j : ia) {
                        System.out.print(ia[j] + "");
                    }
                }
            }



            do {//game iteration
                System.out.println("\nVeux-tu recommencer depuis le début ? (O/N)");
                choice = sc.nextLine().charAt(0);
            } while ((char) (choice | 32) != 'o' && (char) (choice | 32) != 'n');

        } while (choice == 'o' || choice == 'O');
        System.out.println("Merci d'avoir joué, à plus tard...");
    }
}

