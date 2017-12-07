package com.ocr.personae.comportement;

public class Courrir implements I_Deplacement {
    @Override
    public void deplacer() {
        System.out.println("Je me déplace en courrant.");
    }
}