/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.UserListDao;
import Domain.Userlist;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author admin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class NewTestSuite extends TestCase{

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    @Override
    public void setUp() throws Exception {
    }

    @After
    @Override
    public void tearDown() throws Exception {
    }
     public void testCreateUser() throws Exception {
        Userlist user = new Userlist(7, "Sergei Koshkin", "kot333", "111", "Tverskaya, 11, Moskou"); 
        UserListDao dao = new UserListDao();
        int firstSize = dao.getList().size();
        dao.insert(user);
        Assert.assertEquals(firstSize+1, dao.getList().size());
        
    }
    
    
}
