package com.ocr.personae;
import com.ocr.personae.comportement.*;

public abstract class Personnage {

   //Instances de comportement
    protected I_EspritCombatif EspritCombatif = new Pacifiste();
    protected I_Soin soin = new AucunSoin();
    protected I_Deplacement Deplacement = new Marcher();

    //Constructeur par défaut
    public Personnage(){}

    //Constructeur avec paramètres
    public Personnage(I_EspritCombatif espritCombatif, I_Soin soin, I_Deplacement deplacement){
        this.EspritCombatif = espritCombatif;
        this.soin = soin;
        this.Deplacement = deplacement;
    }
    //Méthodes de déplacement des personnages
    public void seDeplacer() {
        Deplacement.deplacer();
    }
    //Méthode que les combattants utilisent
    public void combattre() {
        EspritCombatif.combat();
    }

    //Méthode de soin
    public void soigner(){
        soin.soigne();
    }

    //Redéfinition des comportements au combat
    public void setIEspritCombatif(I_EspritCombatif espritCombatif) {
        this.EspritCombatif = espritCombatif;
    }

    //Redéfinition des comportements de soin
    public void setSoin(I_Soin soin) {
        this.soin = soin;
    }

    //Redéfinition des comportements de déplacement
    public void setDeplacement(I_Deplacement deplacement) {
        this.Deplacement = deplacement;
    }
}
