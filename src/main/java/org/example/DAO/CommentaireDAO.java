package org.example.DAO;

import org.example.Entity.Commentaire;
import org.example.Entity.Ingredient;
import org.example.Entity.Recette;
import org.example.util.DatabaseManager;
import org.example.util.Difficulte;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentaireDAO extends BaseDAO<Commentaire> {

    @Override
    public Commentaire save(Commentaire commentaire) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO etape (description) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, commentaire.getDescription());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (row != 1) {
                throw new SQLException();
            }
            if (resultSet.next()) {
                commentaire.setId(resultSet.getInt(1));
            }
            connection.commit();
            return commentaire;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public boolean delete(Commentaire element) throws SQLException {
        return false;
    }

    @Override
    public Commentaire update(Commentaire element) throws SQLException {
        return null;
    }

    @Override
    public Commentaire get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM commentaire WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Commentaire.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .build();
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    @Override
    public List<Commentaire> get() throws SQLException {
        try {
            List<Commentaire> commentaires = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM commentaire";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                commentaires.add(Commentaire.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .build());
            }
            return commentaires;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            close();
        }
    }
}
