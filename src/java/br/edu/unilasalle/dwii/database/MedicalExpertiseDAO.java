/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unilasalle.dwii.database;

import br.edu.unilasalle.dwii.classes.MedicalExpertise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ChristianGuilherme
 */
public class MedicalExpertiseDAO {
  private Connection connection;

  public MedicalExpertiseDAO() {
  }
  
  public void store(MedicalExpertise expertise) throws SQLException, ClassNotFoundException {
    this.connection = new ConnectionFactory().getConnection();
    String query = "" +
            "INSERT INTO expertises " +
            "(name,active) " +
            "values (?, ?)";

    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, expertise.getName());
    statement.setBoolean(2, expertise.isActive());

    statement.execute();
    statement.close();
  }
  
  public MedicalExpertise show(long id) throws SQLException, ClassNotFoundException {
    this.connection = new ConnectionFactory().getConnection();
    String query = "" +
            "SELECT * FROM expertises " +
            "WHERE id =?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setLong(1, id);
    
    ResultSet result = statement.executeQuery();
    
    if (!result.next()) {
      statement.close();
      return null;
    }
    
    MedicalExpertise expertise = new MedicalExpertise(
      result.getLong("id"),
      result.getString("name"),
      result.getBoolean("active")
    );
    statement.close();
    return expertise;
  }
  
  public Collection<MedicalExpertise> list() throws SQLException, ClassNotFoundException {
    this.connection = new ConnectionFactory().getConnection();
    
    String query = "SELECT * FROM expertises";
    
    PreparedStatement statement = connection.prepareStatement(query);
    ResultSet result = statement.executeQuery();    
    Collection<MedicalExpertise> expertises = new ArrayList<>();
      
    if (!result.isBeforeFirst()) {
      statement.close();
      return expertises;
    }
    
    while(result.next()) {
      expertises.add(new MedicalExpertise(
        result.getLong("id"), result.getString("name"), result.getBoolean("active"))
      );
    }
    
    statement.close();
    return expertises;
  }
  
  public void update(MedicalExpertise expertise) throws ClassNotFoundException, SQLException {
    this.connection = new ConnectionFactory().getConnection();
    String query = "" +
            "UPDATE expertises SET name=?, active=?" +
            "WHERE id=?";
    
    PreparedStatement statement = this.connection.prepareStatement(query);
    statement.setString(1, expertise.getName());
    statement.setBoolean(2, expertise.isActive());
    statement.setLong(3, expertise.getId());
    statement.execute();
    statement.close();
  }
  
  public void destroy(long id) throws ClassNotFoundException, SQLException {
    this.connection = new ConnectionFactory().getConnection();
    String query = "DELETE FROM expertises WHERE id=?";
    PreparedStatement statement = this.connection.prepareStatement(query);
    statement.setLong(1, id);
    statement.execute();
    statement.close();
  }
}