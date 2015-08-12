/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Userlist;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class UserListDaoTest {
    
    public UserListDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class UserListDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Userlist t = null;
        UserListDao instance = new UserListDao();
        instance.insert(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UserListDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Userlist t = null;
        UserListDao instance = new UserListDao();
        instance.delete(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UserListDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Userlist t = null;
        UserListDao instance = new UserListDao();
        instance.update(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getList method, of class UserListDao.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        UserListDao instance = new UserListDao();
        List<Userlist> expResult = null;
        List<Userlist> result = instance.getList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class UserListDao.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        UserListDao instance = new UserListDao();
        Userlist expResult = null;
        Userlist result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
