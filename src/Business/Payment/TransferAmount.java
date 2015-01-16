/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Payment;

import Business.LocalAgent.LocalAgent;
import Business.WorkQueue.WorkRequest;
import java.util.Date;

/**
 *
 * @author JJPL
 */
public class TransferAmount extends WorkRequest {
    
    private LocalAgent localAgent;
    private Date transferredDate;
    private Payment payment;
      private double amount;
      
      
    
    public TransferAmount()
    {
      
        super();
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
