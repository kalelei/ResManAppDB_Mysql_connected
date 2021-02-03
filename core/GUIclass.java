package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;


/***
 * GUI class Implementation
 */
public class GUIclass extends Main implements ActionListener,Serializable {
    private JButton addStaff;
    private JPanel start_panel;
    private JButton deleteStaff;
    private JButton listStaffDetail;
    private JButton addCustomer;
    private JButton deleteCustomer;
    private JButton addBooking;
    private JButton listCustomerDetailsButton;
    private JButton displayCustomerLastBookingButton;
    private JButton listCustomerOrdersButton;
    private JButton addOrderButton;
    private JButton listStaffButton;
    private JButton listCustomerButton;
    private JButton listAllStaffSalaryButton;
    private JButton listAllOrderButton;
    private JButton addOrderOfBookingButton;
    private JComboBox getStaffTypeCombo;
    private JTextField GetStaffNameText;
    private JTextField getStaffDobText;
    private JComboBox getStaffGenderCombo;
    private JButton createStaffButton;
    private JLabel staffNameLabel;
    private JLabel staffTypeLabel;
    private JLabel staffGenderLabel;
    private JLabel dateOfBirthLabel;
    private JPanel addStaffPanel;
    private JPanel deleteStaffPanel;
    private JPanel listStaffDetailPanel;
    private JPanel addCustomerPanel;
    private JPanel deleteCustomerPanel;
    private JPanel addBookingPanel;
    private JPanel listCustomerDetailPanel;
    private JPanel displayCustomerLastBookingPanel;
    private JPanel listCustomerOrdersPanel;
    private JPanel addOrderPanel;
    private JPanel listStaffPanel;
    private JPanel listCustomerPanel;
    private JPanel listAllStaffSalaryPanel;
    private JPanel listAllOrderPanel;
    private JPanel addOrderOfBookingPanel;
    private JTextField staffDel_idText;
    private JLabel Staff_idLabel;
    private JButton deleteStaffButton;
    private JTextField staffList_idText;
    private JButton listStaffDetailButton;
    private JLabel Staff_id_listLabel;
    private JLabel Add_Customer_IdLabel;
    private JLabel Add_Customer_GenderLabel;
    private JLabel Add_Customer_DOBLabel;
    private JTextField getCustomerNameText;
    private JComboBox getCustomerGenderCombo;
    private JTextField getCustomerDobText;
    private JButton createCustomerButton;
    private JTextField customerDel_idText;
    private JButton deleteCustomerButton;
    private JLabel delCustomerIDLabel;
    private JLabel addBookingDateCustomerLabel;
    private JTextField customerAddBookingText;
    private JButton addBookingCustomerButton;
    private JTextField listDetailsCustomerText;
    private JLabel listDetailsCustomerIDLabel;
    private JLabel addBookingCustomerIDLabel;
    private JTextField lastBookingCustomerText;
    private JLabel lastBookingCustomerLabel;
    private JButton listDetailsCustomerButton;
    private JButton lastBookingCustomerButton;
    private JLabel listOrdersCustomerLabel;
    private JTextField listOrdersCustomerText;
    private JButton listOrdersCustomerButton;
    private JTextField addOrderCustomerIDText;
    private JComboBox addOrderTypeCombo;
    private JLabel addOrderCustomerIDLabel;
    private JLabel addOrderTypeLabel;
    private JTextField getStaffGrossSalaryText;
    private JTextField getStaffMonthlySalaryText;
    private JLabel getStaffGrossSalaryLabel;
    private JLabel getStaffMonthlySalaryLabel;
    private JTextField getStaffStart_DateText;
    private JTextField getStaffExp_end_DateText;
    private JLabel getStaffStart_DateLabel;
    private JLabel getStaffExp_end_DateLabel;
    private JButton listAllStaffButton;
    private JButton listAllCustomerButton;
    private JButton listAllStaffSalaryButton_func;
    private JButton listAllOrderButton_func;
    private JTable table1;
    private JFormattedTextField getCustomerRegText;
    private JLabel add_Customer_Reg_label;
    private JLabel deleteCustomerErrorLabel;
    private JLabel deleteStaffErrorLabel;
    private JFormattedTextField customerBookingDateText;
    private JLabel addBookingErrorLabel;
    private JFormattedTextField addOrderDateText;
    private JTextField addOrderDetailText;
    private JTextField addOrderExtraNotesText;
    private JLabel addOrderDateLabel;
    private JLabel addOrderDetailLabel;
    private JLabel addOrderExtraNotesLabel;
    private JButton addCustomerOrderButton;
    private JLabel addOrderErrorLabel;
    private JComboBox addOrderPaymentCombo;
    private JTextField addOrderTableText;
    private JLabel tableNumberLabel;
    private JLabel bookingOrderNumberLabel;
    private JTextField addOrderBookingOrderNumText;
    private JLabel paymentTypeLabel;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JTable table6;
    private JTable table7;
    private JTable table8;
    private JFormattedTextField addOrderOfBookFormattedText;
    private JLabel existingBookingDateLabel;
    private JLabel orderDateLabel;
    private JLabel orderDetailLabel;
    private JLabel orderExtraNoteLabel;
    private JLabel orderTableNumberLabel;
    private JLabel bookingOrderNumberLabel1;
    private JTextField addOrderOfBookOrderDateText;
    private JTextField addOrderOfBookDetailText;
    private JTextField addOrderOfBookEkstraText;
    private JTextField addOrderOfBookTableNoText;
    private JTextField addOrderOfBookOrderNoText;
    private JTextField addOrderOfBookCustomerIDText;
    private JLabel customerIDLabel;
    private JButton addOrderBookingButton;
    private JLabel listStaffDetailErrorLabel;
    private JLabel listCustomerDetailErrorLabel;
    private JLabel displayCustomerLastBookingErrorLabel;
    private JLabel listAllStaffErrorLabel;
    private JLabel listAllCustomerErrorLabel;
    private JLabel listAllStaffSalaryErrorLabel;
    private JLabel listAllOrderErrorLabel;
    private JLabel addOrderOfBookingErrorLabel;



