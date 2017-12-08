package com.ocr.ville;

public class NombreHabitantException extends Exception {
    public NombreHabitantException() {
        System.out.println("Vous essayez d'instancier une classe 'Ville' avec un nombre d'habitant négatif !");
    }

    public NombreHabitantException(int nbre) {
        System.out.println("Instanciation avec un nombre d'habitant négatif.");
        System.out.println("\t => "+ nbre+"\n");
    }

}
