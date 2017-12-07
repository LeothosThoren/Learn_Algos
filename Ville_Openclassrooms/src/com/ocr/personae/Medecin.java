package com.ocr.personae;
<<<<<<< HEAD
import com.ocr.comportement.*;
=======
import com.ocr.personae.comportement.*;
>>>>>>> a130f515d8076777f17afd801abee51cb898b51e

public class Medecin extends Personnage {

    public Medecin() {
        this.soin = new PremierSoin();
    }

    public Medecin(I_EspritCombatif esprit, I_Soin soin, I_Deplacement dep) {
        super(esprit, soin, dep);
    }



}

