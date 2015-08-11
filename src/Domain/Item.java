/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */

public class Item{
    private static final long serialVersionUID = 1L;
    @Id
    
    private int itemid;
    
    private String title;
    private String description;
    private double startprice;
    private int timeleft;
    private Date startbindingdata;
    private int bidincrement;
    private int buyitnow;
    private int sellerid;
    private Collection<Bids> bidsCollection;

    public Item() {
    }

    public Item(int itemid) {
        this.itemid = itemid;
    }

    public Item(int itemid, String title, int startprice, Date startbindingdata) {
        this.itemid = itemid;
        this.title = title;
        this.startprice = startprice;
        this.startbindingdata = startbindingdata;
    }

     
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartprice() {
        return startprice;
    }

    public void setStartprice(double startprice) {
        this.startprice = startprice;
    }

    public int getTimeleft() {
        return timeleft;
    }

    public void setTimeleft(int timeleft) {
        this.timeleft = timeleft;
    }

    public Date getStartbindingdata() {
        return startbindingdata;
    }

    public void setStartbindingdata(Date startbindingdata) {
        this.startbindingdata = startbindingdata;
    }

    public int getBidincrement() {
        return bidincrement;
    }

    public void setBidincrement(int bidincrement) {
        this.bidincrement = bidincrement;
    }

    public int getBuyitnow() {
        return buyitnow;
    }

    public void setBuyitnow(int buyitnow) {
        this.buyitnow = buyitnow;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    @XmlTransient
    public Collection<Bids> getBidsCollection() {
        return bidsCollection;
    }

    public void setBidsCollection(Collection<Bids> bidsCollection) {
        this.bidsCollection = bidsCollection;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }
*/
    @Override
    public String toString() {
        return "Domain.Item_1[ itemid=" + itemid + " ]";
    }
    
}
