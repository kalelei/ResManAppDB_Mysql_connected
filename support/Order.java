package support;
import support.Payment;

import java.io.Serializable;
import java.util.Date;

/**
 * Abstract class definition and implements Payment INTERFACE
 */
public abstract class Order implements Payment, Serializable {
    private String orderType;
    private int orderID;
    private java.util.Date orderDate;
    private String orderDetails;
    private String extraNotes;

    /**
     *
     * @return getting orderType
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     *
     * @return getting orderID
     */
    public int getOrderID() {
        return orderID;
    }
    /**
     *
     * @return getting orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }
    /**
     *
     * @return getting orderDetails
     */
    public String getOrderDetails() {
        return orderDetails;
    }

    /**
     *
     * @return getting extraNotes
     */
    public String getExtraNotes() {
        return extraNotes;
    }

    /**
     *
     * @param orderID setting orderID
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     *
     * @param orderDate setting orderDate
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     *
     * @param orderDetails orderDetails
     */
    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     *
     * @param extraNotes setting extraNotes
     */
    public void setExtraNotes(String extraNotes) {
        this.extraNotes = extraNotes;
    }

    /**
     *
     * @param orderType setting orderType
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * This method is overriding for (InRestrOrder and Onlineorder) just printing according obj details.
     */
    public void show(){

    }

    /**
     * Overriding prints differently for different order types
     */
    public void processPayment() { }

}
