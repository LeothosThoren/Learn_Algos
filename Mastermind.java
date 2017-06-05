import java.util.Scanner;

public class MasterMindCorrected
{
    static final int MAX_CHANCE = 12;

    /*!
    ** Generate a random combination of 4 numbers between 1 and 8.
    **
    ** @return A new mastermind combination.
    */
    public static int generateCombination()
    {
        int res = 0;

        for (int i = 0; i < 4; ++i)
        {
            res *= 10;
            res += (Math.random() * 7) + 1;
        }

        return res;
    }

    /*!
    ** Get the french plural of a word, if necessary.
    **
    ** @param nb The quantity.
    **
    ** @return "s" if plural, nothing else.
    */
    public static String plural(int nb)
    {
        if (nb > 1)
            return "s";

        return "";
    }

    /*!
    ** Given a number, get the asked digit.
    ** 0 is the first digit from the left.
    ** 3 is the last digit.
    ** An invalid digit is outside the range [0, 3].
    **
    ** @param nb The number.
    ** @param pos The digit position.
    **
    ** @return Digit at asked position, or -1 if an error ocurred.
    */
    public static int getDigit(int nb, int pos)
    {
        if (pos < 0 || pos > 3)
            return -1; // Should throw instead

        int div = 1000;
        int res = 0;
        while (pos >= 0)
        {
            res = (nb / div) % 10;
            div /= 10;
            --pos;
        }

        return res;
    }

    /*!
    ** Get the number of correctly placed digit.
    **
    ** @param tries The provided number.
    ** @param num The number to guess.
    **
    ** @return Number of correctly placed digit.
    */
    public static int sameNumSamePlace(int tries, int num)
    {
        int common = 0;

        for (int i = 0; i < 4; ++i)
            if (getDigit(tries, i) == getDigit(num, i))
                ++common;

        return common;
    }

    /*!
    ** Check if a number contains a given digit.
    **
    ** @param number The number.
    ** @param digit The digit.
    **
    ** @return If digit is contained in number.
    */
    public static Boolean numberContainsDigit(int number, int digit)
    {
        while (number > 0)
        {
            if (number % 10 == digit)
                return true;
            number /= 10;
        }

        return false;
    }

    /*!
    ** Get the number of digit a given number has in common with another number.
    **
    ** @param tries The provided number.
    ** @param num The number to guess.
    **
    ** @return Number of common digits.
    */
    public static int commonDigit(int tries, int num)
    {
        int common = 0;

        for (int i = 0; i < 4; ++i)
            if (numberContainsDigit(num, getDigit(tries, i)))
                ++common;

        return common;
    }

    /*!
    ** Ask an int until it's valid.
    **
    ** @param sc The input scanner.
    ** @param chance The current chance.
    **
    ** @return A valid user provided int.
    */
    public static int askInt(Scanner sc, int chance)
    {
        Boolean isValid = true;
        int nb = 0;

        do
        {
            System.out.print("Entrez une combinaison (4 chiffres entre 1 et 8) (" + chance + "): ");
            nb = sc.nextInt();
            sc.nextLine();
            isValid = nb >= 1111 && nb <= 8888 && !numberContainsDigit(nb, 0) && !numberContainsDigit(nb, 9);
            if (!isValid)
                System.out.println("Le nombre donné est invalide !");
        } while (!isValid);

        return nb;
    }

    /*!
    ** Ask if user want to retry (only get valid answer)
    **
    ** @param sc The input scanner.
    **
    ** @return If user want to retry.
    */
    public static Boolean askRetry(Scanner sc)
    {
        char choice = '\0';

        do
        {
            System.out.println("Veux-tu recommencer depuis le début ? (O/N)");
            choice = (char) (sc.nextLine().charAt(0) | 32);
        } while (choice != 'o' && choice != 'n');

        return choice == 'o';
    }

    /*!
    ** Mastermind game.
    */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("MASTERMIND !!!");

        do
        {
            System.out.println("\nNouvelle partie");
            final int iaNum = generateCombination();
            int tries = 0;
            int chance = 0;

            while (chance < MAX_CHANCE && iaNum != tries)
            {
                ++chance;
                tries = askInt(sc, chance);
                if (chance < MAX_CHANCE)
                {
                    final int sD = commonDigit(tries, iaNum);
                    final int sNsP = sameNumSamePlace(tries, iaNum);
                    System.out.println("IA: " + sD + " nombre" + plural(sD) + " correct" + plural(sD) +
                            ", " + sNsP + " nombre" + plural(sNsP) + " bien placé" + plural(sNsP));
                }
            }

            if (tries == iaNum)
                System.out.println("IA : Félicitation vous avez trouvé le bon nombre en " +
                        chance + " essai" + plural(chance));
            else
                System.out.println("IA : Perdu, le bon nombre était " + iaNum);
        }
        while (askRetry(sc));
        System.out.println("Merci d'avoir joué, à plus tard...");
    }
}
