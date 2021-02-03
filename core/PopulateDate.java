package core;

import support.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class for represent database.
 */
public class PopulateDate {

    public PopulateDate(){
    }

    /**
     *
     * @param customers getting customers Arraylist
     * @param staffs getting staff Arraylist
     * @throws ParseException Giving error message
     */
    public void CreateData(ArrayList<Customer> customers, ArrayList<Staff> staffs) throws ParseException {
        Date date_in = new Date();
        Date date_start = new Date();
        Date date_end = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
//Initializing staff members.
        date_in = DateFor.parse("19/02/1998");
        date_start = DateFor.parse("19/02/2010");
        Senior newStaff1 = new Senior(1,"yigit",'M',date_in,date_start,1000,"Senior");
        staffs.add(newStaff1);

        date_in = DateFor.parse("19/02/2001");
        date_start = DateFor.parse("19/02/2011");
        date_end = DateFor.parse("19/02/2020");
        Junior newStaff2 = new Junior(2,"mustafa",'M',date_in,date_start,1000,date_end,"Junior");
        staffs.add(newStaff2);

        date_in = DateFor.parse("19/02/2005");
        date_start = DateFor.parse("19/02/2015");
        date_end = DateFor.parse("19/02/2020");
        Junior newStaff3 = new Junior(3,"Hamza",'M',date_in,date_start,1500,date_end,"Junior");
        staffs.add(newStaff3);



////////////
        date_in = DateFor.parse("19/02/1998");
        InRestrOrder newOrder1=new InRestrOrder("In_restaurant",1,date_in,"Hamburger","NOSALAD",10,99);

        date_in = DateFor.parse("20/20/2020");
        InRestrOrder newOrder2=new InRestrOrder("In_restaurant",2,date_in,"Pizza","vegan",11,98);

        date_in = DateFor.parse("11/11/2011");
        InRestrOrder newOrder3=new InRestrOrder("In_restaurant",3,date_in,"Pasta","Mayo",12,97);


        date_in = DateFor.parse("19/02/1998");
        Booking newbook1=new Booking(date_in,1);
        newbook1.makeOrder(newOrder1);

        date_in = DateFor.parse("20/20/2020");
        Booking newbook2=new Booking(date_in,2);
        newbook2.makeOrder(newOrder2);

        date_in = DateFor.parse("11/11/2011");
        Booking newbook3=new Booking(date_in,3);
        newbook3.makeOrder(newOrder3);

        Date date_reg = new Date();
        date_in = DateFor.parse("19/02/1998");
        date_reg = DateFor.parse("19/12/2020");
        Customer newcustomer1 = new Customer(4,"Osman",'M',date_in,date_reg,100);
        customers.add(newcustomer1);
        newcustomer1.makeBooking(newbook1);

        date_in = DateFor.parse("22/02/2000");
        date_reg = DateFor.parse("12/11/2020");
        Customer newcustomer2 = new Customer(5,"Serkan",'M', date_in, date_reg,101);
        customers.add(newcustomer2);
        newcustomer2.makeBooking(newbook2);

        date_in = DateFor.parse("5/05/2005");
        date_reg = DateFor.parse("12/28/2020");
        Customer newcustomer3 = new Customer(6,"Mustafa",'M', date_in, date_reg,102);
        customers.add(newcustomer3);
        newcustomer3.makeBooking(newbook3);

    }

}
