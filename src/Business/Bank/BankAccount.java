/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Bank;
import java.util.Random;
/**
 *
 * @author JJPL
 */
public class BankAccount {
    
    private int accountNumber;
    private double accountBalance;
    
    private String accountPin;
    private static int count=0;
    
    
    public BankAccount ()
    {
        this.accountNumber =++count* (int)(Math.random()*9000)+1000;
        this.accountBalance =0;
        
   
    }
    
    
    public enum BankAccountType{
        
        DONOR_ACCOUNT("Donor Account"),
        ENTERPRISE_ACCOUNT("Enterprise Account"),
        LOCALAGENT_ACCOUNT("Local Agent Account");
        
        
        
        private String value;
        
        private BankAccountType(String value)
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

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double payment) {
        
        this.accountBalance=this.accountBalance+payment;
    }
    
    
    public void clearAccountBalance(double payment)
    {
        accountBalance = accountBalance-payment;
    }

    public String getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(String accountPin) {
        this.accountPin = accountPin;
    }

    
    
    
    
}
