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
import userInterface.AccountsManager.AccountManagerWorkAreaJPanel;

/**
 *
 * @author JJPL
 */
public class BankAdmin extends Role {
    
    public BankAdmin()
    {
        super(Role.RoleType.BANKADMIN);
    }
            
    
    
     
     public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, Ecosystem business) {
        
return new AccountManagerWorkAreaJPanel(userProcessContainer, enterprise, account);
    }

    
}
