package com.ocr.personae.comportement;

public class PremierSoin implements I_Soin {
    @Override
    public void soigne() {
        System.out.println("Je procure les premiers soin.");
    }
}
