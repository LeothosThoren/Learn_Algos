package com.ocr.personae;
import com.ocr.personae.comportement.*;

public class Civil extends Personnage {

   public Civil(){}

   public Civil(I_EspritCombatif esprit, I_Soin soin, I_Deplacement dep){
       super(esprit, soin, dep);
   }
}
