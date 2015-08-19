/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Bids;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import onlinemarketplace.ConnectionFactory;

/**
 *
 * @author
 */
public class BidsDao implements IDao<Bids> {

    @Override
    public void insert(Bids t) {
        String query = "insert into bids (bidId, bidderID,  itemId, bid) values (?, ?, ?, ?)";
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, t.getBidid());
            preparedStatement.setInt(2, t.getBidderid());
            preparedStatement.setInt(3, t.getItemid());
            preparedStatement.setInt(4, t.getBid());

            preparedStatement.execute();
        } catch (SQLException ex) {
        } catch (Exception ex) {
        }

    }

    @Override
    public void delete(Bids t) {
        String query = "delete from bids where bidid = ?";
        try {
            Connection Connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = Connection.prepareStatement(query);
            preparedStatement.setInt(1, t.getBidid());
            preparedStatement.execute();
        } catch (Exception ex) {
        }
    }

    @Override
    public void update(Bids t) {

        String query = ("update bids set bidderID=?,  itemId=?, bid=? where bidid=?");
        try {

            Connection Connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = Connection.prepareStatement(query);
            preparedStatement.setInt(4, t.getBidid());
            preparedStatement.setInt(1, t.getBidderid());
            preparedStatement.setInt(2, t.getItemid());
            preparedStatement.setInt(3, t.getBid());
            preparedStatement.execute();
        } catch (Exception ex) {
        }
    }

    @Override
    public Bids searchByID(int id) {

        Bids Object = new Bids();
        String query = ("select * from bids where id=?");
        try {
            Connection Connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = Connection.prepareStatement(query);
            Statement.setInt(1, id);

            ResultSet Rezult = Statement.executeQuery();

            if (Rezult.next()) {

                Object.setBidid(Rezult.getInt(1));
                Object.setBidderid(Rezult.getInt(2));
                Object.setItemid(Rezult.getInt(3));
                Object.setBid(Rezult.getInt(4));

                return Object;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Bids> getList() {
        List<Bids> objectCollection = new ArrayList<Bids>();
        String query = ("select * from bids");
        try {
            Connection Connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = Connection.prepareStatement(query);
            ResultSet Rezult = Statement.executeQuery();
            while (Rezult.next()) {
                Bids Object = new Bids();

                Object.setBidid(Rezult.getInt(1));
                Object.setBidderid(Rezult.getInt(2));
                Object.setItemid(Rezult.getInt(3));
                Object.setBid(Rezult.getInt(4));
                objectCollection.add(Object);
            }

        } catch (Exception ex) {

        }
        return objectCollection;
    }

    public List<Bids> getByItem(int itemid) {
        List<Bids> objectCollection = new ArrayList<Bids>();
        String query = "select * from bids where itemid=?";
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, itemid);
            ResultSet Rezult = statement.executeQuery();
            while (Rezult.next()) {
                Bids Object = new Bids();

                Object.setBidid(Rezult.getInt(1));
                Object.setBidderid(Rezult.getInt(2));
                Object.setItemid(Rezult.getInt(3));
                Object.setBid(Rezult.getInt(4));
                objectCollection.add(Object);
            }

        } catch (Exception ex) {
            return null;
        }
        return objectCollection;
    }

    public int getBestBidsByitem(int itemid) {

        String query = ("select max(bid) from bids where itemid=?");
        Connection Connection;
        try {
            Connection = ConnectionFactory.getConnection();
            PreparedStatement Statement;
            Statement = Connection.prepareStatement(query);
            Statement.setInt(1, itemid);
            ResultSet Rezult = Statement.executeQuery();
            if (Rezult.next()) {
                return Rezult.getInt(1);
            } else {
                return 0;
            }

        } catch (Exception ex) {
            return 0;
        }

    }
}
