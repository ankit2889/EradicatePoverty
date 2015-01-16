/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.GovernmentEnterprise.Government;
import Business.MobileEnterprise.MobileEnterprise;
import Business.Bank.BankEnterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.LocalAgent.LocalAgent;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class EnterpriseDirectory {
    
    private ArrayList <Enterprise> enterpriseList;
    private ArrayList<LocalAgent> localAgentList;
    
    public EnterpriseDirectory ()
    {
        this.enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    
    public Enterprise addEnterprise (String name,EnterpriseType type)
    {
        Enterprise enterprise = null;
        
        if(type == EnterpriseType.BANK)
        {
            enterprise = new BankEnterprise(name,type);
        enterpriseList.add(enterprise);
        
        }
        
        if(type == EnterpriseType.MOBILE)
        {
            enterprise = new MobileEnterprise(name,type);
        enterpriseList.add(enterprise);
        }
        
        
        if(type == EnterpriseType.GOVERNMENT)
        {
            enterprise = new Government(name,type);
        enterpriseList.add(enterprise);
      
        }
        
        
        if(type == EnterpriseType.DONATION)
        {
            enterprise = new DonationEnterprise(name,type);
        enterpriseList.add(enterprise);
        return enterprise;
        }
        
        return enterprise;
        
    }
    
    
    
    public boolean checkUserNamePresent(String emailId)
    {
        for(Enterprise enterprise:enterpriseList)
        {
            if(enterprise.getUserAccountDirectory().checkifUsernameisPresent(emailId))
                return true;
        }
        
        for(Enterprise enterprise:enterpriseList)
        {
            for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(organization.getUserAccountDirectory().checkifUsernameisPresent(emailId))
                    return true;
            }
        }
        return false;
    }
    
}