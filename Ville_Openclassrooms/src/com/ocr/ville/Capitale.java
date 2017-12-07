package com.ocr.ville;

public class Capitale extends Ville {

    private String monument;

    //Constrcuteur par défaut
    public Capitale() {
        //Ici le mot clé super permet de faire appel àu constructeur de la classe mère (com.ocr.ville.Ville.java=
        super();
        monument = "aucun";
    }

    //Constructeur d'initialisation de capitale avec paramètre
    public Capitale(String nom, int hab, String pays, String monument) throws NombreHabitantException, NomVilleException {
        super(nom, hab, pays);
        this.monument = monument;
    }

    /*
    * Description d'une capitale
    * @return String retourne la description de l'objet
    * */
    public String toString() {
        String str = super.toString() + "\n\t ==>>" + this.monument + " en est un monument";
        System.out.println("Invocation de super.decrisToi()");
        return str;
    }


    /*
    * @return le nom du monument
    * */
    public String getMonument() {
        return monument;
    }

    //Définit le nom du monument
    public void setMonument(String monument) {
        this.monument = monument;
    }
}
