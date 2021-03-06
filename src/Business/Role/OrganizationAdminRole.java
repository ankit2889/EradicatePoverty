/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.EnrollmentOrganization.EnrollmentOrganizationAdminJPanel;

/**
 *
 * @author JJPL
 */
public class OrganizationAdminRole extends Role{

    
        public OrganizationAdminRole() {
    
        super(Role.RoleType.ORGANIZATIONADMIN);
}
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business) {
            return new EnrollmentOrganizationAdminJPanel(userProcessContainer,organization);
    }
    
}
