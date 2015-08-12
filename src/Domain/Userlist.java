/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
public class Userlist  {

    private static final long serialVersionUID = 1L;
    private int userid;
    private String fullname;
    private String login;
    private String password;
    private String billingadress;
    private Collection<Bids> bidsCollection;

    public Userlist() {
    }

    public Userlist(int userid) {
        this.userid = userid;
    }

    public Userlist(int userid, String fullname, String login, String password, String billingAdress) {
        this.userid = userid;
        this.fullname = fullname;
        this.login=login; 
        this.password= password; 
        this.billingadress = billingAdress; 
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBillingadress() {
        return billingadress;
    }

    public void setBillingadress(String billingadress) {
        this.billingadress = billingadress;
    }


    public void setBidsCollection(Collection<Bids> bidsCollection) {
        this.bidsCollection = bidsCollection;
    }

  
    @Override
    public String toString() {
        return "Domain.Userlist[ userid=" + userid + " ]";
    }

}
