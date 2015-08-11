/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author admin
 */
public class Bids {

    private static final long serialVersionUID = 1L;
    private int bidid;
    private int bid;
    private int itemid;
    private int bidderid;

    public Bids() {
    }

    public Bids(int bidid) {
        this.bidid = bidid;
    }

    public Bids(int bidid, int bid) {
        this.bidid = bidid;
        this.bid = bid;
    }

    public int getBidid() {
        return bidid;
    }

    public void setBidid(int bidid) {
        this.bidid = bidid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getBidderid() {
        return bidderid;
    }

    public void setBidderid(int bidderid) {
        this.bidderid = bidderid;
    }

  /*  @Override
    public int hashCode() {
    
        int hash += (bidid != null ? bidid.hashCode() : 0);
        return hash;
    }*/

   /* @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bids)) {
            return false;
        }
        Bids other = (Bids) object;
        return !((this.bidid == null && other.bidid != null) || (this.bidid != null && !this.bidid.equals(other.bidid)));
    }*/

    @Override
    public String toString() {
        return "Domain.Bids[ bidid=" + bidid + " ]";
    }

}
