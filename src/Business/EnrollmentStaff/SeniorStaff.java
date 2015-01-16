/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.EnrollmentStaff;

import Business.Employee.Employee;
import Business.Recipient.Recipient;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class SeniorStaff extends Employee implements Staff{
    
    private ArrayList<Recipient> recipientApproved;
    private int yearsOfExperience;
    
    public SeniorStaff()
    {
        super();
        this.recipientApproved=new ArrayList<>();
    }

    public ArrayList<Recipient> getRecipientApproved() {
        return recipientApproved;
    }

    public void setRecipientApproved(ArrayList<Recipient> recipientApproved) {
        this.recipientApproved = recipientApproved;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    
    
    
    
}
