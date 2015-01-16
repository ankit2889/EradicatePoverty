/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.EnrollmentStaff.Staff;
import Business.Role.FieldStaffRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class EnrollmentOrganization extends Organization{
    
    private Staff staffType;
     public EnrollmentOrganization(String name) {
        super(name,Organization.Type.ENROLLMENT.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        
        roles.add(new FieldStaffRole());
        
        return roles;
    }

    public Staff getStaffType() {
        return staffType;
    }

    public void setStaffType(Staff staffType) {
        this.staffType = staffType;
    }
    
    
    
}