    JMenuBar  menuBar;
    JMenu menu;
    JMenuItem Save_item;
    JMenuItem Load_item;

    /*Connection myConn;
    PreparedStatement myPreState;
    ResultSet myRes;
    Statement createState;*/


    int row,col;


    //GUIclass constructor
    public GUIclass() throws ParseException, IOException, NoSuchAlgorithmException {

        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","cng443user","1234");  //Local host because Connecting Local computer
            System.out.println("DATABASE CONNECTED");
            DataStorage db = new DataStorage();


            db.Write_starting_data(customers, myConn);
            System.out.println("FIRST THREE CUSTOMERS SAVED TO DATABASE");
            //Loading initialized data to database. (Only customers)
            customers.clear();  //If I dont clear it will duplicate the data

            db.readData(myConn);
            db.readData_bookings(myConn);

// READING DATA FROM DATABASE AND WRITES THEM TO Customer.dat file
            File file_out_customer = new File("CustomerOut.dat");
            try {

                FileOutputStream fos2 = new FileOutputStream(file_out_customer);
                ObjectOutputStream out2 = new ObjectOutputStream(fos2);

                for (int i = 0; i < customers.size(); i++) {
                    out2.writeObject(customers.get(i));
                }

                out2.close(); //Closing file after usage
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            //makeMD5(); //To initialize first file

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //Initializing the GUI basics
        JFrame frame = new JFrame("RestManApp GUI (YOU SHOULD SAVE THE PROGRAM TO UPDATE MD5 FILE !!!!)");
        JScrollPane scrollPane = new JScrollPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.add(start_panel);//Adding panel to frame

        if(checkMD5()){
            JOptionPane.showMessageDialog(frame,"MD5 APPROVED");
        }
        else{
            JOptionPane.showMessageDialog(frame,"WARNING DATA CORRUPTED");
        }



        menuBar = new JMenuBar();
        menu = new JMenu("File");

        Save_item = new JMenuItem("Save");
        Load_item = new JMenuItem("Load(PLEASE ONLY CHOOSE ('StaffOut.dat')");

        Save_item.addActionListener(this);
        Load_item.addActionListener(this);

        menu.add(Save_item);
        menu.add(Load_item);

        menuBar.add(menu);

        frame.setJMenuBar(menuBar); //Setting JmenuBar to Jframe

        addStaffPanel.setVisible(false);  //Junior seçildiğinde bazı textbox'ları disable yap
        deleteStaffPanel.setVisible(false);
        listStaffDetailPanel.setVisible(false);
        addCustomerPanel.setVisible(false);
        deleteCustomerPanel.setVisible(false);
        addBookingPanel.setVisible(false);
        listCustomerDetailPanel.setVisible(false);
        displayCustomerLastBookingPanel.setVisible(false);
        listCustomerOrdersPanel.setVisible(false);
        addOrderPanel.setVisible(false);
        listStaffPanel.setVisible(false);
        listCustomerPanel.setVisible(false);
        listAllStaffSalaryPanel.setVisible(false);
        listAllOrderPanel.setVisible(false);
        addOrderOfBookingPanel.setVisible(false);

        frame.pack();

        frame.setVisible(true);//Making frame to visable by giving boolean value 'true'


/***
 * addStaff ActionListener
 */

        addStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getStaffMonthlySalaryText.setEnabled(false);
                getStaffGrossSalaryText.setEnabled(false);
                addStaffPanel.setVisible(true);

                //REST OF PANELS INVISBLE
                deleteStaffPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addBookingPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });


/***
 * ComboBox ActionListener Example
 */
        getStaffTypeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getStaffTypeCombo.getSelectedItem().equals("Senior")) {
                    getStaffGrossSalaryText.setEnabled(true);
                    getStaffMonthlySalaryText.setEnabled(false);

                }
                else if (getStaffTypeCombo.getSelectedItem().equals("Junior")) {
                    getStaffMonthlySalaryText.setEnabled(true);
                    getStaffGrossSalaryText.setEnabled(false);
                }

            }
        });

/***
 * It enable us to enter only integer values
 */
        getStaffGrossSalaryText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    getStaffGrossSalaryText.setEditable(false);
                }
                else{
                    getStaffGrossSalaryText.setEditable(true);
                }
            }
        });


        getStaffMonthlySalaryText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    getStaffMonthlySalaryText.setEditable(false);
                }
                else{
                    getStaffMonthlySalaryText.setEditable(true);
                }
            }
        });

