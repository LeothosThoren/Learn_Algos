package com.ocr.comportement;

public class Marcher implements I_Deplacement {
    @Override
    public void deplacer() {
        System.out.println("Je me déplace en marchant.");
    }
}
