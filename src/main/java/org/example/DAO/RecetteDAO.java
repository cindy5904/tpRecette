package org.example.DAO;

import org.example.Entity.Ingredient;
import org.example.Entity.Recette;
import org.example.util.DatabaseManager;
import org.example.util.Difficulte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAO extends BaseDAO<Recette> {


    @Override
    public Recette save(Recette recette) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO recette (nom, tempsPrep, tempsCuisson, difficulte) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, recette.getNom());
            statement.setInt(2, recette.getTempsPrep());
            statement.setInt(3, recette.getTempsCuisson());
            statement.setString(4, recette.getDifficulte().toString());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(row != 1){
                throw new SQLException();
            }
            if(resultSet.next()){
                recette.setId(resultSet.getInt(1));
            }
            connection.commit();
            return recette;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();

        }
    }

    @Override
    public boolean delete(Recette recette) throws SQLException {
        return false;
    }

    @Override
    public Recette update(Recette recette) throws SQLException {
        try {
        connection = DatabaseManager.getConnection();
        request =  "UPDATE recette SET nom=?, tempsPrep = ?, tempsCuisson = ?, difficulte =? WHERE id =?";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, recette.getNom());
        statement.setInt(2, recette.getTempsPrep());
        statement.setInt(3, recette.getTempsCuisson());
        statement.setString(4, recette.getDifficulte().toString());
        int row = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(row != 1){
            throw new SQLException();
        }
        if(resultSet.next()){
            recette.setId(resultSet.getInt(1));
        }
        connection.commit();
        return recette;

    } catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();

        }
    }

    @Override
    public Recette get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM recette WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Recette.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .tempsPrep(resultSet.getInt("tempsPrep"))
                        .tempsCuisson(resultSet.getInt("tempsCuisson"))
                        .difficulte(Difficulte.valueOf(resultSet.getString("difficulte").toUpperCase()))
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
    public List<Recette> get() throws SQLException {
        try {
            List<Recette> recettes = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM recette";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                recettes.add(Recette.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .tempsPrep(resultSet.getInt("tempsPrep"))
                        .tempsCuisson(resultSet.getInt("tempsCuisson"))
                        .difficulte(Difficulte.valueOf(resultSet.getString("difficulte").toUpperCase()))
                        .build());
            }
            return recettes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            close();
        }
    }

}
