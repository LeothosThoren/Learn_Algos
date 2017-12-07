import java.util.Scanner;
import java.util.Arrays;

public class Scrabble_bis
{
    static int _alphabet[] = {/*a*/1, /*b*/3, /*c*/3, /*d*/2, /*e*/1, /*f*/4,
                              /*g*/2, /*h*/4, /*i*/1, /*j*/8, /*k*/5, /*l*/1,
                              /*m*/3, /*n*/1, /*o*/1, /*p*/3, /*q*/10, /*r*/1,
                              /*s*/1, /*t*/1, /*u*/1, /*v*/4, /*w*/4, /*x*/8,
                              /*y*/4, /*z*/10};


    /*!
    ** Compute the score word.
    ** @note Please *not* a big if list :p, I'm
    ** sure you can find something more elegant!
    **
    ** @param word The given word
    **
    ** @return The word score.
    */
    public static int computeWordScore(char word[])
    {
        int score = 0;
        for (int i = 0; i < word.length; ++i)
            score += _alphabet[word[i] - 'a'];

        return score;
    }

    /*
    ** Check if word could match given letters.
    ** Example: word "abc" will match "abecd" but "abf" will not match "abc".
    ** Warning: The letters must be sorted!
    */
    static Boolean match(char[] needle, char[] heap)
    {
        int i = 0;
        int k = 0;
        while (i < needle.length && k < heap.length)
        {
            while (i < needle.length && k < heap.length &&
                    needle[i] == heap[k])
            {
                ++i;
                ++k;
            }
            ++k;
        }

        return i >= needle.length;
    }

    /*!
    **
    **
    ** @param words The list of words.
    ** @param letters The current letters own by the player.
    **
    ** @return The best word (with the greatest score)
    **         or "" if nothing matched.
    */
    static int findBestWord(char words[][], char[] letters)
    {
        int index = -1;
        int best = 0;
        for (int i = 0; i < words.length; ++i)
        {
            if (match(words[i], letters))
            {
                final int score = computeWordScore(words[i]);
                if (score > best)
                {
                    best = score;
                    index = i;
                }
            }
        }

        return index;
    }

    // =========================
    /**
     * This function compare every letters from @param word with each letters from @param letters
     * and when it's found, the previous letter is replaced by an empty char in the array and @return a string
     **/
    static String comparatorSOF(char[] words, char[] letters) {

        String tmp = "";
        char[] tab_letters = letters.clone();

        for (int i = 0; i < words.length; i++) {
            int j = 0;
            while (j < tab_letters.length) {
                if (tab_letters[j] == words[i]) {
                    tmp += words[i];
                    tab_letters[j] = '\0';
                    break;
                }
                j++;
                if (j >= tab_letters.length)
                    i = words.length;
            }
        }
        return tmp;
    }

    /**
     * This function checks the value of each letters from a @param word and @returns the total
     **/
    static int bestScoreSOF(String word) {

        int score = 0;
        int _alphabetSOF[] = {/*a*/1, /*b*/3, /*c*/3, /*d*/2, /*e*/1, /*f*/4,
                              /*g*/2, /*h*/4, /*i*/1, /*j*/8, /*k*/5, /*l*/1,
                              /*m*/3, /*n*/1, /*o*/1, /*p*/3, /*q*/10, /*r*/1,
                              /*s*/1, /*t*/1, /*u*/1, /*v*/4, /*w*/4, /*x*/8,
                              /*y*/4, /*z*/10};

        for (int i = 0; i < word.length(); ++i) {
            score += _alphabetSOF[word.charAt(i) - 'a'];
        }
        return score;
    }

    /**
     * This function @returns a word contains in a dictionnary, with the greatest score
     **/
    static String findBestWordSOF(char[][] words, char[] letters) {
        String res = "";
        String tmp;
        int best = 0;

        if (letters.equals("")) return res;

        for (char[] word : words) {
            if (word.length <= letters.length) {
                tmp = comparatorSOF(word, letters);
                if (Arrays.equals(tmp.toCharArray(), word)) {
                    final int score = bestScoreSOF(tmp);
                    if (best < score) {
                        best = score;
                        res = tmp;
                    }
                }
            }
        }
        return res;
    }


