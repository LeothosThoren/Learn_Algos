package com.ocr.personae;
import com.ocr.comportement.*;

public class Chirurgien extends Personnage {

    public Chirurgien(){
        this.soin = new Operation();
    }

    public Chirurgien(I_EspritCombatif esprit, I_Soin soin, I_Deplacement dep){
        super(esprit, soin, dep);
    }
}
