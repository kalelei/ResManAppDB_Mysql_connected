package core;

import java.io.Serializable;
import java.util.Date;

/**
 * Class sub_class of staff
 */
public class Junior extends Staff implements Serializable {
    private int monthlySalary;
    private java.util.Date expectedEndDate;

    /**
     * Constructor with no values
     */
    public Junior(){ }

    /**
     * Constructor with values
     * @param id setting id
     * @param name setting name
     * @param gender setting gender
     * @param date_birth setting date_birth
     * @param date_start setting date_start
     * @param monthlySalary setting monthlySalary
     * @param expectedEndDate setting expectedEndDate
     * @param staff_type setting staff_type
     */
    public Junior(int id, String name, char gender, java.util.Date date_birth,java. util.Date date_start, int monthlySalary, java.util.Date expectedEndDate, String staff_type){
        super();
        super.setId(id);
        super.setName(name);
        super.setGender(gender);
        super.setDateOfBirth(date_birth);
        super.setStartDate(date_start);
        super.setStaff_type(staff_type);
        this.monthlySalary=monthlySalary;
        this.expectedEndDate=expectedEndDate;

    }

    /**
     *
     * @return getting monthlySalary
     */
    public int getMonthlySalary() {
        return monthlySalary;
    }

    /**
     *
     * @return getting expectedEndDate
     */
    public Date getExpectedEndDate() {
        return expectedEndDate;
    }

    /**
     *
     * @param monthlySalary setting monthlySalary
     */
    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    /**
     *
     * @param expectedEndDate setting expectedEndDate
     */
    public void setExpectedEndDate(Date expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    /**
     * This method is overriding for different saff types(junior/senior)
     */
    public void staff_show(){
        System.out.println("Staff type="+super.getStaff_type());
        System.out.println("Staff id="+super.getId());
        System.out.println("Staff name="+super.getName());
        System.out.println("Staff gender="+super.getGender());
        System.out.println("Staff date of birth="+super.getDateOfBirth());
        System.out.println("Staff start date="+super.getStartDate());
        System.out.println("Staff monthly salary="+this.monthlySalary);
        System.out.println("Staff expected end date="+this.expectedEndDate);
    }

    /**
     * This method is overriding for different stafff types(junior/senior)
     */
    public void staff_show_name_type(){
        System.out.println("Staff ID="+super.getId());
        System.out.println("Staff type="+super.getStaff_type());
        System.out.println("Staff name="+super.getName());
    }

    /**
     * This method is overriding for different stafff types(junior/senior)
     */
    public void getSalary(){
        System.out.println("Staff monthly salary is="+this.monthlySalary);
    }

    public int money(){return this.monthlySalary;}

}
