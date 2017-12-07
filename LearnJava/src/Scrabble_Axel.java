import java.util.Arrays;

public class Scrabble_Axel {
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
    public static int computeWordScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); ++i)
            score += _alphabet[word.charAt(i) - 'a'];

        return score;
    }

    /*!
    ** Sort the letters of a string.
    **
    ** @param s The string to sort
    **
    ** @return A sorted copy of the string.
    */
    public static String sortString(String s) {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }

    /*
    ** Check if word could match given letters.
    ** Example: word "abc" will match "abecd" but "abf" will not match "abc".
    ** Warning: The letters must be sorted!
    */
    static Boolean match(String needle, String heap) {
        int i = 0;
        int k = 0;
        while (i < needle.length() && k < heap.length()) {
            while (i < needle.length() && k < heap.length() &&
                    needle.charAt(i) == heap.charAt(k)) {
                ++i;
                ++k;
            }
            ++k;
        }

        return i >= needle.length();
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
    static String findBestWord(String[] words, String letters) {
        letters = sortString(letters);
        String res = "";
        int best = 0;
        for (int i = 0; i < words.length; ++i) {
            if (match(sortString(words[i]), letters)) {
                final int score = computeWordScore(words[i]);
                if (score > best) {
                    best = score;
                    res = words[i];
                }
            }
        }

        return res;
    }

    /*!
    ** Test suite for scrabble.
    */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        String dictionnary[] =
                {"fawn", "nunnery", "deferment", "sonja", "circuitry", "hanging", "woody", "houyhnhnm", "aileen", "scold",
                        "originality", "crossbar", "eugenics", "trimester", "appropriation", "rawhide", "fractal", "durocher", "broiler",
                        "wednesday", "woods", "crotch", "steadfastness", "asama", "thrace", "kublai", "precocity", "feasibility", "bannister",
                        "sooth", "selassie", "prosody", "jinrikisha", "dormancy", "centimeter", "cooking", "warmongering", "usenet", "designing",
                        "numeral", "crouch", "china", "chino", "uniroyal", "chink", "doldrums", "existentialist", "cupful", "controversy", "kidd",
                        "neurologist", "climber", "golden", "topography", "projection", "fretwork", "stern", "agassi", "portugal", "insecurity",
                        "cannibal", "inevitable", "definiteness", "music", "crooner", "yahoo", "alphecca", "meteorologist", "adventist", "equilateral",
                        "murchison", "simper", "kampala", "locker", "locket", "busyness", "transom", "wang", "wand", "wane", "fluorite", "disparagement",
                        "titanium", "want", "rayon", "pinto", "cocksucker", "absolute", "travel", "dictionary", "digitalis", "abductor", "diva",
                        "obliteration", "yore", "kipper", "fitzpatrick", "conversation", "calvary", "cain", "ionic", "boondoggle", "firehouse",
                        "bleakness", "harmlessness", "probation", "endemic", "salient", "droop", "intention", "nomination", "overdraft", "myspace",
                        "galley", "triumvirate", "anaemia", "motorcar", "drool", "dschubba", "transubstantiation", "constituent", "institution",
                        "bismuth", "enticement", "clemson", "sculpture", "bodice", "lateness", "alfonso", "muezzin", "agronomy", "florin", "agency",
                        "bagel", "sindhi", "wetback", "gracelessness", "optometry", "siphon", "noggin", "deena", "fortieth", "weeper", "dent", "dena",
                        "deng", "fief", "myrna", "aquafresh", "seaweed", "chicken", "debate", "brainteaser", "dandruff", "moet", "storekeeper", "cache",
                        "ninepin", "forfeit", "daydreamer", "sagittarius", "silas", "dope", "inseam", "watercolor", "ophthalmology", "suet", "ghetto",
                        "heretic", "expertness", "netzahualcoyotl", "handspring", "jaime", "quaternary", "proprietorship", "sediment", "emery",
                        "inconspicuousness", "goldfinch", "ebb", "bekesy", "churchman", "gerrymander", "criminologist", "weller", "caginess", "closet",
                        "genius", "panty", "linebacker", "satire", "caracul", "foetus", "addie", "salesgirl", "spoil", "dependance", "memento", "barrett",
                        "soapbox", "wilbur", "profanity", "heterosexuality", "broadside", "grain", "canopy", "premise", "hyphen", "neighborliness",
                        "fishhook", "softie", "window", "reindeer", "cordite", "emirate", "zenger", "verizon", "butchery", "buffy", "shuttlecock",
                        "waggle", "repetition", "rasher", "kerchief", "wilt", "vanilla", "cursor", "wild", "wile", "hobbyhorse", "jehovah", "ideogram",
                        "whorl", "whore", "vintage", "headlight", "fomentation", "zilch", "firmament", "parthenon", "premiere", "diploma", "octagon",
                        "issuance", "antipasto", "overwork", "declamation", "english", "breaker", "rocker", "rocket", "boot", "wren", "miniscule",
                        "happiness", "temerity", "disturbance", "harare", "sky", "micronesia", "sweetener", "thermodynamics", "adoption", "ski",
                        "armonk", "knob", "saturation", "branch", "knot", "alisha", "pastern", "obliqueness", "iberia", "pygmalion", "cutlet", "hitchhike",
                        "dancer", "nominative", "lance", "sequence", "dispossession", "birthmark", "eventfulness", "preposition", "holler", "empire",
                        "holley", "leaf", "lead", "zanuck", "leak", "lean", "lear", "leap", "friskiness", "saltcellar", "voluptuousness", "leader",
                        "haywood", "murderer", "thoroughfare", "slur", "mitt", "slut", "wesley", "corpuscle", "mite", "slug", "slue", "throne", "throng",
                        "incline", "hausdorff", "biscuit", "dependence", "shipping", "sidekick", "uccello", "dependency", "epiphany", "lardner",
                        "warranty", "bugle", "hotcake", "headphone", "brush", "registration", "maize", "grapevine", "preferment", "hypnotism",
                        "footwork", "clampdown", "wight", "brashness", "nassau", "goose", "tab", "daffodil", "gelatine", "windfall", "benetton",
                        "hilfiger", "jewel", "horsewoman", "dearth", "carbohydrate", "hardiness", "goodness", "attributive", "boor", "percent",
                        "illinois", "book", "boom", "boon", "boob", "malefactor", "junk", "juno", "xenon", "june", "jung", "sherd", "dissension", "sheri",
                        "flatfish", "northerly", "jawbone"};

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
                        {"some", "first", "potsie", "day", "could", "postie", "from", "have", "back", "this"},

                        {"tsropwe", "powers"},
                        {"after", "repots", "user", "powers", "these", "time", "know", "from", "could", "people"},

                        {"arwtsre", "waster"},
                        {"arrest", "rarest", "raster", "raters", "sartre", "starer", "waster", "waters", "wrest", "wrase"},

                        {"etiewrn", "tween"},
                        {"entire", "tween", "soft", "would", "test"},

                        {"qzaeiou", "aeiou"},
                        {"qzyoq", "azejuy", "kqjsdh", "aeiou", "qsjkdh"},

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


        for (int i = 0; i < testSuite.length; i += 2) {
            if (testSuite[i][1].equals(findBestWord(testSuite[i + 1], testSuite[i][0])))
                System.out.println("Test " + (i / 2) + ": OK");
            else
                System.out.println("Test " + (i / 2) + ": FAIL => expected " + testSuite[i][1] +
                        " but was " + findBestWord(testSuite[i + 1], testSuite[i][0]));
        }
        long end = System.currentTimeMillis();
        System.out.print("Temps d'exécution pour Axel : ");
        System.out.println(end - start);

    }

}

