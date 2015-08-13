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
    private int userId;
    private String fullname;
    private String login;
    private String password;
    private String billingadress;
    private Collection<Bids> bidsCollection;

    public Userlist() {
    }

    public Userlist(int userid) {
        this.userId = userid;
    }

    public Userlist(int userid, String fullname, String login, String password, String billingAdress) {
        this.userId = userid;
        this.fullname = fullname;
        this.login=login; 
        this.password= password; 
        this.billingadress = billingAdress; 
    }

    public int getUserid() {
        return userId;
    }

    public void setUserid(int userid) {
        this.userId = userid;
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
    
    
@Override
    public boolean equals(Object object) {
        if (!(object instanceof Userlist)) {
            return false;
        }
        Userlist other = (Userlist) object;
       return this.userId==userId; 
           
        
    }  

  
    @Override
    public String toString() {
        return "Domain.Userlist[ userid=" + userId + " ]";
    }

}
