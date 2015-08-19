/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Bids;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author admin
*/
public class BidsDaoTest {
    @Test
    public void testGetByItem(){
     List<Bids> collection = new ArrayList<Bids>();
        collection.add(new Bids(2, 4, 1, 5500));  
        collection.add(new Bids(3, 1, 1, 6000));
        collection.add(new Bids (4, 3, 1, 6500));
        BidsDao dao = new BidsDao();
    List<Bids> bidsByItem = dao.getByItem(1);
    assertEquals(collection.size(), bidsByItem.size());
//    assertEquals(collection, bidsByItem);   
    }
    
    @Test
    public void testAddBid(){
        BidsDao dao = new BidsDao();
        Bids newBid = new Bids(5, 2, 2, 2600);
        int firstSize = dao.getList().size();
        dao.insert(newBid);
        int sizeAfterAdd = dao.getList().size();
        dao.delete(newBid);
        assertEquals(firstSize + 1, sizeAfterAdd);
    }
    @Test
    public void testGetMaxBidByItem(){
    BidsDao dao = new BidsDao();
    int maxBid =dao.getBestBidsByitem(1);
    assertEquals(maxBid, 6500); }
    
}
