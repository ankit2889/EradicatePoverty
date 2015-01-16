/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author JJPL
 */
public abstract class Enterprise extends Organization {
    
    private int enterpriseId;
    private String enterpriseName;
    

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    
    private static int count=0;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    public Enterprise(String name,EnterpriseType type)
    {
        super(name,Organization.Type.DONATION.getValue());
        this.enterpriseType = type;
        enterpriseId = ++count;
        organizationDirectory = new OrganizationDirectory();
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }
    
    
    public enum EnterpriseType{
        
        DONATION("Donation"),
        MOBILE("Mobile"),
        GOVERNMENT("Government"),
        BANK("Bank");
        
        
        private String value;
        
        private EnterpriseType(String value)
        {
            this.value=value;
        
        
    }
        
        public String getValue()
        {
            return value;
        }
        
        @Override
        public String toString()
        {
            return value;
        }
            
        
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
}
