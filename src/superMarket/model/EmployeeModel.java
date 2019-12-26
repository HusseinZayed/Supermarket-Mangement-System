
package superMarket.model;

import java.util.Date;

/**
 *
 * @author hussein
 */
public class EmployeeModel {
    
    
    private int emp_ID;
    private double emp_Salary;
    private String emp_Name;
    private String city;
    private String street;
    private Date join_Year;
    private String Rank;

    public int getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }

    public double getEmp_Salary() {
        return emp_Salary;
    }

    public void setEmp_Salary(double emp_Salary) {
        this.emp_Salary = emp_Salary;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

   

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }

    public Date getJoin_Year() {
        return join_Year;
    }

    public void setJoin_Year(Date join_Year) {
        this.join_Year = join_Year;
    }

   
}
