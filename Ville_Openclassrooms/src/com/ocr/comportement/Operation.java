package com.ocr.comportement;

public class Operation implements I_Soin {
    @Override
    public void soigne() {
        System.out.println("Je pratique de la chirurgie.");
    }
}