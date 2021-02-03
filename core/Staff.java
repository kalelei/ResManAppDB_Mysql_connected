package core;

import support.Employee;
import support.Person;

import java.io.Serializable;
import java.util.Date;

/**
 * Subclass of person Employee and implements Employee INTERFACE
 */
public class Staff extends Person implements Employee, Serializable {
    private String staff_type;
    private java.util.Date startDate;

    /**
     * Cosntructor with values
     * @param id setting id
     * @param name settig id
     * @param gender setting id
     * @param date_birth setting date_birth
     * @param date_start setting date_start
     * @param staff_type setting staff_type
     */
    public Staff(int id, String name, char gender, java.util.Date date_birth,java. util.Date date_start, String staff_type){
        super.setId(id);
        super.setName(name);
        super.setGender(gender);
        super.setDateOfBirth(date_birth);
        this.startDate=date_start;
        this.staff_type=staff_type;
    }

    /**
     * constructor with no values
     */
    public Staff() {
    }

    /**
     *
     * @return getting staff_type
     */
    public String getStaff_type() {
        return staff_type;
    }

    /**
     *
     * @return getting startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate setting stardtDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @param staff_type setting staff_type
     */
    public void setStaff_type(String staff_type) {
        this.staff_type = staff_type;
    }

    /**
     * Overriding method for its sub classes
     */
    public void staff_show(){ }

    /**
     * Overriding method for its sub classes
     */
    public void staff_show_name_type(){}

    /**
     * Interface method form Employee Interface
     */
    @Override
    public void getSalary(){}

    @Override
    public int money(){
        return 0;
    }

}
