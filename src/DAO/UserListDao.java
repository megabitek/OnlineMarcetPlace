/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Userlist;
import java.sql.Connection;
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
public class UserListDao implements IDao<Userlist> {

    @Override
    public void insert(Userlist t) {

        try {
            String query = "insert into userlist (userid, fullname, login , password, billingadress) values (?, ?, ?, ?, ?)";
            Connection connection = null;
            //  try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, t.getUserid());
            preparedStatement.setString(2, t.getFullname());
            preparedStatement.setString(3, t.getLogin());
            preparedStatement.setString(4, t.getPassword());
            preparedStatement.setString(5, t.getBillingadress());

            preparedStatement.execute();
             connection.close();
        } catch (SQLException ex) {
            System.out.println("not insert user");
        } catch (Exception ex) {
            System.out.println("not insert user");
        }
        // } catch (SQLException ex) {
        //   Logger.getLogger(UserListDao.class.getName()).log(Level.SEVERE, null, ex);

    }

    @Override
    public void delete(Userlist t) {
        try {
            String query = "delete from userlist where userid = ?";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, t.getUserid());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Not delete user!");
        } catch (Exception ex) {

        }
    }

    @Override
    public void update(Userlist t) {
        String query = ("update userlist set fullname=?,  login=?, password=?, billingadress=?  where userid=?");
        try {

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(5, t.getUserid());
            preparedStatement.setString(1, t.getFullname());
            preparedStatement.setString(2, t.getLogin());
            preparedStatement.setString(3, t.getPassword());
            preparedStatement.setString(4, t.getBillingadress());

            preparedStatement.execute();
            connection.close();
        } catch (Exception ex) {
        }

    }

    @Override
    public List<Userlist> getList() {
        List<Userlist> objectCollection = new ArrayList<>();
        String query = ("select * from userlist");
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = connection.prepareStatement(query);
            ResultSet Rezult = Statement.executeQuery();
            while (Rezult.next()) {
                Userlist Object = new Userlist();

                Object.setUserid(Rezult.getInt(1));
                Object.setFullname(Rezult.getString(2));
                Object.setLogin(Rezult.getString(3));
                Object.setPassword(Rezult.getString(4));
                Object.setBillingadress(Rezult.getString(5));
                objectCollection.add(Object);
            }
            connection.close();
        } catch (Exception ex) {
            return null;
        }

        return objectCollection;

    }

    @Override
    public Userlist searchByID(int id) {

        Userlist Object = new Userlist();
        String query = ("select * from userlist where id=?");
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = connection.prepareStatement(query);
            Statement.setInt(1, id);

            ResultSet Rezult = Statement.executeQuery();

            if (Rezult.next()) {

                Object.setUserid(Rezult.getInt(1));
                Object.setFullname(Rezult.getString(2));
                Object.setLogin(Rezult.getString(3));
                Object.setPassword(Rezult.getString(4));
                Object.setBillingadress(Rezult.getString(5));
                connection.close();
                return Object;
            } else {
                connection.close();
                return null;
            }
        } catch (Exception ex) {
            return null;
        }

    }

    public Userlist getUserByLogin(String login) {
        Userlist Object = new Userlist();
        String query = ("select * from userlist where login=?");
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);

            ResultSet Rezult = statement.executeQuery();

            if (Rezult.next()) {

                Object.setUserid(Rezult.getInt(1));
                Object.setFullname(Rezult.getString(2));
                Object.setLogin(Rezult.getString(3));
                Object.setPassword(Rezult.getString(4));
                Object.setBillingadress(Rezult.getString(5));
                connection.close();
                return Object;

            } else {
                connection.close();
                return null;

            }

        } catch (Exception ex) {

            return null;
        }

    }
}
