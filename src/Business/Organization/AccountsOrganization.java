/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.AccountsManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class AccountsOrganization extends Organization{
    public AccountsOrganization(String name) {
        super(name,Organization.Type.ACCOUNTS.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AccountsManagerRole());
        return roles;
    }
    
    
}
