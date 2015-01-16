/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(String name,Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.ACCOUNTS.getValue())){
            organization = new AccountsOrganization(name);
            organizationList.add(organization);
              
        }
//        else if (type.getValue().equals(Type.CUSTOMER_SERVICES.getValue())){
//            organization = new CustomerServicesOrganization(name);
//            organizationList.add(organization);
//              
//        }
        
        else if (type.getValue().equals(Type.ENROLLMENT.getValue())){
            organization = new EnrollmentOrganization(name);
            organizationList.add(organization);
              
        }
        
//        else if (type.getValue().equals(Type.RESEARCH.getValue())){
//            organization = new ResearchOrganization(name);
//            organizationList.add(organization);
//              
//        }
        
        
            return organization;
        
     
    }
    
    
    public boolean checkifUserNameisPresent(String emailId)
    {
        for(Organization organization:organizationList)
        {
            if(organization.checkIfUserNameIsPresent(emailId))
                return true;
    
        }
        
        
    return false;
    }
    
}