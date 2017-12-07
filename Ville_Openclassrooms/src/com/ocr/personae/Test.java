package com.ocr.personae;
import com.ocr.personae.comportement.*;

class Test{
    public static void main(String[] args) {
        Personnage[] tPers = {new Guerrier(), new Sniper(), new Civil(), new Medecin(), new Chirurgien()};
        Personnage pers = new Guerrier();
        pers.soigner();
        pers.setSoin(new Operation());
        pers.soigner();

        for(int i = 0; i < tPers.length; i++){
            System.out.println("\nInstance de " + tPers[i].getClass().getSimpleName());
            System.out.println("*****************************************");
            tPers[i].combattre();
            tPers[i].seDeplacer();
            tPers[i].soigner();
        }
    }
}
