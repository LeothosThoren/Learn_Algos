package com.ocr.personae.comportement;

public class AucunSoin implements I_Soin {
    @Override
    public void soigne() {
        System.out.println("Je ne donne AUCUN soin !");
    }
}