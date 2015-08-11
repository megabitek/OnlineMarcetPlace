/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemarketplace;

import DAO.BidsDao;
import DAO.IDao;
import DAO.ItemDao;
import Domain.Bids;
import Domain.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 *
 * @author admin
 */
public class OnlineMarketPlace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception  {
        /* Connection Connection = ConnectionFactory.getConnection();
        IDao bidsDao = new BidsDao();
        List <Bids> bids = bidsDao.getList(); 
        for (ListIterator it = bids.listIterator(); it.hasNext();){
        System.out.println(it.next());}
         */ 
 
        Item item; 
        item = new Item(5, "кот",  3, java.util.Calendar.getInstance().getTime());
        item.setSellerid(3);
        item.setDescription("кот домашний");
        item.setTimeleft(4);
        item.setBidincrement(1);
        item.setBuyitnow(0);
        ItemDao dao = new ItemDao(); 
        dao.insert(item);
        
    }

}
