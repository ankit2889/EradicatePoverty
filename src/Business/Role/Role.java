/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    private RoleType roleype;
    
    public enum RoleType{
        DONOR("Donor"),
        SYSADMIN("SysAdmin"),
        NETWORKADMIN("Network Admin"),
        ENTERPRISEADMIN("Enterprise Admin"),
        ORGANIZATIONADMIN("Organization Admin"),
        ACCOUNT_MANAGER("Account Manager"),
        FIELD_STAFF("Field Staff"),
        APPROVAL_MANAGER("Approval Manager"),
        DELIVERY_MANAGER("Delivery_Manager"),
        RECEPTIONIST("Receptionist"),
        GOVERNMENT_OFFICIAL("Government Official"),
        LOCAL_AGENT("Local Agent"),
        SENIOR_STAFF("Senior Staff"),
        BANKADMIN("Bank Admin"),
        RECIPIENT("Recipient");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, Ecosystem business);

    public RoleType getRoleype() {
        return roleype;
    }

    public void setRoleype(RoleType roleype) {
        this.roleype = roleype;
    }
    
    
    public Role(Role.RoleType type)
    {
        this.roleype = type;
    }

    
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}