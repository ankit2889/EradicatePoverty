/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Donor;

import Business.Bank.DonorEnterpriseBankAccount;

/**
 *
 * @author JJPL
 */
public class DonorEnterprise extends Donor {
    
    private String enterpriseName;
    private DonorEnterpriseBankAccount enterpriseBankAccount;
    
    
    public DonorEnterprise ()
    {
        
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public DonorEnterpriseBankAccount getEnterpriseBankAccount() {
        return enterpriseBankAccount;
    }

    public void setEnterpriseBankAccount(DonorEnterpriseBankAccount enterpriseBankAccount) {
        this.enterpriseBankAccount = enterpriseBankAccount;
    }
    
    
    
    
}
