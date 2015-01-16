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
import userInterface.Government.GovernmentAdminJPanel;

/**
 *
 * @author JJPL
 */
public class GovernmentOfficialRole extends Role {
    
    public GovernmentOfficialRole()
    {
        super(Role.RoleType.GOVERNMENT_OFFICIAL);
    }
    
     public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, Ecosystem business) {
        
return new GovernmentAdminJPanel(userProcessContainer, enterprise);
    }

}
