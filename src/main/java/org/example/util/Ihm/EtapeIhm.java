package org.example.util.Ihm;

import org.example.DAO.EtapeDAO;
import org.example.Entity.Etape;
import org.example.Entity.Ingredient;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EtapeIhm {
    private final Scanner scanner;
    private final EtapeDAO etapeDAO;

    public EtapeIhm(Scanner scanner) {
        this.scanner = scanner;
        etapeDAO = new EtapeDAO();
    }
    public void start (){
        int entry;
        while(true){
            System.out.println("--- Etape ---");
            System.out.println("1/ Entrer la description");
            System.out.println("2/ Afficher toutes les étapes");
            System.out.println("3/ Modifier une étape");
            System.out.println("4/ Supprimer une étape");
            entry = scanner.nextInt();
            scanner.nextLine();
            switch (entry){
                case 1:
                    createEtape();
                    break;
                case 2:
                    getAllEtape();
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
    private void createEtape (){
        System.out.println("-- Ajouter une étape --");
        System.out.println("Description de l'étape :");
        String description = scanner.nextLine();

        Etape etape = Etape.builder().description(description).build();

        try {
            Etape etapeCreated = etapeDAO.save(etape);
            if(etapeCreated != null){
                System.out.println("Etape créer: "+ etapeCreated );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void getAllEtape() {
        System.out.println("-- Récupération des étapes--");
        try {
            List<Etape> etapes = etapeDAO.get();
            if (etapes.isEmpty()) {
                System.out.println("Aucune étape trouvé.");
            } else {
                for (Etape etape : etapes) {
                    afficherEtape(etape);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des recettes.", e);
        }
    }
    private void afficherEtape(Etape etape) {
        System.out.println("ID : " + etape.getId());
        System.out.println("Nom : " + etape.getDescription());
        System.out.println("---------------------------------------");
    }
}
