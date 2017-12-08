package com.ocr.personae;
import com.ocr.personae.comportement.*;

public class Sniper extends Personnage {

    public Sniper() {
        this.EspritCombatif = new CombatSniper();
    }
    public Sniper(I_EspritCombatif esprit, I_Soin soin, I_Deplacement dep) {
        super(esprit, soin, dep);
    }



}
