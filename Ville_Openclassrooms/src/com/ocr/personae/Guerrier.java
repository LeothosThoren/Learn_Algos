package com.ocr.personae;
import com.ocr.comportement.*;

public class Guerrier extends Personnage {

    public Guerrier(){
        this.EspritCombatif = new CombatPistolet();
    }

    public Guerrier(I_EspritCombatif esprit, I_Soin soin, I_Deplacement dep){
        super(esprit, soin, dep);
    }
}
