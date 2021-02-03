package core;

import support.Order;

import java.io.Serializable;
import java.util.Date;

/**
 * This is sub-class
 */
public class InRestrOrder extends Order implements Serializable {
    private int tableNumber;
    private int bookingOrder;

    /**
     * Constructor
     */
    public InRestrOrder(){}

    /**
     * Constructor with given values
     * @param orderType setting orderType
     * @param orderID setting orderID
     * @param orderDate setting orderDate
     * @param orderDetails setting orderDetails
     * @param extraNotes setting orderExtraNotes
     * @param tableNumber setting orderNumber
     * @param bookingOrder setting booking Order
     */
    public InRestrOrder(String orderType, int orderID, java.util.Date orderDate, String orderDetails, String extraNotes, int tableNumber, int bookingOrder){
        super.setOrderType(orderType);
        super.setOrderID(orderID);
        super.setOrderDate(orderDate);
        super.setOrderDetails(orderDetails);
        super.setExtraNotes(extraNotes);
        this.tableNumber=tableNumber;
        this.bookingOrder=bookingOrder;


    }

    /**
     *
     * @return Returning tableNumber
     */
    public int getTableNumber() {
        return tableNumber;
    }
    /**
     *
     * @return Returning bookingOrder
     */
    public int getBookingOrder() {
        return bookingOrder;
    }

    /**
     *
     * @param tableNumber setting tableNumber
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     *
     * @param bookingOrder setting bookingOrder
     */
    public void setBookingOrder(int bookingOrder) {
        this.bookingOrder = bookingOrder;
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
        System.out.println("Order table number="+this.tableNumber);
        System.out.println("Order booking order (number)="+this.bookingOrder);
    }

    /**
     * Overriding prints differently for different order types
     */
    public void processPayment() {
        System.out.println("This is restaurant payment");
    }
}
