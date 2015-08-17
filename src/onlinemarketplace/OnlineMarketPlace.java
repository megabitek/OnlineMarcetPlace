/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemarketplace;

import DAO.UserListDao;
import Domain.Userlist;

/**
 *
 * @author admin
 */
public class OnlineMarketPlace {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception  
    {
       

         

        /* Connection Connection = ConnectionFactory.getConnection();
        IDao bidsDao = new BidsDao();
        List <Bids> bids = bidsDao.getList(); 
        for (ListIterator it = bids.listIterator(); it.hasNext();){
        System.out.println(it.next());}
         */ 
 
    /*    Item item; 
        item = new Item(5, "кот",  3, java.util.Calendar.getInstance().getTime());
        item.setSellerid(3);
        item.setDescription("кот домашний");
        item.setTimeleft(4);
        item.setBidincrement(1);
        item.setBuyitnow(0);
        ItemDao dao = new ItemDao(); 
        dao.insert(item);*/
        
    Userlist userlogin = new Userlist(6, "Yulya", "login", "333", "---"); 
    UserListDao dao = new UserListDao();
    dao.delete(userlogin);

}}
