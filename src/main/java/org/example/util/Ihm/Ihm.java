package org.example.util.Ihm;

import java.util.Scanner;

public class Ihm {
    private Scanner scanner;
    private RecetteIhm recetteIhm;
    private IngredientIhm ingredientIhm;
    private EtapeIhm etapeIhm;
    private CommentaireIhm commentaireIhm;

    public Ihm(Scanner scanner) {
        this.scanner = scanner;
        recetteIhm = new RecetteIhm(scanner);
        commentaireIhm = new CommentaireIhm(scanner);
        ingredientIhm = new IngredientIhm(scanner);
        etapeIhm = new EtapeIhm(scanner);
    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Application gestion de recette ---");
            System.out.println("1/ menu recette");
            System.out.println("2/ menu ingrédient");
            System.out.println("3/ menu Etape");
            System.out.println("4/ menu commentaire");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    recetteIhm.start();
                    break;
                case 2:
                    ingredientIhm.start();
                    break;
                case 3:
                    etapeIhm.start();
                    break;
                case 4:
                    commentaireIhm.start();
                    break;
                default:
                    return;
            }
        }
    }

}
