/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Userlist;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import onlinemarketplace.ConnectionFactory;
import static org.eclipse.persistence.config.ExclusiveConnectionMode.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author admin
 */
public class UserListDaoTest {

    public UserListDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
       // ConnectionFactory.getConnection().setAutoCommit(false);
   //     System.out.println(ConnectionFactory.getConnection().getAutoCommit());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {

      /*  System.out.println(ConnectionFactory.getConnection().getAutoCommit());
        ConnectionFactory.getConnection().rollback();
    */}

    @Before
    public void setUp() throws Exception {
        //ConnectionFactory.getConnection().setAutoCommit(false);
       // System.out.println(ConnectionFactory.getConnection().getAutoCommit());
    }

    @After
    public void tearDown() throws Exception {
    //    ConnectionFactory.getConnection().rollback();
     //   ConnectionFactory.getConnection().close();
    }

    @Test
    public void testGetList() {
        List<Userlist> collection = new ArrayList<Userlist>();
        collection.add(new Userlist(1, "Ivanov Ivan", "ivanov", "1223", "Moskovskaya str, 14, Saratov"));
        collection.add(new Userlist(2, "Petrov Dmitri", "petrovdima", "147852", "Actrakhanskaya, 15, Saratov"));
        collection.add(new Userlist(3, "Makarova Ekaterina", "Kate112", "kate", "Stroiteley pr., 47, Saratov"));
        collection.add(new Userlist(4, "Gogolev Oleg", "gogolefff", "236", "Tverskaya 45, Moskow"));
        collection.add(new Userlist(5, "Nikita Smirnov", "login", "555", "---"));
        UserListDao dao = new UserListDao();
        List<Userlist> collectionFromBase = dao.getList();
        assertEquals(collection.size(), collectionFromBase.size());
        for (int i = 0; i < 4; i++) {
            assertEquals(collection.get(i), collectionFromBase.get(i));
        }
    }

    @Test
    public void testAddUser() throws Exception {
     //   ConnectionFactory.setCommit(false);
     //   System.out.println(ConnectionFactory.getConnection().getAutoCommit());
        UserListDao dao = new UserListDao();
        Userlist newUser = new Userlist(6, "Yuri Pavlov", "pavl", "558", "Moskovskaya str, 13, Moskow");
        int firstSize = dao.getList().size();
        dao.insert(newUser);
        int sizeAfterAdd = dao.getList().size();
        dao.delete(newUser);
        assertEquals(firstSize + 1,sizeAfterAdd);
       // ConnectionFactory.getConnection().rollback();
    }

    @Test(expected = java.lang.AssertionError.class)
    public void testAddUserLogin() {
        boolean thrown = false;
        UserListDao dao = new UserListDao();
        Userlist newUser = new Userlist(7, "Sergei Smirnov", "login", "555", "---");
        dao.insert(newUser);
        fail();

    }

    @Test
    public void testGetUserByLogin() {
        UserListDao dao = new UserListDao();
        Userlist user = dao.getUserByLogin("login");
        assertEquals(5, user.getUserid());
        assertEquals("Nikita Smirnov", user.getFullname());
        assertEquals("login", user.getLogin());
        assertEquals("555", user.getPassword());
        assertEquals("---", user.getBillingadress());

    }

    @Test
    public void testLoginNotExist() {
        UserListDao dao = new UserListDao();
        Userlist user = dao.getUserByLogin("login2");
        assertNull(user);

    }
    @Test
    public void testChangeLogin(){
    UserListDao dao = new UserListDao();
    Userlist UserLogin = dao.getUserByLogin("login");
    Userlist oldUserLogin= dao.getUserByLogin("login");
    if (oldUserLogin!=null){
    oldUserLogin.setFullname("Masha");
    oldUserLogin.setPassword("masha");
    oldUserLogin.setBillingadress("ul. Gvardejskaya 4");
    dao.update(oldUserLogin);
    Userlist newUserLogin= dao.getUserByLogin("login");
    dao.update(UserLogin);
    
    assertEquals(newUserLogin.getUserid(), 5);
    assertEquals(newUserLogin.getFullname(), "Masha");
    assertEquals(newUserLogin.getLogin(), "login");
    assertEquals(newUserLogin.getPassword(), "masha");
    assertEquals(newUserLogin.getBillingadress(), "ul. Gvardejskaya 4");
    }}
}
