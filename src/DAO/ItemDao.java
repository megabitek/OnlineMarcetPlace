/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Bids;
import Domain.Item;
import Domain.Userlist;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import onlinemarketplace.ConnectionFactory;

/**
 *
 * @author admin
 */
public class ItemDao implements IDao<Item> {

    @Override
    public void insert(Item t) {
        String query = "INSERT INTO Item (itemId, sellerId, title, description, startPrice, timeleft, startBindingData, bidincrement, buyitnow) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            connection = ConnectionFactory.getConnection();

            preparedStatement.setInt(1, t.getItemid());
            preparedStatement.setInt(2, t.getSellerid());
            preparedStatement.setString(3, t.getTitle());
            preparedStatement.setString(4, t.getDescription());
            preparedStatement.setDouble(5, t.getStartprice());
            preparedStatement.setInt(6, t.getTimeleft());
            preparedStatement.setDate(7, (Date) t.getStartbindingdata());
            preparedStatement.setInt(8, t.getBidincrement());
            preparedStatement.setInt(9, t.getBuyitnow());
            preparedStatement.execute();
        } catch (SQLException ex) {
        } catch (Exception ex) {
        }
    }

    @Override
    public void delete(Item t) {
        String query = "delete from item where id = ?";
        try {
            Connection Connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = Connection.prepareStatement(query);
            preparedStatement.setInt(1, t.getItemid());
            preparedStatement.execute();
        } catch (Exception ex) {
        }
    }

    @Override
    public void update(Item t) {
        String query = ("update item set sellerId =?, title=?, description=?, startPrice=?, timeleft, startBindingData, bidincrement, buyitnow where itemId = ?");
        try {

            Connection Connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = Connection.prepareStatement(query);
            preparedStatement.setInt(9, t.getItemid());
            preparedStatement.setInt(1, t.getSellerid());
            preparedStatement.setString(2, t.getTitle());
            preparedStatement.setString(3, t.getDescription());
            preparedStatement.setDouble(4, t.getStartprice());
            preparedStatement.setInt(5, t.getTimeleft());
            preparedStatement.setDate(6, (Date) t.getStartbindingdata());
            preparedStatement.setInt(7, t.getBidincrement());
            preparedStatement.setInt(8, t.getBuyitnow());
            preparedStatement.execute();
        } catch (Exception ex) {
        }

    }

    @Override
    public List<Item> getList() {
        List<Item> objectCollection = new ArrayList<>();
        String query = ("select * from item");
        try {
            Connection Connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = Connection.prepareStatement(query);
            ResultSet Rezult = Statement.executeQuery();
            while (Rezult.next()) {
                Item Object = new Item();

                Object.setItemid(Rezult.getInt(1));
                Object.setSellerid(Rezult.getInt(2));
                Object.setTitle(Rezult.getString(3));
                Object.setDescription(Rezult.getString(4));
                Object.setStartprice(Rezult.getDouble(5));
                Object.setTimeleft(Rezult.getInt(6));
                Object.setStartbindingdata(Rezult.getDate(7));
                Object.setBidincrement(Rezult.getInt(8));
                Object.setBuyitnow(Rezult.getInt(9));
                objectCollection.add(Object);
            }

        } catch (Exception ex) {
            return null;
        }
        return objectCollection;

    }

    @Override
    public Item searchByID(int id) {

        Item Object = new Item();
        String query = ("select * from item where id=?");
        try {
            Connection Connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = Connection.prepareStatement(query);
            Statement.setInt(1, id);

            ResultSet Rezult = Statement.executeQuery();

            if (Rezult.next()) {

                Object.setItemid(Rezult.getInt(1));
                Object.setSellerid(Rezult.getInt(2));
                Object.setTitle(Rezult.getString(3));
                Object.setDescription(Rezult.getString(4));
                Object.setStartprice(Rezult.getDouble(5));
                Object.setTimeleft(Rezult.getInt(6));
                Object.setStartbindingdata(Rezult.getDate(7));
                Object.setBidincrement(Rezult.getInt(8));
                Object.setBuyitnow(Rezult.getInt(9));

                return Object;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

}
