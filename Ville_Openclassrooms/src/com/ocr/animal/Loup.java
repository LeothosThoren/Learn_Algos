package com.ocr.animal;

public class Loup extends Canin {

    public Loup() {

    }

    public Loup(String couleur, int poids) {
        this.couleur = couleur;
        this.poids = poids;
    }

    void crier() {
        System.out.println("La nuit de pleine lune, je fais ouhouh!!");
    }
}
