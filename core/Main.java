package core;
import core.Main;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/**
 * @author yigit_kaleli
 * @version 4.0
 *
 */

public class Main implements Serializable {

    static ArrayList<Staff> staffs = new ArrayList<Staff>();    //They are initially empty
    static ArrayList<Customer> customers = new ArrayList<Customer>();           //They are initially empty

    //DataStorage db = new DataStorage();
    static PopulateDate newdata= new PopulateDate();
    static {
        try {
            newdata.CreateData(customers,staffs);        //Populates Data
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    static int credit_card_detail=104; //I defined as static variable because evey customer should have different credit card numbers.
    public static int id=7;    //I defined as static variable because evey customer should have different ID numbers.
    static int booking_uniqueId=4; //I defined as static variable because evey customer should have different booking_id numbers.
    static int order_uniqueId=4;   //I defined as static variable because evey customer should have different order_uniqueId numbers.

    /**
     *Menu method
     */
    static void menu(){                             /*Defining menu() method*/
        System.out.println("1)Add staff");
        System.out.println("2)Delete staff");
        System.out.println("3)List staff details");
        System.out.println("4)Add customer");
        System.out.println("5)Delete customer");
        System.out.println("6)Add booking to customer");
        System.out.println("7)List customer details");
        System.out.println("8)Display customer last booking");
        System.out.println("9)List customer orders");
        System.out.println("10)ADD order to customer");
        System.out.println("11)List all staffs");
        System.out.println("12)List all customers");
        System.out.println("13)List all staff salary");
        System.out.println("14)List all order");
        System.out.println("15)Add order of booking");
        System.out.println("16)Exit");
        System.out.print("Enter selection:");
    }

    /**
     *
     * @param choice for getting boolean value
     * @return getting boolean value
     */
    static boolean exit(int choice){
        if(choice==1 || choice==2 || choice==3 || choice==4 || choice==5 || choice==6 || choice==7 || choice==8 || choice==9 || choice==10 || choice==11 || choice==12 || choice==13 || choice==14 || choice==15){
            return true;
        }
        else{
            System.out.println("------GOOD BYE------");
            return false;
        }
    }

    /**
     *
     * @param staffs for staff Arraylist
     * @param staff_type intitialize staff type
     * @throws ParseException giving error message
     */
    static void addStaff(ArrayList<Staff> staffs, int staff_type) throws ParseException {
        Scanner scanObj = new Scanner(System.in);          //Re declaring scanner object.When "space enter it blows"

        // I did not asked for ID's because it initialized as static value so its automatically differs for every person

        System.out.print("Name:");                        //Entering the values.
        String name = scanObj.next();

        System.out.print("Gender:");                     //Entering the values.
        char gender = scanObj.next().charAt(0);

        System.out.print("Date of birth:");                     //Entering the values.
        String date_enter;
        date_enter=scanObj.next();
        Date date_birth = new Date();

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Start date:");                     //Entering the values.
        String Start_date;
        Start_date=scanObj.next();
        Date date_start = new Date();

        try {
            if(staff_type==1) {
                System.out.print("Enter grossSalary:");
                date_birth = DateFor.parse(date_enter);
                date_start = DateFor.parse(Start_date);//Entering the values.
                int grossSalary = scanObj.nextInt();
                Senior newStaff = new Senior(id, name, gender, date_birth, date_start, grossSalary, "Senior");   //bunu boş cağırıp altta setterlarla objeye değer girilebilir   //Creating core.Staff object
                staffs.add(newStaff);           //Adding object to ArrayList.
            }
            else{
                System.out.print("Enter monthly Salary:");                          //Entering the values.
                int monthly_salary = scanObj.nextInt();
                System.out.print("Enter expected end date:");                     //Entering the values.
                String end_date;
                end_date=scanObj.next();
                Date date_end = new Date();
                date_end = DateFor.parse(end_date);
                date_birth = DateFor.parse(date_enter);
                date_start = DateFor.parse(Start_date);
                Junior newStaff = new Junior(id, name, gender, date_birth, date_start,monthly_salary, date_end, "Junior");
                staffs.add(newStaff);

            }
        }
        catch (ParseException e) {e.printStackTrace();}

    }


    /**
     *
     * @param delete_id selecting id to delete
     * @param staffs getting staffs Arraylist
     */
    static void deleteStaff(int delete_id, ArrayList<Staff> staffs){
        int person=0;
        int check=0;

        for (int i = 0; i <= staffs.size()-1; i++) {   //Check for if the given id number in the given core.Staff object list
            if(staffs.get(i).getId()!=delete_id){
                continue;
            }
            else {
                check = 1;
                break;
            }
        }

        if(check==1) {
            for (int i = 0; i <= staffs.size() - 1; i++) { ////Searching index of given id number when it finds it break the loop and DELETING at the found index.
                if (staffs.get(i).getId() != delete_id) {
                    person = person + 1;
                } else break;
            }
            staffs.remove(staffs.get(person));
        }
        else{
            System.out.println("There is no one with specified ID number please try again to delete staff member");
        }
    }


    /**
     *
     * @param search_id ıd number to search
     * @param staffs gettin staff Arraylist
     */
    static void listStaffDetail(int search_id, ArrayList<Staff> staffs){

        int person=0;
        int check=0;

        for (int i = 0; i <= staffs.size()-1; i++) {   //Check for if the given id number in the given core.Staff object list

            if(staffs.get(i).getId()!=search_id){
                continue;
            }
            else {
                check = 1;
                break;
            }
        }

        if(check==1) {
            for (int i = 0; i <= staffs.size() - 1; i++) {   //Searching index of given id number when it finds it break the loop
                if (staffs.get(i).getId() != search_id) {
                    person = person + 1;
                } else break;
            }

            staffs.get(person).staff_show(); //I just write a overriding staff_show() function for giving details of different sub-classes

        }
        else{
            System.out.println("There is no one with specified ID number please try again.");
        }
    }

    /**
     *
     * @param customers to get customer Arraylist
     */
    static void addCustomer(ArrayList<Customer> customers){
        Scanner scanObj = new Scanner(System.in);

        // I did not asked for ID's because it initialized as static value so its automatically differs for every person

        System.out.print("Name:");                        //Entering the values.
        String name = scanObj.next();

        System.out.print("Gender:");                     //Entering the values.
        char gender = scanObj.next().charAt(0);

        System.out.print("Date of birth:");                     //Entering the values.
        String date_enter;
        date_enter=scanObj.next();
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Registration Date:");                     //Entering the values.
        String date_enter_reg;
        date_enter_reg=scanObj.next();
        Date date_reg = new Date();
        try {

            date = DateFor.parse(date_enter);
            date_reg = DateFor.parse(date_enter_reg);

            //Calling core.Customer constructor.
            Customer newCustomer = new Customer(id, name, gender, date, date_reg, credit_card_detail);
            customers.add(newCustomer);
            id=id+1;
            credit_card_detail=credit_card_detail+1;


        }
        catch (ParseException e) {e.printStackTrace();}

    }

    /**
     *
     * @param delete_id entering id to delete customer
     * @param customers to get customers Arraylist
     */
    static void deleteCustomer(int delete_id, ArrayList<Customer> customers){
        int person=0;
        int check=0;

        for (int i = 0; i <= customers.size()-1; i++) {   //Check for if the given id number in the given core.Staff object list
            if(customers.get(i).getId()!=delete_id){
                continue;
            }
            else {
                check = 1;
                break;
            }
        }

        if(check==1) {
            for (int i = 0; i <= customers.size() - 1; i++) { ////Searching index of given id number when it finds it break the loop and DELETING at the found index.
                if (customers.get(i).getId() != delete_id) {
                    person = person + 1;
                } else break;
            }
            customers.remove(customers.get(person));
        }
        else{
            System.out.println("There is no one with specified ID number please try again to delete Customer");
        }

    }

    /**
     *
     * @param booking_id shows the customer id and checking for if the customer exist given booking_id
     * @param customers getting customers Arraylist
     */
    static void addBooking(int booking_id,ArrayList<Customer> customers){
        int person=0;
        int check=0;
        Scanner scanObj = new Scanner(System.in);

        for (int i = 0; i <= customers.size()-1; i++) {   //Check for if the given id number in the given core.Staff object list
            if(customers.get(i).getId()!=booking_id){
                continue;
            }
            else {
                check = 1;
                break;
            }
        }

        if(check==1) {
            for (int i = 0; i <= customers.size() - 1; i++) { ////Searching index of given id number when it finds it break the loop and DELETING at the found index.
                if (customers.get(i).getId() != booking_id) {
                    person = person + 1;
                } else break;
            }

            /**System.out.print("Enter booking ID:");
            int booking_Table_id = scanObj.nextInt();**/

            System.out.print("Booking date:");                     //Entering the values.
            String date_booking;
            date_booking=scanObj.next();
            Date date = new Date();
            try {

                SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                date=DateFor.parse(date_booking);

                Booking new_booking = new Booking(date, booking_uniqueId);

                customers.get(person).makeBooking(new_booking);
                booking_uniqueId=booking_uniqueId+1;

            }
            catch (ParseException e){e.printStackTrace();}
        }
        else{
            System.out.println("There is no one with specified ID number please try again to Receive Booking");
        }
    }

    /**
     *
     * @param customer_id checking the if the customer exist in customers list
     * @param customers getting customers Arraylist
     */
    static void listCustomerDetails(int customer_id, ArrayList<Customer> customers){
        int person=0;
        int check=0;
        for (int i = 0; i <= customers.size()-1; i++) {   //Check for if the given ID number in the given customer object list

            if(customers.get(i).getId()!=customer_id){
                continue;
            }
            else {
                check = 1;
                break;
            }
        }
        if(check==1) {
            for (int i = 0; i <= customers.size() - 1; i++) {   //Searching index of given ID number when it finds it break the loop
                if (customers.get(i).getId() != customer_id) {
                    person = person + 1;
                } else break;
            }
            System.out.println("\nCustomer ID="+customers.get(person).getId());
            System.out.println("Name="+customers.get(person).getName());
            System.out.println("Gender="+customers.get(person).getGender());
            System.out.println("Date of birth customer="+customers.get(person).getDateOfBirth());
            System.out.println("Registration date customer="+customers.get(person).getRegistrationDate());
            System.out.println("Customer credit card details="+customers.get(person).getCreditCardDetails());
        }
        else{
            System.out.println("There is no one with specified ID number please try again."); //Error message
        }
    }

    /**
     *
     * @param customer_id given customer_id displays its last booking
     * @param customers getting customers list to reach spesific customer
     */
    static void displayCustomerLastBooking(int customer_id, ArrayList<Customer> customers)  {   //list.get (list.size ()-1)
        int person=0;
        int check=0;
        for (int i = 0; i <= customers.size()-1; i++) {   //Check for if the given ID number in the given customer object list

            if(customers.get(i).getId()!=customer_id){
                continue;
            }
            else {
                check = 1;
                break;
            }
        }
        if(check==1) {
            for (int i = 0; i <= customers.size() - 1; i++) {   //Searching index of given ID number when it finds it break the loop
                if (customers.get(i).getId() != customer_id) {
                    person = person + 1;
                } else break;
            }
            if(customers.get(person).getBookings().size()>0) {
                System.out.println("\n----Customer most recent booking details are----");
                System.out.println("Customer last booking date:"+customers.get(person).getBookings().get(customers.get(person).getBookings().size()-1).getBookingDate());
                System.out.println("Customer last booking ID:"+customers.get(person).getBookings().get(customers.get(person).getBookings().size()-1).getBookingID());
            }
            else{
                System.out.println("Customer has no bookings");
            }
        }
        else{
            System.out.println("There is no one with specified ID number please try again."); //Error message
        }
    }

    /**
     *
     * @param customer_id searching given customer_id Orders
     * @param customers getting customers Arraylist
     */
    static void listCustomerOrdes(int customer_id, ArrayList<Customer> customers){
        int check_id=0;
        int person = 0;

        for (int i = 0; i <= customers.size()-1; i++) {
            if(customers.get(i).getId()!=customer_id){
                continue;
            }
            else {
                person=i;
                check_id=1;
                break;
            }
        }


        if(check_id==1) {
            //Checks given id number customer has booking or not
            if(customers.get(person).getOrders().size()!=0 || customers.get(person).getBookings().size()!=0) {
                System.out.println("---- Customer ORDERS ----");

                if(customers.get(person).getOrders().size()!=0) {
                    System.out.println("---- Customer NORMAL ORDERS ----\n");
                    for (int i = 0; i < customers.get(person).getOrders().size(); i++) {

                        customers.get(person).getOrders().get(i).show(); //I just write a show() function which is overriding according to class type So I get more clear code
                        System.out.println("-------------------------");
                    }
                }

                else{
                    System.out.println("Customer has no Normal");
                }

                if(customers.get(person).getBookings().size()!=0) { //Checking if the customer have booking order
                    int check_rest_or=0;
                    for (int i = 0; i < customers.get(person).getBookings().size(); i++) {
                        for (int j = 0; j < customers.get(person).getBookings().get(i).getInRestrorders().size(); j++) { //Checking for if any booking has order or not
                            if(customers.get(person).getBookings().get(i).getInRestrorders().size()>0){
                                check_rest_or=1;
                                break;
                            }
                            else{
                                continue;
                            }

                        }

                    }

                    if(check_rest_or==1) {
                        System.out.println("---- Customer BOOKING ORDERS ----\n");
                        for (int j = 0; j < customers.get(person).getBookings().size(); j++) {
                            for (int k = 0; k < customers.get(person).getBookings().get(j).getInRestrorders().size(); k++) {

                                customers.get(person).getBookings().get(j).getInRestrorders().get(k).show(); //Getting order details from Bookings IF he has bookings
                                System.out.println("-------------------------");
                            }
                        }
                    }
                    else{
                        System.out.println("Customer has bookings but has no BOOKING order yet");
                    }
                }
                else{
                    System.out.println("Customer has no booking order so there is no Booking order to show");
                }
            }
            else{
                System.out.println("Customer has no Normal and no Booking order");
            }
        }
        else{
            System.out.println("Given ID number does not exist");
        }
    }

    /**
     *
     * @param customer_id given customer_id check for if the custoeer exist or not
     * @param customers getting customers list to able to search in all customers
     * @param order_type initializing order_type(online or Restaurant)
     */
    static void addOrder(int customer_id, ArrayList<Customer> customers, int order_type){ //taking Parameter ArrayList<Customers> to reach spesific customer's infos.
        Scanner scanObj = new Scanner(System.in);

        String OrderDate,Order_Details,Order_Notes;
        Date order_date = new Date();

        int check_id=0;
        int person = 0;

//Check for if the given id number in the given core.Customer object list adn find the customer_index(person)
        for (int i = 0; i <= customers.size()-1; i++) {
            if(customers.get(i).getId()!=customer_id){
                continue;
            }
            else    {
                person=i;
                check_id=1;
                break;
            }
        }


        //Checking the given id exist then check the booking dates
        if(check_id==1) {
            if(order_type==1){

                System.out.print("Please enter Order Date:");
                OrderDate = scanObj.next();

                System.out.print("Please enter Order details:");
                Order_Details = scanObj.next();

                System.out.print("Please enter Order extra notes:");
                Order_Notes = scanObj.next();

                System.out.print("Please enter payment type (Cash/Card) please:");
                String payment_Type = scanObj.next();
                try {
                    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                    order_date=DateFor.parse(OrderDate);

                    OnlineOrder New_order = new OnlineOrder("Online", order_uniqueId, order_date, Order_Details, Order_Notes,payment_Type);

                    customers.get(person).makeOrder(New_order); //Adding New_order to customer Orderlist
                    order_uniqueId=order_uniqueId+1;

                }
                catch (ParseException e){e.printStackTrace();}
            }
            else{
                    System.out.print("Please enter Order Date:");
                    OrderDate=scanObj.next();

                    System.out.print("Please enter Order details:");
                    Order_Details = scanObj.next();

                    System.out.print("Please enter Order extra notes:");
                    Order_Notes = scanObj.next();

                    System.out.print("Please enter table number:");
                    int table_Number = scanObj.nextInt();

                    System.out.print("Please enter booking order (number):");
                    int bookingOrder = scanObj.nextInt();

                    InRestrOrder New_order = new InRestrOrder("In_restaurant", order_uniqueId, order_date, Order_Details, Order_Notes, table_Number, bookingOrder);

                    customers.get(person).makeOrder(New_order);  //Adding "RESTAURANT ORDER"  to given booking date and ID number
                    order_uniqueId=order_uniqueId+1; //After every order +1

                    //customers.get(person).makeOrder(New_order); I dont need it anymore

                    }
                }
        else
            {
            System.out.println("Given ID number does not exist");
        }
    }


    /**
     *
     * @param staffs getting staffs Arraylist to reach all staffs
     */
    static void listStaff(ArrayList<Staff> staffs){
        System.out.println();
        System.out.println("----------------");
        if(staffs.size()>0) {
            for (int i = 0; i < staffs.size(); i++) {
                System.out.println("Staff " + (i + 1) + ":");
                staffs.get(i).staff_show_name_type();  //staff_show_name_type is a overriding method that prints differently for different types of staffs
                System.out.println("----------------");
            }
        }
        else{
            System.out.println("Restaurant has no staff");
        }

    }

    /**
     *
     * @param customers getting customers Arraylist to reach all customers
     */
    static void listCustomer(ArrayList<Customer> customers){
        System.out.println();
        System.out.println("----------------");
        if(customers.size()>0) {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("Customer " + (i + 1) + ":");
                customers.get(i).customer_show_name_type();  //staff_show_name_type is a overriding method that prints differently for different types of staffs
                System.out.println("----------------");
            }
        }
        else{
            System.out.println("Restaurant has no customer");
        }

    }

    /**
     *
     * @param staffs getting all stafs Arraylist to able to fing every spesific staff salary
     */
    static void listAllStaffSalary(ArrayList<Staff> staffs){
            System.out.println();
            System.out.println("----------------");
            if(staffs.size()>0) {
                for (int i = 0; i < staffs.size(); i++) {
                    System.out.println("Staff " + (i + 1) + ":");
                    staffs.get(i).getSalary();  //getSalary is a overriding method that prints differently for different types of staffs
                    System.out.println("----------------");
                }
            }
            else{
                System.out.println("Restaurant has no staff");
            }
    }

    /**
     *
     * @param customers getting customers Arraylist because customers have orders so we can find orders from them
     */
    static void listAllOrder(ArrayList<Customer> customers){

        if(customers.size()>0) {
            System.out.println("\nAll ORDERS--------------");
            for (int i = 0; i < customers.size(); i++) {
                for (int j = 0; j < customers.get(i).getOrders().size(); j++) {
                    customers.get(i).getOrders().get(j).show();
                    customers.get(i).getOrders().get(j).processPayment(); // Calling processpaymnet method for every different object
                    System.out.println("-------------------------");  //Getting online orders

                }
                for (int j = 0; j < customers.get(i).getBookings().size(); j++) {
                    for (int k = 0; k < customers.get(i).getBookings().get(j).getInRestrorders().size(); k++) {

                        customers.get(i).getBookings().get(j).getInRestrorders().get(k).show(); //Getting In restaurant orders
                        customers.get(i).getBookings().get(j).getInRestrorders().get(k).processPayment();

                        System.out.println("-------------------------");
                    }

                }
            }

        }
        else{
            System.out.println("There is no customer so NO order to show");
        }

    }


    /**
     *
     * @param customer_id getting customers_id to serach if the customer exist in custoemrs list
     * @param customers getting all customers Arraylist
     */
    static void addOrderOfBooking(int customer_id, ArrayList<Customer> customers){
        Scanner scanObj = new Scanner(System.in);

        String OrderDate,Order_Details,Order_Notes;
        Date order_date = new Date();


        int order_id,check_id=0;
        int person = 0;

        int flag_date=0;
        int index_date=0;

        for (int i = 0; i <= customers.size()-1; i++) {
            if(customers.get(i).getId()!=customer_id){
                continue;
            }
            else    {
                person=i;
                check_id=1;
                break;
            }
        }


        if(check_id==1) {
            System.out.print("Please enter exsisting customer booking date to give order:");
            String search_order = scanObj.next();
            Date search_date = new Date();


            if (customers.get(person).getBookings().size() != 0) {
                try {
                    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                    search_date = DateFor.parse(search_order);
                    for (int i = 0; i < customers.get(person).getBookings().size(); i++) { //Searching for if the given date exist in customer bookings
                        if (customers.get(person).getBookings().get(i).getBookingDate().equals(search_date)) {
                            flag_date = 1;
                            index_date = i;
                            break;
                        } else {
                            continue;
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                //If he has a booking at entered Date then get the order
                if (flag_date == 1) {

                    System.out.print("Please enter Order Date:");
                    OrderDate = scanObj.next();

                    System.out.print("Please enter Order details:");
                    Order_Details = scanObj.next();

                    System.out.print("Please enter Order extra notes:");
                    Order_Notes = scanObj.next();

                    System.out.print("Please enter table number:");
                    int table_Number = scanObj.nextInt();

                    System.out.print("Please enter booking order (number):");
                    int bookingOrder = scanObj.nextInt();

                    InRestrOrder New_order = new InRestrOrder("In_restaurant", order_uniqueId, order_date, Order_Details, Order_Notes, table_Number, bookingOrder);

                    customers.get(person).getBookings().get(index_date).makeOrder(New_order);  //Adding "RESTAURANT ORDER"  to given booking date and ID number
                    order_uniqueId = order_uniqueId + 1; //After every order +1


                }
                else {
                    System.out.println("Customer has no bookings at given date");
                }
            }
            else {
                System.out.println("Customer has no bookings in given date");
            }
        }
        else{
            System.out.println("There is no customer with entered ID number");
        }
    }

    
    /**
     *
     * @param args Getting arguments
     * @throws ParseException giving error message
     */
    public static void main(String[] args) throws ParseException, IOException, NoSuchAlgorithmException {

        GUIclass gui = new GUIclass();   //Creating GUI class (Visualising)








        /** COMMAND PROMPT PROGRAM*/
        menu();
        Scanner scanObj = new Scanner(System.in);
        int choice = scanObj.nextInt();

        int search_id,staff_type,delete_id,booking_id,order_type;
        String date_search;


        while(exit(choice)){
            switch (choice){
                case 1:
                    System.out.print("Please enter staff type (1(Senior)/2(Junior)):");
                    staff_type = scanObj.nextInt();
                    addStaff(staffs, staff_type);
                    id=id+1;
                    break;
                case 2:
                    System.out.print("Enter ID to delete the specified staff:");
                    delete_id = scanObj.nextInt();
                    deleteStaff(delete_id,staffs);
                    break;
                case 3:
                    System.out.print("Enter ID to search staff:");
                    search_id = scanObj.nextInt();
                    listStaffDetail(search_id,staffs);
                    break;
                case 4:
                    addCustomer(customers);

                    break;
                case 5:
                    System.out.print("Enter ID to delete the specified Customer:");
                    delete_id = scanObj.nextInt();
                    deleteCustomer(delete_id, customers);
                    break;
                case 6:
                    System.out.print("Enter ID to set booking for customer:");
                    booking_id = scanObj.nextInt();
                    addBooking(booking_id,customers);
                    break;
                case 7:
                    System.out.print("Enter customer ID to get customer details:");
                    search_id=scanObj.nextInt();
                    listCustomerDetails(search_id,customers);
                    break;
                case 8:
                    System.out.print("Enter customer ID to get customer most recent booking:");
                    search_id=scanObj.nextInt();
                    displayCustomerLastBooking(search_id,customers);
                    break;
                case 9:
                    System.out.print("Enter customer ID to display orders of customer:");
                    search_id=scanObj.nextInt();
                    listCustomerOrdes(search_id,customers);
                    break;
                case 10:
                    System.out.print("Enter customer ID to add order:");
                    search_id=scanObj.nextInt();
                    System.out.print("Please enter order type (1(Online)/2(InRest)):");
                    order_type=scanObj.nextInt();
                    addOrder(search_id,customers,order_type);

                    break;
                case 11:
                    listStaff(staffs);
                    break;
                case 12:
                    listCustomer(customers);
                    break;
                case 13:
                    listAllStaffSalary(staffs);
                    break;
                case 14:
                    listAllOrder(customers);
                    break;
                case 15:
                    System.out.print("Enter ID to set booking for customer:");
                    search_id = scanObj.nextInt();
                    addOrderOfBooking(search_id,customers);
                    break;

            }
            System.out.println("\n");
            menu();
            choice = scanObj.nextInt();
        }
    }
}
