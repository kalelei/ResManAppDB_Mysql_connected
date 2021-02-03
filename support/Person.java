package support;
import java.io.Serializable;
import java.util.Date;

/**
 * Abstract class definition with no constructor
 */
public abstract class Person implements Serializable {
    private  int id;
    private  String name;
    private  char gender;
    private java.util.Date dateOfBirth;

    /**
     *
     * @return getting id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return getting name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return getting gender
     */
    public char getGender() {
        return gender;
    }

    /**
     *
     * @return getting dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @param id setting id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param name setting name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param gender setting gender
     *
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     *
     * @param dateOfBirth setting dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}

