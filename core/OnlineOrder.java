package core;

import support.Order;

import java.io.Serializable;

/**
 * class sub_class
 */
public class OnlineOrder extends Order implements Serializable {
    private String paymentType;
    private Junior juniorStaff;

    /**
     * Constructor
     */
    public OnlineOrder(){}

    /**
     *
     * @param orderType setting OrderType
     * @param orderID setting OrderID
     * @param orderDate setting orderDate
     * @param orderDetails setting orderDetails
     * @param extraNotes setting extraNotes
     * @param paymentType setting paymentType
     */
    public OnlineOrder(String orderType, int orderID, java.util.Date orderDate, String orderDetails, String extraNotes, String paymentType){
        super.setOrderType(orderType);
        super.setOrderID(orderID);
        super.setOrderDate(orderDate);
        super.setOrderDetails(orderDetails);
        super.setExtraNotes(extraNotes);
        this.paymentType=paymentType;
    }

    /**
     *
     * @return returning paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     *
     * @return returning juniorStaff
     */
    public Junior getJuniorStaff() {
        return juniorStaff;
    }

    /**
     *
     * @param paymentType setting paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     *
     * @param juniorStaff setting juniorStaff
     */
    public void setJuniorStaff(Junior juniorStaff) {
        this.juniorStaff = juniorStaff;
    }

    /**
     * This method is overriding for (InRestrOrder and Onlineorder) just printing according obj details.
     */
    public void show(){
        System.out.println("Order type="+super.getOrderType());
        System.out.println("Order id="+super.getOrderID());
        System.out.println("Order date="+super.getOrderDate());
        System.out.println("Order details="+super.getOrderDetails());
        System.out.println("Order extra notes="+super.getExtraNotes());
        System.out.println("Order payment type="+this.paymentType);
    }

    /**
     * Overriding prints differently for different order types
     */
    public void processPayment() {
        System.out.println("This is online payment");
    }

}
