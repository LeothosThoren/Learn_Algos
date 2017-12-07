import java.util.Arrays;

public class CasablancaHorses

{
    /*!
    ** Given an array, return the 2 closest values.
    ** If the array is invalid (meaning < 2), then return {0, 0, 0}
    ** An horse power can't exceed 9999.
    ** Ex:
    **     [8, 5, 2, 4, 1, 9] => {8, 9, 1}.
    **     [120, 42, 789, 38] => {38, 42, 4}.
    **     [3] => {0, 0, 0} (invalid)
    **
    ** @param horses  A list of horses.
    **
    ** @return The best 2 horses and the power difference between them.
    */

    static void revertedBubbleSort(int tab[]) {
        int round = 0;
        int i;
        boolean change = true;

        while (change) {
            change = false;
            round++;
            for (i = 0; i < tab.length - round; i++) {
                if (tab[i] < tab[i + 1]) {
                    int temp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;
                    change = true;
                }
            }
        }
    }

    static int[] computeDuel(int horses[]) {

        int res[] = {0, 0, 0};

        if (horses.length < 2) return res;
        Arrays.sort(horses);

        res[2] = 10000;

        for (int i = 0; i < horses.length -1; i++) {
           final int  tmp = horses[i+1] - horses[i];
            if (tmp < res[2]) {
                res[2] = tmp;
                res[1] = horses[i+1];
                res[0] = horses[i];
            }
        }
        return res;
    }

    /*!
    ** Test suite for casablanca horses.
    */

    public static void main(String[] args)

    {

        int testSuite[][] =

                {
                        {1, 4, 78, 98, 2},
                        {1, 2, 1},

                        {1},
                        {0, 0, 0},

                        {},
                        {0, 0, 0},

                        {1, 3},
                        {1, 3, 2},

                        {120, 42, 789, 38},
                        {38, 42, 4},

                        {45, 5, 19, 5},
                        {5, 5, 0},

                        {7, 7, 7, 7},
                        {7, 7, 0},

                        {120, 151, 17, 9999, 45, 7894, 4567, 0, 9992},
                        {9992, 9999, 7},

                        {240, 1, 7, 8, 54, 489, 2, 55, 490},
                        {1, 2, 1},

                        {5, 15, 17, 3, 8, 11, 28, 6, 55, 7, 1},
                        {5, 6, 1},

                        {9946, 9818, 8503, 8386, 8290, 6993, 4861,
                                3440, 3311, 3208, 3146, 3093, 3009, 2888,
                                2758, 2683, 2534, 2426, 2338, 2268, 2195,
                                2123, 2005, 1912, 1842, 1713, 1442, 47},
                        {3093, 3146, 53}
                };


        for (int i = 0; i < testSuite.length; i += 2)

        {
            if (Arrays.equals(computeDuel(testSuite[i]), testSuite[i + 1]))
                System.out.println("Test " + (i / 2) + ": OK");
            else
                System.out.println("Test " + (i / 2) + ": FAIL => expected " +
                        Arrays.toString(testSuite[i + 1]) + " but was " +
                        Arrays.toString(computeDuel(testSuite[i])));

        }

    }

}