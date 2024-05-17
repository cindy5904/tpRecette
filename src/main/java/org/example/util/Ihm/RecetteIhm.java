package org.example.util.Ihm;

import org.example.DAO.RecetteDAO;
import org.example.Entity.Recette;
import org.example.util.Difficulte;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class RecetteIhm {
    private Scanner scanner;
    private RecetteDAO recetteDAO;

    public RecetteIhm(Scanner scanner) {
        this.scanner = scanner;
        recetteDAO = new RecetteDAO();
    }
    public void start (){
        int entry;
        while(true){
            System.out.println("--- Menu Recette ---");
            System.out.println("1/ Créer une recette");
            System.out.println("2/ Afficher toutes les recettes");
            System.out.println("3/ Modifier la recette");
            System.out.println("4/ Supprimer la recette");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    createRecette();
                    break;
                case 2:
                    getAllRecette();
                    break;
                case 3 :
                    System.out.println("en cours");;
                    break;
                case 4 :
                    System.out.println("en cours");;
                    break;
                default:
                    return;
            }
        }
    }
    private void createRecette (){
        System.out.println("-- creation d'une recette --");
        System.out.println("nom de la recette :");
        String nom = scanner.nextLine();
        System.out.println("Entrer le temps de préparation :");
        int tempsPrep = Integer.parseInt(scanner.nextLine());
        System.out.println("Entrer le temps de cuisson :");
        int tempsCuisson = Integer.parseInt(scanner.nextLine());
        System.out.println("Entrez la difficulté de la recette (Facile/Intermédiaire/Difficile) :");
        String difficulte = scanner.nextLine();

        Recette recette = Recette.builder().nom(nom).tempsPrep(tempsPrep).tempsCuisson(tempsCuisson).difficulte(Difficulte.valueOf(difficulte)).build();

        try {
            Recette recetteCreated = recetteDAO.save(recette);
            if(recetteCreated != null){
                System.out.println("recette créer "+ recetteCreated );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void update() {
        System.out.println("--- modification de la recette ---");
        System.out.println("id de la recette:");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Recette recette = RecetteDAO.get(id);
            System.out.println("Nom de la recette (" + recette.getNom()+")");
            String nouveauNom = scanner.nextLine();
            recette.setNom(nouveauNom);

        }
    }
    private void getAllRecette() {
        System.out.println("-- Récupération des recettes --");
        try {
            List<Recette> recettes = recetteDAO.get();
            if (recettes.isEmpty()) {
                System.out.println("Aucune recette trouvée.");
            } else {
                for (Recette recette : recettes) {
                    afficherRecette(recette);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des recettes.", e);
        }
    }

    private void afficherRecette(Recette recette) {
        System.out.println("ID : " + recette.getId());
        System.out.println("Nom : " + recette.getNom());
        System.out.println("Temps de préparation : " + recette.getTempsPrep() + " minutes");
        System.out.println("Temps de cuisson : " + recette.getTempsCuisson() + " minutes");
        System.out.println("Difficulté : " + recette.getDifficulte());

        System.out.println("---------------------------------------");
    }

}
