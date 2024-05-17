package org.example.DAO;

import org.example.Entity.Ingredient;
import org.example.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO extends BaseDAO<Ingredient> {

    @Override
    public Ingredient save(Ingredient ingredient) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO ingredient (nom) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ingredient.getNom());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(row != 1){
                throw new SQLException();
            }
            if(resultSet.next()){
                ingredient.setId(resultSet.getInt(1));
            }
            connection.commit();
            return ingredient;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();

        }
    }

    @Override
    public boolean delete(Ingredient element) throws SQLException {
        return false;
    }

    @Override
    public Ingredient update(Ingredient element) throws SQLException {
        return null;
    }

    @Override
    public Ingredient get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM ingredient WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Ingredient.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
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
    public List<Ingredient> get() throws SQLException {
        try {
            List<Ingredient> ingredients = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM ingredient";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingredients.add(Ingredient.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .build());
            }
            return ingredients;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            close();
        }
    }
}
