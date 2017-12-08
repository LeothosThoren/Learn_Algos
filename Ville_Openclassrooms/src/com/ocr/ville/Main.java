package com.ocr.ville;

class Main {

    public static void main(String[] args) {
        Ville v = null;
        try {

            v = new Ville("Re", -12000, "France");

        } catch (NombreHabitantException | NomVilleException e) {
            System.out.println(e.getMessage());

        } finally {
            if (v == null)
                v = new Ville();
        }

        System.out.println(v.toString());
    }

}
