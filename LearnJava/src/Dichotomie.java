public class Dichotomie

{

    /*!
    ** Dichotomic search.
    **
    ** @param tab  An array of int.
    ** @param value The value to search.
    **
    ** @return The index where the value is,
    **         or -1 if not found
    */

    public static int search(int tab[], int value)

    {
        int beg = 0, end = tab.length - 1, mid;

        while (beg <= end) {
            mid = (end + beg) / 2;

            if (value == tab[mid])
                return mid;
            else {
                if (value > tab[mid])
                    beg = mid + 1;
                else if (value < tab[mid])
                    end = mid - 1;
            }
        }

        return -1;

    }

    public static int searchWE(int tab[], int value)

    {
        int beg = 0, end = tab.length - 1, mid;

        while (beg <= end) {
            mid = (end + beg) / 2;

            if (value == tab[mid])
                return mid;
            if (value > tab[mid])
                beg = mid + 1;
            if (value < tab[mid])
                end = mid - 1;
        }
        return-1;
}


    /*!
    ** Test suite for dichotomie
    */

    public static void main(String[] args)

    {

        int testSuite[][] =

                {

                        {5, 2},

                        {1, 2, 5, 9, 45},


                        {5, -1},

                        {1, 2, 9, 18, 45},


                        {45, 4},

                        {1, 2, 9, 18, 45},


                        {1, 0},

                        {1, 2, 9, 18, 45},


                        {1, 0},

                        {1},


                        {1, -1},

                        {},


                        {1, 0},

                        {1, 2},


                        {2, 1},

                        {1, 2},


                        {20, 1},

                        {10, 20, 30, 40},


                        {30, 2},

                        {10, 20, 30, 40},


                        {20, 1},

                        {10, 20, 25, 30, 40},


                        {25, 2},

                        {10, 20, 25, 30, 40},


                        {30, 3},

                        {10, 20, 25, 30, 40},


                        {3845, 6},

                        {1, 45, 56, 78, 987, 1500, 3845},


                        {1, 0},

                        {1, 45, 56, 78, 987, 1500, 3845},

                };

        //Testing performance => with else
        long start = System.nanoTime();
        for (int i = 0; i < testSuite.length; i += 2)

        {

            if (search(testSuite[i + 1], testSuite[i][0]) == testSuite[i][1])

                System.out.println("Test " + (i / 2) + ": OK");

            else

                System.out.println("Test " + (i / 2) + ": FAIL => expected " +

                        testSuite[i][1] + " but was " +

                        search(testSuite[i + 1], testSuite[i][0]));

        }
        long end = System.nanoTime();
        System.out.print("Temps d'exécution avec else : ");
        System.out.println((end - start) / 1000);


        System.out.println("\n**********************************************************\n");

        //Testing performance => without else
        long start1 = System.nanoTime();
        for (int i = 0; i < testSuite.length; i += 2)

        {

            if (searchWE(testSuite[i + 1], testSuite[i][0]) == testSuite[i][1])

                System.out.println("Test " + (i / 2) + ": OK");

            else

                System.out.println("Test " + (i / 2) + ": FAIL => expected " +

                        testSuite[i][1] + " but was " +

                        searchWE(testSuite[i + 1], testSuite[i][0]));

        }
        long end2 = System.nanoTime();
        System.out.print("Temps d'exécution sans else : ");
        System.out.println((end - start) / 1000);


    }

}