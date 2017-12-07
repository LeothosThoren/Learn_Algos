package com.ocr.personae.comportement;

public class Pacifiste implements I_EspritCombatif {
    @Override
    public void combat() {
        System.out.println("Je ne combat PAS !");
    }
}
