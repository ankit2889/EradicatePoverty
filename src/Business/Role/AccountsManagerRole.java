/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Bank.LocalEnterpriseBankAccount;
import Business.Bank.SavingsAccount;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.AccountsManager.AccountManagerWorkAreaJPanel;
import userInterface.SystemAdmin.SystemAdminWorkAreaJPanel;

/**
 *
 * @author JJPL
 */
public class AccountsManagerRole extends Role {
    
    public AccountsManagerRole()
    {
        super(Role.RoleType.ACCOUNT_MANAGER);
    }
            
    
    
     
     public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, Ecosystem business) {
        
return new AccountManagerWorkAreaJPanel(userProcessContainer, enterprise, account);
    }

}
