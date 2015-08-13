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

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {
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
        ConnectionFactory.getConnection().setAutoCommit(false);
        UserListDao dao = new UserListDao();
        Userlist newUser = new Userlist(6, "Yuri Pavlov", "pavl", "558", "Moskovskaya str, 13, Moskow");
        int firstSize = dao.getList().size();
        dao.insert(newUser);
        assertEquals(firstSize + 1, dao.getList().size());
        ConnectionFactory.getConnection().rollback();
    }

    @Test
    public void testAddUserLogin() {
        boolean thrown= false;
        UserListDao dao = new UserListDao();
        Userlist newUser = new Userlist(7, "Sergei Smirnov", "login", "555", "---");
        try {
            dao.insert(newUser);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

    }

}