    // =========================

    static char[][] stringToChar(String tab[])
    {
        char[][] ctab = new char[tab.length][];
        for (int i = 0; i < tab.length; ++i)
            ctab[i] = tab[i].toCharArray();
        return ctab;
    }

    /*!
    ** Test suite for scrabble.
    */
    public static void main(String[] args)
    {
        String dictionnary[] =
                {"fawn","nunnery","deferment","sonja","circuitry","hanging","woody","houyhnhnm","aileen","scold",
                        "originality","crossbar","eugenics","trimester","appropriation","rawhide","fractal","durocher","broiler",
                        "wednesday","woods","crotch","steadfastness","asama","thrace","kublai","precocity","feasibility","bannister",
                        "sooth","selassie","prosody","jinrikisha","dormancy","centimeter","cooking","warmongering","usenet","designing",
                        "numeral","crouch","china","chino","uniroyal","chink","doldrums","existentialist","cupful","controversy","kidd",
                        "neurologist","climber","golden","topography","projection","fretwork","stern","agassi","portugal","insecurity",
                        "cannibal","inevitable","definiteness","music","crooner","yahoo","alphecca","meteorologist","adventist","equilateral",
                        "murchison","simper","kampala","locker","locket","busyness","transom","wang","wand","wane","fluorite","disparagement",
                        "titanium","want","rayon","pinto","cocksucker","absolute","travel","dictionary","digitalis","abductor","diva",
                        "obliteration","yore","kipper","fitzpatrick","conversation","calvary","cain","ionic","boondoggle","firehouse",
                        "bleakness","harmlessness","probation","endemic","salient","droop","intention","nomination","overdraft","myspace",
                        "galley","triumvirate","anaemia","motorcar","drool","dschubba","transubstantiation","constituent","institution",
                        "bismuth","enticement","clemson","sculpture","bodice","lateness","alfonso","muezzin","agronomy","florin","agency",
                        "bagel","sindhi","wetback","gracelessness","optometry","siphon","noggin","deena","fortieth","weeper","dent","dena",
                        "deng","fief","myrna","aquafresh","seaweed","chicken","debate","brainteaser","dandruff","moet","storekeeper","cache",
                        "ninepin","forfeit","daydreamer","sagittarius","silas","dope","inseam","watercolor","ophthalmology","suet","ghetto",
                        "heretic","expertness","netzahualcoyotl","handspring","jaime","quaternary","proprietorship","sediment","emery",
                        "inconspicuousness","goldfinch","ebb","bekesy","churchman","gerrymander","criminologist","weller","caginess","closet",
                        "genius","panty","linebacker","satire","caracul","foetus","addie","salesgirl","spoil","dependance","memento","barrett",
                        "soapbox","wilbur","profanity","heterosexuality","broadside","grain","canopy","premise","hyphen","neighborliness",
                        "fishhook","softie","window","reindeer","cordite","emirate","zenger","verizon","butchery","buffy","shuttlecock",
                        "waggle","repetition","rasher","kerchief","wilt","vanilla","cursor","wild","wile","hobbyhorse","jehovah","ideogram",
                        "whorl","whore","vintage","headlight","fomentation","zilch","firmament","parthenon","premiere","diploma","octagon",
                        "issuance","antipasto","overwork","declamation","english","breaker","rocker","rocket","boot","wren","miniscule",
                        "happiness","temerity","disturbance","harare","sky","micronesia","sweetener","thermodynamics","adoption","ski",
                        "armonk","knob","saturation","branch","knot","alisha","pastern","obliqueness","iberia","pygmalion","cutlet","hitchhike",
                        "dancer","nominative","lance","sequence","dispossession","birthmark","eventfulness","preposition","holler","empire",
                        "holley","leaf","lead","zanuck","leak","lean","lear","leap","friskiness","saltcellar","voluptuousness","leader",
                        "haywood","murderer","thoroughfare","slur","mitt","slut","wesley","corpuscle","mite","slug","slue","throne","throng",
                        "incline","hausdorff","biscuit","dependence","shipping","sidekick","uccello","dependency","epiphany","lardner",
                        "warranty","bugle","hotcake","headphone","brush","registration","maize","grapevine","preferment","hypnotism",
                        "footwork","clampdown","wight","brashness","nassau","goose","tab","daffodil","gelatine","windfall","benetton",
                        "hilfiger","jewel","horsewoman","dearth","carbohydrate","hardiness","goodness","attributive","boor","percent",
                        "illinois","book","boom","boon","boob","malefactor","junk","juno","xenon","june","jung","sherd","dissension","sheri",
                        "flatfish","northerly","jawbone"};

        String testSuite[][] =
                {
                        {"", ""},
                        {"", "a", "b", "c"},

                        {"wdbtrsoe", "bestword"},
                        {"word", "bestword", "badword", "anotherword"},

                        {"abcdefg", "abc"},
                        {"abc", "xyz", "abh", "zefg"},

                        {"abcdefg", "abc"},
                        {"abc", "xyz", "abh", "zefg", "abcdefgabc"},

                        {"wdbtrsoe", ""},
                        {"zzz", "aaaaaaaa", "yyyyyy", "xx"},

                        {"aeizqx", "zq"},
                        {"aei", "xie", "zq", "axe"},

                        {"hicquwh", "which"},
                        {"because", "first", "these", "could", "which"},

                        {"sopitez", "potsie"},
                        {"some","first","potsie","day","could","postie","from","have","back","this"},

                        {"tsropwe", "powers"},
                        {"after","repots","user","powers","these","time","know","from","could","people"},

                        {"arwtsre", "waster"},
                        {"arrest","rarest","raster","raters","sartre","starer","waster","waters","wrest","wrase"},

                        {"etiewrn", "tween"},
                        {"entire","tween","soft","would","test"},

                        {"qzaeiou", "aeiou"},
                        {"qzyoq","azejuy","kqjsdh","aeiou","qsjkdh"},

                        {"etaenhs", "ethane"},
                        {"ethane", "hates", "sane", "ant"},

                        {"aretsui", "satire"},
                        dictionnary,

                        {"retpasn", "pastern"},
                        dictionnary,

                        {"wdbtrsoe", ""},
                        dictionnary,

                        {"northerly", "northerly"},
                        dictionnary,
                };

        {
            char cTestSuite[][][] = new char[testSuite.length][][];
            for (int i = 0; i < testSuite.length; ++i)
                cTestSuite[i] = stringToChar(testSuite[i]);

            // =============================================

            long start = System.nanoTime();
            for (int i = 0; i < testSuite.length; i += 2)
            {
                String res = findBestWordSOF(cTestSuite[i + 1], cTestSuite[i][0]);
                if (testSuite[i][1].equals(res))
                    System.out.println("Test " + (i / 2) + ": OK");
                else
                    System.out.println("Test " + (i / 2) + ": FAIL => expected " + testSuite[i][1] +
                            " but was " + new String(res));
            }

            long end = System.nanoTime();
            System.out.print("Temps d'exécution Sof en us : ");
            System.out.println((end - start) / 1000);
        }

        // ====================================

        {
            char cTestSuite[][][] = new char[testSuite.length][][];
            for (int i = 0; i < testSuite.length; ++i)
            {
                cTestSuite[i] = stringToChar(testSuite[i]);
                for (int j = 0; j < cTestSuite[i].length; ++j)
                    Arrays.sort(cTestSuite[i][j]);
            }

            // ===============================

            long start = System.nanoTime();
            for (int i = 0; i < testSuite.length; i += 2)
            {
                char[] res = {};
                int index = findBestWord(cTestSuite[i + 1], cTestSuite[i][0]);
                if (index >= 0)
                    res = testSuite[i + 1][index].toCharArray();
                if (Arrays.equals(testSuite[i][1].toCharArray(), res))
                    System.out.println("Test " + (i / 2) + ": OK");
                else
                    System.out.println("Test " + (i / 2) + ": FAIL => expected " + testSuite[i][1] +
                            " but was " + new String(res));
            }

            long end = System.nanoTime();
            System.out.print("Temps d'exécution axel en us : ");
            System.out.println((end - start) / 1000);
        }
    }
}
