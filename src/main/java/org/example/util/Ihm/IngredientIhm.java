package org.example.util.Ihm;

import org.example.DAO.IngredientDAO;
import org.example.Entity.Ingredient;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class IngredientIhm {
    private Scanner scanner;
    private IngredientDAO ingredientDAO;

    public IngredientIhm(Scanner scanner) {
        this.scanner = scanner;
        ingredientDAO = new IngredientDAO();

    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Menu Ingrédient ---");
            System.out.println("1/ Ajouter un ingrédient");
            System.out.println("2/ Afficher tous les ingrédients");
            System.out.println("3/ Modifier un ingrédient");
            System.out.println("4/ Supprimer un ingrédient");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    createIngredient();
                    break;
                case 2:
                    getAllIngredient();
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
    private void createIngredient (){
        System.out.println("-- Ajputer un ingrédient --");
        System.out.println("nom de l'ingrédient :");
        String nom = scanner.nextLine();


        Ingredient ingredient = Ingredient.builder().nom(nom).build();

        try {
            Ingredient ingredientCreated = ingredientDAO.save(ingredient);
            if(ingredientCreated != null){
                System.out.println("Ingrédient créer: "+ ingredientCreated );
            }else{
                System.out.println("erreur lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void getAllIngredient() {
        System.out.println("-- Récupération des ingrédients --");
        try {
            List<Ingredient> ingredients = ingredientDAO.get();
            if (ingredients.isEmpty()) {
                System.out.println("Aucun ingrédient trouvé.");
            } else {
                for (Ingredient ingredient : ingredients) {
                    afficherIngredient(ingredient);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des recettes.", e);
        }
    }
    private void afficherIngredient(Ingredient ingredient) {
        System.out.println("ID : " + ingredient.getId());
        System.out.println("Nom : " + ingredient.getNom());
        System.out.println("---------------------------------------");
    }
}
