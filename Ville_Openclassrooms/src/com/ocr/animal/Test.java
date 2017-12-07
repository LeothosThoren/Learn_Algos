package com.ocr.animal;

public class Test {

    public static void main(String[] args) {
        Animal l = new Lion("Blanc argenté", 200);
        Chien c = new Chien("Grise", 15);


        System.out.println(c.toString());
        c.boire();
        c.manger();
        c.deplacement();
        c.crier();

        System.out.println("---------------------------------------");
        //Les méthodes de l'interface
        c.faireCalin();
        c.faireLeBeau();
        c.faireLechouille();

        System.out.println("-----------------------------------------");
        // Utilisons le polymorphisme
        Rintintin r = new Chien();
        r.faireCalin();
        r.faireLeBeau();
        r.faireLechouille();

    }

}
