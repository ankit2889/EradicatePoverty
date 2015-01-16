package Business.Role;


import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.EnrollmentOrganization.SeniorStaffWorkAreaJPanel;
import userInterface.SystemAdmin.SystemAdminWorkAreaJPanel;

public class SeniorStaffRole extends Role{
    
    public SeniorStaffRole()
    {
        super(Role.RoleType.SENIOR_STAFF);
    }
    
     public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, Ecosystem business) {
        
        return new SeniorStaffWorkAreaJPanel(userProcessContainer, organization,account);
    }

}