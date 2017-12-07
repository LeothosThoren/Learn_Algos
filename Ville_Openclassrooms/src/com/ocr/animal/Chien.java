package com.ocr.animal;

public class Chien extends Canin implements Rintintin {

    public Chien() {

    }

    public Chien(String couleur, int poids) {
        this.couleur = couleur;
        this.poids = poids;
    }

    void crier() {
        System.out.println("Quand j'aboie ça fait Wouaf wouaf !!");
    }

    @Override
    public void faireCalin() {
        System.out.println("Je te fais un gros Câlin");
    }

    @Override
    public void faireLeBeau() {
        System.out.println("Je fais le beau !");
    }

    @Override
    public void faireLechouille() {
        System.out.println("Je te fais une grosse léchouille...");
    }
}