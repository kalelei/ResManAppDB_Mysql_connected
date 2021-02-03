package core;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Subclass
 */
public class Senior extends Staff implements Serializable {
    private int grossSalary_yearly;
    private ArrayList<Junior> juniors;

    /**
     * Constructor with no parameters
     */
    public Senior(){}

    /**
     * Constructor with parameters
     * @param id setting id
     * @param name setting name
     * @param gender setting gender
     * @param date_birth setting date_birth
     * @param date_start setting date_start
     * @param grossSalary_yearly setting grossSalary
     * @param staff_type setting staff_type
     */
    public Senior(int id, String name, char gender, java.util.Date date_birth,java. util.Date date_start, int grossSalary_yearly, String staff_type) {
        super.setId(id);
        super.setName(name);
        super.setGender(gender);
        super.setDateOfBirth(date_birth);
        super.setStartDate(date_start);
        super.setStaff_type(staff_type);
        this.grossSalary_yearly=grossSalary_yearly;
        this.juniors=new ArrayList<Junior>();
    }

    /**
     *
     * @return getting grossSalary
     */
    public int getGrossSalary_yearly() {
        return grossSalary_yearly;
    }

    /**
     *
     * @return Getting Juniors ArrayList
     */
    public ArrayList<Junior> getJuniors() {
        return juniors;
    }

    /**
     *
     * @param grossSalary_yearly setting grossSalary_yearly
     */
    public void setGrossSalary_yearly(int grossSalary_yearly) {
        this.grossSalary_yearly = grossSalary_yearly;
    }

    /**
     *
     * @param juniors stting juniors ArrayList
     */
    public void setJuniors(ArrayList<Junior> juniors) {
        this.juniors = juniors;
    }

    /**
     * Overriding method for senior
     */
    public void staff_show(){
        System.out.println("Staff type="+super.getStaff_type());
        System.out.println("Staff id="+super.getId());
        System.out.println("Staff name="+super.getName());
        System.out.println("Staff gender="+super.getGender());
        System.out.println("Staff date of birth="+super.getDateOfBirth());
        System.out.println("Staff start date="+super.getStartDate());
        System.out.println("Staff gross salary="+this.grossSalary_yearly);
    }

    /**
     * Overriding method for senior
     */
    public void staff_show_name_type(){
        System.out.println("Staff ID="+super.getId());
        System.out.println("Staff type="+super.getStaff_type());
        System.out.println("Staff name="+super.getName());
    }

    /**
     * Interface method for staff type And senior can reach it OVERRIDING
     */
    public void getSalary(){
        int current_year=2020; //Initialize
        Calendar start_date = Calendar.getInstance();
        start_date.setTime(super.getStartDate());
        int total_year_worked=(2020-start_date.get(Calendar.YEAR));
        System.out.println("Year staff started to work="+start_date.get(Calendar.YEAR));
        System.out.println("Total year worked="+total_year_worked);
        for (int i = 0; i < total_year_worked; i++) {
            this.grossSalary_yearly=this.grossSalary_yearly+(this.grossSalary_yearly*10/100);
        }
        setGrossSalary_yearly(this.grossSalary_yearly);

        System.out.println("After "+total_year_worked+" staff salary will be "+this.grossSalary_yearly);
    }

    public int money(){return this.grossSalary_yearly;}

}
