/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Bank.BankEnterprise;
import Business.Bank.LocalEnterpriseBankAccount;
import Business.Donor.DonorDirectory;
import Business.GovernmentEnterprise.Government;
import Business.GovernmentEnterprise.Region;
import Business.LocalAgent.LocalAgent;
import Business.MobileEnterprise.MobileEnterprise;
import Business.Payment.Payment;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import com.db4o.collections.ActivatableArrayList;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class DonationEnterprise extends Enterprise {
    
    private ArrayList<Enterprise> associatedEnterprise;
    private LocalEnterpriseBankAccount localEnterpriseBankAccount;
    private DonorDirectory donorDirectory;
    private ArrayList<Payment> incomingPaymentList;
    private ArrayList<WorkQueue> workQueueList;
    
    
   
    public DonationEnterprise (String name,EnterpriseType type)
    {
        super(name,type.DONATION);
        this.associatedEnterprise = new ArrayList<>();
        this.localEnterpriseBankAccount = new LocalEnterpriseBankAccount();
        this.donorDirectory = new DonorDirectory();
        this.incomingPaymentList=new ArrayList<>();
        this.workQueueList=new ArrayList<>();
                
        
    }
    
     public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Enterprise> getAssociatedEnterprise() {
        return associatedEnterprise;
    }

    public void setAssociatedEnterprise(ArrayList<Enterprise> associatedEnterprise) {
        this.associatedEnterprise = associatedEnterprise;
    }

    
    
    public Enterprise addAssociatedEnterprise(String name,Enterprise.EnterpriseType type)
    {
        Enterprise enterprise = null;
            if(type == EnterpriseType.BANK)
        {
            enterprise = new BankEnterprise(name,type);
        associatedEnterprise.add(enterprise);
        
        }
        
        if(type == EnterpriseType.MOBILE)
        {
            enterprise = new MobileEnterprise(name,type);
        associatedEnterprise.add(enterprise);
        }
        
        
        if(type == EnterpriseType.GOVERNMENT)
        {
            enterprise = new Government(name,type);
        associatedEnterprise.add(enterprise);
      
        }
        
        return enterprise;
    }
    
    
    public void removeAssociatedEnterprise(Enterprise e)
    {
        associatedEnterprise.remove(e);
    }

    public LocalEnterpriseBankAccount getLocalEnterpriseBankAccount() {
        return localEnterpriseBankAccount;
    }

    public void setLocalEnterpriseBankAccount(LocalEnterpriseBankAccount localEnterpriseBankAccount) {
        this.localEnterpriseBankAccount = localEnterpriseBankAccount;
    }

    public DonorDirectory getDonorDirectory() {
        return donorDirectory;
    }

    public void setDonorDirectory(DonorDirectory donorDirectory) {
        this.donorDirectory = donorDirectory;
    }
    
    public WorkQueue createRegionalWorkQueue(Region region)
    {
        WorkQueue workQueue= new WorkQueue();
        workQueue.setRegion(region);
        workQueueList.add(workQueue);
        return workQueue;
        
    }

    public ArrayList<WorkQueue> getWorkQueueList() {
        return workQueueList;
    }

    public void setWorkQueueList(ArrayList<WorkQueue> workQueueList) {
        this.workQueueList = workQueueList;
    }
    
    
    
    public boolean regionalWorkQueuePresent(Region region,DonationEnterprise donationEnterprise)
    {
        for(WorkQueue workQueue:donationEnterprise.getWorkQueueList())
        {
            if(workQueue.getRegion().equals(region))
            {
                return true;
                
            }
        }
    
       return false;
    }
  
   
    public WorkQueue getRegionalWorkQueue(Region region)
    {
        for(WorkQueue workQueue:workQueueList)
        {
            if(workQueue.getRegion().equals(region))
            {
                return workQueue;
               
            }
                
        }
    return null;
    }
    
    
    public double getAccountBalance(WorkQueue workQueue)
    {
        double accountBalance=0;
        Payment payment;
        for(WorkRequest workRequest:workQueue.getWorkRequestList())
        {
            if(workRequest instanceof Payment)
            {
                payment = (Payment)workRequest;
                accountBalance+=payment.getAmount();
            }
        }
        return accountBalance;
    }
    
    
    
    
    public void addWorkRequest(WorkQueue workQueue,Payment payment)
    {
        payment.setAmount(payment.getAmount());
        workQueue.getWorkRequestList().add(payment);
        
        
        
    }
     
    
    public double getEnterpriseAccountBalance()
    {
        double totalBalance=0;
       
            for(WorkRequest workRequest:this.getWorkQueue().getWorkRequestList())
            {
                if(workRequest instanceof Payment)
                {
                    Payment payment = (Payment)workRequest;
                    totalBalance+=payment.getAmount();
                }
            }
       
        
        return totalBalance;
    }
    
    
    public void addPayment(WorkRequest workRequest)
    {
        Payment payment=null;
        this.getWorkQueue().getWorkRequestList().add(workRequest);
        if(workRequest instanceof Payment)
           payment = (Payment)workRequest;
          this.localEnterpriseBankAccount.setAccountBalance(payment.getAmount());
    }
    
    
    public void clearAllWorkRequestBalance()
    {
        this.localEnterpriseBankAccount.clearAccountBalance(getEnterpriseAccountBalance());
        this.getWorkQueue().getWorkRequestList().clear();
    }
    


}
