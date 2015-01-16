/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.Role;
import java.util.ArrayList;
import static java.util.Objects.hash;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(String.valueOf(hash(password))))
            {
                return ua;
                
                
                    
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(String.valueOf(hash(password)));
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccount.getRole().setRoleype(role.getRoleype());
        userAccount.setIsActive(true);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    
    public boolean checkifUsernameisPresent(String username)
    {
        for (UserAccount ua:userAccountList)
        {
            if(ua.getUsername().equals(username)){
                return true;
               
            }
        }
        
        return false;
    }
    
    
    public UserAccount getOrganizationAdmin(Organization organization)
    {
        for (UserAccount ua:organization.getUserAccountDirectory().getUserAccountList())
        {
            if(ua.getRole().equals(Role.RoleType.ORGANIZATIONADMIN))
            {
                return ua;
            }
        }
    return null;
    }
}
