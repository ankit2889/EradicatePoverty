/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Bank;

import Business.Donor.DonorEnterprise;

/**
 *
 * @author JJPL
 */
public class DonorEnterpriseBankAccount extends BankAccount{
    
    private DonorEnterprise donorEnterprise;
    
    public DonorEnterpriseBankAccount ()
    {
        
    }

    public DonorEnterprise getDonorEnterprise() {
        return donorEnterprise;
    }

    public void setDonorEnterprise(DonorEnterprise donorEnterprise) {
        this.donorEnterprise = donorEnterprise;
    }
    
    
    
    
}
