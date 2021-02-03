package core;

import support.Person;
import support.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Subclass of person
 */
public class Customer extends Person implements Serializable {
    private java.util.Date registrationDate;
    private ArrayList<Booking> bookings;
    private ArrayList<Order> orders;
    private int creditCardDetails; //I assume that it is creditcard number

    /**
     * Constructor with no values
     */
    public Customer(){}

    /**
     * Constructoer with values
     * @param id setting id
     * @param name setting name
     * @param gender setting gender
     * @param date_birth setting date_birth
     * @param registrationDate setting registrationDate
     * @param creditCardDetails setting creditCardDetails
     */
    public Customer(int id, String name, char gender, java.util.Date date_birth, java.util.Date registrationDate, int creditCardDetails){
        super.setId(id);
        super.setName(name);
        super.setGender(gender);
        super.setDateOfBirth(date_birth);
        this.registrationDate=registrationDate;
        this.creditCardDetails=creditCardDetails;
        this.bookings=new ArrayList<Booking>();
        this.orders=new ArrayList<Order>();
    }

    /**
     *
     * @return getting registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     *
     * @return getting bookings ArrayList
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     *
     * @return getting orders ArrayList
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     *
     * @return getting creditCardDetail
     */
    public int getCreditCardDetails() {
        return creditCardDetails;
    }

    /**
     *
     * @param registrationDate setting registrationDate
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     *
     * @param bookings setting bookings
     *
     */
    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     *
     * @param orders setting booking arraylist
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /**
     *
     * @param creditCardDetails setting creditcardDetail
     */
    public void setCreditCardDetails(int creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    /**
     *
     * @param booking_New setting new booking to bookings arraylist
     */
    public void makeBooking(Booking booking_New){
        this.bookings.add(booking_New);
    }

    /**
     *
     * @param Order_New setting order to orders Arraylist
     */
    public void makeOrder(Order Order_New){
        this.orders.add(Order_New);

    }

    /**
     * method for printing customers details
     */
    public void customer_show_name_type(){
        System.out.println("Customer name="+super.getName());
        System.out.println("Customer gender="+super.getGender());
        System.out.println("Customer credit card details="+this.getCreditCardDetails());
    }

}
