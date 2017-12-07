package com.ocr.personae;
<<<<<<< HEAD
import com.ocr.comportement.*;
=======
import com.ocr.personae.comportement.*;
>>>>>>> a130f515d8076777f17afd801abee51cb898b51e

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
