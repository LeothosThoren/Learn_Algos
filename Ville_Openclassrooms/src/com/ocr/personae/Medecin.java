package com.ocr.personae;
import com.ocr.comportement.*;

public class Medecin extends Personnage {

    public Medecin() {
        this.soin = new PremierSoin();
    }

    public Medecin(I_EspritCombatif esprit, I_Soin soin, I_Deplacement dep) {
        super(esprit, soin, dep);
    }



}