/***
 * createStaffButton ActionListener example
 */
        createStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = GetStaffNameText.getText();
                char gender = getStaffGenderCombo.getSelectedItem().toString().charAt(0);

                String date_enter = getStaffDobText.getText();
                Date date_birth = new Date();

                String Start_date = getStaffDobText.getText();
                Date date_start = new Date();

                SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    if(getStaffTypeCombo.getSelectedItem().equals("Senior")) {
                        date_birth = DateFor.parse(date_enter);
                        date_start = DateFor.parse(Start_date);//Entering the values.
                        int grossSalary = Integer.parseInt(getStaffGrossSalaryText.getText());
                        Senior newStaff = new Senior(id, name, gender, date_birth, date_start, grossSalary, "Senior");   //bunu boş cağırıp altta setterlarla objeye değer girilebilir   //Creating core.Staff object
                        staffs.add(newStaff);           //Adding object to ArrayList.


                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","cng443user","1234");  //Local host because Connecting Local computer
                        System.out.println("DATABASE CONNECTED");
                        DataStorage db = new DataStorage();//db.readData();


                        db.writeData(newStaff, (String) getStaffTypeCombo.getSelectedItem(), myConn); //Calling Overloading writeData method UPDATING db every time new item inserted


                        id=id+1;
                    }
                    else{

                        int monthly_salary = Integer.parseInt(getStaffMonthlySalaryText.getText());
                        String end_date = getStaffExp_end_DateText.getText();
                        Date date_end = new Date();
                        date_end = DateFor.parse(end_date);
                        date_birth = DateFor.parse(date_enter);
                        date_start = DateFor.parse(Start_date);
                        Junior newStaff = new Junior(id, name, gender, date_birth, date_start,monthly_salary, date_end, "Junior");
                        staffs.add(newStaff);

                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","cng443user","1234");  //Local host because Connecting Local computer
                        System.out.println("DATABASE CONNECTED");
                        DataStorage db = new DataStorage();//db.readData();


                        db.writeData(newStaff, (String) getStaffTypeCombo.getSelectedItem(), myConn);   //Calling Overloading writeData method UPDATING db every time new item inserted


                        id=id+1;

                    }
                }
                catch (ParseException | SQLException ex) {ex.printStackTrace();}
                addStaffPanel.setVisible(false);
            }
        });


        deleteStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStaffPanel.setVisible(true);
                deleteStaffErrorLabel.setVisible(false);
                deleteStaffErrorLabel.setText("");


                //REST OF PANELS INVISBLE
                addStaffPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addBookingPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);

            }
        });

        deleteStaffButton.addActionListener(new ActionListener() {    /** PRESS BUTTON TO DELETE STAFF*/
            @Override
            public void actionPerformed(ActionEvent e) {
                int person=0;
                int check=0;

                for (int i = 0; i <= staffs.size()-1; i++) {   //Check for if the given id number in the given core.Staff object list
                    if(staffs.get(i).getId()!=Integer.parseInt(staffDel_idText.getText())){
                        continue;
                    }
                    else {
                        check = 1;
                        break;
                    }
                }

                if(check==1) {
                    for (int i = 0; i <= staffs.size() - 1; i++) { ////Searching index of given id number when it finds it break the loop and DELETING at the found index.
                        if (staffs.get(i).getId() !=Integer.parseInt(staffDel_idText.getText())) {
                            person = person + 1;
                        } else break;
                    }
                    staffs.remove(staffs.get(person));
                    deleteStaffErrorLabel.setVisible(true);
                    deleteStaffErrorLabel.setForeground(Color.GREEN);
                    deleteStaffErrorLabel.setText("Staff deleted");



                }
                else{
                    deleteStaffErrorLabel.setVisible(true);
                    deleteStaffErrorLabel.setForeground(Color.RED);
                    deleteStaffErrorLabel.setText("Staff not found with given ID number!");



                }
            }
        });


        listStaffDetail.addActionListener(new ActionListener() { //PRESS BUTTON TO MAKE "listStaffDetailPanel" visable
            @Override
            public void actionPerformed(ActionEvent e) {
                listStaffDetailErrorLabel.setText("");
                listStaffDetailErrorLabel.setVisible(false);
                listStaffDetailPanel.setVisible(true);

                //REST OF PANELS INVISBLE
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addBookingPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });


        listStaffDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String header[] = new String[]{"ID","Name","DOB","Gender","Type"}; //CALISMIYORRR ??
                DefaultTableModel staffDetail_Table;

                staffDetail_Table = new DefaultTableModel(header,0);
                table1.setModel(staffDetail_Table);


                int person=0;
                int check=0;

                for (int i = 0; i <= staffs.size()-1; i++) {   //Check for if the given id number in the given core.Staff object list

                    if(staffs.get(i).getId()!=Integer.parseInt(staffList_idText.getText())){
                        continue;
                    }
                    else {
                        check = 1;
                        break;
                    }
                }

                if(check==1) {
                    for (int i = 0; i <= staffs.size() - 1; i++) {   //Searching index of given id number when it finds it break the loop
                        if (staffs.get(i).getId() != Integer.parseInt(staffList_idText.getText())) {
                            person = person + 1;
                        } else break;
                    }

                    staffs.get(person).staff_show(); //I just write a overriding staff_show() function for giving details of different sub-classes


                    Object[] objs = {staffs.get(person).getId(), staffs.get(person).getName(), staffs.get(person).getDateOfBirth(), staffs.get(person).getGender(), staffs.get(person).getStaff_type()};
                    staffDetail_Table.addRow(objs);   //**********************************************STAFF TABLE INSERTION*************************
                    listStaffDetailErrorLabel.setForeground(Color.GREEN);
                    listStaffDetailErrorLabel.setText("Staff Detail Shown");
                    listStaffDetailErrorLabel.setVisible(true);


                }
                else{
                    listStaffDetailErrorLabel.setForeground(Color.RED);
                    listStaffDetailErrorLabel.setText("There is no one with specified ID number please try again.");
                    listStaffDetailErrorLabel.setVisible(true);
                    System.out.println("There is no one with specified ID number please try again.");
                }
            }
        });



        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // I did not asked for ID's because it initialized as static value so its automatically differs for every person
                                      //Entering the values.
                String name = getCustomerNameText.getText();

                                  //Entering the values.
                char gender = getCustomerGenderCombo.getSelectedItem().toString().charAt(0);
                 //Entering the values.
                String date_enter;
                date_enter= getCustomerDobText.getText();
                Date date = new Date();
                SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                //Entering the values.
                String date_enter_reg;
                date_enter_reg=getCustomerRegText.getText();
                Date date_reg = new Date();

                try {

                    date = DateFor.parse(date_enter);
                    date_reg = DateFor.parse(date_enter_reg);

                    //Calling core.Customer constructor.
                    Customer newCustomer = new Customer(id, name, gender, date, date_reg, credit_card_detail);
                    customers.add(newCustomer);


                    String dbop = "INSERT INTO person(id,name,date_of_birth) values(?,?,?) ON DUPLICATE KEY UPDATE id=VALUES(id)";
/**

**/                 Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","cng443user","1234");  //Local host because Connecting Local computer
                    System.out.println("DATABASE CONNECTED");
                    DataStorage db = new DataStorage();//db.readData();


                    db.writeData(newCustomer,myConn); //UPDATING db every time new item inserted

                    id=id+1;
                    credit_card_detail=credit_card_detail+1;

                }
                catch (ParseException | SQLException ex) {ex.printStackTrace();}
                addCustomerPanel.setVisible(false);
            }
        });



        addCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addCustomerPanel.setVisible(true);


                //REST OF PANELS INVISBLE
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addBookingPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);

            }
        });
        deleteCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCustomerErrorLabel.setVisible(false);
                deleteCustomerPanel.setVisible(true);
                deleteCustomerErrorLabel.setText("");

                //REST OF PANELS INVISBLE
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                addBookingPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });
        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int person=0;
                int check=0;

                for (int i = 0; i <= customers.size()-1; i++) {   //Check for if the given id number in the given core.Staff object list
                    if(customers.get(i).getId()!=Integer.parseInt(customerDel_idText.getText())){
                        continue;
                    }
                    else {
                        check = 1;
                        break;
                    }
                }

                if(check==1) {
                    for (int i = 0; i <= customers.size() - 1; i++) { ////Searching index of given id number when it finds it break the loop and DELETING at the found index.
                        if (customers.get(i).getId() !=Integer.parseInt(customerDel_idText.getText())) {
                            person = person + 1;
                        } else break;
                    }

                    customers.remove(customers.get(person));
                    deleteCustomerErrorLabel.setVisible(true);
                    deleteCustomerErrorLabel.setForeground(Color.GREEN);
                    deleteCustomerErrorLabel.setText("Customer deleted");


                    String dbop="DELETE FROM customer WHERE customer_id=?";
                    String dbop2="DELETE FROM person WHERE id=?";

                    try {

                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","cng443user","1234");  //Local host because Connecting Local computer
                        System.out.println("DATABASE CONNECTED");
                        DataStorage db = new DataStorage();//db.readData();

                        db.myPreState = myConn.prepareStatement(dbop);
                        db.myPreState.setInt(1,Integer.parseInt(customerDel_idText.getText()));
                        db.myPreState.execute();
                        db.myPreState.close();


                        db.myPreState = myConn.prepareStatement(dbop2);
                        db.myPreState.setInt(1,Integer.parseInt(customerDel_idText.getText()));
                        db.myPreState.execute();
                        db.myPreState.close();



                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }



                }
                else{
                    deleteCustomerErrorLabel.setVisible(true);
                    deleteCustomerErrorLabel.setForeground(Color.RED);
                    deleteCustomerErrorLabel.setText("No customer found with given ID");                }
            }
        });
        addBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookingErrorLabel.setText("");
                addBookingErrorLabel.setVisible(false);
                addBookingPanel.setVisible(true);


                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });
        addBookingCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int person=0;
                int check=0;
                Scanner scanObj = new Scanner(System.in);

                for (int i = 0; i <= customers.size()-1; i++) {   //Check for if the given id number in the given core.Staff object list
                    if(customers.get(i).getId()!=Integer.parseInt(customerAddBookingText.getText())){
                        continue;
                    }
                    else {
                        check = 1;
                        break;
                    }
                }

                if(check==1) {
                    for (int i = 0; i <= customers.size() - 1; i++) { ////Searching index of given id number when it finds it break the loop and DELETING at the found index.
                        if (customers.get(i).getId() !=Integer.parseInt(customerAddBookingText.getText())) {
                            person = person + 1;
                        } else break;
                    }

                                         //Setting the values.
                    String date_booking = customerBookingDateText.getText();
                    Date date = new Date();
                    try {

                        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                        date=DateFor.parse(date_booking);

                        Booking new_booking = new Booking(date, booking_uniqueId); //Creating new booking

                        customers.get(person).makeBooking(new_booking);   //Adding "created booking" to customer's booking list.


                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","cng443user","1234");  //Local host because Connecting Local computer
                        System.out.println("DATABASE CONNECTED");
                        DataStorage db = new DataStorage();//db.readData();


                        db.writeBooking(customers.get(person),myConn);  //Sending the customer to function to save the last booking he made in DATABASE, and UPDATING db every time new item inserted



                        booking_uniqueId=booking_uniqueId+1;
                        addBookingErrorLabel.setVisible(true);
                        addBookingErrorLabel.setForeground(Color.GREEN);
                        addBookingErrorLabel.setText("Booking created");







                    }
                    catch (ParseException | SQLException ex){ex.printStackTrace();}
                }
                else{
                    addBookingErrorLabel.setVisible(true);
                    addBookingErrorLabel.setForeground(Color.RED);
                    addBookingErrorLabel.setText("There is no one with specified ID number please try again");

                }
            }
        });
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrderErrorLabel.setText("");
                addOrderErrorLabel.setVisible(false);

                addOrderPanel.setVisible(true);

                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });



        addCustomerOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String OrderDate,Order_Details,Order_Notes;
                Date order_date = new Date();



                int check_id=0;
                int person = 0;

