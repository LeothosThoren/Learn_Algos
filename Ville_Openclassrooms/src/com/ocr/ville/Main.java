package com.ocr.ville;

class Main {

    public static void main(String[] args) {
        Ville v = null;
        try {
<<<<<<< HEAD
            v = new Ville("Re", -12000, "France");

        } catch (NombreHabitantException | NomVilleException e) {
            System.out.println(e.getMessage());

=======
            v = new Ville("Rennes", -12000, "France");

        } catch (NombreHabitantException e) {
>>>>>>> a130f515d8076777f17afd801abee51cb898b51e
        } finally {
            if (v == null)
                v = new Ville();
        }
<<<<<<< HEAD

=======
>>>>>>> a130f515d8076777f17afd801abee51cb898b51e
        System.out.println(v.toString());
    }

}
