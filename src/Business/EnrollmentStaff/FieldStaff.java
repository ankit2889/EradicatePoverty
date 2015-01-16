/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.EnrollmentStaff;

import Business.Employee.Employee;

/**
 *
 * @author JJPL
 */
public class FieldStaff extends Employee implements Staff {
    
    private int villagesAlloted;
    private int creditHistory;
    public FieldStaff()
    {
        super();
    }

    public int getVillagesAlloted() {
        return villagesAlloted;
    }

    public void setVillagesAlloted(int villagesAlloted) {
        this.villagesAlloted = villagesAlloted;
    }

    public int getCreditHistory() {
        return creditHistory;
    }

    public void setCreditHistory(int creditHistory) {
        this.creditHistory = creditHistory;
    }
    
    
    
}
