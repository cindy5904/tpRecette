package org.example.DAO;

import org.example.Entity.RecetteIngredient;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RecetteIngredientDAO extends BaseDAO<RecetteIngredient> {


    @Override
    public RecetteIngredient save(RecetteIngredient element) throws SQLException {
        String query = "INSERT INTO ";
        try {statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, element.getIdRecette());
            statement.setInt(2, element.getIdIngredient());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (row != 1) {
                throw new SQLException();
            }
            if (resultSet.next()) {
                element.setId(resultSet.getInt(1));
            }
            connection.commit();
            return element;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public boolean delete(RecetteIngredient element) throws SQLException {
        return false;
    }

    @Override
    public RecetteIngredient update(RecetteIngredient element) throws SQLException {
        return null;
    }

    @Override
    public RecetteIngredient get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<RecetteIngredient> get() throws SQLException {
        return null;
    }
}
