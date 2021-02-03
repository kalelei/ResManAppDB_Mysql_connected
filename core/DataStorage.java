package core;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DataStorage extends  Main{
    //public Connection myConn;
    public PreparedStatement myPreState;
    public ResultSet myRes;
    public Statement createState;

    public DataStorage(){
//        try{
//            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","cng443user","1234");  //Local host because Connecting Local computer
//            System.out.println("DATABASE CONNECTED");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }

    /***
     *
     * @param customers We need to pass customers ArrayList because I will store their data to DATABASE
     * @throws SQLException To get rid of Error.
     */
    public void Write_starting_data(ArrayList<Customer> customers, Connection myConn) throws SQLException {
        for (int i = 0; i < customers.size(); i++) {

            String dbop = "INSERT INTO person(id,name,gender,date_of_birth) values(?,?,?,?) ON DUPLICATE KEY UPDATE id=VALUES(id)";  //adding to person table

            myPreState = myConn.prepareStatement(dbop);
            myPreState.setInt(1,customers.get(i).getId());
            myPreState.setString(2,customers.get(i).getName());
            myPreState.setString(3,Character.toString(customers.get(i).getGender()));
            myPreState.setLong(4,customers.get(i).getDateOfBirth().getTime()/1000);   /**DATE OF BIRTH SOLVE*/
            myPreState.execute();
            myPreState.close();


            String dbop2 = "INSERT INTO customer(customer_id,customer_name,credit_card,reg_date) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE customer_id=VALUES(customer_id)";  //Adding to customer table
            myPreState = myConn.prepareStatement(dbop2);
            myPreState.setInt(1,customers.get(i).getId());
            myPreState.setString(2,customers.get(i).getName());
            myPreState.setInt(3,customers.get(i).getCreditCardDetails());
            myPreState.setLong(4,customers.get(i).getDateOfBirth().getTime()/1000);   /**DATE OF BIRTH SOLVE*/
            myPreState.execute();
            myPreState.close();

            for (int j = 0; j < customers.get(i).getBookings().size(); j++) { //For every customer it looks for all bookings he has.

                String dbop3 = "INSERT INTO booking(customer_id,booking_id,booking_date) VALUES (?,?,?) ON DUPLICATE KEY UPDATE customer_id=VALUES(customer_id)";  //Adding to customer table
                myPreState = myConn.prepareStatement(dbop3);
                myPreState.setInt(1,customers.get(i).getId());
                myPreState.setInt(2,customers.get(i).getBookings().get(j).getBookingID());
                myPreState.setLong(3,customers.get(i).getBookings().get(j).getBookingDate().getTime()/1000);   /**DATE OF BIRTH SOLVE*/
                myPreState.execute();
                myPreState.close();

            }

        }

    }


    //WHILE ADDING NEW CUSTOMER DO DB
    public void writeData(Customer newCustomer, Connection myConn) throws SQLException {                 /**Overloading writeData method*/
        String dbop = "INSERT INTO person(id,name,gender,date_of_birth) values(?,?,?,?) ON DUPLICATE KEY UPDATE id=VALUES(id)";  //adding to person table

        myPreState = myConn.prepareStatement(dbop);
        myPreState.setInt(1,newCustomer.getId());
        myPreState.setString(2,newCustomer.getName());
        myPreState.setString(3,Character.toString(newCustomer.getGender()));
        myPreState.setLong(4,newCustomer.getDateOfBirth().getTime()/1000);   /**DATE OF BIRTH SOLVE*/
        myPreState.execute();
        myPreState.close();



        String dbop2 = "INSERT INTO customer(customer_id,customer_name,credit_card,reg_date) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE customer_id=VALUES(customer_id)";  //Adding to customer table
        myPreState = myConn.prepareStatement(dbop2);
        myPreState.setInt(1,newCustomer.getId());
        myPreState.setString(2,newCustomer.getName());
        myPreState.setInt(3,newCustomer.getCreditCardDetails());
        myPreState.setLong(4,newCustomer.getDateOfBirth().getTime()/1000);   /**DATE OF BIRTH SOLVE*/
        myPreState.execute();
        myPreState.close();
        }

    //WHILE ADDING NEW CUSTOMER DO DB
    public void writeData(Staff newStaff,String staffType, Connection myConn) throws SQLException { /**Overloading writeData method*/

        if(staffType.equals("Senior")) {
            String dbop = "INSERT INTO person(id,name,gender,date_of_birth) values(?,?,?,?) ON DUPLICATE KEY UPDATE id=VALUES(id)";

            myPreState = myConn.prepareStatement(dbop);
            myPreState.setInt(1, newStaff.getId());
            myPreState.setString(2, newStaff.getName());
            myPreState.setString(3, Character.toString(newStaff.getGender()));
            myPreState.setLong(4, newStaff.getDateOfBirth().getTime() / 1000);   /**DATE OF BIRTH SOLVE*/
            myPreState.execute();
            myPreState.close();
        }

        else{
            String dbop2 = "INSERT INTO person(id,name,gender,date_of_birth) values(?,?,?,?) ON DUPLICATE KEY UPDATE id=VALUES(id)";

            myPreState = myConn.prepareStatement(dbop2);
            myPreState.setInt(1,newStaff.getId());
            myPreState.setString(2,newStaff.getName());
            myPreState.setString(3, Character.toString(newStaff.getGender()));
            myPreState.setLong(4, newStaff.getDateOfBirth().getTime()/1000);
            myPreState.execute();
            myPreState.close();

        }

    }

    /***
     * Make us able to Update database tables while adding new booking
     * @param newCustomer   we are calling  id specified customer to method because we need to update that customer's booking list
     * @param myConn        data base connection
     * @throws SQLException SQL exceptions
     */
    public void writeBooking(Customer newCustomer, Connection myConn) throws SQLException { /**Overloading writeData method*/

        String dbop3 = "INSERT INTO booking(customer_id,booking_id,booking_date) VALUES (?,?,?) ON DUPLICATE KEY UPDATE customer_id=VALUES(customer_id)";  //Adding to customer table
        myPreState = myConn.prepareStatement(dbop3);
        myPreState.setInt(1,newCustomer.getId());
        myPreState.setInt(2,newCustomer.getBookings().get(newCustomer.getBookings().size()-1).getBookingID()); //Just adding the last booking that customer made
        myPreState.setLong(3,newCustomer.getBookings().get(newCustomer.getBookings().size()-1).getBookingDate().getTime()/1000);   //Just adding the last booking that customer made
        myPreState.execute();
        myPreState.close();

        }


    /***
     * TO read from dabase and update the staffs ARRAYLIST.
     * @param myConn Database connection
     * @throws SQLException  SQL exceptions
     */
   public void readData(Connection myConn) throws SQLException {

        String dbop4 = "SELECT c.customer_id, c.customer_name, c.credit_card, c.reg_date, p.date_of_birth, p.gender FROM customer c,person p WHERE c.customer_id=p.id";  //Adding to customer table
        myPreState = myConn.prepareStatement(dbop4);
        myRes=myPreState.executeQuery();

        while(myRes.next()){

            Long seconds = myRes.getLong("p.date_of_birth")*1000L;
            Date dateofbirth = new Date(seconds);

            Long seconds2 = myRes.getLong("c.reg_date")*1000L;
            Date registration_date = new Date(seconds2);


            Customer newCustomer = new Customer(myRes.getInt("c.customer_id"), myRes.getString("c.customer_name"), myRes.getString("p.gender").charAt(0), dateofbirth, registration_date, myRes.getInt("c.credit_card"));

            customers.add(newCustomer);
            // Booking newBooking = new Booking(bookingDate, myRes.getInt("b.booking_id"));
            // newCustomer.makeBooking(newBooking);


            id = myRes.getInt("c.customer_id") + 1;


        }
    }

    /***
     * This function run and read every ROW on database and according to b.customer_id it find correct customer and add this booking row to that customer.
     * @param myConn to make database connection
     * @throws SQLException for SQL exceptions
     */
    public void readData_bookings(Connection myConn) throws SQLException {

        String dbop5 = "SELECT c.customer_id, b.customer_id, b.booking_id, b.booking_date FROM customer c,booking b WHERE c.customer_id=b.customer_id";  //Adding to customer table
        myPreState = myConn.prepareStatement(dbop5);
        myRes=myPreState.executeQuery();

        while(myRes.next()){
        int person=0;

            for (int i = 0; i <= customers.size() - 1; i++) { ////Searching index of given id number when it finds it break the loop and DELETING at the found index.
                if (customers.get(i).getId() != myRes.getInt("b.customer_id")) {
                    person = person + 1;
                } else break;
            }

            Long seconds = myRes.getLong("b.booking_date")*1000L;
            Date bookingDate = new Date(seconds);

            Booking newBooking = new Booking(bookingDate, myRes.getInt("b.booking_id"));

            customers.get(person).makeBooking(newBooking);

        }
    }
}
