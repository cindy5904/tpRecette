package org.example.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecetteIngredient {
    private int id;
    private int idIngredient;
    private  int idRecette;
}
