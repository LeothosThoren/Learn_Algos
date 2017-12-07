package com.ocr.animal;


abstract class Animal {

    protected String couleur;
    protected int poids;

    protected void manger() {
        System.out.println("Je mange de la viande.");
    }

    protected void boire() {
        System.out.println("Je bois de l'eau !");
    }

    abstract void deplacement();

    abstract void crier();

    public String toString() {
        String str = "Je suis un objet de la classe " + this.getClass().getSimpleName() + ", je suis de couleur " + this.couleur
                + ", je pèse " + this.poids + " Kilos";
        return str;
    }
}
