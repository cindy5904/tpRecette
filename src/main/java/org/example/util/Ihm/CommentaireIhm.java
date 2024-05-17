package org.example.util.Ihm;

import org.example.DAO.CommentaireDAO;
import org.example.DAO.EtapeDAO;
import org.example.Entity.Commentaire;
import org.example.Entity.Etape;

import javax.xml.stream.events.Comment;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CommentaireIhm {
    private Scanner scanner;
    private CommentaireDAO commentaireDAO;

    public CommentaireIhm(Scanner scanner) {
        this.scanner = scanner;
        commentaireDAO = new CommentaireDAO();
    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Menu Commentaire ---");
            System.out.println("1/ Entrer un commentaire");
            System.out.println("2/ Afficher tous les commentaires");
            System.out.println("3/ Modifier un commentaire");
            System.out.println("4/ Supprimer un commentaire");
            entry = scanner.nextInt();
            scanner.nextLine();
            switch (entry){
                case 1:
                    createCommentaire();
                    break;
                case 2:
                    getAllCommentaire();
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
    private void createCommentaire (){
        System.out.println("-- Ajouter un commentaire--");
        System.out.println("Description du commentaire :");
        String description = scanner.nextLine();

        Commentaire commentaire = Commentaire.builder().description(description).build();

        try {
            Commentaire commentaireCreated = commentaireDAO.save(commentaire);
            if(commentaireCreated != null){
                System.out.println("Commentaire créer: "+ commentaireCreated );
            }else{
                System.out.println("erreur lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void getAllCommentaire() {
        System.out.println("-- Récupération des commentaires--");
        try {
            List<Commentaire> commentaires = commentaireDAO.get();
            if (commentaires.isEmpty()) {
                System.out.println("Aucun commentaire trouvé.");
            } else {
                for (Commentaire commentaire : commentaires) {
                    afficherCommentaire(commentaire);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des commentaires.", e);
        }
    }
    private void afficherCommentaire(Commentaire commentaire) {
        System.out.println("ID : " + commentaire.getId());
        System.out.println("Nom : " + commentaire.getDescription());
        System.out.println("---------------------------------------");
    }
}