//Check for if the given id number in the given core.Customer object list adn find the customer_index(person)
                for (int i = 0; i <= customers.size()-1; i++) {
                    if(customers.get(i).getId()!=Integer.parseInt(addOrderCustomerIDText.getText())){
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
                    if(addOrderTypeCombo.getSelectedItem().equals("Online")){

                        OrderDate = addOrderDateText.getText();

                        Order_Details = addOrderDetailText.getText();

                        Order_Notes = addOrderExtraNotesText.getText();

                        String payment_Type = addOrderPaymentCombo.getSelectedItem().toString();
                        try {
                            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                            order_date=DateFor.parse(OrderDate);

                            OnlineOrder New_order = new OnlineOrder("Online", order_uniqueId, order_date, Order_Details, Order_Notes,payment_Type);

                            customers.get(person).makeOrder(New_order); //Adding New_order to customer Orderlist
                            order_uniqueId=order_uniqueId+1;
                            addOrderErrorLabel.setVisible(true);
                            addOrderErrorLabel.setForeground(Color.GREEN);
                            addOrderErrorLabel.setText("Order Created");

                        }
                        catch (ParseException ex){ex.printStackTrace();}
                    }
                    else{
                        OrderDate = addOrderDateText.getText();

                        Order_Details = addOrderDetailText.getText();

                        Order_Notes = addOrderExtraNotesText.getText();

                        int table_Number = Integer.parseInt(addOrderTableText.getText());

                        int bookingOrder = Integer.parseInt(addOrderBookingOrderNumText.getText());

                        InRestrOrder New_order = new InRestrOrder("In_restaurant", order_uniqueId, order_date, Order_Details, Order_Notes, table_Number, bookingOrder);

                        customers.get(person).makeOrder(New_order);  //Adding "RESTAURANT ORDER"  to given booking date and ID number
                        order_uniqueId=order_uniqueId+1; //After every order +1

                        //customers.get(person).makeOrder(New_order); I dont need it anymore
                        addOrderErrorLabel.setVisible(true);
                        addOrderErrorLabel.setForeground(Color.GREEN);
                        addOrderErrorLabel.setText("Order Created");
                    }
                }
                else
                {
                    addOrderErrorLabel.setVisible(true);
                    addOrderErrorLabel.setForeground(Color.RED);
                    addOrderErrorLabel.setText("Given ID number does not exist!");
                }
            }
        });


        addOrderTypeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addOrderTypeCombo.getSelectedItem().equals("Online")) {
                    addOrderPaymentCombo.setEnabled(true);
                    addOrderTableText.setEnabled(false);
                    addOrderBookingOrderNumText.setEnabled(false);

                }
                else if (addOrderTypeCombo.getSelectedItem().equals("In_restaurant")) {
                    addOrderTableText.setEnabled(true);
                    addOrderBookingOrderNumText.setEnabled(true);
                    addOrderPaymentCombo.setEnabled(true);
                }
            }
        });
        listCustomerDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCustomerDetailErrorLabel.setText("");
                listCustomerDetailErrorLabel.setVisible(false);
                listCustomerDetailPanel.setVisible(true);

                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });
        listDetailsCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String header2[] = new String[]{"ID","Name","Dob","Gender"};
                DefaultTableModel staffDetail_Table2;

                staffDetail_Table2 = new DefaultTableModel(header2,0);
                table2.setModel(staffDetail_Table2);



                int person=0;
                int check=0;
                for (int i = 0; i <= customers.size()-1; i++) {   //Check for if the given ID number in the given customer object list

                    if(customers.get(i).getId()!=Integer.parseInt(listDetailsCustomerText.getText())){
                        continue;
                    }
                    else {
                        check = 1;
                        break;
                    }
                }
                if(check==1) {
                    for (int i = 0; i <= customers.size() - 1; i++) {   //Searching index of given ID number when it finds it break the loop
                        if (customers.get(i).getId() != Integer.parseInt(listDetailsCustomerText.getText())) {
                            person = person + 1;
                        } else break;
                    }

                    Object[] objs2 = {customers.get(person).getId(),customers.get(person).getName(),customers.get(person).getDateOfBirth(),customers.get(person).getGender()};
                    staffDetail_Table2.addRow(objs2);

                    listCustomerDetailErrorLabel.setText("Customer details shown");
                    listCustomerDetailErrorLabel.setForeground(Color.GREEN);
                    listCustomerDetailErrorLabel.setVisible(true);

                }
                else{
                    listCustomerDetailErrorLabel.setText("There is no one with specified ID number please try again.");
                    listCustomerDetailErrorLabel.setForeground(Color.RED);
                    listCustomerDetailErrorLabel.setVisible(true);
                    System.out.println("There is no one with specified ID number please try again."); //Error message
                }
            }
        });
        displayCustomerLastBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCustomerLastBookingErrorLabel.setText("");
                displayCustomerLastBookingErrorLabel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(true);


                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });
        lastBookingCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String header3[] = new String[]{"ID","Name","Customer Last Booking"};
                DefaultTableModel staffDetail_Table3;

                staffDetail_Table3 = new DefaultTableModel(header3,0);
                table3.setModel(staffDetail_Table3);


                int person=0;
                int check=0;
                for (int i = 0; i <= customers.size()-1; i++) {   //Check for if the given ID number in the given customer object list

                    if(customers.get(i).getId()!=Integer.parseInt(lastBookingCustomerText.getText())){
                        continue;
                    }
                    else {
                        check = 1;
                        break;
                    }
                }
                if(check==1) {
                    for (int i = 0; i <= customers.size() - 1; i++) {   //Searching index of given ID number when it finds it break the loop
                        if (customers.get(i).getId() != Integer.parseInt(lastBookingCustomerText.getText())) {
                            person = person + 1;
                        } else break;
                    }
                    if(customers.get(person).getBookings().size()>0) {

                        Object[] objs3 = {customers.get(person).getId(),customers.get(person).getName(),customers.get(person).getBookings().get(customers.get(person).getBookings().size()-1).getBookingDate()};
                        staffDetail_Table3.addRow(objs3);

                        displayCustomerLastBookingErrorLabel.setText("Customer last booking details shown");
                        displayCustomerLastBookingErrorLabel.setForeground(Color.GREEN);
                        displayCustomerLastBookingErrorLabel.setVisible(true);


                    }
                    else{
                        displayCustomerLastBookingErrorLabel.setText("Customer has no bookings");
                        displayCustomerLastBookingErrorLabel.setForeground(Color.RED);
                        displayCustomerLastBookingErrorLabel.setVisible(true);
                        System.out.println("Customer has no bookings");
                    }
                }
                else{
                    displayCustomerLastBookingErrorLabel.setText("There is no one with specified ID number please try again.");
                    displayCustomerLastBookingErrorLabel.setForeground(Color.RED);
                    displayCustomerLastBookingErrorLabel.setVisible(true);
                    System.out.println("There is no one with specified ID number please try again."); //Error message
                }
            }
        });

