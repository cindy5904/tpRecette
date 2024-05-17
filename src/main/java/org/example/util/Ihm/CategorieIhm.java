package org.example.util.Ihm;

import org.example.DAO.CategorieDAO;
import org.example.DAO.IngredientDAO;
import org.example.Entity.Categorie;
import org.example.Entity.Ingredient;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CategorieIhm {
//    private Scanner scanner;
//    private CategorieIhm categorieIhm;
//    private Connection connection;
//
//    public CategorieIhm(Scanner scanner, CategorieIhm categorieIhm) {
//        this.scanner = scanner;
//        this.categorieIhm = categorieIhm;
//    }
//    public void start (){
//        int entry;
//        while(true){
//            System.out.println("--- Menu Categorie ---");
//            System.out.println("1/ Ajouter une catégorie");
//            System.out.println("2/ Afficher toutes les catégories");
//            System.out.println("3/ Modifier une catégorie");
//            System.out.println("4/ Supprimer une catégorie");
//            entry = scanner.nextInt();
//            scanner.nextLine();
//            switch (entry){
//                case 1:
//                    createCategorie();
//                    break;
//                case 2:
//                    getAllCategorie();
//                    break;
//                case 3 :
//                    System.out.println("en cours");;
//                    break;
//                case 4 :
//                    System.out.println("en cours");;
//                    break;
//                default:
//                    return;
//            }
//        }
//    }
//    private void createCategorie (){
//        System.out.println("-- Ajputer une catégorie --");
//        System.out.println("nom de la catégorie :");
//        String nom = scanner.nextLine();
//        scanner.nextLine();
//
//        Categorie categorie = Categorie.builder().nom(nom).build();
//
//        try {
//            CategorieDAO categorieDAO = new CategorieDAO(connection);
//            Categorie categorieCreated = categorieDAO.save(categorie);
//            if(categorieCreated != null){
//                System.out.println("Categorie créer: "+ categorieCreated);
//            }else{
//                System.out.println("erreure lors de la creation");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//    private void getAllCategorie() {
//        System.out.println("-- Récupération des catégories --");
//        try {
//            List<Categorie> categories = CategorieDAO.get(connection);
//            if (categories.isEmpty()) {
//                System.out.println("Aucune catégories trouvé.");
//            } else {
//                for (Categorie categorie : categories) {
//                    afficherCategorie(categorie);
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Erreur lors de la récupération des catégories.", e);
//        }
//    }
//    private void afficherCategorie(Categorie categorie) {
//        System.out.println("ID : " + categorie.getId());
//        System.out.println("Nom : " + categorie.getNom());
//        System.out.println("---------------------------------------");
//    }
}
