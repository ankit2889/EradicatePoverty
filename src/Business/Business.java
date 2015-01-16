/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;



/**
 *
 * @author Administrator
 */
public class Business {
    
    private static Business business;
    private Ecosystem systemOrg;

    public Ecosystem getSystemOrg() {
        return systemOrg;
    }

    public void setSystemOrg(Ecosystem systemOrg) {
        this.systemOrg = systemOrg;
    }
    private OrganizationDirectory organizationDirectory;
    
    public static Business getInstance(){
        if (business == null){
            business = new Business();
        }
        return business;
    }

    private Business() {
        organizationDirectory = new OrganizationDirectory();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    
    
}