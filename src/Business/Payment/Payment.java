/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Payment;

import Business.Donor.DonorPerson;
import Business.Enterprise.Enterprise;
import Business.GovernmentEnterprise.Region;
import Business.LocalAgent.LocalAgent;
import Business.Recipient.Recipient;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author JJPL
 */
public class Payment extends WorkRequest{
    
    private double amount;
    private DonorPerson donorPerson;
    private Enterprise enterprise;
   private PaymentMode paymentMode;
    private static int count=0;
    private int paymentId;
    private Region region;
    private LocalAgent localAgent;
    private Date transferredDate;
    private ArrayList<Recipient> paymentRecipientList;
   
    
    public Payment ()
    {
        super();
        this.paymentMode = new PaymentMode();
        this.paymentId = count++;
        this.paymentRecipientList = new ArrayList<>();
        
    }
    
    
    public enum paymentStatus{
        DONATED("Pending to be transferred to Local Agent") , 
        TRANSFERRED("Successfully transferred to Local Agent"), 
        RECEIVED("Received Successfully by Recipient");
        
        private String value;
        private paymentStatus(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
//        public Organization createOrganization(Type t) {
//            return t.createOrganization();
//        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public DonorPerson getDonor() {
        return donorPerson;
    }

    public void setDonor(DonorPerson donor) {
        this.donorPerson = donor;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

  public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    
    public String toString()
    {
        return String.valueOf(paymentId);
    }

    public LocalAgent getLocalAgent() {
        return localAgent;
    }

    public void setLocalAgent(LocalAgent localAgent) {
        this.localAgent = localAgent;
    }

    public Date getTransferredDate() {
        return transferredDate;
    }

    public void setTransferredDate(Date transferredDate) {
        this.transferredDate = transferredDate;
    }

    public ArrayList<Recipient> getPaymentRecipientList() {
        return paymentRecipientList;
    }

    public void setPaymentRecipientList(ArrayList<Recipient> paymentRecipientList) {
        this.paymentRecipientList = paymentRecipientList;
    }
    
    
    
    
    
}
