package com.ocr.personae;
<<<<<<< HEAD
import com.ocr.comportement.*;
=======
import com.ocr.personae.comportement.*;
>>>>>>> a130f515d8076777f17afd801abee51cb898b51e

public class Guerrier extends Personnage {

    public Guerrier(){
        this.EspritCombatif = new CombatPistolet();
    }

    public Guerrier(I_EspritCombatif esprit, I_Soin soin, I_Deplacement dep){
        super(esprit, soin, dep);
    }
}
