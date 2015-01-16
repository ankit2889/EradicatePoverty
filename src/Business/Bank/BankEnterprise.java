/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Bank;

import Business.Enterprise.Enterprise;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class BankEnterprise extends Enterprise{
    
    private String bankName;
    private ArrayList<BankAccount> bankAccountList;
    
    public BankEnterprise (String name,EnterpriseType type)
    {
        super(name,type.BANK);
        this.bankAccountList = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(ArrayList<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }
    
    
    public BankAccount addBankAccount()
    {
        BankAccount bankAccount = new BankAccount();
        bankAccountList.add(bankAccount);
        return bankAccount;
        
    }
    
    public BankAccount getBankAccount(int accountNumber)
    {
        for (BankAccount bankAccount:bankAccountList)
        {
            if (bankAccount.getAccountNumber() == accountNumber)
            {
                return bankAccount;
            }
        }
        
        return null;
    }
    
     public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
