package org.example.Entity;

import lombok.Builder;
import lombok.Data;
import org.example.util.Difficulte;

import java.util.List;
@Data
@Builder
public class Recette {
    private  int id;
    private String nom;
    private int tempsPrep;
    private int tempsCuisson;
    private Difficulte difficulte;
    private List<Ingredient> ingredients;
    private List<Etape> etapes;
    private List<Commentaire> commentaires;
    private List<Categorie> categories;
}
