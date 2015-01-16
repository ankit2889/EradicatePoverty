/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Donor;

import Business.Media.Media;
import Business.Payment.PaymentHistory;
import Business.Person.Person;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author JJPL
 */
public class Donor extends Person {
    
    private static int count =0;
    private int donorId;
    private Media mediaType;
    private WorkQueue workQueue;
    private PaymentHistory paymentHistory;
    
    public enum DonorType{
            
        PERSON("Person"),
        ENTERPRISE("Donor Enterprise");
        
        
        
        private String value;
        
        private DonorType(String value)
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
    
    public Donor()
    {
     donorId = count++;   
    }
    
    
    
    

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }
    public Media getMediaType() {
        return mediaType;
    }

    public void setMediaType(Media mediaType) {
        this.mediaType = mediaType;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(PaymentHistory paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
    
    
    
}