/***
 * listCustomerOrderButton example
 */
        listCustomerOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listCustomerOrdersPanel.setVisible(true);

                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });


/***
 * listOrderCustomerButton it list customer orders
 */
        listOrdersCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String header4[] = new String[]{"Order Type","Details","Extra Note"};
                DefaultTableModel staffDetail_Table4;

                staffDetail_Table4 = new DefaultTableModel(header4,0);
                table4.setModel(staffDetail_Table4);



                int check_id=0;
                int person = 0;

                for (int i = 0; i <= customers.size()-1; i++) {
                    if(customers.get(i).getId()!=Integer.parseInt(listOrdersCustomerText.getText())){
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

                                Object[] objs4 = {customers.get(person).getOrders().get(i).getOrderType(),customers.get(person).getOrders().get(i).getOrderDetails(),customers.get(person).getOrders().get(i).getExtraNotes()};
                                staffDetail_Table4.addRow(objs4);

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

                                        Object[] objs4 = {customers.get(person).getBookings().get(j).getInRestrorders().get(k).getOrderType(),customers.get(person).getBookings().get(j).getInRestrorders().get(k).getOrderDetails(),customers.get(person).getBookings().get(j).getInRestrorders().get(k).getExtraNotes()};
                                        staffDetail_Table4.addRow(objs4);

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
        });


