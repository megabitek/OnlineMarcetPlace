/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Item;
import Domain.Userlist;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author admin
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({DAO.UserListDaoTest.class})
public class ItemDaoTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetItemList() {
        List<Item> collection = new ArrayList<Item>();
        collection.add(new Item(1, "коляска", 5000, new GregorianCalendar(2015, 8, 8).getTime()));
        collection.add(new Item(2, "телефон", 800, new GregorianCalendar(2015, 8, 8).getTime()));
        collection.add(new Item(3, "кроссовки", 2000, new GregorianCalendar(2015, 8, 8).getTime()));
        collection.add(new Item(5, "кот", 3, new GregorianCalendar(2015, 8, 11).getTime()));
        ItemDao dao = new ItemDao();
        List<Item> collectionFromBase = dao.getList();
        assertEquals(collection.size(), collectionFromBase.size());
        for (int i = 0; i < collection.size(); i++) {
            assertEquals(collection.get(i), collectionFromBase.get(i));
        }
    }

    @Test
    public void testSearchBySubstring() {
        List<Item> collection = new ArrayList<Item>();
        collection.add(new Item(1, "коляска", 5000, new GregorianCalendar(2015, 8, 8).getTime()));
        collection.add(new Item(5, "кот", 3, new GregorianCalendar(2015, 8, 11).getTime()));
        ItemDao dao = new ItemDao();
        List<Item> collectionFromBase = dao.searchBySubstring("ко");
        assertEquals(collection.size(), 2);
        for (int i = 0; i < collection.size(); i++) {
            assertEquals(collection.get(i), collectionFromBase.get(i));
        }
    }

    @Test
    public void testSearchById() {
        Item item = new Item(1, "коляска", 5000, new GregorianCalendar(2015, 8, 8).getTime());
        ItemDao dao = new ItemDao();
        Item itemSearch = dao.searchByID(item.getItemid());
        assertEquals(item, itemSearch);
    }

    @Test
    public void testBySeller() {
        List<Item> collection = new ArrayList<Item>();
        collection.add(new Item(1, "коляска", 5000, new GregorianCalendar(2015, 8, 8).getTime()));
        ItemDao dao = new ItemDao();
        assertEquals(dao.searchBySeller(4), collection);
    }

    @Test
    public void testAddItem() {
        ItemDao dao = new ItemDao();
        Item newItem = new Item(4, "колье", 5000, java.util.Calendar.getInstance().getTime());
        newItem.setDescription("жемчужное колье");
        newItem.setBidincrement(1000);
        newItem.setBuyitnow(0);
        newItem.setSellerid(2);
        int firstSize = dao.getList().size();
        dao.insert(newItem);
        int sizeAfterAdd = dao.getList().size();
        dao.delete(newItem);
        assertEquals(firstSize + 1, sizeAfterAdd);
    }
}
