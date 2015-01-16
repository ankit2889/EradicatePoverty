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
import userInterface.Recipient.RecipientWorkAreaJPanel;

/**
 *
 * @author JJPL
 */
public class RecipientRole extends Role{
    
    public RecipientRole() {
    
        super(Role.RoleType.RECIPIENT);
}
    
    
     public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, Ecosystem business) {
        
        return new RecipientWorkAreaJPanel(userProcessContainer,account);
    }

}