/***
 * Lists all the staffs
 */
        listStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listAllStaffErrorLabel.setText("");
                listAllStaffErrorLabel.setVisible(false);

                listStaffPanel.setVisible(true);
                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);
            }
        });



        listAllStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String header5[] = new String[]{"ID","Name","Type"}; //WHY IT IS NOT WORKINNGGG????
                DefaultTableModel staffDetail_Table5;


                staffDetail_Table5 = new DefaultTableModel(header5,0);
                table5.setModel(staffDetail_Table5);




                System.out.println();
                System.out.println("----------------");
                if(staffs.size()>0) {
                    for (int i = 0; i < staffs.size(); i++) {
                        System.out.println("Staff " + (i + 1) + ":");
                        staffs.get(i).staff_show_name_type();  //staff_show_name_type is a overriding method that prints differently for different types of staffs

                        Object[] objs4 = {staffs.get(i).getId(),staffs.get(i).getName(),staffs.get(i).getStaff_type()};
                        staffDetail_Table5.addRow(objs4);

                        listAllStaffErrorLabel.setText("All staff list displayed");
                        listAllStaffErrorLabel.setForeground(Color.GREEN);
                        listAllStaffErrorLabel.setVisible(true);

                        System.out.println("----------------");
                    }
                }
                else{
                    listAllStaffErrorLabel.setText("Restaurant has no staff");
                    listAllStaffErrorLabel.setForeground(Color.RED);
                    listAllStaffErrorLabel.setVisible(true);
                    System.out.println("Restaurant has no staff");
                }
            }
        });





        listCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listAllCustomerErrorLabel.setText("");
                listAllCustomerErrorLabel.setVisible(false);

                listCustomerPanel.setVisible(true);

                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);

            }
        });



        listAllCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String header6[] = new String[]{"ID","Name","Type"};
                DefaultTableModel staffDetail_Table6;

                staffDetail_Table6 = new DefaultTableModel(header6,0);
                table6.setModel(staffDetail_Table6);

                System.out.println();
                System.out.println("----------------");
                if(customers.size()>0) {
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println("Customer " + (i + 1) + ":");
                        customers.get(i).customer_show_name_type();  //staff_show_name_type is a overriding method that prints differently for different types of staffs


                        Object[] objs6 = {customers.get(i).getId(),customers.get(i).getName(),customers.get(i).getGender(),customers.get(i).getDateOfBirth()};
                        staffDetail_Table6.addRow(objs6);

                        listAllCustomerErrorLabel.setText("All Customer list displayed");
                        listAllCustomerErrorLabel.setForeground(Color.GREEN);
                        listAllCustomerErrorLabel.setVisible(true);


                        System.out.println("----------------");
                    }
                }
                else{

                    listAllCustomerErrorLabel.setText("Restaurant has no customer");
                    listAllCustomerErrorLabel.setForeground(Color.RED);
                    listAllCustomerErrorLabel.setVisible(true);

                    System.out.println("Restaurant has no customer");
                }
            }
        });




        listAllStaffSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listAllStaffSalaryErrorLabel.setText("");
                listAllStaffSalaryErrorLabel.setVisible(false);

                listAllStaffSalaryPanel.setVisible(true);
                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);

            }
        });


        listAllStaffSalaryButton_func.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String header7[] = new String[]{"Money"};
                DefaultTableModel staffDetail_Table7;

                staffDetail_Table7 = new DefaultTableModel(header7,0);
                table7.setModel(staffDetail_Table7);

                System.out.println();
                System.out.println("----------------");
                if(staffs.size()>0) {
                    for (int i = 0; i < staffs.size(); i++) {

                        System.out.println("Staff " + (i + 1) + ":");
                        staffs.get(i).getSalary();  //getSalary is a overriding method that prints differently for different types of staffs

                        Object[] objs7 = {staffs.get(i).money()};
                        staffDetail_Table7.addRow(objs7);

                        listAllStaffSalaryErrorLabel.setText("All Staff salaries displayed");
                        listAllStaffSalaryErrorLabel.setForeground(Color.GREEN);
                        listAllStaffSalaryErrorLabel.setVisible(true);


                        System.out.println("----------------");
                    }
                }
                else{
                    listAllStaffSalaryErrorLabel.setText("Restaurant has no staff");
                    listAllStaffSalaryErrorLabel.setForeground(Color.RED);
                    listAllStaffSalaryErrorLabel.setVisible(true);

                    System.out.println("Restaurant has no staff");
                }

            }
        });

        listAllOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAllOrderPanel.setVisible(true);

                listAllOrderErrorLabel.setText("");
                listAllOrderErrorLabel.setVisible(false);

                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                addOrderOfBookingPanel.setVisible(false);


            }
        });
        listAllOrderButton_func.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String header8[] = new String[]{"Type","Description","Extra notes"};
                DefaultTableModel staffDetail_Table8;

                staffDetail_Table8 = new DefaultTableModel(header8,0);
                table8.setModel(staffDetail_Table8);



                if(customers.size()>0) {
                    System.out.println("\nAll ORDERS--------------");
                    for (int i = 0; i < customers.size(); i++) {
                        for (int j = 0; j < customers.get(i).getOrders().size(); j++) {
                            customers.get(i).getOrders().get(j).show();
                            customers.get(i).getOrders().get(j).processPayment(); // Calling processpaymnet method for every different object


                            Object[] objs8 = {customers.get(i).getOrders().get(j).getOrderType(),customers.get(i).getOrders().get(j).getOrderDetails(),customers.get(i).getOrders().get(j).getExtraNotes()};
                            staffDetail_Table8.addRow(objs8);




                            System.out.println("-------------------------");  //Getting online orders

                        }
                        for (int j = 0; j < customers.get(i).getBookings().size(); j++) {
                            for (int k = 0; k < customers.get(i).getBookings().get(j).getInRestrorders().size(); k++) {

                                customers.get(i).getBookings().get(j).getInRestrorders().get(k).show(); //Getting In restaurant orders
                                customers.get(i).getBookings().get(j).getInRestrorders().get(k).processPayment();


                                Object[] objs8 = {customers.get(i).getBookings().get(j).getInRestrorders().get(k).getOrderType(),customers.get(i).getBookings().get(j).getInRestrorders().get(k).getOrderDetails(),customers.get(i).getBookings().get(j).getInRestrorders().get(k).getExtraNotes()};
                                staffDetail_Table8.addRow(objs8);

                                System.out.println("-------------------------");
                            }

                        }
                    }

                }
                else{

                    listAllOrderErrorLabel.setText("There is no customer so NO order to show");
                    listAllOrderErrorLabel.setForeground(Color.RED);
                    listAllOrderErrorLabel.setVisible(true);

                }


            }
        });


        addOrderOfBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addOrderOfBookingPanel.setVisible(true);

                addOrderOfBookingErrorLabel.setText("");
                addOrderOfBookingErrorLabel.setVisible(false);


                //REST OF PANELS INVISBLE
                deleteCustomerErrorLabel.setVisible(false);
                addBookingPanel.setVisible(false);
                addCustomerPanel.setVisible(false);
                listStaffDetailPanel.setVisible(false);
                addStaffPanel.setVisible(false);
                deleteStaffPanel.setVisible(false);
                deleteCustomerPanel.setVisible(false);
                addOrderPanel.setVisible(false);
                listCustomerDetailPanel.setVisible(false);
                displayCustomerLastBookingPanel.setVisible(false);
                listCustomerOrdersPanel.setVisible(false);
                listStaffPanel.setVisible(false);
                listCustomerPanel.setVisible(false);
                listAllStaffSalaryPanel.setVisible(false);
                listAllOrderPanel.setVisible(false);
            }
        });

