package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class definition superclass
 */
public class Booking implements Serializable {

    private java.util.Date bookingDate;
    private int bookingID;
    private ArrayList<InRestrOrder> inRestrorders;

    /**
     * Constructor
     */
    public Booking(){}

    /**
     * Constructor
     * @param bookingDate Entering bookingDate to constructor
     * @param bookingID Entering bookingID to constructor
     */
    public Booking(java.util.Date bookingDate, int bookingID){
        this.bookingDate=bookingDate;
        this.bookingID=bookingID;
        this.inRestrorders=new ArrayList<InRestrOrder>();
    }

    /**
     *
     * @return returning inRestorders
     */
    public ArrayList<InRestrOrder> getInRestrorders() {
        return inRestrorders;
    }

    /**
     *
     * @return returns bookingDate
     */
    public Date getBookingDate() {
        return bookingDate;
    }

    /**
     *
     * @return returns bookingID
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     *
     * @param bookingDate setting booking date given obj
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     *
     * @param bookingID setting bookingID given obj
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    /**
     *
     * @param inRestrorders setting inRestrorders given obj
     */
    public void setInRestrorders(ArrayList<InRestrOrder> inRestrorders) {
        this.inRestrorders = inRestrorders;
    }

    /**
     *
     * @param newOrder adding order to inRestrprders Arraylist
     */
    public void makeOrder(InRestrOrder newOrder){
        this.inRestrorders.add(newOrder);
    }
}
