package com.ocr.ville;

/**
 * Classe public : Objet com.ocr.ville.Ville
 ***/

public class Ville {

    public static int nbreInstances = 0;
    protected static int getNbreInstancesBis = 0;
    //Variables d'instances
    protected String nomVille;
    protected String nomPays;
    protected int nbreHabitants;
    protected char categorie;

    /*********************************************
     ****************CONSTRUCTEUR*****************
     ********************************************/

    //Constructeurs par défaut
    public Ville() {
        System.out.println("Création d'une ville !");
        nomVille = "Inconnu";
        nomPays = "Inconnu";
        nbreHabitants = 0;
        this.setCategorie();
        nbreInstances++;
        getNbreInstancesBis++;

    }

    //Constructerus avec paramètres

    public Ville(String nomV, int nbreV, String paysV) throws NombreHabitantException, NomVilleException {

        if (nbreV < 0)
            throw new NombreHabitantException(nbreV);

        if (nomV.length() < 3)
            throw new NomVilleException("le nom de la ville est inférieur à 3 caractères ! nom = " + nomV);

        else {
            System.out.println("Création d'une ville avec paramètres !");
            nomVille = nomV;
            nomPays = paysV;
            nbreHabitants = nbreV;
            this.setCategorie();
            nbreInstances++;
            getNbreInstancesBis++;
        }
    }

    /***************************************************
     *************ACCESSEURS / GETTERS ******************
     ***************************************************/

    public String getNomVille() {
        return nomVille;
    }

    public String getNomPays() {
        return nomPays;
    }

    public int getNbreHabitants() {
        return nbreHabitants;
    }

    public char getCategorie() {
        return categorie;
    }

    public static int getNombreInstancesBis() {
        return getNbreInstancesBis;
    }

    /*****************************************************
     /**************MUTATEURS / SETTERS********************
     ****************************************************/

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }


    public void setNbreHabitants(int nbreHabitants) {
        this.nbreHabitants = nbreHabitants;
        this.setCategorie();
    }


    /***********************************************
     ******************  METHODES  *******************
     ***********************************************/

    //Définit la catégorie de la ville
    private void setCategorie() {
        int bornesSuperieures[] = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};
        char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        int i = 0;
        while (i < bornesSuperieures.length && this.nbreHabitants > bornesSuperieures[i]) {
            i++;

            this.categorie = categories[i];
        }
    }

    //Retourne la description de la ville
    public String toString() {
        return "\t" + this.nomVille + " est une ville de " + this.nomPays + ", elle comporte : "
                + this.nbreHabitants + " habitant(s) => elle est donc de catégorie : " + this.categorie;
    }

    //Retourne une chaine de caractère en fonction
    public String comparer(Ville v1) {
        String str = "";

        if (v1.getNbreHabitants() > this.nbreHabitants)
            str = v1.getNomVille() + " est plus peuplé que " + this.nomVille;

        else
            str = this.nomVille + " est une ville plus peuplé que " + v1.getNomVille();
        return str;
    }

}