/***
 * addOrderBookingbutton to create order
 */
        addOrderBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                String OrderDate,Order_Details,Order_Notes;
                Date order_date = new Date();


                int order_id,check_id=0;
                int person = 0;

                int flag_date=0;
                int index_date=0;

                for (int i = 0; i <= customers.size()-1; i++) {
                    if(customers.get(i).getId()!=Integer.parseInt(addOrderOfBookCustomerIDText.getText())){
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
                    String search_order = addOrderOfBookFormattedText.getText();
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
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }


                        //If he has a booking at entered Date then get the order
                        if (flag_date == 1) {


                            OrderDate = addOrderOfBookOrderDateText.getText();

                            System.out.print("Please enter Order details:");
                            Order_Details = addOrderOfBookDetailText.getText();

                            System.out.print("Please enter Order extra notes:");
                            Order_Notes = addOrderOfBookEkstraText.getText();

                            System.out.print("Please enter table number:");
                            int table_Number = Integer.parseInt(addOrderOfBookTableNoText.getText());

                            System.out.print("Please enter booking order (number):");
                            int bookingOrder = Integer.parseInt(addOrderOfBookOrderNoText.getText());

                            InRestrOrder New_order = new InRestrOrder("In_restaurant", order_uniqueId, order_date, Order_Details, Order_Notes, table_Number, bookingOrder);

                            customers.get(person).getBookings().get(index_date).makeOrder(New_order);  //Adding "RESTAURANT ORDER"  to given booking date and ID number
                            order_uniqueId = order_uniqueId + 1; //After every order +1


                        }
                        else {

                            addOrderOfBookingErrorLabel.setText("Customer has no bookings at given 'Existing booking date'");
                            addOrderOfBookingErrorLabel.setForeground(Color.RED);
                            addOrderOfBookingErrorLabel.setVisible(true);

                            System.out.println("Customer has no bookings at given date");
                        }
                    }
                    else {

                        addOrderOfBookingErrorLabel.setText("Customer has no bookings in given date");
                        addOrderOfBookingErrorLabel.setForeground(Color.RED);
                        addOrderOfBookingErrorLabel.setVisible(true);

                        System.out.println("Customer has no bookings in given date");
                    }
                }
                else{

                    addOrderOfBookingErrorLabel.setText("There is no customer with entered ID number");
                    addOrderOfBookingErrorLabel.setForeground(Color.RED);
                    addOrderOfBookingErrorLabel.setVisible(true);

                    System.out.println("There is no customer with entered ID number");
                }
            }
        });
    }


    /***
     * To customize some text fields Inputs
     * @throws ParseException
     */
    private void createUIComponents() throws ParseException {

        MaskFormatter df = new MaskFormatter("##/##/####");
        df.setPlaceholderCharacter(' ');
        getStaffDobText = new JFormattedTextField(df);
        getStaffStart_DateText = new JFormattedTextField(df);  //I should pick the checkbox(Custom Create) in the GUIclass.form at the properties of  "getStaffStart_DateText"
        getStaffExp_end_DateText = new JFormattedTextField(df);
        getCustomerDobText = new JFormattedTextField(df);
        getCustomerRegText = new JFormattedTextField(df);
        customerBookingDateText = new JFormattedTextField(df);
        addOrderDateText = new JFormattedTextField(df);

        addOrderOfBookFormattedText = new JFormattedTextField(df);
        addOrderOfBookOrderDateText =new JFormattedTextField(df);



    }

    /***
     * This is Action listener for JmenuItems. It Reads ActionEvent as 'e' then get it's source and check for functionality to RUN
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Load_item) {

            JFileChooser Jload = new JFileChooser(); //Opening file chooser
            Jload.showSaveDialog(null);

            File file_in = Jload.getSelectedFile();  // READ Staff File name

            try {

                FileInputStream fis = new FileInputStream(file_in);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Staff a = null;
                while((a = (Staff)ois.readObject())!=null) {
                                                                        //CREATE object as STAFF
                    staffs.add(a);                                      //THEN ADD THE OBJECT TO staffs ArrayList
                }
                ois.close();

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                System.out.println("End of file");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }

            //READING CUSTOMER FILE***********************************************

            File file_in_customer = new File("CustomerOut.dat"); //Reading from file name


            try {
                FileInputStream fis2 = new FileInputStream(file_in_customer);
                ObjectInputStream ois2 = new ObjectInputStream(fis2);

                BufferedInputStream bis = new BufferedInputStream(fis2);

                Customer b = null;
                while((b = (Customer) ois2.readObject())!=null){

                    customers.add(b);

                }

                ois2.close();


            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                System.out.println("End of file");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }

            System.out.println("LOAD SuccesFul");
        }


        else if (e.getSource() == Save_item) {
            File file_out = new File("StaffOut.dat");       //Saving objects to given File name
            try {

                FileOutputStream fos = new FileOutputStream(file_out);
                ObjectOutputStream out = new ObjectOutputStream(fos);
                for (int i = 0; i < staffs.size(); i++) {
                    out.writeObject(staffs.get(i));
                }
                out.close(); //Closing file after usage
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            File file_out_customer = new File("CustomerOut.dat");  //Saving objects to given File name
            try {

                FileOutputStream fos2 = new FileOutputStream(file_out_customer);
                ObjectOutputStream out2 = new ObjectOutputStream(fos2);

                for (int i = 0; i < customers.size(); i++) {
                    out2.writeObject(customers.get(i));
                }

                out2.close(); //Closing file after usage
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                makeMD5();
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


    /***
     * Creating MD5 file reading earlier file
     * @throws NoSuchAlgorithmException exception
     *
     * @throws IOException exception
     */
    public void makeMD5() throws NoSuchAlgorithmException, IOException {


        FileInputStream fis = new FileInputStream ("CustomerOut.dat");
        BufferedInputStream bis = new BufferedInputStream (fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch;
        while ((ch = bis.read()) != -1) {
            baos.write (ch);
        }
        byte buffer[] = baos.toByteArray();

        MessageDigest algorithm = MessageDigest.getInstance ("MD5");

        algorithm.reset();

        algorithm.update (buffer);

        byte digest[] = algorithm.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<digest.length;i++) {
            hexString.append (Integer.toHexString(0xFF & digest[i]));
            hexString.append (" ");
        }
        System.out.println (hexString.toString());

        FileOutputStream fos = new FileOutputStream("CustomerMD5.dat");
        fos.write(digest);
    }


    /***
     * MD5 file check with earlier out file (CustomerOut.dat)
     * @return True or False if the files are equal(true)
     * @throws NoSuchAlgorithmException Exception
     * @throws IOException  exception
     */
    public boolean checkMD5() throws NoSuchAlgorithmException, IOException { //COMPARING TWO FILES

        FileInputStream fis = new FileInputStream ("CustomerOut.dat");
        BufferedInputStream bis = new BufferedInputStream (fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch;
        while ((ch = bis.read()) != -1) {
            baos.write (ch);
        }
        byte buffer[] = baos.toByteArray();

        MessageDigest algorithm = MessageDigest.getInstance ("MD5");

        algorithm.reset();

        algorithm.update (buffer);

        byte digest[] = algorithm.digest();

        StringBuffer hexString = new StringBuffer();


        for (int i=0;i<digest.length;i++) {
            hexString.append (Integer.toHexString(0xFF & digest[i]));
            hexString.append (" ");
        }
        System.out.println (hexString.toString());


        byte MD5read[]= Files.readAllBytes(Paths.get("CustomerMD5.dat"));                          // MD5 that stored to check with
        StringBuffer hexM5 = new StringBuffer();
        for (int i = 0; i < MD5read.length; i++){
            hexM5.append(Integer.toHexString(0xFF & MD5read[i]));
            hexM5.append(" ");
        }

        System.out.println("MD5 CHECK:");
        System.out.println("*****************************");
        System.out.println(hexM5);

        System.out.println(hexString);
        System.out.println("*****************************");




        if(hexM5.toString().equals(hexString.toString())){
            return true;
        }
        else{
            return false;
        }
    }
}
