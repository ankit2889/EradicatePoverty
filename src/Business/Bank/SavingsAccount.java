/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Bank;

import Business.Donor.DonorPerson;
import Business.Person.Person;

/**
 *
 * @author JJPL
 */
public class SavingsAccount extends BankAccount {
    
    private Person accountHolder;
    
    
    public SavingsAccount()
    {
        super();
    }

    

    
    

    public Person getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(Person accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    
}
